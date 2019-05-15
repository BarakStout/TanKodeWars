import java.awt.*;

public class Shell {
	
	private int centerX;
	private int centerY;
	private int radius;
	private int direction;
	private int velocity;
	
	public Shell(int x, int y, double barrelRadius, double barrelAngle, int v)
	{
		centerX = x;
		centerY = y;
		radius = (int) barrelRadius;
		direction = (int) barrelAngle;
		velocity = v;
	}
	
	public int getX()
	{
		return centerX;
	}
	
	public int getY()
	{
		return centerY;
	}
	
	// TODO: verify that math is correct to update shell new x,y
	// TODO: add velocity? 
	private void move()
	{
		centerX += velocity*Math.ceil(Math.cos(direction));
		centerY += velocity*Math.ceil(Math.sin(360-direction));
	}
	
	// Draws the shell
    public void drawShell(Graphics g) {
		move();
    	g.setColor(Color.RED);
    	g.fillOval(centerX, centerY, radius, radius);
  
    }
	
}
