import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerEx extends JFrame{
    private JLabel label = new JLabel("이진표");

    public MouseListenerEx() {
        super("Mouse Listener Ex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());

        c.setLayout(null);
        label.setSize(50, 20);
        label.setLocation(30, 30);
        c.add(label);

        setSize(250, 250);
        setVisible(true);
    }
    public static void main(String[] args){
        new MouseListenerEx();
    }
    class MyMouseListener implements MouseListener{
        public void mousePressed(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            label.setLocation(x,y);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e){
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
