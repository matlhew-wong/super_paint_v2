// --------- Import JFrame/JPanel ---------
import javax.swing.JFrame;
import javax.swing.JPanel;

// --------- Import GUI Items ---------
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JColorChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JToolBar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Graphics;

// --------- Import JFrame/JPanel Layout Managers ---------
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// --------- Import Events Handlers ---------
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Draw Frame Class
 * Description: DrawFrame for SuperPaint
 *              Instantiates and handles GUI
 * 
 * April 16 2016
 * @author Matthew Wong
 * @version 1.0
 * 
 */
public class DrawFrame extends JFrame {
    
    // ------Instance Variables------
    
    private JPanel menuPanel; // Panel for menu items
    
    // ------Tool Bar------
    private JToolBar toolBar;
    
    // ------Menu Panel------
    private JPanel menuBox;
    
    // ------Menu Items------
    private JButton undo;
    private JButton redo; 
    private JButton clear;
    
    private JComboBox colorSelection;
    private String colors[] = {"Red", "Green", "Blue", "Orange", "Pink", "Cyan", "Magenta", "Yellow", "Black", "White", "Gray", "Light Gray", "Dark Grey"};
    
    private JComboBox shapeSelection;
    private String shapes[] = {"Line", "Oval", "Rectangle"};
    
    private JButton color1;
    private JButton color2;
    private JButton background;
    
    private JCheckBox clearOrNot;
    private JCheckBox gradientOrNot;
    private JCheckBox dashedOrNot;
    
    private SpinnerNumberModel fontSpinnerModel;
    private JLabel fontSizeLabel;
    private JSpinner fontSizeSpinner;
    
    private SpinnerNumberModel dashSpinnerModel;
    private JLabel dashSizeLabel;
    private JSpinner dashSizeSpinner;
    
    // ------Menu Bar------
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem about;
    private JMenuItem prefs;
    private JMenuItem exit;
    
    // ------Magic Numbers------
    static final int LINE = 0;
    static final int OVAL = 1;
    static final int RECTANGLE = 2;
    
    private Preferences preferences;
    private PreferenceReader preferenceReader;
    private JLabel statusLabel;
    
    private DrawPanel drawPanel;
    
