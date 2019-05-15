import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Driver {

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

}
