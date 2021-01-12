package stickman.model;

import org.json.simple.JSONObject;
import stickman.Entities.Entity;
import stickman.Observe.Observer;
import stickman.levels.Level;
import stickman.levels.LevelDirector;
import stickman.levels.LevelImp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Memento {
    int currentLevelNumber;
    boolean firstPrintWonBar;
    int totalScore;
    int startLife;
    boolean isFirstRecordLevelLost;
    int tickCount;
    int firstLevelLostTick ;
    Level level;

    public Memento(GameEngine gameEngine){
        GameEngineImpl model = (GameEngineImpl) gameEngine;

        this.level = model.getCurrentLevel().newInstance();
        this.currentLevelNumber = model.currentLevelNumber;
        this.firstPrintWonBar = model.firstPrintWonBar;
        this.totalScore = model.totalScore;
        this.startLife = model.startLife;
        this.isFirstRecordLevelLost = model.isFirstRecordLevelLost;
        this.tickCount = model.tickCount;
        this.firstLevelLostTick = model.firstLevelLostTick;
    }
}
