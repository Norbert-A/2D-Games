package pl.coderslab.app;

public class PaddleHuman {

    private int yCor = 0;
    private int score;
    final int xCor = 30;

    public PaddleHuman(){

        setyCor(115);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
}