package Game;

import static org.lwjgl.opengl.GL11.*;

import Game.Map.Tile;
import Game.Map.Tile.Color;

public abstract class Draw {

	public static void Square(Point center, double width) {
		glColor3f(1f, 1f, 1f);
		glBegin(GL_QUADS);
		{
			glVertex2d(center.getPosX() - width / 2, center.getPosY() + width / 2);
			glVertex2d(center.getPosX() + width / 2, center.getPosY() + width / 2);
			glVertex2d(center.getPosX() + width / 2, center.getPosY() - width / 2);
			glVertex2d(center.getPosX() - width / 2, center.getPosY() - width / 2);
		}
		glEnd();

	}

	public static void Square(Point center, double width, Tile.Color color) {

		switch (color) {
		case White:
			glColor3f(1, 1, 1);
			break;
		case Blue:
			glColor3f(0, 0, 1);
			break;
		case Red:
			glColor3f(1, 0, 0);
			break;
		default:
			glColor3f(1, 1, 1);

			break;
		}
		glBegin(GL_QUADS);
		{
			glVertex2d(center.getPosX() - width / 2, center.getPosY() + width / 2);
			glVertex2d(center.getPosX() + width / 2, center.getPosY() + width / 2);
			glVertex2d(center.getPosX() + width / 2, center.getPosY() - width / 2);
			glVertex2d(center.getPosX() - width / 2, center.getPosY() - width / 2);

		}
		glEnd();

	}

	public static void Circle(Point pos, double radius, Color color) {
		// filled circle
		double x1, y1, x2, y2;
		double angle;

		x1 = pos.getPosX();
		y1 = pos.getPosY();
		
		switch (color) {
		case White:
			glColor3f(1, 1, 1);
			break;
		case Blue:
			glColor3f(0, 0, 1);
			break;
		case Red:
			glColor3f(1, 0, 0);
			break;
		default:
			glColor3f(1, 1, 1);

			break;
		}
		glBegin(GL_TRIANGLE_FAN);
		glVertex2d(x1, y1);

		for (angle = 1.0f; angle < 361.0f; angle += 0.2) {
			x2 = x1 + Math.sin(angle) * radius;
			y2 = y1 + Math.cos(angle) * radius;
			glVertex2d(x2, y2);
		}
		glEnd();
	}

}
