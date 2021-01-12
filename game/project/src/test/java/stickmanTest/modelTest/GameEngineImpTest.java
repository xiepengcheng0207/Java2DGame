package stickmanTest.modelTest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import stickman.model.GameEngine;
import stickman.model.GameEngineImpl;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class GameEngineImpTest {


    private JSONObject configuration;
    private String config;
    private GameEngineImpl gameEngine;
    @Before
    public void setup() {
        configuration = null;
        config = "";
        JSONParser parser = new JSONParser();
        try {
            config = Files.readString(Paths.get("src/main/resources/config.json"));
            configuration = (JSONObject) parser.parse(config);
            gameEngine = new GameEngineImpl(configuration);
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
    public void moveLeftTest(){
        assertFalse(gameEngine.moveLeft());
    }

    @Test
    public void moveRightTest(){
        assertFalse(gameEngine.moveRight());
    }

    @Test
    public void stopMovingTest(){
        assertFalse(gameEngine.stopMoving());
    }

    @Test
    public void jump(){
        assertTrue(gameEngine.jump());
    }

}
