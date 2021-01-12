package stickman.model;
import stickman.Observe.Observer;
import stickman.Observe.ObserverImp;
import stickman.levels.*;
import org.json.simple.JSONObject;

public class GameEngineImpl implements GameEngine {
    Level currentLevel;
    int currentLevelNumber;
    LevelDirector levelDirector;
    JSONObject configuration;
    int totalLevel;
    boolean firstPrintWonBar = true;
    Observer observer;
    int totalScore = 0;
    Originator originator;
    Caretaker caretaker;
    int startLife;
    int originalLife;
    boolean isFirstRecordLevelLost = true;
    int tickCount = 0;
    int firstLevelLostTick = 0;

    public GameEngineImpl(JSONObject configuration) {
        this.configuration = configuration;
        this.currentLevelNumber = 1;
        observer = new ObserverImp();
        getTotalLevels();
        startLevel();
        originator = new Originator(this);
        caretaker = new Caretaker(originator);
    }


    public int getCurrentLevelNumber(){
        return currentLevelNumber;
    }
    public int getTotalLevel(){
        return totalLevel;
    }
    public int getTotalScore(){
        return  this.totalScore;
    }
    public Observer getObserver(){
        return this.observer;
    }
    public void getTotalLevels(){
        JSONObject game =  (JSONObject) configuration.get("game");
        totalLevel = Integer.valueOf(game.get("levelcount").toString());
        originalLife = Integer.valueOf(game.get("heroLife").toString());
        startLife = originalLife;
        System.out.println(totalLevel);

    }
    //Check levelWon
    public boolean isLevelWon(){
        return this.currentLevel.levelWon();
    }

    public void save(){
        caretaker.save(originator);
    }

    public void load(){
        caretaker.undo(originator);
    }
    //go to next level

    public void goToNextLevel(){
        currentLevel.unregister(observer);
        if(isLevelWon()){
            if(currentLevelNumber < totalLevel) {
                LevelImp currLevel = (LevelImp) currentLevel;
                startLife = currLevel.getLife();
                totalScore += observer.getScore();
                currentLevelNumber += 1;
                loadLevel(currentLevelNumber);
                LevelImp newLevel = (LevelImp) currentLevel;
                newLevel.setLife(startLife);
            }else{
                LevelImp levelImp  = (LevelImp) currentLevel;
                if(firstPrintWonBar){
                    totalScore += observer.getScore();
                    levelImp.showWinBar();
                    firstPrintWonBar = false;
                }
            }
        }
    }

    private void loadLevel(int levelNumber) {
        JSONObject levels = (JSONObject)configuration.get("levels");
        String key = String.valueOf(levelNumber);

        JSONObject level = (JSONObject)levels.get(key);

        if (level != null) {
            levelDirector = new LevelDirector(new DefaultLevelBuilder(level));
            currentLevel = levelDirector.construct();
            currentLevel.register(observer);
        }

    }

    @Override
    public Level getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void startLevel() {
        loadLevel(this.currentLevelNumber);
        LevelImp currLevel = (LevelImp) currentLevel;
        currLevel.setLife(startLife);
    }

    public void gameLost(){
            currentLevelNumber = 1;
            totalScore = 0;
            startLife = originalLife;
            loadLevel(currentLevelNumber);
            LevelImp newLevel = (LevelImp) currentLevel;
            newLevel.setLife(startLife);
    }
    @Override
    public boolean jump() {
        return currentLevel.jump();
    }

    @Override
    public boolean moveLeft() {
        currentLevel.moveLeft();
        return false;
    }

    @Override
    public boolean moveRight() {
        currentLevel.moveRight();
        return false;
    }

    @Override
    public boolean stopMoving() {
        currentLevel.stopMoving();
        return false;
    }

    @Override
    public void tick() {
        tickCount ++;
        if (currentLevel.levelLost()) {
            if(isFirstRecordLevelLost){
                firstLevelLostTick = tickCount;
                LevelImp currLevel = (LevelImp)currentLevel;
                currLevel.showLoseBar();
                isFirstRecordLevelLost = false;
            }else{
                if(tickCount - firstLevelLostTick > 110){
                    gameLost();
                    isFirstRecordLevelLost = true;
                }
            }
        }
        if(isLevelWon()){
            goToNextLevel();
        }
        currentLevel.tick();

    }
}
