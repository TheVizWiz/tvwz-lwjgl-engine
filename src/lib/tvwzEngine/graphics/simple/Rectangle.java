package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import lib.tvwzEngine.math.Vector4;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class Rectangle extends Renderable {

    public Vector2 position, dimensions;
    public Vector3[] colors = new Vector3[4];

    public Rectangle () {
        colors[0] = new Vector3(1, 1, 1);
    }


    @Override
    public void render () {
        glBegin(GL_QUADS);
        {
            int currentColorIndex = 0;

            glColor3f(colors[currentColorIndex].x, colors[currentColorIndex].y, colors[currentColorIndex].z);
            glVertex3f(position.x, position.y, depth);

            currentColorIndex = colors[1] != null ? 1 : 0;
            glColor3f(colors[currentColorIndex].x, colors[currentColorIndex].y, colors[currentColorIndex].z);
            glVertex3f(position.x, position.y + dimensions.y, depth);


            currentColorIndex = colors[2] != null ? 2 : 0;
            glColor3f(colors[currentColorIndex].x, colors[currentColorIndex].y, colors[currentColorIndex].z);
            glVertex3f(position.x + dimensions.x, position.y + dimensions.y, depth);

            currentColorIndex = colors[3] != null ? 3 : 0;
            glColor3f(colors[currentColorIndex].x, colors[currentColorIndex].y, colors[currentColorIndex].z);
            glVertex3f(position.x + dimensions.x, position.y, depth);
        }
        glEnd();
    }
}