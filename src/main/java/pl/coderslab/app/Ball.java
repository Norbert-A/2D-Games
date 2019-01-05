package pl.coderslab.app;

public class Ball{

    private int xCor;
    private int yCor;

    public int directionX = 5, directionY = -5;

    public Ball(){

        setCor(250, 145);
    }

    public void setCor(int x, int y){
        this.xCor = x;
        this.yCor = y;
    }

    public int getX(){
        return xCor;
    }

    public int getY(){
        return yCor;
    }

    public void move(){

        setCor(this.getX() + directionX, this.getY() + directionY);
    }

    public void reset(){

        setCor(250,145);
        directionX = 5;
        directionY = -5;
    }
}