    // ------Constructor------
    public DrawFrame() {
        
        
        // ------DrawFrame------
        super("SuperPaint v.2.0"); // Set Title
        setLayout(new BorderLayout(5, 5)); // Set Layout Manager
        
        preferenceReader = new PreferenceReader();
        preferences = new Preferences(preferenceReader);
        
        // ------MenuBox(North)------
        menuBox = new JPanel();
        menuBox.setLayout(new BorderLayout());
        
        toolBar = new JToolBar("Tool Bar");
        
        // ------Menu Bar------
        MenuItemHandler menuItemHandler = new MenuItemHandler();
        
        // Create Menu Bar
        menuBar = new JMenuBar();
        
        // Create Menu
        menu = new JMenu("File");
        
        menuBar.add(menu);
        
        // Create Menu Items
        about = new JMenuItem("About");
        about.addActionListener(menuItemHandler);
        menu.add(about);
        
        prefs = new JMenuItem("Prefs");
        prefs.addActionListener(menuItemHandler);
        menu.add(prefs);
        
        exit = new JMenuItem("Exit");
        exit.addActionListener(menuItemHandler);
        menu.add(exit);
        
        menuBar.add(menu);
        menuBox.add(menuBar, BorderLayout.NORTH);
        
        // Buttons
        ButtonHandler buttonHandler = new ButtonHandler();
        
        undo = new JButton("undo");
        undo.addActionListener(buttonHandler);
        toolBar.add(undo);
        
        redo = new JButton("redo");
        redo.addActionListener(buttonHandler);
        toolBar.add(redo);
        
        clear = new JButton("clear");
        clear.addActionListener(buttonHandler);
        toolBar.add(clear);
        toolBar.addSeparator();
        
        menuBox.add(toolBar, BorderLayout.SOUTH);
        
        fontSizeLabel = new JLabel("Thickness");
        toolBar.add(fontSizeLabel);
        toolBar.addSeparator();
        
        FontSizeSpinnerHandler fontSizeSpinnerHandler = new FontSizeSpinnerHandler();
        fontSpinnerModel = new SpinnerNumberModel(Integer.parseInt(preferenceReader.returnLineWidth()), 1, 100, 1);
        fontSizeSpinner = new JSpinner(fontSpinnerModel);
        fontSizeSpinner.addChangeListener(fontSizeSpinnerHandler);
        toolBar.add(fontSizeSpinner);
        toolBar.addSeparator();
        
        dashSizeLabel = new JLabel("Dash Thikness");
        toolBar.add(dashSizeLabel);
        toolBar.addSeparator();
        
        DashSizeSpinnerHandler dashSizeSpinnerHandler = new DashSizeSpinnerHandler();
        dashSpinnerModel = new SpinnerNumberModel(Integer.parseInt(preferenceReader.returnDashWidth()), 1, 100, 1);
        dashSizeSpinner = new JSpinner(dashSpinnerModel);
        dashSizeSpinner.addChangeListener(dashSizeSpinnerHandler);
        toolBar.add(dashSizeSpinner);
        toolBar.addSeparator();
        
        ShapeComboBoxHandler shapeComboBoxHandler = new ShapeComboBoxHandler();
        
        shapeSelection = new JComboBox(shapes);
        shapeSelection.setSelectedIndex(Integer.parseInt(preferenceReader.returnShapeType()));
        shapeSelection.addActionListener(shapeComboBoxHandler);
        toolBar.add(shapeSelection);
        
        // CheckBox
        
        
        DashedOrNotCheckBoxHandler dashedOrNotCheckBoxHandler = new DashedOrNotCheckBoxHandler();
        dashedOrNot = new JCheckBox("Dashed", Boolean.parseBoolean(preferenceReader.returnDash()));
        dashedOrNot.addItemListener(dashedOrNotCheckBoxHandler);
        toolBar.add(dashedOrNot);
                                    
        ClearOrNotCheckBoxHandler clearOrNotCheckBoxHandler = new ClearOrNotCheckBoxHandler();
        
        clearOrNot = new JCheckBox("Clear", Boolean.parseBoolean(preferenceReader.returnFill()));
        clearOrNot.addItemListener(clearOrNotCheckBoxHandler);
        toolBar.add(clearOrNot);
        
        GradientOrNotCheckBoxHandler gradientOrNotCheckBoxHandler = new GradientOrNotCheckBoxHandler();
        gradientOrNot = new JCheckBox("Gradient", Boolean.parseBoolean(preferenceReader.returnGrad()));
        gradientOrNot.addItemListener(gradientOrNotCheckBoxHandler);
        toolBar.add(gradientOrNot);
        
        color1 = new JButton("Color 1");
        color1.addActionListener(buttonHandler);
        toolBar.add(color1);
        
        color2 = new JButton("Color 2");
        color2.addActionListener(buttonHandler);
        toolBar.add(color2);
        toolBar.addSeparator();
        
        background = new JButton("Background");
        background.addActionListener(buttonHandler);
        toolBar.add(background);
        toolBar.addSeparator();
        
        add(menuBox, BorderLayout.NORTH);
        
        // ------StatusLabel(South)------
        statusLabel = new JLabel("Draw Something");
        add(statusLabel, BorderLayout.SOUTH);
        
        // ------DrawPanel(Center)------
        drawPanel = new DrawPanel(statusLabel, 
                                  Integer.parseInt(preferenceReader.returnShapeType()), 
                                  returnColor1(), 
                                  returnColor2(), 
                                  Boolean.parseBoolean(preferenceReader.returnFill()), 
                                  Boolean.parseBoolean(preferenceReader.returnDash()), 
                                  Boolean.parseBoolean(preferenceReader.returnDash()), 
                                  Integer.parseInt(preferenceReader.returnLineWidth()), 
                                  Integer.parseInt(preferenceReader.returnDashWidth())  );
        add(drawPanel, BorderLayout.CENTER);
        
    }
    
