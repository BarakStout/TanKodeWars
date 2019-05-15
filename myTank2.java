import java.awt.Color;
import java.util.ArrayList;

public class myTank2 extends Tank{

	private int tankX;
	private int tankY;
	private int barrelAngle;
	
	//list all tanks in the world
	private ArrayList<Tank> tanks = null;
	
	// constructor already written for you
	public myTank2(int x, int y, int w, int h, int s, int r, Color c, String n) {
		super(x, y, w, h, s, r, c);
		tankX = x;
		tankY = y;
		barrelAngle = 0;
		setName(n);
	}
	
	// Main loop function that will be called over and over
	public void moveTank()
	{
	
		// do not modify
		goTo(tankX,tankY);		
		aim(barrelAngle);
		updateTankData();
		
		// YOUR CODE GOES HERE 
		// examples: 
		//	tankX++;
		//  bareelAngle = 45;
			
	}
	
	// You may add any function here
	
	
	
	
	// --------------  DO NOT Change any of the methods bellow ----------------
	private void updateXY()
	{
		tankX = getX();
		tankY = getY();
	}
	
	private void updateBarrelAngle()
	{
		barrelAngle = getBarrelAngle();
	}
	
	private void updateTankData()
	{
		updateXY();
		updateBarrelAngle();
	}

	public ArrayList<Tank> getTanks() {
		return tanks;
	}

	public void setTanks(ArrayList<Tank> t) {
		tanks = t;
	}
}
