
package minimalistic.sketch.model;

import java.awt.Color;
import minimalistic.sketch.view.*;

public class panelmenuModel {
    public MyCanvas canvas;
    public panelmenuModel(MyCanvas canvs){
        System.err.println("model created");
        canvas = canvs;
    }
    public void setColor(Color col, float bsize)
    {
        if(this.canvas != null){
            System.err.println(bsize);
            canvas.Col = col;
            canvas.addBrush(col, (int)bsize); 
        }
    }
    public void setBgColor(Color new_col, Color old_col)
    {
        System.err.println("bgcolor Called");
        if(this.canvas != null){
          canvas.previous_bgcolor = canvas.bgcolor;
          canvas.bgcolor = new_col;
          canvas.setBackground(new_col);
          canvas.change_bgcolor();
        }
    }
}
