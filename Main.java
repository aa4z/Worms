import java.awt.Color;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.JFrame;


public class Main {
	private static Game game;
	private static Screen screen;
	public static GraphicsDevice vc;

	public static void main(String[] args) throws Exception {
		playGame();
	}

	private static void setFullScreen(JFrame window)
	{
		window.setUndecorated(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		window.getContentPane().setBackground(Color.CYAN);
		vc.setFullScreenWindow(window);
	}
	public static Window getFullScreenWindow()
	{
		return vc.getFullScreenWindow();
	}
	
	public static void restoreScreen()
	{
		Window w = getFullScreenWindow();
		if(w != null)
			w.dispose();
		vc.setFullScreenWindow(null);
	}
	
	private static void playGame() throws Exception {
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice();
		
		JFrame main = new JFrame("Worms");
		game = new Game(2);
		screen = new Screen(game);
		main.add(screen);
		main.addKeyListener(new Kelet(screen));
		screen.requestFocus();
		setFullScreen(main);
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
