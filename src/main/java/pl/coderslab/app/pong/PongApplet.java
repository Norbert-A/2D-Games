package pl.coderslab.app.pong;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class PongApplet extends Applet implements MouseMotionListener, ActionListener {

    Ball ball;
    PaddleHuman hPaddle;
    PaddleComputer cPaddle;

    Font newFont = new Font("sansserif", Font.BOLD, 20);

    Graphics bufferGraphics;

    Image offscreen;

    final int WIDTH = 500, HEIGHT = 300;

    long currentTime;

    long highscoreTime;

    Timer time = new Timer(15, this);

    public void init() {

        setSize(WIDTH, HEIGHT);

        ball = new Ball();
        hPaddle = new PaddleHuman();
        cPaddle = new PaddleComputer(ball.getY() - 35);

        addMouseMotionListener(this);
        setBackground(Color.black);

        offscreen = createImage(WIDTH, HEIGHT);
        bufferGraphics = offscreen.getGraphics();

    }

    public void start() {

        currentTime = System.currentTimeMillis();
        time.start();

    }

    public void actionPerformed(ActionEvent arg0) {

        stop();
        ball.move();
        cPaddle.setyCor(ball.getY() - 35);
        checkCollision();
        repaint();

    }

    public void stop() {

        if (cPaddle.getScore() == 3) {
            time.stop();
            highscoreTime = (System.currentTimeMillis()-currentTime)/1000;
        }

    }

    public void checkCollision() {

        if(ball.getY() <= 0 || ball.getY() >= 290) {

            ball.directionY = (ball.directionY * -1);
        }

        if((ball.getX() == 40) && hitLeftPaddle()) {

            ball.directionX = (ball.directionX * -1);
        }

        if(ball.getX() == 470 && hitRightPaddle()){

            ball.directionX = (ball.directionX * -1);
        }

        if(ball.getX() == 0) {

            cPaddle.setScore(cPaddle.getScore() + 1);
            ball.reset();
        }
    }

    public boolean hitLeftPaddle()
    {
        boolean hit = false;

        if((hPaddle.getyCor() - 10) <= ball.getY() && (hPaddle.getyCor() + 70) > ball.getY()) {

            if(hPaddle.getyCor() + 35 < ball.getY()) {

                ball.directionY = 6;

            } else {

                ball.directionY = -6;
            }
            hit = true;
        }
        return hit;
    }

    public boolean hitRightPaddle() {
        boolean hit = false;

        if((cPaddle.getyCor() - 10) <= ball.getY() && (cPaddle.getyCor() + 70) > ball.getY()) {

            if(cPaddle.getyCor() + 35 < ball.getY()) {

                ball.directionY = 5;

            } else {

                ball.directionY = -5;
            }
            hit = true;
        }
        return hit;
    }

    public void paint(Graphics g) {

        bufferGraphics.clearRect(0,0,WIDTH,HEIGHT);

        bufferGraphics.setColor(Color.white);

        bufferGraphics.fillRect(hPaddle.xCor, hPaddle.getyCor(),10,70);

        bufferGraphics.fillRect(cPaddle.xCor, cPaddle.getyCor(),10,70);

        bufferGraphics.setColor(Color.lightGray);

        bufferGraphics.setFont(newFont);

        bufferGraphics.drawString(" " + cPaddle.getScore(),245,18);

        if(cPaddle.getScore() == 3) {

            bufferGraphics.drawString("You Lasted: " + highscoreTime + " seconds!", 50, 180);
        }

        bufferGraphics.setColor(Color.white);

        bufferGraphics.fillRoundRect(ball.getX(),ball.getY(),10,10, 10, 10);

        g.drawImage(offscreen,0,0,this);

        Toolkit.getDefaultToolkit().sync();
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void mouseMoved(MouseEvent evt)
    {
        hPaddle.setyCor(evt.getY() -35);
    }

    public void mouseDragged(MouseEvent evt) {

    }
}