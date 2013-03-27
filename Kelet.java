import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Kelet implements KeyListener {
	
	private Screen screen;
	private static final int KEYCODE_ESCAPE =27;

	public Kelet(Screen screen) {
		this.screen = screen;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KEYCODE_ESCAPE)
			Main.restoreScreen();
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {
	}

}
