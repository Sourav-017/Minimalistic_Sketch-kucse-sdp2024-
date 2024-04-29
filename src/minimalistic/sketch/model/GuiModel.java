/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimalistic.sketch.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import minimalistic.sketch.view.MyCanvas;

/**
 *
 * @author shome
 */
public class GuiModel {
    MyCanvas canvas;
    public GuiModel(MyCanvas canvas) {
        this.canvas = canvas;
    }

    public void saveImage(BufferedImage image){
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(canvas);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                ImageIO.write(image, "png", fileToSave);
                JOptionPane.showMessageDialog(canvas, "Image saved successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(canvas, "Error saving image!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
}
