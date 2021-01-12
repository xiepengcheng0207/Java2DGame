package stickmanTest.EntitiesTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.Platform;

import static org.junit.Assert.*;

public class PlatformTest {
    private Platform platform;

    @Before
    public void setup(){
        platform = new Platform(0,0,1,1);
    }

    @Test
    public void getImagePathTest(){
        assertEquals("/platform.png",platform.getImagePath());
    }

    @Test
    public void newInstanceTest(){
        assertEquals(0,platform.newInstance().getXPos(), 0);
    }
}
