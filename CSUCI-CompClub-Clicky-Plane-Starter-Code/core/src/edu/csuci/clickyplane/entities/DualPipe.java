/**	Created by: Marc Julian Jamerlan
 *  Last Modified on: 11-01-19
 **/

package edu.csuci.clickyplane.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import edu.csuci.clickyplane.ClickyPlane;

public class DualPipe extends AbstractEntity {

    private static final float PIPE_GAP = 250f;

    private Pipe top;
    private Pipe bottom;
    private boolean gotPoint;

    public DualPipe() {
        super();
        float topY = MathUtils.random(
                Pipe.TOP_HEIGHT + PIPE_GAP,
                ClickyPlane.WORLD_HEIGHT - Pipe.TOP_HEIGHT
        );

        top = new Pipe(topY, Pipe.PipeType.TOP);
        bottom = new Pipe(topY - PIPE_GAP, Pipe.PipeType.BOTTOM);
        gotPoint = false;

        setSize(top.getSize());
    }

    public void point() {
        gotPoint = true;
    }

    public boolean hasPoint() {
        return gotPoint;
    }

    @Override
    public void update(float dt) {
        top.update(dt);
        bottom.update(dt);
        setX(top.getX());
    }

    @Override
    public void draw(float dt, SpriteBatch sb, ShapeRenderer sr) {
        top.draw(dt, sb, sr);
        bottom.draw(dt, sb, sr);
    }

    @Override
    public float getX() {
        return top.getX();
    }

    @Override
    public float getY() {
        return top.getY();
    }

    @Override
    public boolean isColliding(Rectangle rectangle) {
        return top.isColliding(rectangle) || bottom.isColliding(rectangle);
    }

    @Override
    public void dispose() {
        top.dispose();
        bottom.dispose();
    }
}
