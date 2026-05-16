
public class Player {
	public String player_sign;
	public String player_tail;
	public Grid grid;

	public int x;
	public int y;
	
	public Player(String player_sign, String player_tail, Grid grid, int x, int y) {
		this.player_sign = player_sign;
		this.player_tail = player_tail;
		this.grid = grid;
		this.x = x;
		this.y = y;

	}
	
	public void DrawPlayer() {
		grid.DrawObject(player_sign, this.x, this.y);
	}
	public void DeletePlayer() {
		grid.DeleteObject(player_sign, this.x, this.y);
	}
	public void Move(int x, int y) {
        DeletePlayer();
        this.x = x;
        this.y = y;
        DrawPlayer();
        grid.UpdateGrid();
	}
	
}
