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
        assertEquals(expected, instance.pointcount());
    }
    @Test
    public void testadd_brush() {
        int expected = 3;
        MyCanvas instance = new MyCanvas();
        Color test = Color.BLACK;
        int bsize = 10;
        instance.addBrush(test, bsize);
        instance.addBrush(test, bsize);
        assertEquals(expected, instance.BrushCount());
    } 
        @Test
    public void testzoom_in() {
        
        MyCanvas instance = new MyCanvas();
        float expected = (float) (1.1);
        instance.zoomIn();
        assertEquals(expected, instance.get_scale(), 0.001);
    } 
    @Test
        public void testzoom_out() {
        
        MyCanvas instance = new MyCanvas();
        float expected = (float) (1.0);
        instance.zoomIn();
        //System.out.println( instance.ZoomIn_Factor);
        instance.zoomOut();
        //System.out.println( instance.ZoomIn_Factor);
        assertEquals(expected, instance.get_scale(), 0.001);
    } 
    @Test
    public void testinitialZoom() {
        
        MyCanvas instance = new MyCanvas();
        float expected = (float) (1.0);
        instance.zoomIn();
        instance.zoomIn();
        instance.zoomIn();
        instance.zoomIn();
        instance.zoomIn();
        instance.initial_zoom();
        assertEquals(expected, instance.get_scale(), 0.001);
    }
    @Test
    public void testset_height()
    {
        MyCanvas instance = new MyCanvas();
        float expected_height = 100;
        instance.set_window_height(100);
        assertEquals(expected_height, instance.get_window_height(), 0.001);
    }
        @Test
    public void testset_width()
    {
        MyCanvas instance = new MyCanvas();
        float expected_width = 100;
        instance.set_window_width(100);
        assertEquals(expected_width, instance.get_window_width(), 0.001);
    }
    @Test
    public void testsetBgcolor()
    {
        MyCanvas instance = new MyCanvas();
        Color expected = Color.BLUE;
        instance.set_bgcolor(Color.BLUE);
        assertEquals(expected, instance.get_bgcolor());
    }
}
