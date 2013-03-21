import java.awt.Color;

import javax.swing.JFrame;


public class Main {
	private static Game game;
	private static Screen screen;

	public static void main(String[] args) throws Exception {
		playGame();
	}

	private static void playGame() throws Exception {
		JFrame main = new JFrame("Worms");
		game = new Game(2);
		screen = new Screen(game);
		main.setSize(800,600);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.add(screen);
		screen.requestFocus();
		main.setVisible(true);
		main.getContentPane().setBackground(Color.CYAN);
		mainloop();
	}

	private static void mainloop() throws Exception {
		while (true) {
			game.update(0.05);
			screen.repaint();
			Thread.sleep(50);
		}
	}
}
