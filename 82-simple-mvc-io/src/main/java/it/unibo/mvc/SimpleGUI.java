package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame("My first graphical interface");
    private final JPanel panel;
    private final JButton button;
    private Controller controller;
    private final JTextArea textArea = new JTextArea();

    public SimpleGUI(Controller ctrllr){
        this.controller = ctrllr; 

        //button
        this.button = new JButton("Save");
        this.button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(final ActionEvent event) {
                controller.writeOnFile(textArea.getText());
            }

        });
        
        //panel
        this.panel = new JPanel(new BorderLayout());
        this.panel.add(this.textArea, BorderLayout.CENTER);
        this.panel.add(this.button, BorderLayout.SOUTH);

        //frame
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
    }

    public  static void main(String ... args){
        Controller controller = new Controller();
        new SimpleGUI(controller).display();
    } 
}


