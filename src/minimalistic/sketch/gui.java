package minimalistic.sketch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class gui extends JFrame {   
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
