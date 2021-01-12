package stickmanTest.EntitiesTest.FloorTileFactoryTest;
import org.junit.Before;
import org.junit.Test;
import stickman.Entities.FloorTileFactory.DefaultDirtFloorTile;
import stickman.Entities.FloorTileFactory.DefaultFloorTileFactory;
import stickman.Entities.FloorTileFactory.FloorTileFactory;

import static org.junit.Assert.*;
public class FloorTileFactoryTest {
    private DefaultFloorTileFactory defaultFloorTileFactory;

    @Before
    public void setup(){
        defaultFloorTileFactory = new DefaultFloorTileFactory();
    }
    @Test
    public void createFloorTileTest(){
        assertEquals("/floor_tile/default/top.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.TOP, 1, 1,1 ,1).getImagePath());
        assertEquals("/floor_tile/default/dirt.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.DIRT, 1, 1,1 ,1).getImagePath());
        assertEquals("/floor_tile/default/left.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.LEFT, 1, 1,1 ,1).getImagePath());
        assertEquals("/floor_tile/default/right.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.RIGHT, 1, 1,1 ,1).getImagePath());
        assertEquals("/floor_tile/default/left_corner.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.LEFT_CORNER, 1, 1,1 ,1).getImagePath());
        assertEquals("/floor_tile/default/right_corner.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.RIGHT_CORNER, 1, 1,1 ,1).getImagePath());

    }

    @Test
    public void buildTileTest(){
        assertEquals("/floor_tile/default/top.png", defaultFloorTileFactory.buildTile(FloorTileFactory.Path.TOP,1,1,1,1).getImagePath());
    }

    @Test
    public void newInstanceTest(){
        assertEquals("/floor_tile/default/top.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.TOP, 1, 1,1 ,1).newInstance().getImagePath());
        assertEquals("/floor_tile/default/dirt.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.DIRT, 1, 1,1 ,1).newInstance().getImagePath());
        assertEquals("/floor_tile/default/left.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.LEFT, 1, 1,1 ,1).newInstance().getImagePath());
        assertEquals("/floor_tile/default/right.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.RIGHT, 1, 1,1 ,1).newInstance().getImagePath());
        assertEquals("/floor_tile/default/left_corner.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.LEFT_CORNER, 1, 1,1 ,1).newInstance().getImagePath());
        assertEquals("/floor_tile/default/right_corner.png", defaultFloorTileFactory.createFloorTile(FloorTileFactory.Path.RIGHT_CORNER, 1, 1,1 ,1).newInstance().getImagePath());
    }
}