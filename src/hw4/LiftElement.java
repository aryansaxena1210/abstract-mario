package hw4;

/**
 * An element with two distinctive behaviors. First, it can be set up to move
 * vertically within a fixed set of boundaries. On reaching a boundary, the
 * y-component of its velocity is reversed. Second, it maintains a list of
 * <em>associated</em> elements whose basic motion all occurs relative to the
 * LiftElement.
 * 
 * @author Aryan Saxena
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class LiftElement extends ParentElement{
	

	/**
	 * Constructs a new Elevator. Initially the upper and lower boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public LiftElement(double x, double y, int width, int height) {
		super (x, y, width, height);
	}
	
	/**
	 * updates the position of the Lift Element and the elements associated with it, and deletes
	 * the associated elements that are marked from deletion
	 */
	@Override
	public void update() {
		super.update();

		if ((getYReal()+getHeight() >= max ) ) {
			setVelocity(0, -getDeltaY());
			setPosition(getXReal(), max - getHeight());
		}
		else if( (getYReal()<= min)) {
			setVelocity(0, -getDeltaY());
			setPosition(getXReal(), min);
		}
		
		for(ChildElement e : associated) {
			e.update();
		}
		deleteMarkedAssociated();
	}
	
	/**
	 * associates a child to this lift element
	 */
	public void addAssociated(FollowerElement f) {
		getAssociated().add(f);
		f.setBase(this);
	}
}