package stickmanTest.levelsTest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import stickman.App;
import stickman.levels.DefaultLevelBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class LevelTest {
    private App app;
    private String[] args;
    @Before
    public void setup() {
        app = new App();
    }

    @Test
    public void buildLevelTest(){
        App.main(args);
    }



}
