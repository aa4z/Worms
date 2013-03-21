import java.awt.image.BufferedImage;


public class World implements GameObject {
	private boolean[][] isGround;
	private BufferedImage ground;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	public World() {
		ground = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		GroundGenerator gen = new GroundGenerator();
		isGround = gen.getGround(WIDTH,HEIGHT);
		updateImage();
	}
	
	private void updateImage() {
		int[] pixels = new int[WIDTH*HEIGHT*4];
		for (int i = 0;i < HEIGHT;i++)
			for (int j = 0;j < WIDTH;j++) {
				int pixelIndex = (HEIGHT-i-1)*WIDTH*4+j*4;
				if (isGround[i][j]) {
					pixels[pixelIndex] = 100;   //R
					pixels[pixelIndex+1] = 50;   //G
					pixels[pixelIndex+2] = 50;   //B
					pixels[pixelIndex+3] = 255;  //A (255 - opaque)
				} else {
					pixels[pixelIndex] = 0;
					pixels[pixelIndex+1] = 0;  
					pixels[pixelIndex+2] = 0;    
					pixels[pixelIndex+3] = 0;   //A (0 - tranparent) 
				}
			}
		ground.getRaster().setPixels(0,0,WIDTH,HEIGHT,pixels);
	}

	public void draw(Screen s) {
		s.graphics.drawImage(ground, 0, 0, null);
	}
	
	public boolean isGround(int x, int y) {
		return isGround[y][x];
	}

	public void update(double dt) {
		
	}

}
