import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.GradientPaint;
import java.awt.BasicStroke;

//The line class extends from the shape class 
public class MyLine extends MyShape {
    //Instead of having its own default constructor, it calls the shape class constructor or the "super"
    public MyLine() {
        super();
    }
    //Instead of having its own constructor, it passes in arguments and calls the shape constructor to set the instance variabales
    public MyLine( int x1, int x2, int y1, int y2, Color color, Color color2, boolean gradient, int fontSize, boolean dashed, float dashSize ) {
        super( x1, x2, y1, y2, color, color2, gradient, fontSize, dashed, dashSize );
    }
    //Define the draw method to set the color and draw the line according to the coordinates
    public void draw( Graphics2D g2d ) {
        if (getGradient()) {
            GradientPaint twoColor = new GradientPaint(getX1(), getY1(), getColor(), getX1(), getY2(), getColor2(), true);
            g2d.setPaint(twoColor);
            if (getDashed()) {
                float dash[] = {getDashSize()};
                g2d.setStroke(new BasicStroke(getFontSize(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));          
            } else {
                g2d.setStroke(new BasicStroke(getFontSize()));
            }
        } else {
            g2d.setPaint( getColor() );
            if (getDashed()) {
                float dash[] = {getDashSize()};
                g2d.setStroke(new BasicStroke(getFontSize(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f)); 
            } else {
                g2d.setStroke(new BasicStroke(getFontSize()));
            }
        }
        g2d.draw(new Line2D.Double( getX1(), getY1(), getX2(), getY2() ));
        
    }
}
    