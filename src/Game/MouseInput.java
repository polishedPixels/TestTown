package Game;


import org.lwjgl.glfw.GLFWCursorPosCallback;

import Game.Map.Tile;
import Game.Map.Tilemap;

public class MouseInput extends GLFWCursorPosCallback{

	static double X, Y;
	
	
	@Override
	public void invoke(long window, double x, double y) {
		// TODO Auto-generated method stub
		X = x;
		Y = y;
	}
	
	public double getMouseX()
	{
		return X + Camera.Xoffset - Main.WIDTH/2;
	}
	public  double getMouseY()
	{
		return Main.HEIGHT -Y + Camera.Yoffset - Main.HEIGHT/2;
	}
	public Tile getCurTile() {
		Tile curTile = null;
		if (getMouseX() >= 0 && getMouseX() <= Scene.getCurTilemap().getSceneSizeX() && getMouseY() >= 0 && getMouseY() <= Scene.getCurTilemap().getSceneSizeY()) {
			int TileX, TileY;

			TileX = (int) (getMouseX() / Tilemap.tileSize);
			TileY = (int) (getMouseY() / Tilemap.tileSize);
			curTile = Scene.getCurTilemap().getTile(TileX, TileY);

		}else{
			curTile = Scene.getCurTilemap().getTile(0, 0);
			//System.err.println("Point GetCurTile Out of Bounds");
		}
		return curTile;
	}
	
}
