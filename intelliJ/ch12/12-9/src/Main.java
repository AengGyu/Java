import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.event.*;

public class Main extends JFrame{
    private MyPanel panel = new MyPanel();
    public Main(){
        super("practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300,300);
        setVisible(true);
    }
    public class MyPanel extends JPanel{
        private Vector<Point> vStart = new Vector<>();
        private Vector<Point> vEnd = new Vector<>();
        public MyPanel(){
            addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    vStart.add(e.getPoint());
                }
                public void mouseReleased(MouseEvent e){
                    vEnd.add(e.getPoint());
                    repaint();
                }
            });
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);

            for(int i=0;i<vStart.size();i++){
                Point start = vStart.get(i);
                Point end = vEnd.get(i);

                g.drawLine(start.x,start.y,end.x,end.y);
            }
        }
    }
    public static void main(String[] args){
        new Main();
    }
}
