package hw4;

/**
 * Moving element in which the vertical velocity is adjusted each frame by a
 * gravitational constant to simulate gravity. The element can be set to
 * "grounded", meaning gravity will no longer influence its velocity.
 * 
 * @author Aryan Saxena
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class FlyingElement extends MovingElement{
	
	/**
	 * the value of gravity
	 */
	private double gravity;
	/**
	 * hold if the element is grounded or not
	 */
	private boolean grounded;
	/**
	 * Constructs a new FlyingElement. By default it should be grounded, meaning
	 * gravity does not influence its velocity.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public FlyingElement(double x, double y, int width, int height) {
		super(x,y,width,height);//increases frame count and sets memory to velocity[] array
	}
	
	/**
	 * updates the frame count, and position of the element, with respect to velocity and gravity
	 * acting on it
	 */
	@Override
	public void update() {
		super.update();//updates the frameCount by 1, and changes positions by adding deltaX and deltaY to x and y
		if(!isGrounded()) 
			setVelocity( getDeltaX() , getDeltaY() + gravity );
	}
	
	/**
	 * sets the value of gravity acting on the object
	 * @param gravity the gravity acting on the elemtn
	 */
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	/**
	 * checks if element is grounded or not
	 * @return if element is grounded or not
	 */
	public boolean isGrounded() {
		return grounded;
	}
	/**
	 * sets the value of grounded
	 * @param grounded is the element grounded
	 */
	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}
}
