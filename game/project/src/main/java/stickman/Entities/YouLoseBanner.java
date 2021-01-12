package stickman.Entities;

public class YouLoseBanner extends Entity{

    private static final String imagePath = "/gameover.png";

    public YouLoseBanner (double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.layer = Layer.FOREGROUND;
    }


    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public Entity newInstance() {
        return new YouLoseBanner(this.getXPos(),this.getYPos());
    }

}
