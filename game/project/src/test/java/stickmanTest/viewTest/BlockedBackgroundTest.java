package stickmanTest.viewTest;

import javafx.scene.layout.Pane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import stickman.model.GameEngine;
import stickman.model.GameEngineImpl;
import stickman.view.BlockedBackground;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BlockedBackgroundTest {
    private BlockedBackground blockedBackground;
    private GameEngine model;
    private Pane pane;
    private JSONObject configuration;
    private String config;


    @Before
    public void setup(){
        configuration = null;
        config = "";
        JSONParser parser = new JSONParser();
        try {
            config = Files.readString(Paths.get("src/main/resources/config.json"));
            configuration = (JSONObject) parser.parse(config);
            model = new GameEngineImpl(configuration);
            blockedBackground = new BlockedBackground();
            pane = new Pane();
        } catch (
                ParseException e) {
            System.out.println("Invalid or corrupt configuration file.");
            System.out.println(e.getMessage());
        } catch (
                IOException e) {
            System.out.println("Error reading configuration file.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void drawTest(){
        blockedBackground.draw(model, pane);
        assertEquals(0,pane.getChildren().get(0).getLayoutX(),0);
    }
}
