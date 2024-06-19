package hw4;

import api.AbstractElement;

/**
 * a child element is an element that can be associated to a parent element, and its motion is 
 * relative to the motion of the parent element
 * 
 * @author Aryan Saxena
 */
public class ChildElement extends BoundedElement{
	
	/**
	 * hold the parent element that the child is associated to
	 */
	private MovingElement associatedTo;
	/**
	 * hold the value of offset from of the child from the left end of the parent
	 */
	private int offset;
	/**
	 * hold the value of hover of the child from the top of the parent element
	 */
	private int hover;
	
	/**
	 * Constructs a new Child Element.
	 * 
	 * @param width  element's width
	 * @param height element's height
	 * @param offset when added to a base object, this amount will be added to the
	 *               other object's x-coordinate to calculate this element's
	 *               x-coordinate
	 * @param hover  when added to a base object, this element's y-coordinate is the
	 *               other object's y-coordinate, minus this element's height, minus
	 *               the hover amount
	 */
	public ChildElement(int width, int height, int offset, int hover) {
		super(0, 0, width, height);
		this.offset=offset;
		this.hover=hover;
	}
	
	
	/**
	 * sets the base of the child element to the parent element
	 * @param newBase the element which is supposed to become the base
	 */
	public void setBase(AbstractElement newBase) {
		
		associatedTo =  (MovingElement) newBase;
		setPosition(newBase.getXReal()+this.offset, newBase.getYReal()-this.hover-this.getHeight());//sets x,y,rect.x and rect.y
		setBounds(newBase.getXReal(), newBase.getXReal() + newBase.getWidth());
	}
	
	/**
	 * gets the offset of the child from parent
	 * @return the offset of the child from parent
	 */
	public int getOffset() {
		return offset;
	}
	/**
	 * sets the offset of the child from parent
	 * @param offset the offset of the child from parent
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}
	/**
	 * gets the hover of the child from parent
	 * @return the hover of the child from parent
	 */
	public int getHover() {
		return hover;
	}
	/**
	 * sets the hover of the child from parent
	 * @param hover the hover of the child from parent
	 */
	public void setHover(int hover) {
		this.hover = hover;
	}
	/**
	 * gets the parent element the child is associated to
	 * @return the parent element the child is associated to
	 */
	protected MovingElement getAssociatedTo() {
		return associatedTo;
	}
}
