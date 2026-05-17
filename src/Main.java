import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main {
	
	public static enum Direction {
	    UP, DOWN, LEFT, RIGHT
	}
	
	public static int P_X;	
	public static int P_Y;	

	public static volatile Direction dir = Direction.RIGHT;
	
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
		            dir = Direction.UP;
		            break;

		        case KeyEvent.VK_S:
		            dir = Direction.DOWN;
		            break;

		        case KeyEvent.VK_D:
		            dir = Direction.RIGHT;
		            break;

		        case KeyEvent.VK_A:
		            dir = Direction.LEFT;
		            break;

		        case KeyEvent.VK_R:
		            System.exit(0);
		            break;
		    	}	
		    	
		    }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		frame.setFocusable(true);
		frame.requestFocus();
		
		while (true) {
	    	switch(dir) {
			
            case UP:
            	if (P_Y == 1) {
            		P_Y = grid.height-1;
            	}
            	P_Y--;
                break;

            case DOWN:
            	if (P_Y == grid.height-2) {
            		P_Y = 0;
            	}
            	P_Y++;
                break;

            case RIGHT:
            	if (P_X == grid.width-2) {
            		P_X = 0;
            	}
            	P_X++;
                break;

            case LEFT:
            	if (P_X == 1) {
            		P_X = grid.width-1;
            	}
            	P_X--;
                break;
	    	}
	    	
	    	player.Move(P_X, P_Y);
	    	grid.UpdateGrid();
	    	Thread.sleep(100);
		}
	}

}
