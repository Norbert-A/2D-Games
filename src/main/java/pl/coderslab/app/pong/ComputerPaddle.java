package pl.coderslab.app.pong;

public class ComputerPaddle {

    private int yCor = 0;
    private int score;
    final int xCor = 470;

    public ComputerPaddle(int ballCor){

        setyCor(ballCor);
        setScore(0);
    }

    public void setyCor(int yCor){

        this.yCor = yCor;

        if(yCor > 270){
            setyCor(270);
        }
        else if (yCor < 0){
            setyCor(0);
        }
    }

    public int getyCor(){
        return this.yCor;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

}