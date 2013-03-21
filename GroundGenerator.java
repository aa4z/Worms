import java.util.Random;


public class GroundGenerator {
	private static Random rand = new Random();
	private static final int numWaves = 5;
	private RandomWave[] waves;
	static class RandomWave {
		double freq;
		double phase;
		double amplitude;
		public RandomWave() {
			freq = rand.nextDouble()*0.02+0.01;
			phase = rand.nextDouble()*Math.PI*2;
			amplitude = rand.nextDouble()*50;
		}
		public double heightAt(int col) {
			return this.amplitude*Math.sin(this.phase+this.freq*col);
		}
	}
	public GroundGenerator() {
		waves = new RandomWave[numWaves];
		for (int i = 0;i < numWaves;i++)
			waves[i] = new RandomWave();
	}
	public void fillGround(boolean[][] isGround) {
		for (int col = 0;col < isGround[0].length;col++) {
			double waveSum = 0.0;
			for (int wave = 0;wave < numWaves;wave++)
				waveSum+=waves[wave].heightAt(col);
			fillColumn(isGround,col,200+(int)waveSum);
		}
	}
	private static void fillColumn(boolean[][] isGround, int col, int height) {
		int row = 0;
		for (;row < height;row++)
			isGround[row][col]=true;
		for (;row < isGround.length;row++)
			isGround[row][col]=false;
	}
	public boolean[][] getGround(int width, int height) {
		boolean[][] isGround = new boolean[height][];
		for (int i = 0;i < height;i++)
			isGround[i] = new boolean[width];
		fillGround(isGround);
		return isGround;
	}

}
