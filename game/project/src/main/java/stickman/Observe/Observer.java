package stickman.Observe;

public interface Observer {
    public void notify(String type, int value);

    public int getLife();

    public int getScore();

    public int getTime();
}
