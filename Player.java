import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Player {

    private int score;

    public Player() {
        score = 0;
    }

    public void scorePoint() {
        score += 1;
        System.out.println("Scored 1 point");
    }

    public int getScore() {
        return score;
    }
}