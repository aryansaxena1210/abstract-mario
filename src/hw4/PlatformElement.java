package hw4;

/**
 * A PlatformElement is an element with two distinctive behaviors. First, it can
 * be set up to move horizontally within a fixed set of boundaries. On reaching
 * a boundary, the x-component of its velocity is reversed. Second, it maintains
 * a list of <em>associated</em> elements whose basic motion all occurs relative
 * to the PlatformElement.
 * 
 * @author Aryan Saxena
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class PlatformElement extends ParentElement {
	
	/**
	 * Constructs a new PlatformElement. Initially the left and right boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public PlatformElement(double x, double y, int width, int height) {
	super(x, y, width, height);	
	}

	/**
	 * updates the position of the Platform element and the elements associated with it, and deletes
	 * the associated elements that are marked from deletion
	 */
	@Override
	public void update() {
		super.update();//moves the element, updates the frameCount by 1
		
		//fix the position if boundaries are crossed
		if ((getXReal()+getWidth() >= max ) ) {
			setVelocity(-getDeltaX(), 0);
			setPosition(max-getWidth(), getYReal());
		}
		else if( (getXReal()<= min)) {
			setVelocity(-getDeltaX(), 0);
			setPosition(min, getYReal());
		}
		
		for(ChildElement e : associated) {
			e.update();
		}
		
		deleteMarkedAssociated();
	}

	
	@Override
	public void addAssociated(FollowerElement f) {
		getAssociated().add(f);
		f.setBase(this);
		f.setVelocity(this.getDeltaX()+f.getDeltaX(), 0);
		
	}
	
}
