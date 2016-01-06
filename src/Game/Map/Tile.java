package Game.Map;

import Game.Draw;
import Game.Point;

public class Tile {
	
	public int posX, posY; // posiitons in Tilemap array
	Point pos; // position in scene
	Color color;
	
	public Tile(Color type,int PosX,int PosY)
	{
		posX = PosX;
		posY = PosY;
		color = type;
		
		pos = new Point((PosX * Tilemap.tileSize) + Tilemap.tileSize/2, PosY * Tilemap.tileSize + Tilemap.tileSize/2);
		
	}
	public Color getColor()
	{
		return color;
	}
	public void draw()
	{
		Draw.Square(pos, Tilemap.tileSize, color);
	}
	public enum Color
	{
		White,Red,Blue
	}
}
