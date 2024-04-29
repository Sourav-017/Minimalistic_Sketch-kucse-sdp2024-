/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimalistic.sketch.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import minimalistic.sketch.model.GuiModel;
import minimalistic.sketch.view.MyCanvas;


public class GuiController {
    MyCanvas canvas;
    public GuiModel guimodel;
    public GuiController(MyCanvas canvas)
    {
        this.canvas = canvas;
        if(this.canvas == null)
        {
            System.err.println("hi");
        }
        guimodel = new GuiModel(canvas);
    } 
    public void saveImage() {
        
        BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        canvas.paint(g2);
        g2.dispose();
        guimodel.saveImage(image);             

    }
}

