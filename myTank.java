import java.awt.Color;
import java.util.ArrayList;

public class myTank extends Tank{

	private int tankX;
	private int tankY;
	private int barrelAngle;
	
	//list all tanks in the world
	private ArrayList<Tank> tanks = null;
	
	private int targetX;
	private int targetY;
	
	public myTank(int x, int y, int w, int h, int s, int r, Color c) {
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
		
		if(tanks != null)
			for(Tank t: tanks)
				if(t.getX() != tankX)
				{
					targetX = t.getX();
					targetY = t.getY();
				}
		
		barrelAngle = (int) Math.toDegrees(Math.atan(((double) tankY - targetY)/(tankX - targetX)));
		
		System.out.println("Target: " + targetX + " " + targetY);
		System.out.println("Own: " + tankX + " " + tankY);
		System.out.println("Slope: " + (tankY - targetY)/(tankX - targetX));
		System.out.println("Angle: " + barrelAngle);
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
