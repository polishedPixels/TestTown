package Game.Physics;

import java.util.HashMap;
import java.util.Map;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import Game.Point;

public abstract class PhysicsHandler {

	private static World world;
	private static Map<String, Body> Bodies;
	private static final int pixelsPerMeter = 50;

	public static void init() {
		world = new World(new Vec2(0, -9.8f), false);
		Bodies = new HashMap<String, Body>();

	}

	public static void addBody(String name, Point pos, double sizeX, double sizeY, BodyType type, float density) {

		BodyDef bodyDef = new BodyDef();
		PolygonShape polygonShape = new PolygonShape();
		Body body;
		FixtureDef fixtureDef = new FixtureDef();

		bodyDef.position.set((float) pos.getPosX(), (float) pos.getPosY());
		bodyDef.type = type;
		polygonShape.setAsBox((float) (sizeX / 2), (float) (sizeY / 2));

		body = world.createBody(bodyDef);

		fixtureDef.density = density;

		fixtureDef.shape = polygonShape;
		body.createFixture(fixtureDef);
		Bodies.put(name, body);

	}

	public static void addBody(String name, Point pos, double sizeX, double sizeY, BodyType type, float density,
			float restitution) {

		BodyDef bodyDef = new BodyDef();
		PolygonShape polygonShape = new PolygonShape();
		Body body;
		FixtureDef fixtureDef = new FixtureDef();

		bodyDef.position.set((float) pos.getPosX(), (float) pos.getPosY());
		bodyDef.type = type;
		polygonShape.setAsBox((float) (sizeX / 2), (float) (sizeY / 2));

		body = world.createBody(bodyDef);

		fixtureDef.density = density;
		fixtureDef.restitution = restitution;

		fixtureDef.shape = polygonShape;
		body.createFixture(fixtureDef);
		Bodies.put(name, body);

	}
	public static void update()
	{
		world.step( 1/60f, 8,3);
	}
	public static Body getBody(String name)
	{
		return Bodies.get(name);
	}
	//Draw functions
}
