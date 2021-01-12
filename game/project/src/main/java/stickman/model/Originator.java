package stickman.model;

import stickman.Entities.Entity;
import stickman.Observe.Observer;
import stickman.levels.LevelImp;

import java.util.ArrayList;
import java.util.List;

public class Originator {

    private GameEngine gameEngine;

    public Originator(GameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    public Memento save(){
        return new Memento(gameEngine);
    }

    public void undo(Object obj){
        Memento memento = (Memento) obj;
        GameEngineImpl model = (GameEngineImpl) this.gameEngine;
        model.currentLevel = memento.level.newInstance();
        model.currentLevel.register(model.observer);
        model.currentLevelNumber = memento.currentLevelNumber;
        model.firstPrintWonBar = memento.firstPrintWonBar;
        model.totalScore = memento.totalScore;
        model.startLife = memento.startLife;
        model.isFirstRecordLevelLost = memento.isFirstRecordLevelLost;
        model.tickCount = memento.tickCount;
        model.firstLevelLostTick = memento.firstLevelLostTick;
    }


}
