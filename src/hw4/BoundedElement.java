package hw4;

/**
 * A bounded element is a Moving Element but it can only move within some bounds. If it crosses or touches
 * the bounds, the the velocity is reversed.
 * 
 * @author Aryan Saxena
 */
public abstract class BoundedElement extends MovingElement{
	/**
	 * minimum boundary of element
	 */
	protected double min;
	/**
	 * maximum boundary of element
	 */
	protected double max;
	
	/**
	 * Constructs a new Bounded Element
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public BoundedElement(double x, double y, int width, int height) {
		super(x, y, width, height);
	}
	
	/**
	 * sets the minimum and maximum bounds of the element
	 * @param min the minimum bound of element
	 * @param max the maximum bound of element
	 */
	public void setBounds(double min, double max) {
		if((max-min)<0) {
			return;
		}
		this.min=min;
		this.max=max;
	}
	
	/**
	 * returns minimum bound of the element
	 * @return the minimum bound of the element
	 */
	public double getMin() {
		return min;
	}

	/**
	 * returns the maximum bound of the element
	 * @return the minimum bound of element
	 */
	public double getMax() {
		return max;
	}
}
