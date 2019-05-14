import java.awt.Color;
import java.util.ArrayList;

public class myTank2 extends Tank{

	private int tankX;
	private int tankY;
	private int barrelAngle;
	
	//list all tanks in the world
	private ArrayList<Tank> tanks = null;
	
	private int targetX;
	private int targetY;
	
	public myTank2(int x, int y, int w, int h, int s, int r, Color c) {
		super(x, y, w, h, s, r, c);
		tankX = x;
		tankY = y;
		barrelAngle = 0;
	}
	
	public void moveTank()
	{
	
		// do not modify
		goTo(tankX,tankY);		
		aim(barrelAngle);
		updateTankData();
		
		tankX++ ;
		if(tankX > 375) tankY--;
		
		// YOUR CODE GOES HERE 
		
	}
	
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

	public void updateTanks(ArrayList<Tank> t)
	{
		tanks = t;
	}
}
