package Game;


import static org.lwjgl.glfw.GLFW.*;

import Game.Map.Tile.Color;


public class Player {

	Point pos;
	double size; // radius
	Type type;
	double speed = 5;
	
	public Player(Type type, double Size, Point position)
	{
		this.type = type;
		size = Size;
		pos = position;
		
	}
	public void draw()
	{
		Color c = Color.White;
		switch(type){
		case Left:
			c = Color.Red;
			break;
		case Right:
			c = Color.Blue;
			break;
		}
		Draw.Circle(pos, size, c);
	}
	public void inputUpdate()
	{
		switch(type)
		{
		case Left:
			if(KeyBoardInput.keys[GLFW_KEY_W])
				pos.setPosY(pos.getPosY() + speed * Time.getDelta());
			else if(KeyBoardInput.keys[GLFW_KEY_S])
				pos.setPosY(pos.getPosY() - speed * Time.getDelta());
			if(KeyBoardInput.keys[GLFW_KEY_D])
				pos.setPosX(pos.getPosX() + speed * Time.getDelta());
			else if(KeyBoardInput.keys[GLFW_KEY_A])
				pos.setPosX(pos.getPosX() - speed * Time.getDelta());		//Main.printXYCoords("Left:", pos.getPosX(), pos.getPosY());

			break;
		case Right:
			if(KeyBoardInput.keys[GLFW_KEY_UP])
				pos.setPosY(pos.getPosY() + speed * Time.getDelta());
			else if(KeyBoardInput.keys[GLFW_KEY_DOWN])
				pos.setPosY(pos.getPosY() - speed * Time.getDelta());
			if(KeyBoardInput.keys[GLFW_KEY_RIGHT])
				pos.setPosX(pos.getPosX() + speed * Time.getDelta());
			else if(KeyBoardInput.keys[GLFW_KEY_LEFT])
				pos.setPosX(pos.getPosX() - speed * Time.getDelta());
			break;
		default:
			break;
		}
	}
	public void setPosition(Point pos)
	{
		this.pos = pos;
	}
	public void setSize(double Size)
	{
		size = Size;
	}
	public Point getPos()
	{
		return pos;
	}
	public double getSize()
	{
		return size;
	}
	public Type getType()
	{
		return type;
	}
	public enum Type
	{
		Left,Right
	}
}
