package minimalistic.sketch.controller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;
import minimalistic.sketch.model.MyCanvasModel;
import minimalistic.sketch.view.MyCanvas;

public class MyCanvasController {
    MyCanvas canvas;
    MyCanvasModel model;
    public MyCanvasController(MyCanvas canvas,MyCanvasModel model) {
        this.canvas = canvas;
        this.model = model;
    }
    public void mouse_pressed(MouseEvent e)
    {   if(canvas.undo_action == true) {
            canvas.undo_action = false;
            canvas.addBrush(canvas.Col, canvas.b_size);
        }
        if(canvas.change_slider == 1) {
            canvas.change_slider = 0;
            canvas.addBrush(canvas.Col, canvas.b_size);
        }
        canvas.addPoint((int) (e.getX() / canvas.scale), (int) (e.getY() / canvas.scale));
    }
    public void mouse_released(MouseEvent e) {
       canvas.repaint();
       canvas.addBrush(canvas.Col, canvas.b_size); 
    }
    public void mouse_dragged(MouseEvent e) {
        canvas.addPoint((int) (e.getX() / canvas.scale), (int) (e.getY() / canvas.scale));
        canvas.repaint();
    }
    public void mouse_wheel_moved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            canvas.zoomIn();
        } else {
            canvas.zoomOut();
        }
    }
    public void paintComponents(Graphics g) {
        model.paintComponents(g);
    }
    public void undo() {
        model.undo();
    }
    public void redo() {
        model.redo();
    }
    public void change_bgcolor() {
        model.change_bgcolor();
    }
    public void set_brush_size(int value) {
        canvas.b_size = value;
        canvas.change_slider = 1;
    }
    public void add_point(int x, int y) {
        List<Point> currentLine = canvas.lines.get(canvas.lines.size() - 1);
        currentLine.add(new Point(x, y));
    }
    public void zoomIn() {
        canvas.scale *= canvas.ZoomIn_Factor;
        canvas.repaint();
    }
    public void initial_zoom() {
        canvas.scale = canvas.Initial_Zoom;
        canvas.repaint();
    }
    public void zoomOut() {
        canvas.scale /= canvas.ZoomIn_Factor;
        canvas.repaint();
    }
    public void addBrush(Color color, int size) {
        model.addBrush(color, size);
    }
    public void clear() {
        model.clear();
    }
}
