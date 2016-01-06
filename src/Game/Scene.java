package Game;

import Game.Map.Tilemap;

public class Scene {
	
	// Scene manager
	
	static Tilemap curTilemap;
	
	public static void init()
	{
		Scene test = new Scene(new Tilemap(100,100));
		
		setScene(test);
	}
	public static void setScene(Scene scene)
	{
		curTilemap = scene.getTilemap();
	}
	public static Tilemap getCurTilemap()
	{
		return curTilemap;
	}
	
	//Scene Object
	Tilemap tilemap;
	
	private Scene(Tilemap tileMap)
	{
		tilemap = tileMap;
	}
	private Tilemap getTilemap()
	{
		return tilemap;
	}
	

}
