package stickmanTest.EntitiesTest.HeroPathStateTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.HeroPathState.HeroPathStateContext;
import stickman.Entities.HeroPathState.WalkLeftState;
import stickman.Entities.HeroPathState.WalkRightState;

import static org.junit.Assert.assertEquals;

public class WalkRightStateTest {
    private WalkRightState walkRightState;
    private HeroPathStateContext heroPathStateContext;

    @Before
    public void setup(){
        walkRightState = new WalkRightState(0);
        heroPathStateContext = new HeroPathStateContext(HeroPathStateContext.Actor.DEFAULT, 10);
    }

    @Test
    public void handleTestTest(){
        assertEquals("/actors/default/ch_walk1.png", walkRightState.handle(heroPathStateContext,150));
    }

}
