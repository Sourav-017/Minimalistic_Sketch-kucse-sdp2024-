/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package minimalistic.sketch.view;
import java.awt.Color;
import java.awt.Graphics;
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
public class MyCanvasIT {
    
    public MyCanvasIT() {
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
     * Test of set_brush_size method, of class MyCanvas.
     */
    
    @Test
    public void testClear() {
        int expected = 0;
        MyCanvas instance = new MyCanvas();
        instance.addPoint(10, 20);
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expected, instance.pointcount());
    }
    @Test
    public void add_brush() {
        int expected = 3;
        MyCanvas instance = new MyCanvas();
        Color test = Color.BLACK;
        int bsize = 10;
        instance.addBrush(test, bsize);
        instance.addBrush(test, bsize);
        assertEquals(expected, instance.BrushCount());
    }    
    
}
