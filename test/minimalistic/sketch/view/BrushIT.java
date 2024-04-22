/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package minimalistic.sketch.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shome
 */
public class BrushIT {
    
    public BrushIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of draw method, of class Brush.
     */
//@Test
//public void testDraw() {
//    // Create a Graphics2D object (you may need to use a mocking framework like Mockito)
//    Graphics2D g2d = createGraphics2D();
//
//    // Create two Point objects
//    Point p1 = new Point(10, 10);
//    Point p2 = new Point(20, 20);
//
//    // Create an instance of the Brush class
//    Brush brush = new Brush(Color.BLACK, 2);
// 
//    // Call the draw method
//    brush.draw(g2d, p1, p2);
//
//    // Verify that the expected outcome matches the actual outcome (this depends on the behavior of your draw method)
//    // For example, you could assert that the color of the graphics object is set to black and the stroke size is 2
//    assertEquals(Color.BLACK, g2d.getColor());
//    assertEquals(2, ((BasicStroke) g2d.getStroke()).getLineWidth());
//}

    @Test
    public void testSetColor() {
        // Create a Color object
        Color color = Color.RED;
        // Create an instance of the Brush class
        Brush brush = new Brush(Color.BLACK, 2);
        // Call the setColor method
        brush.setColor(color);
        // Verify that the color has been set correctly
        assertEquals(color, brush.getColor());
    }

    @Test
    public void testSetSize() {
        // Define the size
        int size = 3;
        // Create an instance of the Brush class
        Brush brush = new Brush(Color.BLACK, 2);
        // Call the setSize method
        brush.setSize(size);
        // Verify that the size has been set correctly
        assertEquals((float)size, brush.getSize(), 0.0001);
    }

    @Test
    public void testGetColor() {
        // Create a Color object
        Color color = Color.BLUE;
        // Create an instance of the Brush class with the specified color
        Brush brush = new Brush(color, 2);
        // Call the getColor method and verify that it returns the correct color
        assertEquals(color, brush.getColor());
    }

    @Test
    public void testGetSize() {
        // Define the size
        float size = 5;
        // Create an instance of the Brush class 
        Brush brush = new Brush(Color.BLACK, (int) size);
        // Call the getSize method and verify that it returns the correct size
        assertEquals(size, brush.getSize(), 0.0);
    }

}
