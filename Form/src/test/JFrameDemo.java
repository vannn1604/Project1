/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class JFrameDemo extends JFrame {
    
    //private JFrame frame;
    JButton button;
    
    
    
    
    public JFrameDemo() {
        creatAndShow();
    }
    
    public void creatAndShow() {
        button = new JButton("OK");
        //frame = new JFrame("Title");
        setSize(300, 400);
        this.setLocationRelativeTo(null); //chay gia man hinh
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(button);
        this.setLayout(new FlowLayout());//tao khung cho 'OK'
        setVisible(true); //hien thi
    }
    
    public static void main(String[] args) {
        new JFrameDemo();
    }
}
