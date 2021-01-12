package stickman.model;

public class Caretaker {
    private Object obj;
    public Caretaker(Originator originator){
        this.save(originator);
    }
    public void save(Originator originator){
        this.obj = originator.save();
    }
    public void undo(Originator originator){
        originator.undo(this.obj);
    }

}
