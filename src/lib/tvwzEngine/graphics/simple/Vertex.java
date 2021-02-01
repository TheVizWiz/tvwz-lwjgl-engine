package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.Translatable;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;

import static org.lwjgl.opengl.GL12.*;

public class Vertex extends Renderable implements Translatable {

    public Vector2 position;
    public Vector3 color;
    public Vector3 normalColor = new Vector3(1, 1, 1);

    public Vertex (Vector3 backgroundColor) {
        normalColor = backgroundColor;
    }

    public Vertex (Vector2 position, Vector3 color) {
        this.position = position;
        this.color = color;
    }

    public Vertex (Vector2 pos) {
        this.position = pos;
    }

    @Override
    public void render (float startDepth) {
        if (color != null) {
            glColor3f(color.x, color.y, color.z);
        } else glColor3f(normalColor.x, normalColor.y, normalColor.z);
        glVertex3f(position.x, position.y, startDepth);
    }

    @Override
    public void translate (float dx, float dy) {
        position = position.add(dx, dy);
    }


    public static void renderVertexList (Vertex[] vertices, float startDepth) {
        glBegin(GL_POLYGON);
        for (Vertex vertex : vertices) {
            vertex.render(startDepth);
        }
        glEnd();
    }
}