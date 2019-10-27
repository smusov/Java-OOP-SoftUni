package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Rectangle(42,69);

        DrawingManager manager = new DrawingManagerImpl();

        manager.draw(shape);

    }
}
