/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimalistic.sketch.model;
import java.awt.Color;
import minimalistic.sketch.view.*;

/**
 *
 * @author shome
 */
public class panelmenuModel {
    MyCanvas canvas;
    public panelmenuModel(MyCanvas canvs){
        canvas = canvs;
    }
    public void setColor(Color col, float bsize)
    {
        System.out.println("Red");
        if(this.canvas != null) canvas.Col = col;
        if(this.canvas != null) canvas.addBrush(col, (int)bsize); 
    }   
}
