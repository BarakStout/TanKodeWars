import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TanKodeWars extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	private int GAME_WIDTH = 600; //the width of the game area
    private int GAME_HEIGHT = 600; //the height of the game area
    private int FPS = 30; //frames per second
    
    //Tank variables
    private int TANK_HEIGHT = 50;
    private int TANK_WIDTH = 50;
    private int BARREL_SIZE = 20;
    
    private Timer timer;
    private ArrayList<Tank> tanks = new ArrayList<Tank>();
    private ArrayList<Shell> shells = new ArrayList<Shell>();

	public static void main(String[] args) {
		JFrame frame = new JFrame();
        frame.setTitle("TanKode Wars");
        frame.setLayout(new BorderLayout());
        
        TanKodeWars game = new TanKodeWars();
        frame.add(game, BorderLayout.CENTER);
        
        game.addKeyListener(game);
        frame.addKeyListener(game);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        
        game.setUpGame();
        game.update();
               
	}
	
	public TanKodeWars()
	{
		setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
	}
	
	//Method that is called by the timer 30 times per second (roughly)
    //Most games go through states - updating objects, then drawing them
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
    
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
    
    public void update()
    {
    	
    				
    }

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
        
//		TODO: fix collision detection and uncomment
//        for(Shell s: shells)
//    		for(Tank t: tanks)
//    			if(t.intersects(s))
//    			{
//    				JOptionPane.showMessageDialog(null, "Tank " + t.getName() + " died!");
//        			setUpGame();
//    			}
        
    }

}
