package minimalistic.sketch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
            JButton clearButton = new JButton("Clear");
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    canvas.clear();
                }
            });
            buttonPanel.add(clearButton);
            JButton exitButton = new JButton("Exit");
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
             buttonPanel.add(exitButton);
        // Add the canvas to the center and button panel to the south of the JFrame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);
    }

    public void saveImage() {
        BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        canvas.paint(g2);
        g2.dispose();

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Image");
            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".jpg")) {
                    filePath += ".jpg";
                    fileToSave = new File(filePath);
                }
                ImageIO.write(image, "jpg", fileToSave);
                JOptionPane.showMessageDialog(this, "Image saved successfully!");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error occurred while saving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    public static void main(String[] args) {
//        gui screen = new gui();
//        screen.setVisible(true);
//    }
}
