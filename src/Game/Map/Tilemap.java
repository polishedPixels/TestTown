package Game.Map;

import Game.Map.Tile.Color;

public class Tilemap {

	int sizeX = 0,sizeY = 0;
	Tile[][] Tilemap;
	public final static double tileSize = 64;
	
	public Tilemap(int SizeX, int SizeY)
	{
		sizeX = SizeX;
		sizeY = SizeY;
		
		// init and populate
		Tilemap = new Tile[SizeX][SizeY];
		
		for(int x = 0; x < sizeX; x++)
		{
			for(int y = 0; y < sizeY; y++)
			{
				Color type = Color.White;
					
				setTile(new Tile(type,x, y));
			}
		}
	}
	public void setTile(Tile tile) {
		Tilemap[tile.posX][tile.posY] = tile;
	}
	public Tile getTile(int x, int y)
	{
		if(x < 0 || x >= sizeX || y < 0 || y >= sizeY)
		{
			System.err.println("Tilemap getTile Out of Bounds X: " + x + " Y: " + y );
			return null;
		}
		return Tilemap[x][y];
	}
	public double getSceneSizeX()
	{
		return sizeX * tileSize;
	}
	public double getSceneSizeY()
	{
		return sizeY * tileSize;
	}
	public void draw()
	{
		for(int x = 0; x < sizeX; x++)
		{
			for(int y = 0; y < sizeY; y++)
			{
				Tilemap[x][y].draw();
			}
		}
	}
}
