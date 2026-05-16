import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main {
	
	public static int P_X;	
	public static int P_Y;	

	public static void main(String[] args) throws InterruptedException {
		
		
		Grid grid = new Grid(100, 15, "*");
		
		P_X = 1;
		P_Y = (int)grid.height/2;
		
		Player player = new Player("$", "%", grid, P_X, P_Y);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		player.DrawPlayer();
		grid.UpdateGrid();
		
		frame.addKeyListener(new KeyListener() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        switch(e.getKeyCode()) {

		            case KeyEvent.VK_W:
		            	if (P_Y == 0) {
		            		//TODO handle movement
		            	}
		            	--P_Y;
		            	player.Move(P_X, --P_Y);
		                break;

		            case KeyEvent.VK_S:
		            	player.Move(P_X, ++P_Y);
		                break;

		            case KeyEvent.VK_D:
		            	player.Move(++P_X, P_Y);
		                break;

		            case KeyEvent.VK_A:
		            	player.Move(--P_X, P_Y);
		                break;

		            case KeyEvent.VK_R:
		                System.exit(0);
		                break;
		        }
		    }

		    public void keyTyped(KeyEvent e) {}
		    public void keyReleased(KeyEvent e) {}
		});
		
		frame.setFocusable(true);
		frame.requestFocus();
	}

}
