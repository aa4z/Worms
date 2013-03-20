import java.awt.Graphics;

import javax.swing.JComponent;


public class Screen extends JComponent{

	private Game game;
	public Graphics graphics;

	public Screen(Game game) {
		super();
		this.game = game;
		addKeyListener(new Kelet(this));
	}
	
	public void paintComponent(Graphics g) {
		graphics = g;
	}

}
