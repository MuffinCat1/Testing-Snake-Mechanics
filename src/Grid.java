import java.util.ArrayList;
import java.io.IOException;
import java.lang.ProcessBuilder;

public class Grid {
	public int width;
	public int height;
	public String sign;
	
	ArrayList<String> grid_buffer = new ArrayList<String>();

	public Grid(int width, int height, String sign) {
		this.width = width;
		this.height = height;
		this.sign = sign;

		DrawGrid();
	}

	void DrawGrid() {
		grid_buffer.add(sign.repeat(width));
		for (int i = 0; i < height-2; ++i) {
			grid_buffer.add(sign+" ".repeat(width-2)+sign);
		}
		grid_buffer.add(sign.repeat(width));	
		
		for (String line:grid_buffer) {
			System.out.println(line);
		}
	}
	
	void UpdateGrid() {
	    try {
	        if (System.getProperty("os.name").contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            new ProcessBuilder("clear").inheritIO().start().waitFor();
	        }
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
		for (String line:grid_buffer) {
			System.out.println(line);
		}
	}
	
	public void DrawObject(String d_sign, int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			System.err.println("trying to draw object outside grid");
			System.exit(-1);
		}
		String line = grid_buffer.get(y);

		String new_line = line.substring(0, x) + d_sign + line.substring(x + 1);
		grid_buffer.set(y, new_line);
	}
	
	public void DeleteObject(String d_sign, int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			System.err.println("trying to delete object outside grid");
			System.exit(-1);
		}
		String line = grid_buffer.get(y);
		String new_line = line;
		
		char current = line.charAt(x);
		if (current == d_sign.charAt(0)) {
			new_line = line.substring(0, x) + " " + line.substring(x + 1);
		}
		
		grid_buffer.set(y, new_line);	
	}
	
}
