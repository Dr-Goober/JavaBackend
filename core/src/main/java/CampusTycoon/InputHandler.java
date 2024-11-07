package CampusTycoon;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputProcessor;

import CampusTycoon.GameLogic.Coordinate;
import CampusTycoon.UI.Camera;
import CampusTycoon.UI.Component;
import CampusTycoon.UI.Window;

public class InputHandler implements InputProcessor {
	private static List<Component> clickables = new ArrayList<Component>();
	

	public InputHandler() {
	}
	
	public static void clear() {
		clickables = new ArrayList<Component>();
	}
	
	public static void add(Component button) {
		clickables.add(button);
	}
	
	public static void add(List<Component> buttons) {
		clickables.addAll(buttons);
	}
	
	
	public boolean keyDown (int keycode) {
		return false;
	}

	public boolean keyUp (int keycode) {
		return false;
	}

	public boolean keyTyped (char character) {
		return false;
	}

	// Called on click
	public boolean touchDown (int x, int y, int pointer, int button) {
		Camera.click(x, y, button);
		
		// Scales mouse position to resolution
		x = transformX(x);
		y = transformY(y);
		
		for (Component btn : clickables){
			if (isTouchWithinButton(x, y, btn)) {
				btn.onClick();
				return true;
			}
		}
		return true;
	}

	private int transformX(int x) {
		return (int)(x * Component.widthRatio);
	}
	private int transformY(int y) {
		return Window.defaultHeight - (int)(y * Component.heightRatio);
	}

	private boolean isTouchWithinButton(int x, int y, Component button) {
		if (button == null) {
			return false; // Button is null, so return false to avoid a NullPointerException
		}
        // Assuming button's (x, y) represents the bottom-left corner and has width and height
        return x >= button.getX() && x <= button.getX() + button.getWidth()
                && y >= button.getY() && y <= button.getY() + button.getHeight();
    }

	public boolean touchUp (int x, int y, int pointer, int button) {
		return false;
	}

	public boolean touchDragged (int x, int y, int pointer) {
		Camera.drag(x, y);
		return true;
	}

	public boolean mouseMoved (int x, int y) {
		return false;
	}

	public boolean scrolled (float amountX, float amountY) {
		Camera.scroll(amountY);
		return true;
	}

	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		return false;
	}
}
