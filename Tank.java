import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * This Tank class is responsible for managing the movement and health of the tank(s)
 * given its start location and moves by what key is being pressed at the time
 */

public class Tank extends Sprite{
    //Movement speed, delay time between frames of animation, and the size of the tank
    private static final int MOVE_SPEED = 2;
    public static final int DELAY_TIME = 33;
    public static final int SIZE = 20;
    

    // latest location of the tank
    private Point centerPoint;
    private double upperLeftX, upperLeftY;
    //max coordinates the tank can be
    private int xMax, yMax;
    //health the tank has 
    private int health;

    //has the tanks health reached zero?
    private boolean done;
    //Booleans for when the tank is moving in a certain direction(Up, Down, Left, Right)
    private boolean movingUp, movingRight, movingDown, movingLeft;
    //Where the tank is being drawn
    private JComponent container;   

    private int xSpeed, ySpeed = 2;
    /**
     *  Constructs a new tank
     *  
     *  @param startCenter the initial point at which the center of the tank will be drawn
     *  @param container Swing component in which this ball is being drawn to allow for 
     *                   a call to the components repaint method
     */
    public Tank(Point startCenter, JComponent container){
        super(container);
        centerPoint = startCenter;
        upperLeftX = startCenter.x - SIZE / 2;
        upperLeftY = startCenter.y - SIZE / 2;
        this.yMax = container.getHeight() - SIZE;
        this.xMax = container.getWidth() - SIZE;
        this.container = container;  
        health = 3; 
    }

    public void paint(Graphics g){
        g.fillRect((int)upperLeftX, (int)upperLeftY, SIZE, SIZE);
    }


    public void run(){
        /* while(!done){ //isDone boolean from the sprite class

            
            sleep();
            
            if(movingUp){
                upperLeftY += ySpeed;
            }
            if(movingDown){
                upperLeftY -= ySpeed;
            }
            if(movingRight){
                upperLeftX += xSpeed;
            }
            if(movingLeft){
                upperLeftX -= xSpeed;
            }
        }
        container.repaint();
 */
    } 

    /**
    *   Returns dead if the tanks health is zero
    *
    *   @return Returns true if the tanks health is zero, false otherwise
     */
    public boolean done(){
        return done;
    }

    /**
    *   Method that delays by 33ms
     */
    protected void sleep(){
        try{
            sleep(DELAY_TIME);
        }catch(InterruptedException e){
        }
    }


    /**
    *   Movement methods that determine what direction the tank is moving 
    *   @return true if the direction of the key is being pressed
     */
    public void moveUp(){
        upperLeftY--;
        container.repaint();
    }
    public void moveRight(){
        upperLeftX++;
        container.repaint();

    }
    public void moveDown(){
        upperLeftY++;
        container.repaint();

    }
    public void moveLeft(){
        upperLeftX--;
        container.repaint();

    }

    public void shoot(){
        //Bullet newBullet = new Bullet(x, y, container)
    }

    /**
    *   Checks to see if a bullet is inside of the tank
    *
    *   @param bullet the bullet that is being checked to see if it is inside the tank
    *   @return true if the bullet has collided with the tank, false otherwise
     */
    public boolean contains(Point bullet){
        if(bullet.x > upperLeftX && bullet.x < upperLeftX + SIZE && bullet.y > upperLeftY 
        && bullet.y < upperLeftY + SIZE){
            return true;
        }
        return false;
    }

    /**
    * Method to be called for when the tank gets hit, the health will decrease
     */
    public void decreaseHealth()
    {
        if(health != 0){
            health--;
        } 

        if(health == 0){
            done = true;
        }
    }
}