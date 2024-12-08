import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
    private JLabel la = new JLabel("No Mouse Event");

    public Main(){
        setTitle("BorderLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        MyMouseListener listener = new MyMouseListener();
        c.addMouseListener(listener);
        c.addMouseMotionListener(listener);
        c.add(la);

        setSize(350,350);
        setVisible(true);
    }
    class MyMouseListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            la.setText("mousePressed ("+e.getX()+", "+e.getY ()+")");
        }
        public void mouseReleased(MouseEvent e){
            la.setText("mouseReleased ("+e.getX()+", "+e.getY ()+")");
        }
        public void mouseClicked(MouseEvent e){
            if(e.getClickCount()==2){
                int r = (int)(Math.random()*256);
                int g = (int)(Math.random()*256);
                int b = (int)(Math.random()*256);
                Container c = (Container)e.getSource();
                c.setBackground(new Color(r,g,b));
            }
        }
        public void mouseEntered(MouseEvent e){
            Container c = (Container)e.getSource();
            c.setBackground(Color.CYAN);
        }
        public void mouseExited(MouseEvent e){
            Container c = (Container)e.getSource();
            c.setBackground(Color.YELLOW);
        }
        public void mouseDragged(MouseEvent e){
            la.setText("mouseDragged ("+e.getX()+", "+e.getY ()+")");
        }
        public void mouseMoved(MouseEvent e){
            la.setText("mouseMoved ("+e.getX()+", "+e.getY ()+")");
        }
    }
    public static void main(String[] args){
        new Main();
    }
}