import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.BasicStroke;

//Oval shape inherits qualities from the bounded shape and the shape class
public class MyOval extends MyBoundedShape {
    //Oval shape uses the bound shape default constructor hence the super
    public MyOval() {
        super();
    }
    //Calls the parent constructor by passing in the appropriate variables
    public MyOval( int x1, int x2, int y1, int y2, Color color, Color color2, boolean gradient, boolean clearCheck, int fontSize, boolean dashed, float dashSize ) {
        super( x1, x2, y1, y2, color, color2, gradient, clearCheck, fontSize, dashed, dashSize );
    }
    //Defines the draw method to draw an oval
    public void draw( Graphics2D g2d ) {
        //Draws an oval that isn't filled and outlined black
        if ( getClearCheck() ) { 
            if (getGradient()) {
                GradientPaint twoColor = new GradientPaint(getUpperLeftX(), getUpperLeftY(), getColor(), getUpperLeftX(), getHeight(), getColor2(), true);
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
                    g2d.setColor(getColor());
                    g2d.setStroke(new BasicStroke(getFontSize()));
                }
            }
            g2d.draw( new Ellipse2D.Double( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() ) );
        } else {
            if (getGradient()) {
                GradientPaint twoColor = new GradientPaint(getUpperLeftX(), getUpperLeftY(), getColor(), getUpperLeftX(), getHeight(), getColor2(), true);
                g2d.setPaint(twoColor); 
            } else {
                System.out.println(getGradient());
                g2d.setColor( getColor() );
            }
            g2d.fill(new Ellipse2D.Double( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() ));
        }
    }
}
    