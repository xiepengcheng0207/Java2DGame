package stickmanTest.EntitiesTest;

import org.junit.Before;
import org.junit.Test;
import stickman.Entities.Tree;
import static org.junit.Assert.*;

public class TreeTest {
    private Tree tree;

    @Before
    public void setup(){
        tree = new Tree(1, 1,1,1);
    }

    @Test
    public void getImagePathTest(){
        assertEquals("/tree.png", tree.getImagePath());
    }

    @Test
    public void newInstanceTest(){
        assertEquals(1, tree.newInstance().getXPos(), 0);
    }
}
