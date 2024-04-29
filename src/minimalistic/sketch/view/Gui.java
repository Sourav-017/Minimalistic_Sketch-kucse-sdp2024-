package minimalistic.sketch.view;
import minimalistic.sketch.controller.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class Gui extends JFrame{
    public Font mousePosFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    Dimension screenDimension;
    Color color = new Color(0x87cefa);
    PanelMenu panelMenu;
    JMenuBar menuBar;
    JMenu menuFile;
    JMenuItem menuItemSave;
    MyCanvas canvas;
    JScrollPane scrollPane;
    JPanel boardCanvas;
    int height = 1000, width = 800;
    public Gui() {
        screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Minimalistic sketch");
        
        boardCanvas = new JPanel();
        canvas = new MyCanvas();
        PanelmenuController controller = new PanelmenuController(canvas);
        panelMenu = new PanelMenu(canvas, controller);
        GuiController guicontroller = new GuiController(canvas);
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuItemSave = new JMenuItem("Save");
        setJMenuBar(menuBar);
        setSize(height, width);
        setMinimumSize(new Dimension(1000, 880));
        setLocation((int) screenDimension.getWidth() / 2 - getSize().width / 2, (int) screenDimension.getHeight() / 2 - getSize().height / 2);
        menuBar.add(menuFile);
        menuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guicontroller.saveImage();
            }
        });
        menuFile.add(menuItemSave);
        add(panelMenu, BorderLayout.EAST);
        boardCanvas.setBackground(color);
        boardCanvas.setLayout(new GridBagLayout());
        boardCanvas.add(canvas);
        scrollPane = new JScrollPane(boardCanvas);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Gui().setVisible(true);
    }

} 
