package pl.coderslab.app.pong;

public class HumanPaddle {

    //Applet window gonna prob be 500x300

    private int yCor = 0;
    final int xCor = 30;

    public HumanPaddle(){

        setyCor(120);
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
}