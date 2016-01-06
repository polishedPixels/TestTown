package Game;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
public abstract class Camera {
	
	
	static Point pos = new Point(0, 0);
	public static double Xoffset, Yoffset;
	public static void setPosition(double X, double y)
	{
		Xoffset = X;
		Yoffset = y;
		pos = new Point(X, y);
		
		glMatrixMode(GL_PROJECTION);
        glLoadIdentity(); // Resets any previous projection matrices
        glOrtho((-Main.WIDTH/2) + pos.posX, (Main.WIDTH/2) + pos.posX, (-Main.HEIGHT/2) + pos.posY, (Main.HEIGHT/2) + pos.posY, 1, -1);
        glMatrixMode(GL_MODELVIEW);
		
	}
	
	public static Point getPosition()
	{
		return pos;
	}

}
