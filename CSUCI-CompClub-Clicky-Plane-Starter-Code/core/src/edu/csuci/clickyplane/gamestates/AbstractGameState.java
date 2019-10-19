/**	Created by: Marc Julian Jamerlan
 *  Last Modified on: 10-18-19
 **/

package edu.csuci.clickyplane.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import edu.csuci.clickyplane.managers.GameStateManager;

public abstract class AbstractGameState implements Disposable {

    private GameStateManager gameStateManager;

    public AbstractGameState(GameStateManager gsm){
        this.gameStateManager = gsm;
        this.init();
    }

    protected abstract void init();
    public abstract void handleInput(float dt);
    public abstract void update(float dt);
    public abstract void draw(float dt, SpriteBatch sb, ShapeRenderer sr);
    public abstract void resize(int width, int height);

    protected void switchState(GameStateType stateType){
        gameStateManager.setState(stateType);
    }
}
