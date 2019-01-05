package pl.coderslab.app.pong;

public class PaddleComputer {

    private int yCor = 0;
    private int score;
    final int xCor = 460;

    public PaddleComputer(int ballCor){

        setyCor(ballCor);
        setScore(0);
    }

    public void setyCor(int cor){

        this.yCor = cor;
        if(yCor > 230){
            setyCor(230);
        }
        else if(yCor < 0){
            setyCor(0);
        }
    }

    public int getyCor(){
        return yCor;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }
}