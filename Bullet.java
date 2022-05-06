import java.awt.*;
import javax.swing.*;
/**This class is supossed to create a threaded bullet object that requires the 
 * current position of the tank in order to be created. Then shoots the bullet object in a straight line
 * from the Point that was in the constructor
 * credit to Dr. Teresco for bulletCollidesWithTank method
 */
public class Bullet extends Sprite{

    //how much to increment the x by
    protected int xSpeed = 2;
    //how much to increment the y by
    protected int ySpeed = 2;
    //boolean to decide if either a collision occured or if the bullet reached the border
    protected boolean done;
    //the width of the bullet
    protected int width = 8;
    //the height of the bullet
    protected int height = 8;
    //the radius of the bullet 
    protected int radius = 4;
    // delay time between frames of animation (ms)
	public static final int DELAY_TIME = 33;
    //Where the bullet is being drawn
    private JComponent container;  
    //I dont know what you want startPos to be 
    private Point startPos;
    //tank1 info
    protected int tank1X, tank1Y, tank1W, tank1H;
    //tank1 info
    protected int tank2X, tank2Y, tank2W, tank2H;
    

    /**
	 * Construct a new BouncingGravityBall object.
	 * 
	 * @param start the initial point at which the tank was when the bullet object was created
	 * @param container   the Swing component in which this bullet is being
	 *                    drawn to allow it to call that component's repaint method
	 */

	public Bullet(Point startPos, int tank1X, int tank1Y, int tank1W, int tank1H, 
                int tank2X, int tank2Y, int tank2W, int tank2H, JComponent container) {
            
            super(container);
            
            //Can we change this to be a point instead of x and y?
            this.startPos = startPos;
            
            

            this.tank1X = tank1X;
            this.tank1Y = tank1Y;
            this.tank1W = tank1W;
            this.tank1H = tank1H;

            this.tank2X = tank2X;
            this.tank2Y = tank2Y;
            this.tank2W = tank2W;
            this.tank2H = tank2H;
    }

    /**
	 * Draw the bullet at its current location.
	 * 
	 * @param g the Graphics object on which the ball should be drawn
	 */
	public void paint(Graphics g) {
        g.setColor(Color.BLACK);
		g.fillOval(startPos.x, startPos.y, width, height);
	}


    /**
	 * This object's run method
	 */
	@Override
	public void run() {
        done = false;
		while (!done) {


			// every iteration, update the coordinates
			// by a pixel
			startPos.x += xSpeed;
			startPos.y += ySpeed;
           
            //Check for a collision with the border
            if(startPos.x < 0 || startPos.x > container.getWidth()){
                done = true;
            }else if (startPos.y < 0 || startPos.y > container.getHeight()){
                done = true;
            }
            
            //check for collisions with other objects
            //checks for bullet collision with tank1
            if(bulletCollidesWithTank(startPos.x, startPos.y, radius, tank1X, 
            tank1Y, tank1W, tank1H)){
                done = true;
            }
            //checks for collision with tank2
            if(bulletCollidesWithTank(startPos.x, startPos.y, radius, tank2X, 
            tank2Y, tank2W, tank2H)){
                done = true;
            }else{

			container.repaint();
            }
		}
	}


    /**
    * Return true if the given circle overlaps the given rectangle.
    * 
    *
    * 
    * This method checks to see if the bullet object overlaps with the tank object 
    * 
    * @param circleX x-coordinate of the center of the bullet
    * @param circleY y-coordinate of the center of the bullet
    * @param circleR radius of the circle
    * @param rectX   the x-coordinate of the upper-left corner of the rectangle
    * @param rectY   the y-coordinate of the upper-left corner of the rectangle
    * @param rectW   the width of the rectangle
    * @param rectH   the height of the rectangle
    * @return true if the given circle overlaps the given rectangle
    */
   public static boolean bulletCollidesWithTank(int circleX, int circleY,
         int circleR,
         int rectX, int rectY,
         int rectW, int rectH) {
        int rectCX = rectX + rectW / 2;
        int rectCY = rectY + rectH / 2;
        // x and y distances between the circle and rectangle
        int dx = Math.abs(circleX - rectCX);
        int dy = Math.abs(circleY - rectCY);

        // check if beyond the bounds of the expanded rectangle
        if (dx > (rectW / 2 + circleR))
            return false;
        if (dy > (rectH / 2 + circleR))
            return false;

        // is circle center within the expanded rectangle
        if (dx <= rectW / 2)
            return true;
        if (dy <= rectH / 2)
            return true;

        // check corners
        int cornerDistSq = ((dx - rectW / 2) * (dx - rectW / 2) +
                    (dy - rectH / 2) * (dy - rectH / 2));
        if (cornerDistSq <= circleR * circleR)
            return true;

        // must not collide
            return false;
    }
}
