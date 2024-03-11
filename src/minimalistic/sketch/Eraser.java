package minimalistic.sketch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Eraser {
    private int size;

    public Eraser(int size) {
        this.size = size;
    }

    public void erase(Graphics2D g2d, Point point) {
        int eraserSize = size;
        int x = point.x - eraserSize / 2;
        int y = point.y - eraserSize / 2;
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(x, y, eraserSize, eraserSize);
        g2d.setComposite(AlphaComposite.SrcOver);
    }

    public void setSize(int size) {
        this.size = size;
    }
}