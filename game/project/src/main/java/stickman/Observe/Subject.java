package stickman.Observe;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void update();
}
