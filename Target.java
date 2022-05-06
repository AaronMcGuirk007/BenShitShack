import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class is the Target class which is used for the collisions made with the
 * Bullet class
 * 
 * @author Aaron McGuirk, Ben McColgen, Adam Leonard, Ethan Bartlett, Jason
 *         Macutek
 * @version Spring 2022
 */

public class Target {

    private final int radius = 50;
    private final int GAME_BOARD_SIZE = 1000;
    private int x, y, area;
    private Point centerPoint;
    private JComponent container;
    

    public Target(JComponent container) {
        // 1000 x 1000 gameboard size
        Random rand = new Random();
        this.x = rand.nextInt(GAME_BOARD_SIZE + 1);
        this.y = rand.nextInt(GAME_BOARD_SIZE + 1);
        this.area = (radius * 2) * (radius * 2);
        this.container = container;
        this.centerPoint = new Point(x, y);

        container.repaint();
    }

    public int getArea() {
        return this.area;
    }

    public Point getCenterPoint() {
        return this.centerPoint;
    }

    public void paint(Graphics g) {
        g.setColor(new Color(48, 213, 200));
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    

}