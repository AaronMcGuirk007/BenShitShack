import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Graphics;

/**
 * Description of game class _____.
 * 
 * @author Aaron McGuirk, Ethan Bartlett, Jason Macutek, Adam Leonard, Ben McColgen
 * @version Spring 2022
 */

public class Game extends SpriteController implements KeyListener {

	//Delay for the animations
	public static final int DELAY_TIME = 33;

	// list of Sprites
	private java.util.List<Sprite> list;

	private java.util.List<Tank> tanks;

	//The tanks
	public Tank tank1;
	public Tank tank2;

	//Terrain

	//The targets
	//private Target target1;


    //the container of the game
	public JPanel container;


    //list of booleans to track keyPresses
    boolean[] keys = new boolean[255];

	// an object to serve as the lock for thread safety of our list access
	private Object lock = new Object();


	public Game(){

		super("Tanks", 1000, 1000);
	}
	/*


	/**
     * Draw the Tanks and targets
     * 
     * @param g the Graphics object in which to draw
     */
    @Override
    protected void paint(Graphics g) {
		
        tank1.paint(g);
		tank2.paint(g);
        //terrain.paint(g);
    }

	/**
     * Add the mouse listeners to the panel. Here, we need methods
     * from both MouseListener, as the MouseMotionListener will be
     * the BreakoutPaddle.
     * 
     * @param p the JPanel to which the mouse listeners will be
     *          attached
     */
    @Override
    protected void addListeners(JPanel panel) {
		
       	panel.addKeyListener(this);
    }

	/**
     * Add the panel to the frame, and set up additional components, which
     * here are the BreakoutBall and the BreakoutBricks, also setting up
     * a repaint thread.
     * 
     * @param frame the JFrame to which the panel is added
     *              be added
     * @param container the JPanel where graphics will be drawn
     */
    protected void buildGUI(JFrame frame, JPanel container) {

        tank1 = new Tank(new Point(100,100),container, 0);
		tank2 = new Tank(new Point(900,900),container, 1);

		frame.addKeyListener(this);
        frame.add(container);

        // repaint regularly forever thread
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Sprite.sleepWithCatch(DELAY_TIME);
                    container.repaint();
                }

            }
        }.start();
    }


	/**
	 * Tank movement and firing method
	 * Player 1 movement:
	 *  W
	 * ASD 
	 * Player 1 Fire
	 * G
	 * 
	 * Tank2m movement:
	 *  ^
	 * <V>
	 *	Tank2 Fire
	 *	L
	 *
	 * @param e mouse event info
	 */
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {
			tank1.moveUp();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			tank1.moveDown();
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			tank1.moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			tank1.moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_G) {
			tank1.shoot();
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			tank2.moveUp();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			tank2.moveDown();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			tank2.moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			tank2.moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			tank2.shoot();
			
		}
		container.repaint();
		// trigger paint so we can see the tank in its new location
	}

	//unused method to satisfy the interfaces.
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e){}

	public static void main(String args[]) {

		// The main method is responsible for creating a thread (more
		// about those later) that will construct and show the graphical
		// user interface.
		javax.swing.SwingUtilities.invokeLater(new Game());
	}
}
