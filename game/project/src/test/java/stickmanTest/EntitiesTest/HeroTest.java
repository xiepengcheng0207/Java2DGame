package stickmanTest.EntitiesTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.Hero;
import stickman.Entities.HeroPathState.HeroPathStateContext;
import static org.junit.Assert.*;

public class HeroTest {
    private Hero hero;

    @Before
    public void setup(){
        hero =new Hero(0,0, HeroPathStateContext.Actor.DEFAULT);
    }

    @Test
    public void getImagePathTest(){
        assertEquals("/actors/default/ch_stand1.png",hero.getImagePath());
    }

    @Test
    public void newInstanceTest(){
        assertEquals(0, hero.newInstance().getXPos(),0);
    }

}
