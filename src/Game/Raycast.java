package Game;

public class Raycast {
	
	final double precision = 1;
	
	Point A,B;
	
	
	public Raycast(Point a, Point b)
	{
		A = a;
		B = b;
	}
	public boolean Cast()
	{
		boolean hit = false;
		double distance,
			slope; // Y / X
		
		distance = Math.sqrt(Math.pow((A.posX - B.posX), 2) + Math.pow((A.posY - B.posY), 2));
		slope = (A.posY - B.posY)/(A.posX - B.posY);
		
		
		
		return hit;
		
	}

}
