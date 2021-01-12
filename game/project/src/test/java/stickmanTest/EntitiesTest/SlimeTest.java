package stickmanTest.EntitiesTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.Slime;
import static org.junit.Assert.*;

public class SlimeTest {
    private Slime slime;

    @Before
    public void setup(){
        slime = new Slime(0, 0,Slime.Colour.BLUE);
    }

    @Test
    public void getImagePathTest(){
        assertEquals("/slimes/blue/slime_a.png", slime.getImagePath());
    }

    @Test
    public void newInstanceTest(){
        assertEquals(0, slime.newInstance().getXPos(), 0);
    }
}
