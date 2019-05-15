/*
 * 	Barak Stout 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TanKodeWars extends JPanel implements ActionListener, KeyListener{
	
	private int GAME_WIDTH = 600; //The width of the game area
    private int GAME_HEIGHT = 600; //The height of the game area
    private int FPS = 30; //Frames per second (lower is slower)
    private Timer timer;
    
    //Tank variables
    private final int TANK_HEIGHT = 50;
    private final int TANK_WIDTH = 50;
    private final int BARREL_SIZE = 20;
    
    //Map information
    private ArrayList<Tank> tanks = new ArrayList<Tank>();
    private ArrayList<Shell> shells = new ArrayList<Shell>();

	
	//Constructor
	public TanKodeWars()
	{
		setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
	}
	
    //Sets the initial state of the game
    //Could be modified to allow for multiple levels
    public void setUpGame() {
    	
    	if(timer != null) {
            timer.stop();
        }
    
        timer = new Timer(1000 / FPS, this); //roughly 30 frames per second
        timer.start();

    	Tank p1 = new myTank(30,30,TANK_WIDTH,TANK_HEIGHT,BARREL_SIZE,BARREL_SIZE, Color.BLUE, "tank1");
    	tanks.add(p1);
    	
    	Tank p2 = new myTank2(300,300,TANK_WIDTH,TANK_HEIGHT,BARREL_SIZE,BARREL_SIZE, Color.GREEN, "tank2");
    	tanks.add(p2);
    	 	
    }
	
	//Method that is called by the timer 30 times per second (roughly)
    //Most games go through states - updating objects, then drawing them
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
    
    public void update()
    {
//		TODO: fix collision detection and uncomment
//      for(Shell s: shells)
//  		for(Tank t: tanks)
//  			if(t.intersects(s))
//  			{
//  				JOptionPane.showMessageDialog(null, "Tank " + t.getName() + " died!");
//      			setUpGame();
//  			}				
    }

    // main paint loop
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        
        for(Tank t : tanks)
        {
        	t.draw(g);
        	t.moveTank();
        	t.setTanks(tanks);
        	if(t.fire())
        		shells.add(t.getShell());
        }
        
        for(Shell s : shells)
        	s.drawShell(g);

        
    }
    
    // METHODS FOR KEYED INPUT -----------------------------------------------------------------
    //Called every time a key is pressed
    //Stores the down state for use in the update method
    public void keyPressed(KeyEvent e) {
        
    }
    
    //Called every time a key is released
    //Stores the down state for use in the update method
    public void keyReleased(KeyEvent e) {
        
    }
    
    //Called every time a key is typed
    public void keyTyped(KeyEvent e) {
    }

}
