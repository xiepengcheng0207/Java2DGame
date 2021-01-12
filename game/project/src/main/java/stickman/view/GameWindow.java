package stickman.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.text.*;
import stickman.Entities.Entity;
import stickman.Observe.Observer;
import stickman.Observe.ObserverImp;
import stickman.levels.Level;
import stickman.model.GameEngine;
import stickman.model.GameEngineImpl;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class GameWindow {
    private final int width;
    private final int height;
    private Scene scene;
    private Pane pane;
    private GameEngine model;
    private List<EntityView> entityViews;

    private double xViewportOffset = 0.0;
    private double yViewportOffset = 0.0;
    private static final double X_VIEWPORT_MARGIN = 200;
    private static final double Y_VIEWPORT_MARGIN = 100;

    //Score and time
    private Text totalScore;
    private Text score;
    private Text time;
    private Text life;
    private Text level;
    private Text dash;
    private Text totalValue;
    private Text scoreValue;
    private Text timeValue;
    private Text lifeValue;
    private Text levelValue;
    private Text totalLevelValue;



    public GameWindow(GameEngine model, int width, int height) {
        this.model = model;
        this.pane = new Pane();
        this.width = width;
        this.height = height;
        this.scene = new Scene(pane, width, height);

        this.entityViews = new ArrayList<>();
        level = new Text(40,20,"CurrentLevel:");
        totalScore = new Text(40,40, "Score:");
        score = new Text(40,60, "LevelScore:");
        time = new Text(40,80,"Time:");
        life = new Text(40,100,"Life:");

        levelValue = new Text(120,20,"");
        dash = new Text(130,20,"/");
        totalLevelValue = new Text(140,20,"");
        totalValue = new Text(80,40, "");
        scoreValue = new Text(110,60, "");
        timeValue = new Text(80,80,"");
        lifeValue = new Text(80,100,"");



        pane.getChildren().addAll(totalScore,score, time, life, totalValue,scoreValue, timeValue, lifeValue, level, levelValue, totalLevelValue,dash);

        KeyboardInputHandler keyboardInputHandler = new KeyboardInputHandler(model);

        scene.setOnKeyPressed(keyboardInputHandler::handlePressed);
        scene.setOnKeyReleased(keyboardInputHandler::handleReleased);

        model.getCurrentLevel().getBGDrawer().draw(model, pane);
    }


    public Scene getScene() {
        return this.scene;
    }

    public void run() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(17),
                t -> this.draw()));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void loadInfo(){
        GameEngineImpl gameEngine = (GameEngineImpl) model;
        Observer observer = gameEngine.getObserver();
        levelValue.setText(Integer.toString(gameEngine.getCurrentLevelNumber()));
        totalLevelValue.setText(Integer.toString(gameEngine.getTotalLevel()));
        totalValue.setText(Integer.toString(gameEngine.getTotalScore()));
        scoreValue.setText(Integer.toString(observer.getScore()));
        timeValue.setText(Integer.toString(observer.getTime()));
        lifeValue.setText(Integer.toString(observer.getLife()));
    }

    private void draw() {
        loadInfo();
        model.tick();
        Level currentLevel = model.getCurrentLevel();
        List<Entity> entities = currentLevel.getEntities();

        for (EntityView entityView: entityViews) {
            entityView.markForDelete();
        }

        double heroXPos = model.getCurrentLevel().getHeroX();
        double heroYPos = model.getCurrentLevel().getHeroY();
        heroXPos -= xViewportOffset;
        heroYPos -= yViewportOffset;

        // Correct X-axis camera
        if (heroXPos < X_VIEWPORT_MARGIN) {
            if (xViewportOffset >= 0) { // Don't go further left than the start of the level
                xViewportOffset -= X_VIEWPORT_MARGIN - heroXPos;
                if (xViewportOffset < 0) {
                    xViewportOffset = 0;
                    model.getCurrentLevel().setHeroX(X_VIEWPORT_MARGIN);
                }
            }
        } else if (heroXPos > width - X_VIEWPORT_MARGIN) {
            xViewportOffset += heroXPos - (width - X_VIEWPORT_MARGIN);
        }

        // Correct Y-axis camera
        if (heroYPos > (height - Y_VIEWPORT_MARGIN)) {
            yViewportOffset += heroYPos - (height - Y_VIEWPORT_MARGIN);
            if (yViewportOffset > 0)
                yViewportOffset = 0;
        } else if (heroYPos < Y_VIEWPORT_MARGIN) {
            yViewportOffset -= Y_VIEWPORT_MARGIN - heroYPos;
        }

        currentLevel.getBGDrawer().update(xViewportOffset, yViewportOffset);

        for (Entity entity: entities) {
            boolean notFound = true;
            for (EntityView view: entityViews) {
                if (view.matchesEntity(entity)) {
                    notFound = false;
                    view.update(xViewportOffset, yViewportOffset);
                    break;
                }
            }
            if (notFound) {
                EntityView entityView = new EntityViewImpl(entity);
                entityViews.add(entityView);
                pane.getChildren().add(entityView.getNode());
            }
        }

        for (EntityView entityView: entityViews) {
            if (entityView.isMarkedForDelete()) {
                pane.getChildren().remove(entityView.getNode());
            }
        }
        entityViews.removeIf(EntityView::isMarkedForDelete);
    }
}
