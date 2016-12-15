import java.awt.Color;
import java.awt.Graphics;
//This is also an abstract class since it extends from the shape class but doesn't define the abstract method yet
abstract class MyBoundedShape extends MyShape {
    //Instance variable decides weather the shape is filled or clear
    private boolean clearCheck;
    //Calls the parent default constructor and set the clearCheck to false
    public MyBoundedShape() {
        super();
        clearCheck = true;
    }
    //Calls the parent constructor and passes in all the arguments with the clear check and sets the instance variables
    public MyBoundedShape( int x1, int x2, int y1, int y2, Color color, Color color2, boolean gradient, boolean clearCheck, int fontSize, boolean dashed, float dashSize ) {
        super( x1, x2, y1, y2, color, color2, gradient, fontSize, dashed, dashSize );
        this.clearCheck = clearCheck; 
    }
    protected void setClear( boolean clear ) {
        this.clearCheck = clear;
    }
    
    protected boolean getClearCheck() {
        return clearCheck;
    }
    
    int getUpperLeftX() {
        if (getX1() > getX2()) {
            return getX2();
        } else {
            return getX1();
        }
        //return (getX1() > getX2()) ? getX2() : getX1();
    }

    int getUpperLeftY() {
        if (getY1() > getY2()) {
            return getY2();
        } else {
            return getY1();
        }
        //return (getY1() > getY2()) ? getY2() : getY1();
    }

    int getWidth() {
        return Math.abs(getX1() - getX2());
    }

    int getHeight() {
        return Math.abs(getY1() - getY2());
    }
}