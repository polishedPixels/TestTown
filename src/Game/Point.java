package Game;

import Game.Map.Tile;
import Game.Map.Tilemap;

public class Point {

	// point in scene
	public double posX, posY;

	public Point(double PosX, double PosY) {

		posX = PosX;
		posY = PosY;
	}

	public double getPosX() {
		return posX;// - Camera.Xoffset;
	}

	public double getPosY() {
		return posY;// - Camera.Yoffset;
	}

	public void setPosX(double PosX) {
		posX = PosX;
	}

	public void setPosY(double PosY) {
		posY = PosY;
	}

	public Tile getCurTile() {
		Tile curTile = null;
		if (posX >= 0 && posX <= Scene.getCurTilemap().getSceneSizeX() && posY >= 0 && posY <= Scene.getCurTilemap().getSceneSizeY()) {
			int TileX, TileY;

			TileX = (int) (posX / Tilemap.tileSize);
			TileY = (int) (posY / Tilemap.tileSize);
			curTile = Scene.getCurTilemap().getTile(TileX, TileY);

		}else{
			System.err.println("Point GetCurTile Out of Bounds");
		}
		return curTile;

	}

}
