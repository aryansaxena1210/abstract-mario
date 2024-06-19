package hw4;

/**
 * A follower element is one that is associated with another "base" element such
 * as a PlatformElement or LiftElement. Specifically, the follower element's
 * movement is determined by the movement of the base element, when the base
 * move up 10 pixels, the follower moves up 10 pixels. However, the follower may
 * not always be at a fixed location relative to the base. When the horizontal
 * velocity of the follower is set to a non-zero value, the follower will
 * oscillate between the left and right edges of the PlatformElement or
 * LiftElement it is associated with.
 * 
 * @author Aryan Saxena
 */
public class FollowerElement extends ChildElement {
	/**
	 * Constructs a new FollowerElement. Before being added to a "base" element such
	 * as a PlatformElement or LiftElement, the x and y coordinates are zero. When a
	 * base element is set, the initial x-coordinate becomes the base's
	 * x-coordinate, plus the given offset, and the y-coordinate becomes the base's
	 * y-coordinate, minus this element's height.
	 * 
	 * @param width         element's width
	 * @param height        element's height
	 * @param initialOffset when added to a base, this amount will be added to the
	 *                      bases's x-coordinate to calculate this element's initial
	 *                      x-coordinate
	 */
	public FollowerElement(int width, int height, int initialOffset) {
		super(width,height, initialOffset , 0 );
		setOffset(initialOffset);
		
	}

	@Override
	public void update() {
		//updating properties of follower element		
		setBounds( getAssociatedTo().getXReal()  , getAssociatedTo().getXReal() + getAssociatedTo().getWidth()  );
		//move the element without caring for bounds, and increments frame count by 1
		super.update();
		
		//fix the position if boundaries are crossed
		if ((this.getXReal()+this.getWidth() >= this.getMax() ) ) {
			setVelocity(-getDeltaX() + getAssociatedTo().getDeltaX(), 0);
			setPosition(max-getWidth(), getYReal());
		}
		else if( (getXReal()<= this.getMin())) {
			setVelocity(-getDeltaX() + getAssociatedTo().getDeltaX() , 0);
			setPosition(min, getYReal());
		}
	}
	
}
