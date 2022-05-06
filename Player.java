import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Player {

    private int score;
    private int health;
    private Tank currTank;

    public Player(Tank currTank) {
        this.currTank = currTank;
        score = 0;
        health = 100;
    }

    public void scorePoint() {
        score += 1;
        System.out.println("Scored 1 point");
    }

    public void hit(){
        if (health >= 25) {
            health -= 25;
        } else {
            currTank.destroyTank();
        }
    }

    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }

    public Point getPoint() {
        return new Point(currTank.getX(), currTank.getY());
    }
}