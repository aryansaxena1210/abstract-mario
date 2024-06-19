package hw4;

/**
 * An element in which the <code>update</code> method updates the position each
 * frame according to a <em>velocity</em> vector (deltaX, deltaY). The units are
 * assumed to be "pixels per frame".
 * 
 * @author Aryan Saxena
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class MovingElement extends SimpleElement{
	/**
	 * stores x and y velocity in first and second index of this array, respectively
	 */
	private double[] velocity;
	/**
	 * Constructs a MovingElement with a default velocity of zero in both
	 * directions.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public MovingElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		velocity = new double[2];
		this.velocity[0] = 0;
		this.velocity[1]=0;
	}
	
	/**
	 * sets the x an y velocity of the element 
	 * @param velocityX velocity of object in x direction
	 * @param velocityY velocity of object in  direction
	 */
	public void setVelocity(double velocityX, double velocityY) {
		this.velocity[0] = velocityX;
		this.velocity[1]=velocityY;
	}
	
	/**
	 * returns the component of velocity in x direction
	 * @return the component of velocity in x direction
	 */
	public double getDeltaX() {
		return velocity[0];
	}
	
	/**
	 * returns the component of velocity in y direction
	 * @return the component of velocity in y direction
	 */
	public double getDeltaY() {
		return velocity[1];
	}
	
	/**
	 * updates the frame count, and sets the element to its new position
	 */
	public void update() {
		super.update();//updates the frameCount by 1
		setPosition( getXReal() + velocity[0], getYReal() + velocity[1]);
	}
	
}
