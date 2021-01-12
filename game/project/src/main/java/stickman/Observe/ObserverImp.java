package stickman.Observe;

public class ObserverImp implements Observer{
    private int life;
    private int score;
    private int time;


    @Override
    public void notify(String type, int value) {
        switch (type){
            case("score"):
                score = value;
                break;
            case("life"):
                life = value;
                break;
            case("time"):
                time = value;
                break;

        }
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getTime() {
        return time;
    }



}
