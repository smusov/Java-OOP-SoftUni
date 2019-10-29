package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {


    @Override
    public void draw(Shape shape) {

        shape.draw();

    }
}
