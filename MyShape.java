import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

abstract class MyShape {
    private int x1; // x coordinate of first endpoint
    private int y1; // y coordinate of first endpoint
    private int x2; // x coordinate of second endpoint
    private int y2; // y coordinate of second endpoint
    private Color myColor; // color of this shape
    private Color myColor2;
    private boolean gradient;
    private int fontSize;
    private float dashSize;
    private boolean dashed;
    
    //Default Constructor, sets shape coordinates to zero and color to black
    public MyShape() {
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
        myColor = Color.RED;
        myColor2 = Color.RED;
        gradient = false;
        fontSize = 1;
        dashed = false;
    }
    //Use the arguments passed in to set the shape coordinates, shape color, gradient, fontsize, dash, and dash size
    public MyShape( int x1, int x2, int y1, int y2, Color color, Color color2, boolean gradient, int fontSize, boolean dashed, float dashSize ) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        myColor = color;
        myColor2 = color2;
        this.gradient = gradient;
        this.fontSize = fontSize;
        this.dashed = dashed;
        this.dashSize = dashSize;
    }
    //Return color as a color object
    protected Color getColor() {
        return myColor;  
    }
    
    protected Color getColor2() {
        return myColor2;
    }
    
    protected boolean getGradient() {
        return gradient;
    }
    
    protected void setGradient(boolean gradient) {
        this.gradient = gradient;
    }
    
    protected int getFontSize() {
        return fontSize;
    }
    
    protected void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
    
    protected void setDashSize(float dashSize) {
        this.dashSize = dashSize;
    }
    
    protected float getDashSize() {
        return dashSize;
    }
    
    protected void setDashed(boolean dashed) {
        this.dashed = dashed;
    }
    
    protected boolean getDashed() {
        return dashed;
    }
    
    //return the coordinate that is designated as the upper left x value
    protected int getX1() {
        return x1;
    }
    //return the coordinate that is designated as the upper left y value
    protected int getY1() {
        return y1;
    }
    //return the coordinate that is designated as the width
    protected int getX2() {
        return x2;
    }
    //return the coordinate that is designated as the height
    protected int getY2() {
        return y2;
    }
    protected void setX1( int x1 ) {
        //Constructor for x1
        this.x1 = x1;
    }
    protected void setX2( int x2 ) {
        //Constructor for x2
        this.x2 = x2;
    }
    protected void setY1( int y1 ) {
        //Constructor for y1
        this.y1 = y1;
    }
    protected void setY2( int y2 ) {
        //Constructor for y2
        this.y2 = y2;
    }
    //Abstract draw method because different shapes will have different ways of drawing
    public abstract void draw( Graphics2D g2d );
}
        