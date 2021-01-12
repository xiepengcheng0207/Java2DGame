package stickmanTest.EntitiesTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.Bullet;
import static org.junit.Assert.*;


public class BulletTestAndEntityTest {
    private Bullet bullet;
    private Bullet bulletTest;
    private enum testLayer {
        BACKGROUND, FOREGROUND, EFFECT
    }

    @Before
    public void setup(){
        bullet = new Bullet(0,0);
    }

    //BulletTest
    @Test
    public void getImagePathTest(){
        assertEquals("/bullet.png", bullet.getImagePath());
    }

    @Test
    public void newInstance(){
        assertEquals(0,bullet.newInstance().getXPos(),0);
    }

    //EntityTest
    @Test
    public void getXPosTest(){
        assertEquals(0,bullet.getXPos(),0);
    }

    @Test
    public void setXPosTest(){
        bullet.setXPos(1);
        assertEquals(1,bullet.getXPos(),0);
    }

    @Test
    public void getYPosTest(){
        assertEquals(0,bullet.getYPos(),0);
    }

    @Test
    public void setYPosTest(){
        bullet.setYPos(1);
        assertEquals(1,bullet.getYPos(),0);
    }
    @Test
    public void getHeightTest(){
        assertEquals(20,bullet.getHeight(),0);
    }
    @Test
    public void setHeightTest(){
        bullet.setHeight(1);
        assertEquals(1,bullet.getHeight(),0);
    }
    @Test
    public void getWidthTest(){
        assertEquals(20,bullet.getWidth(),0);
    }

    @Test
    public void setWidthTest(){
        bullet.setWidth(1);
        assertEquals(1,bullet.getWidth(),0);
    }

    @Test
    public void getXVelTest(){
        assertEquals(5, bullet.getXVel(),0);
    }

    @Test
    public void setXVelTest(){
        bullet.setXVel(1);
        assertEquals(1,bullet.getXVel(),0);
    }

    @Test
    public void getYVelTest(){
        assertEquals(5,bullet.getYVel(),0);
    }


    @Test
    public void setYVelTest(){
        bullet.setYVel(1);
        assertEquals(1,bullet.getYVel(),0);
    }


    @Test
    public void getLayerTest(){
        assertEquals(testLayer.FOREGROUND.toString(), bullet.getLayer().toString());
    }


    @Test
    public void intersectsTest(){
         bulletTest = new Bullet(0,0);
         bulletTest.setWidth(2);
         bulletTest.setHeight(2);
         bullet.setXPos(1);
         bullet.setYPos(1);
         assertTrue(bullet.intersects(bulletTest));
         bullet.setYPos(100);
         bullet.setXPos(100);
         assertFalse(bullet.intersects(bulletTest));
    }

}
