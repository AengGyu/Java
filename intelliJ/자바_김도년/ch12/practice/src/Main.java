import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame{
    public Main(){
        setTitle("practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        MyButton b = new MyButton("New Button");
        b.setOpaque(true);
        b.setBackground(Color.CYAN);
        c.add(b);
        setSize(300,400);
        setVisible(true);
    }
    class MyButton extends JButton{
        public MyButton(String s){
            super(s);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawOval(0,0,getWidth(),getHeight());
        }
    }
    public static void main(String[] args){
        new Main();
    }
}
