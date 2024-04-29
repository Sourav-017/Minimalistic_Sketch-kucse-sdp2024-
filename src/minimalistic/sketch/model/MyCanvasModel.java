/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimalistic.sketch.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import minimalistic.sketch.view.MyCanvas;

/**
 *
 * @author shome
 */
public class MyCanvasModel {
    MyCanvas canvas;

    public MyCanvasModel(MyCanvas canvas) {
        this.canvas = canvas;
    }
    public void paintComponents(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.scale(canvas.scale, canvas.scale);
        for (int i = 0; i < canvas.lines.size(); i++) {
            List<Point> line = canvas.lines.get(i);
            Brush brush = canvas.brushes.get(i);
            g2d.setColor(brush.getColor());
            g2d.setStroke(new BasicStroke(brush.getSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for (int j = 1; j < line.size(); j++) {
                Point p1 = line.get(j - 1);
                Point p2 = line.get(j);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
        g2d.dispose(); 
    }
    public void undo() {
        if (!canvas.lines.isEmpty()) {
            canvas.undoneLines.add(canvas.lines.remove(canvas.lines.size() - 1));
            canvas.undoneBrushes.add(canvas.brushes.remove(canvas.brushes.size() - 1));
            canvas.repaint();
            canvas.undo_action = true;
        }
    }
    public void redo() {
        if (!canvas.undoneLines.isEmpty()) {
            canvas.lines.add(canvas.undoneLines.remove(canvas.undoneLines.size() - 1));
            canvas.brushes.add(canvas.undoneBrushes.remove(canvas.undoneBrushes.size() - 1));
            canvas.repaint();
        }
    }
    public void clear() {
        canvas.lines.clear();
        canvas.brushes.clear();
        canvas.repaint();
    }
    public void change_bgcolor() {
        for (int i = 0; i < canvas.lines.size(); i++) {
        Brush brush = canvas.brushes.get(i);
        if(canvas.previous_bgcolor != null && brush.getColor() == canvas.previous_bgcolor) brush.setColor(canvas.bgcolor);    
        }  
    }
    public void add_point(int x, int y) {
        List<Point> currentLine = canvas.lines.get(canvas.lines.size() - 1);
        currentLine.add(new Point(x, y));
    }
    public void addBrush(Color color, int size) {
        canvas.brushes.add(new Brush(color, size));
        canvas.lines.add(new ArrayList<>());
    }
}
