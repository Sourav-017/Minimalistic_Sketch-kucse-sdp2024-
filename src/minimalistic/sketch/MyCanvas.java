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
    private List<Point> currentLine;
    private List<List<Point>> lines;
    private final Brush brush;
    private double scale = 1.0;

    public MyCanvas() {
        lines = new ArrayList<>();
        brush = new Brush(Color.CYAN, 5); // Set default brush color and size

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentLine = new ArrayList<>();
                addPoint(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lines.add(new ArrayList<>(currentLine));
                repaint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                addPoint(e.getX(), e.getY());
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // Apply scaling transformation
        g2d.scale(scale, scale);

        // Draw all lines
        for (List<Point> line : lines) {
            for (int i = 1; i < line.size(); i++) {
                Point p1 = line.get(i - 1);
                Point p2 = line.get(i);
                brush.draw(g2d, p1, p2);
            }
        }

        // Draw the current line
        if (currentLine != null) {
            for (int i = 1; i < currentLine.size(); i++) {
                Point p1 = currentLine.get(i - 1);
                Point p2 = currentLine.get(i);
                brush.draw(g2d, p1, p2);
            }
        }

        g2d.dispose();
    }
}
