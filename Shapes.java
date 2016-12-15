// Demonstrating some Java 2D shapes.
import javax.swing.JFrame;
 
public class Shapes
{
   // execute application
   public static void main( String args[] )
   {
      // create frame for ShapesJPanel
      JFrame frame = new JFrame( "Drawing 2D shapes" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 
      // create ShapesJPanel
      ShapesJPanel shapesJPanel = new ShapesJPanel();
      frame.add( shapesJPanel ); // add shapesJPanel to frame
      frame.setSize( 425, 200 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
} // end class Shapes