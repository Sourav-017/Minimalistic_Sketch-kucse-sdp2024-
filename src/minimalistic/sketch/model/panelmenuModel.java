/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimalistic.sketch.model;
//import minimalistic.sketch.model.*;
import minimalistic.sketch.controller.*;
import java.awt.Color;
import minimalistic.sketch.view.*;

/**
 *
 * @author shome
 */
public class panelmenuModel {
    public MyCanvas canvas;
    public panelmenuModel(MyCanvas canvs){
        System.err.println("model created");
        canvas = canvs;
    }
    public void setColor(Color col, float bsize)
    {
        if(this.canvas != null){
//            if(col == Color.RED) 
            System.err.println("Method 2 Called");
            canvas.Col = col;
            canvas.addBrush(col, (int)bsize); 
            if(canvas.Col == Color.red) System.out.println(canvas.get_window_height());
        }
//        if(this.canvas != null) 
    }   
}
