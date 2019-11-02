/**	Modified by: Marc Julian Jamerlan
 *  Last Modified on: 11-01-19
 **/

package edu.csuci.clickyplane;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import edu.csuci.clickyplane.gamestates.GameStateType;
import edu.csuci.clickyplane.managers.ContentManager;
import edu.csuci.clickyplane.managers.GameStateManager;

public class ClickyPlane extends ApplicationAdapter {

	public static final int WORLD_WIDTH = 1280;
	public static final int WORLD_HEIGHT = 720;

	private GameStateManager gsm;
	public static ContentManager content;

	@Override
	public void create () {
		content = new ContentManager();
		this.gsm = new GameStateManager(GameStateType.PLAY);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float dt = Gdx.graphics.getDeltaTime();
		this.gsm.step(dt);
	}
	
	@Override
	public void dispose () {
		content.dispose();
		this.gsm.dispose();
	}
}
