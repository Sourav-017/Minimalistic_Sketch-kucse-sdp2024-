package minimalistic.sketch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

public class MyCanvas extends JPanel {
    private List<List<Point>> lines;
    private List<Brush> brushes;
    private double scale = 1.0;
    public Color Col = Color.GREEN;
    public int b_size = 10;
    private List<List<Point>> undoneLines;
    private List<Brush> undoneBrushes;
    public Color bgcolor = new Color(0x0a0e14);
    public Color previous_bgcolor = null;
    public int change_slider = 1;
    public float ZoomIn_Factor = (float) 1.1, Initial_Zoom = (float) 1.0;
    public boolean undo_action = false;
    public MyCanvas() {
        int sizeWidth = 900;
        int sizeHeight = 800;
        this.setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        this.setBackground(bgcolor);
        lines = new ArrayList<>();
        brushes = new ArrayList<>();
        undoneLines = new ArrayList<>();
        undoneBrushes = new ArrayList<>();
        // Initialize default brush
        //Color Col = Color.BLUE;
        addBrush(Col, b_size); // Default brush color and size

         addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(undo_action == true)
                {
                    undo_action = false;
                    addBrush(Col, b_size);
                }
                if(change_slider == 1)
                {
                    change_slider = 0;
                    addBrush(Col, b_size);
                }
                addPoint((int) (e.getX() / scale), (int) (e.getY() / scale));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
                repaint();
                addBrush(Col, b_size); 
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                addPoint((int) (e.getX() / scale), (int) (e.getY() / scale));
                repaint();
            }
        });

        // Add MouseWheelListener for zooming
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getWheelRotation() < 0) {
                    zoomIn();
                } else {
                    zoomOut();
                }
            }
        });
    }
    public void set_brush_size(int value)
    {
        b_size = value;
        change_slider = 1;
        //addBrush(Col, b_size);
    }
    public void undo() {
        if (!lines.isEmpty()) {
            // Remove last drawn line and brush
            undoneLines.add(lines.remove(lines.size() - 1));
            undoneBrushes.add(brushes.remove(brushes.size() - 1));
            repaint();
            //addBrush(Col, b_size);
            undo_action = true;
        }
    }
    public void redo() {
        if (!undoneLines.isEmpty()) {
            // Add back the last removed line and brush
            lines.add(undoneLines.remove(undoneLines.size() - 1));
            brushes.add(undoneBrushes.remove(undoneBrushes.size() - 1));
            repaint();
        }
    }
    
    public void addPoint(int x, int y) {
        List<Point> currentLine = lines.get(lines.size() - 1);
        currentLine.add(new Point(x, y));
    }

    public void zoomIn() {
        scale *= ZoomIn_Factor;
        repaint();
    }
    public void initial_zoom() {
        scale = Initial_Zoom;
        repaint();
    }

    public void zoomOut() {
        scale /= ZoomIn_Factor;
        repaint();
    }

    public void addBrush(Color color, int size) {
        brushes.add(new Brush(color, size));
        lines.add(new ArrayList<>());
    }
    
    public void clear() {
        lines.clear();
        brushes.clear();
        repaint();
    }
    public void changeBrush(int size)
    {
        this.b_size = size;
    }
    public void change_bgcolor()
    {
        for (int i = 0; i < lines.size(); i++) {
        Brush brush = brushes.get(i);
        if(previous_bgcolor != null && brush.getColor() == previous_bgcolor) brush.setColor(bgcolor);    
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // Apply scaling transformation
        g2d.scale(scale, scale);

        // Draw all lines
        for (int i = 0; i < lines.size(); i++) {
            List<Point> line = lines.get(i);
            Brush brush = brushes.get(i);
            g2d.setColor(brush.getColor());
            g2d.setStroke(new BasicStroke(brush.getSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for (int j = 1; j < line.size(); j++) {
                Point p1 = line.get(j - 1);
                Point p2 = line.get(j);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
//        addBrush(Col, 5);
        g2d.dispose();
    }
}
