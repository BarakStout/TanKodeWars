import java.awt.*;

import java.util.ArrayList;

public class Tank extends Component {

	private Rectangle tank;
    private String name;
    private int barrelSize;
    
    // TODO: add shellVelocity based on tank class
    private int shellVelocity = 2;
    
    private double barrelAngle;
    private double barrelRadius; // How far from the center the barrel is.
    
    private int targetX;
    private int targetY; 
    private int targetBarrelAngle;
    private boolean fired = false;
    
    // Limit number of shells
    private int shells = 1;
    
    private Color color;
    
    // Constructor 
    public Tank(int x, int y, int w, int h, int s, int r, Color c) {
        tank = new Rectangle(x, y, w, h);
        barrelAngle = 0;
        barrelSize = s;
        barrelRadius = r;
        targetX = x;
        targetY = y;
        targetBarrelAngle = 0;
        color = c;
        name = "";
    }
    
    // Method to set the tanks name
    public void setName(String s)
    {
    	name = s;
    }
    
    // --- GETTERS ----------------------------------------
    public String getName()
    {
    	return name;
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
    // ----------------------------------------------------
    
    // TODO: need better collision detection
    public boolean intersects(Rectangle p) {
        return tank.intersects(p);
    }
    
    // TODO: make sure tank isn't outside of battle area
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

    // TODO: make sure x and y are within the battle area
    // sets an x,y coordinates to move the tank to
    public void goTo(int x, int y)
    {
    	targetX = x;
    	targetY = y;
    }
    
    // set barrel target angle to degree
    public void aim(int degree)
    {
    	targetBarrelAngle = degree;
    }
    
    // TODO: set timer for cool down. Right now each tank has 1 shot 
    public void fireShell()
    {
    	if (shells > 0)
    		fired = true;
    }
    
    // returns whether a shell was just fired or not
    public boolean fire()
    {
    	return fired;
    }
    
    // TODO: verify math
    // Gets a Shell object that was just fired
    public Shell getShell()
    {
    	fired = false;
    	shells--;
    	
    	// How far off from the center the barrel is in x and y.
    	int offsetY = (int) (Math.sin(Math.toRadians(barrelAngle)) * barrelRadius);
    	int offsetX = (int) (Math.cos(Math.toRadians(barrelAngle)) * barrelRadius);
    	
    	return new Shell(tank.x + tank.width / 2 - barrelSize / 2 + offsetX, tank.y + tank.height / 2 - barrelSize / 2 + offsetY, barrelRadius, barrelAngle, shellVelocity);
    }
    
    // Unified method that draws both the tank and its barrel at a given location and angle.
    public void draw(Graphics g) {
    	move();
        drawTank(g);
        drawBarrel(g);
    }
    
    // Draws the tank at a location.
    public void drawTank(Graphics g)
    {
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

    //TODO: better collision detection... 
	public boolean intersects(Shell s) {
		return s.getX() >= tank.x && s.getX() < tank.x + tank.width && s.getY() >= tank.y && s.getY() < tank.y + s.getY();
	}
	
	// To be implemented by child class
	public void moveTank() {}
    public void updateTanks(ArrayList<Tank> t) {}
    public void setTanks(ArrayList<Tank> tanks) {}
    
}