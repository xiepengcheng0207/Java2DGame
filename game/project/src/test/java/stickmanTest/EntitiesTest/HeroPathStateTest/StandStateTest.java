package stickmanTest.EntitiesTest.HeroPathStateTest;

import jdk.dynalink.StandardNamespace;
import org.junit.Before;
import org.junit.Test;
import stickman.Entities.HeroPathState.HeroPathStateContext;
import stickman.Entities.HeroPathState.StandState;
import static org.junit.Assert.*;

public class StandStateTest {
    private StandState standState;
    private HeroPathStateContext heroPathStateContext;
    @Before
    public void setup(){
        standState = new StandState(0);
        heroPathStateContext = new HeroPathStateContext(HeroPathStateContext.Actor.DEFAULT,0);
    }

    @Test
    public void handleTest(){
        assertEquals("/actors/default/ch_stand1.png", standState.handle(heroPathStateContext,0));
    }
}
