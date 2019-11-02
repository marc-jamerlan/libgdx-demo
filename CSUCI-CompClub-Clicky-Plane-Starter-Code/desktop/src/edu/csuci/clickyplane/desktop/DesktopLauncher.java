/**	Modified by: Marc Julian Jamerlan
 *  Last Modified on: 11-01-19
 **/

package edu.csuci.clickyplane.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import edu.csuci.clickyplane.ClickyPlane;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ClickyPlane.WORLD_WIDTH;
		config.height = ClickyPlane.WORLD_HEIGHT;
		config.resizable = false;
		new LwjglApplication(new ClickyPlane(), config);
	}
}
