package stickman.levels;
import stickman.Entities.Entity;
import stickman.Observe.Subject;
import stickman.view.BackgroundDrawer;

import java.util.List;

public interface Level extends Subject {
    List<Entity> getEntities();
    BackgroundDrawer getBGDrawer();
    double getHeight();
    double getWidth();
    void tick();
    double getFloorHeight();
    double getHeroX();
    double getHeroY();
    void setHeroX(double xPos);
    boolean jump();
    boolean shoot();
    boolean moveLeft();
    boolean moveRight();
    boolean stopMoving();
    boolean levelLost();
    boolean levelWon();
    Level newInstance();
}
