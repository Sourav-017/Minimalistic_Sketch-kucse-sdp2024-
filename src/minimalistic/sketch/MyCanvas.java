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
    public MyCanvas() {
        int sizeWidth = 900;
        int sizeHeight = 800;
        this.setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        this.setBackground(new Color(0x0a0e14));
        lines = new ArrayList<>();
        brushes = new ArrayList<>();
       
        // Initialize default brush
        //Color Col = Color.BLUE;
        addBrush(Col, b_size); // Default brush color and size

         addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
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

    public void addPoint(int x, int y) {
        List<Point> currentLine = lines.get(lines.size() - 1);
        currentLine.add(new Point(x, y));
    }

    public void zoomIn() {
        scale *= 1.1;
        repaint();
    }

    public void zoomOut() {
        scale /= 1.1;
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
