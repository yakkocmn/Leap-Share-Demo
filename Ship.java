import java.awt.Color;
import java.awt.Graphics;


/*
 * A simple thing to keep onscreen in a Leap demo...it can move, change size, and change color.
 */
public class Ship
{
	private int x, y;
	
	private int radius = 30;
	
	private Color clr;
	
	public Ship(int x, int y)
	{
		this.x = x;
		this.y = y;
		clr = Color.BLUE;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getRadius() { return radius; }
	
	
	/*
	 * Change the x-coord of the ship but keep the center onscreen.
	 */
	public void changeX( int delta ) 
	{ 
		x += delta;
		
		if(x < 0) x = 0;
		if(x > LeapDemoFramePollingDrawingArea.WIDTH) x = LeapDemoFramePollingDrawingArea.WIDTH;
	}
	
	/*
	 * Change the y-coord of the ship but keep the center onscreen.
	 */
	public void changeY( int delta ) 
	{ 
		y += delta; 
	
		if(y < 0) y = 0;
		if(y > LeapDemoFramePollingDrawingArea.HEIGHT) y = LeapDemoFramePollingDrawingArea.HEIGHT;
		
	}
	
	/*
	 * Changes the radius by some amount (pos. or neg.) and maintains certain size limits.
	 */
	public void changeRadius( int delta )
	{
		radius += delta;
		
		if(radius < 3) radius = 3;		// a minimum size
		if(radius > 120) radius = 120;	// a maximum size
	}
	 
	/*
	 * Changes the color to some random color
	 */
	public void changeColor()
	{
		clr = new Color( 	(int)(Math.random()*255), 
							(int)(Math.random()*255), 
							(int)(Math.random()*255) 
						);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(clr);
		g.fillOval(x - radius, y - radius, 2*radius, 2*radius);
	}
}
