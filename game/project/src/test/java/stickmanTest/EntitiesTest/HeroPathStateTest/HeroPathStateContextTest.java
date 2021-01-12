package stickmanTest.EntitiesTest.HeroPathStateTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.HeroPathState.HeroPathStateContext;
import stickman.Entities.HeroPathState.StandState;
import static org.junit.Assert.*;

public class HeroPathStateContextTest {
    private HeroPathStateContext heroPathStateContext;
    private StandState standState;
    @Before
    public void setup(){
        heroPathStateContext = new HeroPathStateContext(HeroPathStateContext.Actor.DEFAULT, 0);
        standState = new StandState(0);
    }

    @Test
    public void getCharacterTest(){
        assertEquals(HeroPathStateContext.Actor.DEFAULT,heroPathStateContext.getCharacter());
    }

    @Test
    public void setStateTest(){
        heroPathStateContext.setState(standState);
    }

    @Test
    public void getPathTest(){
        assertEquals("/actors/default/ch_stand1.png",heroPathStateContext.getPath(0));
    }
}
