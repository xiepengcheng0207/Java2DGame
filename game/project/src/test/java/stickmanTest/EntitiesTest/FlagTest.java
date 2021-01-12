package stickmanTest.EntitiesTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.Flag;
import static org.junit.Assert.*;

public class FlagTest {
    private Flag flag;

    @Before
    public void setup(){
        flag = new Flag(0,0,0,0);
    }

    @Test
    public void getImagePathTest(){
        assertEquals("/flag.png",flag.getImagePath());
    }

    @Test
    public void newInstanceTest(){
        assertEquals(0,flag.newInstance().getXPos(),0);
    }
}
