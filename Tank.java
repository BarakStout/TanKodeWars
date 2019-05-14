import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Tank extends Component {
    private Rectangle tank;
    private int barrelSize;
    
    private Graphics2D g2d;
    private double barrelAngle;
    private double barrelRadius; // How far from the center the barrel is.
    
    private int targetX;
    private int targetY; 
    private int targetBarrelAngle;
    
    private Color color;
    
    public Tank(int x, int y, int w, int h, int s, int r, Color c) {
        tank = new Rectangle(x, y, w, h);
        barrelAngle = 0;
        barrelSize = s;
        barrelRadius = r;
        targetX = x;
        targetY = y;
        targetBarrelAngle = 0;
        color = c;
    }
    
    public int getX() {
    	return tank.x;
    }
    
    public int getY() {
    	return tank.y;
    }
    
    public int getWidth() {
    	return tank.width;
    }
    
    public int getHeight() {
    	return tank.height;
    }
    
    public int getBarrelAngle() {
    	return (int) barrelAngle;
    }
    
    public Color getColor() {
        return color;
    }
    
    private Rectangle getRectangle() {
        return tank;
    }
    
    public boolean intersects(Rectangle p) {
        return tank.intersects(p);
    }
    
    private void move() {
    	if(tank.x != targetX)
    		if(tank.x > targetX) tank.x--;
    		else tank.x++;
    	if(tank.y != targetY) 
    		if(tank.y > targetY) tank.y--;
    		else tank.y++;
    	if(barrelAngle != targetBarrelAngle)
    		if(barrelAngle > targetBarrelAngle) barrelAngle--;
    		else barrelAngle++;
    		
    }
    
    public void moveTank() {}
    public void updateTanks(ArrayList<Tank> t) {}
    
    public void goTo(int x, int y)
    {
    	targetX = x;
    	targetY = y;
    }
    
    public void aim(int degree)
    {
    	targetBarrelAngle = degree;
    }
    
    // Unified method that draws both the tank and its barrel at a given location and angle.
    public void draw(Graphics g) {
    	move();
        drawBox(g);
        drawBarrel(g);
    }
    
    // Draws the tank at a location.
    public void drawBox(Graphics g)
    {
    	//g.setColor(getColor());
        //g.fillRect(rect.x, rect.y, rect.width, rect.height);
    	
        g.setColor(getColor());
        g.fillRect(tank.x, tank.y, tank.width, tank.height);
        
    }
    
    // Draws the barrel at a location at an angle.
    public void drawBarrel(Graphics g) {
        
    	g.setColor(Color.BLACK);
    	
    	// How far off from the center the barrel is in x and y.
    	int offsetY = (int) (Math.sin(Math.toRadians(barrelAngle)) * barrelRadius);
    	int offsetX = (int) (Math.cos(Math.toRadians(barrelAngle)) * barrelRadius);
    	
    	g.fillOval(tank.x + tank.width / 2 - barrelSize / 2 + offsetX, tank.y + tank.height / 2 - barrelSize / 2 + offsetY, barrelSize, barrelSize);
  
    }
    
}