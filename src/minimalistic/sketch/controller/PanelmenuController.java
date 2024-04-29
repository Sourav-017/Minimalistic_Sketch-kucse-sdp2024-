/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimalistic.sketch.controller;
import java.awt.Color;
import minimalistic.sketch.view.*;
import minimalistic.sketch.model.panelmenuModel;

public class PanelmenuController {
    MyCanvas canvas;
    public panelmenuModel panelmodel;
    public PanelmenuController(MyCanvas canvas)
    {
        this.canvas = canvas;
        if(this.canvas == null)
        {
            System.err.println("hi");
        }
        panelmodel = new panelmenuModel(canvas);
    }


    public void setColor(Color col, float bsize)
    {
        if(canvas != null) {
            panelmodel.setColor(col, (int)bsize);
        }
    }
    public void setBgColor(Color new_col, Color old_col)
    {
        System.err.println("bgcolor Called");
        if(canvas != null) {
            panelmodel.setBgColor(new_col, old_col);
        }
    }

}
