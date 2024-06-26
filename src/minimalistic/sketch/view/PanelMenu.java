/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package minimalistic.sketch.view;

import minimalistic.sketch.controller.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelMenu extends javax.swing.JPanel {
    MyCanvas canvus;
    private final PanelmenuController controller;
    int s_Factor = 3;

    public PanelMenu(MyCanvas can, PanelmenuController con) {
        
        canvus = can;
        controller = con;
        initComponents();
        jSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = jSlider1.getValue();
                canvus.set_brush_size((int) sliderValue / s_Factor);
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser3 = new javax.swing.JColorChooser();
        jColorChooser1 = new javax.swing.JColorChooser();
        Red_color = new javax.swing.JButton();
        White_color = new javax.swing.JButton();
        Green_color = new javax.swing.JButton();
        Undo = new java.awt.Button();
        jSlider1 = new javax.swing.JSlider();
        Clear1 = new java.awt.Button();
        Redo = new java.awt.Button();
        ZoomIn = new javax.swing.JButton();
        ZoomOut = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Eraser = new javax.swing.JButton();
        Background_White = new javax.swing.JButton();
        BackgroundBlue = new javax.swing.JButton();
        Cyan_Color = new javax.swing.JButton();
        ColorChooser = new java.awt.Button();
        ColorChooser1 = new java.awt.Button();

        setBackground(new java.awt.Color(51, 51, 51));

        Red_color.setBackground(new java.awt.Color(255, 0, 51));
        Red_color.setForeground(new java.awt.Color(255, 0, 51));
        Red_color.setAlignmentX(0.5F);
        Red_color.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Red_color.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Red_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Red_colorActionPerformed(evt);
            }
        });

        White_color.setForeground(new java.awt.Color(255, 255, 255));
        White_color.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        White_color.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        White_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                White_colorActionPerformed(evt);
            }
        });

        Green_color.setBackground(new java.awt.Color(0, 255, 0));
        Green_color.setForeground(new java.awt.Color(255, 0, 51));
        Green_color.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Green_color.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Green_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Green_colorActionPerformed(evt);
            }
        });

        Undo.setActionCommand("Clear");
        Undo.setLabel("Undo");
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });

        Clear1.setActionCommand("Clear");
        Clear1.setBackground(new java.awt.Color(255, 255, 255));
        Clear1.setLabel("Clear");
        Clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear1ActionPerformed(evt);
            }
        });

        Redo.setActionCommand("Clear");
        Redo.setLabel("Redo");
        Redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoActionPerformed(evt);
            }
        });

        ZoomIn.setLabel("+");
        ZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZoomInActionPerformed(evt);
            }
        });

        ZoomOut.setActionCommand("Zoom Out");
        ZoomOut.setLabel("-");
        ZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZoomOutActionPerformed(evt);
            }
        });

        Reset.setActionCommand("Zoom Out");
        Reset.setLabel("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        Eraser.setActionCommand("Zoom Out");
        Eraser.setLabel("Eraser");
        Eraser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EraserActionPerformed(evt);
            }
        });

        Background_White.setForeground(new java.awt.Color(255, 0, 51));
        Background_White.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Background_White.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Background_White.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Background_WhiteActionPerformed(evt);
            }
        });

        BackgroundBlue.setBackground(new java.awt.Color(0, 0, 255));
        BackgroundBlue.setForeground(new java.awt.Color(255, 0, 51));
        BackgroundBlue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BackgroundBlue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackgroundBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackgroundBlueActionPerformed(evt);
            }
        });

        Cyan_Color.setBackground(new java.awt.Color(0, 255, 255));
        Cyan_Color.setAlignmentX(0.5F);
        Cyan_Color.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cyan_Color.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cyan_Color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cyan_ColorActionPerformed(evt);
            }
        });

        ColorChooser.setBackground(new java.awt.Color(255, 255, 255));
        ColorChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ColorChooser.setForeground(new java.awt.Color(0, 0, 102));
        ColorChooser.setLabel("Color Chooser");
        ColorChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorChooserActionPerformed(evt);
            }
        });

        ColorChooser1.setBackground(new java.awt.Color(255, 255, 255));
        ColorChooser1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ColorChooser1.setForeground(new java.awt.Color(0, 0, 102));
        ColorChooser1.setLabel("Color Chooser");
        ColorChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Redo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZoomIn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BackgroundBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Background_White, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Green_color, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(White_color, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Cyan_Color, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                            .addComponent(Red_color, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ZoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Undo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Eraser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(Clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Green_color, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cyan_Color, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(White_color, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Red_color, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Redo, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(Undo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ZoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZoomIn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Eraser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(ColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackgroundBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Background_White, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Undo.getAccessibleContext().setAccessibleName("clear");
        Reset.getAccessibleContext().setAccessibleName("Re");
    }// </editor-fold>//GEN-END:initComponents
    
    private void Red_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Red_colorActionPerformed
        controller.setColor(Color.RED, jSlider1.getValue() / s_Factor);     
    }//GEN-LAST:event_Red_colorActionPerformed

    private void White_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_White_colorActionPerformed
        controller.setColor(Color.WHITE, jSlider1.getValue() / s_Factor); 
    }//GEN-LAST:event_White_colorActionPerformed

    private void Green_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Green_colorActionPerformed
        controller.setColor(Color.GREEN, jSlider1.getValue() / s_Factor); 
    }//GEN-LAST:event_Green_colorActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        canvus.undo();
    }//GEN-LAST:event_UndoActionPerformed

    private void Clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear1ActionPerformed
        canvus.clear();
        canvus.initial_zoom();
    }//GEN-LAST:event_Clear1ActionPerformed

    private void RedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedoActionPerformed
        canvus.redo();
    }//GEN-LAST:event_RedoActionPerformed
    
    private void ZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZoomInActionPerformed
        canvus.zoomIn();
    }//GEN-LAST:event_ZoomInActionPerformed

    private void ZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZoomOutActionPerformed
        canvus.zoomOut(); 
    }//GEN-LAST:event_ZoomOutActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        canvus.initial_zoom();
    }//GEN-LAST:event_ResetActionPerformed

    private void EraserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EraserActionPerformed
        controller.setColor(canvus.bgcolor , jSlider1.getValue() / s_Factor);
    }//GEN-LAST:event_EraserActionPerformed

    private void Background_WhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Background_WhiteActionPerformed
        controller.setBgColor(Color.WHITE, canvus.bgcolor);
    }//GEN-LAST:event_Background_WhiteActionPerformed

    private void BackgroundBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackgroundBlueActionPerformed
        controller.setBgColor(Color.BLUE, canvus.bgcolor);
    }//GEN-LAST:event_BackgroundBlueActionPerformed

    private void Cyan_ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cyan_ColorActionPerformed
        controller.setColor(Color.CYAN, jSlider1.getValue() / s_Factor);       
    }//GEN-LAST:event_Cyan_ColorActionPerformed

    private void ColorChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorChooser1ActionPerformed
        Color cl = Color.CYAN;
        cl = jColorChooser3.showDialog(this, "Choose a color", cl);
        controller.setColor(cl, jSlider1.getValue() / s_Factor); 

    }//GEN-LAST:event_ColorChooser1ActionPerformed

    private void ColorChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorChooserActionPerformed
        Color cl = Color.BLACK;
        cl = jColorChooser3.showDialog(this, "Choose a color", cl);
        controller.setBgColor(cl, canvus.bgcolor);   
    }//GEN-LAST:event_ColorChooserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackgroundBlue;
    private javax.swing.JButton Background_White;
    private java.awt.Button Clear1;
    private java.awt.Button ColorChooser;
    private java.awt.Button ColorChooser1;
    private javax.swing.JButton Cyan_Color;
    private javax.swing.JButton Eraser;
    private javax.swing.JButton Green_color;
    private javax.swing.JButton Red_color;
    private java.awt.Button Redo;
    private javax.swing.JButton Reset;
    private java.awt.Button Undo;
    private javax.swing.JButton White_color;
    private javax.swing.JButton ZoomIn;
    private javax.swing.JButton ZoomOut;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JColorChooser jColorChooser3;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables

}
