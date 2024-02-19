package minimalistic.sketch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui extends JFrame {
    MyCanvas canvas;
    JButton zoomInButton;
    JButton zoomOutButton;

    public gui() {
        setTitle("Front Page");
        setSize(900, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the canvas
        canvas = new MyCanvas();
        canvas.setPreferredSize(new Dimension(500, 500)); // Set canvas size
        canvas.setBackground(Color.BLACK);

        // Create the buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveImage();
            }
        });
        buttonPanel.add(saveButton);

        zoomInButton = new JButton("Zoom In");
        zoomInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.zoomIn();
            }
        });
        buttonPanel.add(zoomInButton);

        zoomOutButton = new JButton("Zoom Out");
        zoomOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.zoomOut();
            }
        });
        buttonPanel.add(zoomOutButton);

        // Add the canvas to the center and button panel to the south of the JFrame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);
    }

    private void saveImage() {
        // Save image logic
    }

    public static void main(String[] args) {
        gui screen = new gui();
        screen.setVisible(true);
    }
}
