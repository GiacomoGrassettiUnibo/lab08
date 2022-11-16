package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 2;

    private final SimpleController controller;
    private final JFrame frame = new JFrame("My third simple GUI");
    private final JPanel panel;
    private final JPanel panelBottom;
    private final JTextField textField;
    private final JTextArea textArea;
    private final JButton btnPrint;
    private final JButton btnShowHistory;

    public SimpleGUI(SimpleController ctrllr){
        this.controller = ctrllr;

        //panel
        this.panel = new JPanel(new BorderLayout());
        this.panelBottom = new JPanel(new BorderLayout());
        this.panel.add(this.panelBottom, BorderLayout.SOUTH);
        
        //textField
        this.textField = new JTextField();
        this.panel.add(this.textField, BorderLayout.NORTH);

        //textArea
        this.textArea = new JTextArea();
        this.panel.add(this.textArea, BorderLayout.CENTER);

        //button
        this.btnPrint = new JButton("Print");
        this.btnPrint.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.printCurrentString(textField.getText());
            }

        });
        this.btnShowHistory = new JButton("ShowHistory");
        this.btnShowHistory.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                textArea.setText(controller.getHistoryOfString().toString());
                
            }
        });
        this.panelBottom.add(btnPrint, BorderLayout.WEST);
        this.panelBottom.add(btnShowHistory, BorderLayout.EAST);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
    }

    public static void main(String ... args){
        new SimpleGUI(new SimpleController()).display();
    }

}
