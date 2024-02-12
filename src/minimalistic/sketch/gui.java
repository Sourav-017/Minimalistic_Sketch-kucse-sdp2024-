package minimalistic.sketch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class gui extends JFrame {
    MyCanvas canvas;

    public gui() {
        setTitle("Front Page");
        setSize(900, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new MyCanvas();
        canvas.setBackground(Color.BLACK);

        // Create a panel for saving functionality
        JPanel savePanel = new JPanel();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveImage();
                } catch (IOException ex) {
                    Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        savePanel.add(saveButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(savePanel, BorderLayout.SOUTH);
    }

    private void saveImage() throws IOException {
        BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        canvas.paint(g2);
        g2.dispose();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Image");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            ImageIO.write(image, "jpg", fileToSave);
            JOptionPane.showMessageDialog(this, "Image saved successfully!");
        }
    }

    public static void main(String[] args) {
        gui screen = new gui();
        screen.setVisible(true);
    }
}