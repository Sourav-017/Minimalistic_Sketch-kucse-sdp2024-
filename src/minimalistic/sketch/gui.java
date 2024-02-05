package minimalistic.sketch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class gui extends JFrame {
    private static class MyCanvas extends JPanel {
         List<Point> currentLine;
         List<List<Point>> lines;
         int brushSize = 5; // Adjust the brush size here

        public MyCanvas() {
            lines = new ArrayList<>();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentLine = new ArrayList<>();
                    addPoint(e.getX(), e.getY());
                    repaint();
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
        }

        private void addPoint(int x, int y) {
            currentLine.add(new Point(x, y));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.CYAN);


            // Draw all lines
            for (List<Point> line : lines) {
                for (int i = 1; i < line.size(); i++) {
                    Point p1 = line.get(i - 1);
                    Point p2 = line.get(i);
                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }

            // Draw the current line
            for (int i = 1; i < currentLine.size(); i++) {
                Point p1 = currentLine.get(i - 1);
                Point p2 = currentLine.get(i);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
            
        }
    }
    
    MyCanvas canvas;

    public gui() {
        setTitle("Front Page");
        setSize(900, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new MyCanvas();
        canvas.setBackground(Color.BLACK);

        getContentPane().add(canvas, BorderLayout.CENTER);
    }


    
}
