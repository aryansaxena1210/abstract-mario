package hw4;

import java.util.ArrayList;
/**
 * A parent element is a Bounded Element to which Child Elements can be associated to.
 * 
 * @author Aryan Saxena
 */
public abstract class ParentElement extends BoundedElement {
	/**
	 * hold an ArrayList of all the elements that are attached to this parent element
	 */
	protected ArrayList<ChildElement> associated;
	
	/**
	 * Constructs a new parent element
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public ParentElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		associated=new ArrayList<ChildElement>();
	}
	
	/**
	 * Associates a new Attached Element this parent element
	 * @param attachedElement the element that is being attached to this parent
	 */
	public void addAssociated(AttachedElement attachedElement) {
		getAssociated().add(attachedElement);
		attachedElement.setBase(this);
	}
	
	/**
	 * Associates a new Follower Element this parent element
	 * @param f The follower element that is to be attached to the parent
	 */
	public abstract void addAssociated(FollowerElement f);
	
	/**
	 * deletes those child elements that are marked for deletion
	 */
	public void deleteMarkedAssociated() {
		for(ChildElement e : associated) {
			if(e.isMarked())
				associated.remove(e);
		}
	}
	
	/**
	 * Returns the ArrayList of all child elements associated with the parent
	 * @return the ArrayList of all child elements associated with the parent
	 */
	public ArrayList<ChildElement> getAssociated() {
		return associated;
	}
	
}
