package Game;

import static org.lwjgl.glfw.GLFW.*;


public class Time {
	// Under the class definition
	
	static int fps = 0;
	static double fpsDeltaCounter = 0;
	static double lastFrame = 0;
	static double delta;
	
	public static double getTime() {
	    return System.nanoTime() / 10000000.0;
	}
	
	public static void resetLastFrame()
	{
		lastFrame = getTime();
	}
	public static double getDelta() {
	    
	    return delta;
	}
	public static void updateDelta()
	{
		double time = getTime();
		delta = (double) (time - lastFrame);
	}
	
	public static void FPS()
	{
		fps++;
		fpsDeltaCounter += getDelta();
		
		if(fpsDeltaCounter >= 1000)
		{
			System.out.println("FPS: " + fps);
			fps = 0;
			fpsDeltaCounter = 0;
		}
	}
	
}
