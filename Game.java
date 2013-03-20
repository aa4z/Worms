
public class Game {
	private WormGroup[] groups;
	private Projectile projectile;
	private World world;
	public Game(int teams) {
		groups = new WormGroup[teams];
		world = new World();
		for (int i = 0;i < teams;i++)
			groups[i] = new WormGroup();
	}
	public void update(double dt) {
		if (projectile != null)
			projectile.update(dt);
		for (WormGroup g : groups)
			g.update(dt);
	}
}
