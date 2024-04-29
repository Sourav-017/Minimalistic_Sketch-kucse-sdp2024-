package minimalistic.sketch.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;
import minimalistic.sketch.model.Brush;
import minimalistic.sketch.model.MyCanvasModel;
import minimalistic.sketch.controller.MyCanvasController;

public class MyCanvas extends JPanel {
    public List<List<Point>> lines, undoneLines;
    public List<Brush> brushes, undoneBrushes;
    public double scale = 1.0;
    public Color Col = Color.GREEN, bgcolor = (Color.white), previous_bgcolor = null;
    public int b_size = 15, change_slider = 1;;
    public float ZoomIn_Factor = (float) 1.1, Initial_Zoom = (float) 1.0, sizeWidth = 1900, sizeHeight = 1800;
    public boolean undo_action = false;
    private MyCanvasController controller;
    private MyCanvasModel model;
    public MyCanvas() {
        this.setPreferredSize(new Dimension((int)sizeWidth, (int) sizeHeight));
        this.setBackground(bgcolor);
        lines = new ArrayList<>();
        brushes = new ArrayList<>();
        undoneLines = new ArrayList<>();
        undoneBrushes = new ArrayList<>();
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                controller.mouse_pressed(e);
            }
            public void mouseReleased(MouseEvent e) {
                controller.mouse_released(e);
            }});
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                controller.mouse_dragged(e);
            }});
        addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                controller.mouse_wheel_moved(e);
            }});
        model = new MyCanvasModel(this);
        controller = new MyCanvasController(this , model);
    }
    public void set_brush_size(int value) {
        controller.set_brush_size(value);
    }
    public void undo() {
        controller.undo();
    }
    public void redo() {
        controller.redo();
    }
    public void addPoint(int x, int y) {
        controller.add_point(x, y);
    }
    public void zoomIn() {
        controller.zoomIn();
    }
    public void initial_zoom() {
        controller.initial_zoom();
    }
    public void zoomOut() {
        controller.zoomOut();
    }
    public void addBrush(Color color, int size) {
        controller.addBrush(color, size);
    }
    public void clear() {
        controller.clear();
    }
    public void change_bgcolor() {
        controller.change_bgcolor();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        controller.paintComponents(g);
    }
}
