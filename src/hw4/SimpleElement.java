package hw4;

import java.awt.Rectangle;

import api.AbstractElement;

// TODO:
// Special documentation requirement: (see page 11 of documentation)
// you must add a comment to the top of the SimpleElement class
// with a couple of sentences explaining how you decided to organize
// the class hierarchy for the elements.

/**
 * Minimal concrete extension of AbstractElement. The <code>update</code> method
 * in this implementation just increments the frame count.
 * 
 * @author Aryan Saxena
 */
// TODO: This class must directly or indirectly extend AbstractElement
public class SimpleElement extends api.AbstractElement{
	/**
	 * stores x value of the top left corner of the rectangle that the element is a part of
	 */
	private double x;
	/**
	 * stores y value of the top left corner of the rectangle that the element is a part of
	 */
	private double y;
	/**
	 * creates a rectangle for the element
	 */
	private Rectangle rect;
	/**
	 *the number of frames the element has existed for
	 */
	private int frameCount;
	/**
	 * checks if the element is marked for deletion 
	 */
	private boolean marked;
	/**
	 * Constructs a new SimpleElement.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	
	
	public SimpleElement(double x, double y, int width, int height) {
		this.x=x;
		this.y=y;
		rect = new Rectangle(width, height);
		rect.x=  (int) Math.round(x);
		rect.y= (int) Math.round(y);
		frameCount=0;
		marked=false;
	}
	
	/**
	 * returns the rounded off integer value of x
	 */
	@Override
	public int getXInt() {
		
		return rect.x;
	}

	@Override
	public int getYInt() {
		return rect.y;
	}

	@Override
	public int getWidth() {
		return (int) rect.getWidth();
	}

	@Override
	public int getHeight() {
		return (int) rect.getHeight();
	}

	@Override
	public Rectangle getRect() {
		return rect;
	}

	@Override
	public void setPosition(double newX, double newY) {
		x=newX;
		y=newY;
		
		rect.x = (int) Math.round(newX);
		rect.y = (int) Math.round(newY);
	}

	@Override
	public double getXReal() {
		return x;
	}

	@Override
	public double getYReal() {
		return y;
	}

	@Override
	public void update() {
		frameCount++;
	}

	@Override
	public int getFrameCount() {
		
		return frameCount;
	}

	@Override
	public boolean isMarked() {
		if(marked)
			return true;
		return false;
	}

	@Override
	public void markForDeletion() {
		marked=true;
	}
	
	@Override
	public boolean collides(AbstractElement other) {
		return rect.intersects(other.getRect()); 
	}
}
	