    // ------Menu Item Handler------
    private class MenuItemHandler implements ActionListener {
        // Handle Menu Item Event
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == about) {
                JOptionPane.showMessageDialog(null, "SuperPaint v.2.0");
            } else if(event.getSource() == exit) {
                System.exit(0);
            } else if(event.getSource() == prefs) {
                int ok = JOptionPane.showOptionDialog(null, 
                                                          preferences, 
                                                          "Preferences", 
                                                          JOptionPane.OK_CANCEL_OPTION, 
                                                          JOptionPane.PLAIN_MESSAGE, 
                                                          null, 
                                                          null, 
                                                          null);
                if (ok == JOptionPane.OK_OPTION) {
                    preferences.setPreferences();
                }
            }
        }
    }
    
    private class FontSizeSpinnerHandler implements ChangeListener {
        // Handle Spinner Event
        public void stateChanged(ChangeEvent event) {
            drawPanel.changeCurrentShapeFont((Integer)fontSizeSpinner.getValue());
        }
    }
    
    private class DashSizeSpinnerHandler implements ChangeListener {
        // Handle Spinner Event
        public void stateChanged(ChangeEvent event) {
            drawPanel.changeCurrentDashFont((Integer)dashSizeSpinner.getValue());
        }
    }
                                                  
    
    // ------Button Handler------
    private class ButtonHandler implements ActionListener {
        // Handle Button Event
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == undo) {
                drawPanel.clearLastShape();
            } else if (event.getSource() == redo) {
                drawPanel.redoLastShape();
            } else if (event.getSource() == clear) {
                drawPanel.clearDrawing();
            } else if (event.getSource() == color1) {
                drawPanel.changeCurrentShapeColor(JColorChooser.showDialog(color1, "Choose Color 1", drawPanel.getCurrentShapeColor()));
            } else if (event.getSource() == color2) {
                drawPanel.changeCurrentShapeColor2(JColorChooser.showDialog(color2, "Choose Color 2", drawPanel.getCurrentShapeColor2()));
            } else if (event.getSource() == background) {
                drawPanel.setBackground(JColorChooser.showDialog(background, "Choose Background Color", drawPanel.getCurrentShapeColor()));
            }
        } // End Method actionPerformed
    } // End ButtonHandler
    
    // ------ShapeComboBoxHandler------
    private class ShapeComboBoxHandler implements ActionListener {
        // Handle Shape ComboBox event
        public void actionPerformed(ActionEvent event) {
            JComboBox<String> shapeSelection = (JComboBox<String>)event.getSource();
            String shape = (String)shapeSelection.getSelectedItem();
            if (shape == "Line") {
                drawPanel.changeCurrentShapeType(LINE);
            } else if (shape == "Oval") {
                drawPanel.changeCurrentShapeType(OVAL);
            } else {
                drawPanel.changeCurrentShapeType(RECTANGLE);
            }
        } // End method actionPerformed
    } // End ShapeComboBoxHandler
    
    // ------ClearOrNotCheckBoxHandler------
    private class ClearOrNotCheckBoxHandler implements ItemListener {
        // Handle CheckBox event
        public void itemStateChanged(ItemEvent event) {
            if (clearOrNot.isSelected() == true) {
                drawPanel.changeCurrentShapeFilled(true);
            } else {
                drawPanel.changeCurrentShapeFilled(false);
            }
        } // End itemStateChanged
    } // End ClearOrNotCheckBoxHandler  
    
    private class GradientOrNotCheckBoxHandler implements ItemListener {
        // Handle CheckBox event
        public void itemStateChanged(ItemEvent event) {
            if(gradientOrNot.isSelected() == true) {
                drawPanel.changeCurrentShapeGradient(true);
            } else {
                drawPanel.changeCurrentShapeGradient(false);
            }
        }
    }
    
    private class DashedOrNotCheckBoxHandler implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            if (dashedOrNot.isSelected() == true) {
                drawPanel.changeCurrentShapeDashed(true);
            } else {
                drawPanel.changeCurrentShapeDashed(false);
            }
        }
    }
    
    private Color returnColor1() {
        if (preferenceReader.returnFirstColor().equals("0")) {
            return Color.RED;
        } else if (preferenceReader.returnFirstColor().equals("1")) {
            return Color.GREEN;
        } else if (preferenceReader.returnFirstColor().equals("2")) {
            return Color.BLUE;
        } else if (preferenceReader.returnFirstColor().equals("3")) {
            return Color.ORANGE;
        } else if (preferenceReader.returnFirstColor().equals("4")) {
            return Color.PINK;
        } else if (preferenceReader.returnFirstColor().equals("5")) {
            return Color.CYAN;
        } else if (preferenceReader.returnFirstColor().equals("6")) {
            return Color.MAGENTA;
        } else if (preferenceReader.returnFirstColor().equals("7")) {
            return Color.YELLOW;
        } else if (preferenceReader.returnFirstColor().equals("8")) {
            return Color.BLACK;
        } else if (preferenceReader.returnFirstColor().equals("9")) {
            return Color.WHITE;
        } else if (preferenceReader.returnFirstColor().equals("10")) {
            return Color.GRAY;
        } else if (preferenceReader.returnFirstColor().equals("11")) {
            return Color.LIGHT_GRAY;
        } else {
            return Color.DARK_GRAY;
        }
    }
    
    private Color returnColor2() {
        if (preferenceReader.returnSecondColor().equals("0")) {
            return Color.RED;
        } else if (preferenceReader.returnSecondColor().equals("1")) {
            return Color.GREEN;
        } else if (preferenceReader.returnSecondColor().equals("2")) {
            return Color.BLUE;
        } else if (preferenceReader.returnSecondColor().equals("3")) {
            return Color.ORANGE;
        } else if (preferenceReader.returnSecondColor().equals("4")) {
            return Color.PINK;
        } else if (preferenceReader.returnSecondColor().equals("5")) {
            return Color.CYAN;
        } else if (preferenceReader.returnSecondColor().equals("6")) {
            return Color.MAGENTA;
        } else if (preferenceReader.returnSecondColor().equals("7")) {
            return Color.YELLOW;
        } else if (preferenceReader.returnSecondColor().equals("8")) {
            return Color.BLACK;
        } else if (preferenceReader.returnSecondColor().equals("9")) {
            return Color.WHITE;
        } else if (preferenceReader.returnSecondColor().equals("10")) {
            return Color.GRAY;
        } else if (preferenceReader.returnSecondColor().equals("11")) {
            return Color.LIGHT_GRAY;
        } else {
            return Color.DARK_GRAY;
        }
    }
    
} // End DrawFrame class
                
        
        
        
        
        
        
        
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

