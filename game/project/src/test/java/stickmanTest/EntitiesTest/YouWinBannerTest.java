package stickmanTest.EntitiesTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.YouWinBanner;
import static org.junit.Assert.*;
public class YouWinBannerTest {
    private YouWinBanner youWinBanner;

    @Before
    public void setup(){
        youWinBanner = new YouWinBanner(0, 0);
    }

    @Test
    public void getImagePathTest(){
        assertEquals("/youwin.png", youWinBanner.getImagePath());
    }

    @Test
    public void newInstanceTest(){
        assertEquals(0, youWinBanner.newInstance().getXPos(), 0);
    }
}
