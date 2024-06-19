package hw4;

/**
 * An element that does not move. Instead, it is intended to appear on the
 * screen for a fixed number of frames.
 * 
 * @author Aryan Saxena
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class VanishingElement extends SimpleElement{
	/**
	 * the number of frames after which the element is supposed to vanish
	 */
	private int initialLife;
	/**
	 * Constructs a new VanishingElement.
	 * 
	 * @param x           x-coordinate of upper left corner
	 * @param y           y-coordinate of upper left corner
	 * @param width       element's width
	 * @param height      element's height
	 * @param initialLife the number of frames until this element marks itself for
	 *                    deletion
	 */
	public VanishingElement(double x, double y, int width, int height, int initialLife) {
		super(x, y, width, height);
		this.initialLife=initialLife;
	}
	
	/**
	 * updates the frame count, and deletes the element after initial life is over
	 */
	@Override
	public void update() {
		super.update();//increases the frameCount by 1
		if(initialLife<=0)
			this.markForDeletion();
		initialLife--;
	}
	

}
