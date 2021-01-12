package stickmanTest.EntitiesTest.HeroPathStateTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.HeroPathState.HeroPathStateContext;
import stickman.Entities.HeroPathState.WalkLeftState;

import static org.junit.Assert.*;

public class WalkLeftStateTest {
    private WalkLeftState walkLeftState;
    private HeroPathStateContext heroPathStateContext;

    @Before
    public void setup(){
        walkLeftState = new WalkLeftState(0);
        heroPathStateContext = new HeroPathStateContext(HeroPathStateContext.Actor.DEFAULT, 10);
    }

    @Test
    public void handleTestTest(){
        assertEquals("/actors/default/ch_walk1.png", walkLeftState.handle(heroPathStateContext,5));
    }

}
