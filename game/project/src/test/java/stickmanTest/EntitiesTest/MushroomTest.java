package stickmanTest.EntitiesTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.Mushroom;

import static org.junit.Assert.*;

public class MushroomTest {
    private Mushroom mushroom;

    @Before
    public void setup(){
        mushroom = new Mushroom(0, 0, 1,1);
    }

    @Test
    public void getImagePathTest(){
        assertEquals("/mushroom.png", mushroom.getImagePath());
    }

    @Test
    public void newInstanceTest(){
        assertEquals(0, mushroom.newInstance().getXPos(),0);
    }
}
