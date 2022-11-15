package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 5;
    private Controller controller;
    private final JFrame frame = new JFrame("My second graphical interface");
    private final JPanel panel;
    private final JPanel panelTop;
    private final JButton buttonSave;
    private final JButton buttonBrowse;
    private final JTextArea textArea = new JTextArea();
    private final JTextField textField;

    public SimpleGUIWithFileChooser(Controller ctrllr){
        this.controller =  ctrllr;

        //TextField
        this.textField = new JTextField(controller.getFilePath());
        
        //panel
        this.panel = new JPanel(new BorderLayout());
        this.panel.add(this.textArea, BorderLayout.CENTER);
        //panelTop
        this.panelTop = new JPanel(new BorderLayout());
        this.panelTop.add(textField, BorderLayout.CENTER);
        this.panel.add(this.panelTop, BorderLayout.NORTH);

        //buttonSave
        this.buttonSave = new JButton("Save");
        this.buttonSave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(final ActionEvent event) {
                controller.writeOnFile(textArea.getText());
            }

        });
        this.panel.add(this.buttonSave, BorderLayout.SOUTH);
        

        //buttonBrowse
        this.buttonBrowse = new JButton("Browse...");
        this.buttonBrowse.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent event) {
                JFileChooser fileChooser = new JFileChooser(controller.getFilePath());
                int status = fileChooser.showSaveDialog(fileChooser);
                if( status == JFileChooser.APPROVE_OPTION){
                    controller.setCurrentFile(fileChooser.getSelectedFile());
                    textField.setText(controller.getFilePath());
                }else if(status == JFileChooser.CANCEL_OPTION){
                    return;
                }else{
                    JOptionPane.showMessageDialog(frame, "Error");
                }
            }

        });

        this.panelTop.add(this.buttonBrowse, BorderLayout.EAST);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }


    private void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
    }

    public static void main(String ... args){
        Controller controller = new Controller();
        new SimpleGUIWithFileChooser(controller).display();
    }
}
