package stickmanTest.EntitiesTest;
import org.junit.Before;
import org.junit.Test;
import stickman.Entities.Ghost;

import static org.junit.Assert.*;

public class GhostTest {
    private Ghost ghost;

    @Before
    public void setup(){
        ghost = new Ghost(0,0);
    }

    @Test
    public void getImagePathTest(){
        assertEquals("/ghost.png", ghost.getImagePath());
    }

    @Test
    public void newInstanceTest(){
        assertEquals(0,ghost.newInstance().getXPos(),0);
    }
}
