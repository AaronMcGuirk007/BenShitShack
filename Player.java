import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class is the Player class which creates the Player who is going to play on
 * the gameboard.
 * 
 * @author Aaron McGuirk, Ben McColgen, Adam Leonard, Ethan Bartlett, Jason
 *         Macutek
 * @version Spring 2022
 */

public class Player {

    private int forward, reverse;
    private int score;
    private String name;
    private JComponent panel;
    private boolean moveLeft, moveRight, moveUp, moveDown;
    private boolean destroyed;

    public Player(String name, JComponent panel) {
        this.name = name;
        this.panel = panel;

        score = 0;

        forward = 0;
        reverse = 0;

        moveLeft = false;
        moveRight = false;
        moveUp = false;
        moveDown = false;

        destroyed = false;
    }

    public String getPlayerName() {
        return name;
    }
    public int getScore() {
        return score;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}

    