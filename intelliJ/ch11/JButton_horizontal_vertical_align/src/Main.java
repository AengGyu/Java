import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main extends JFrame {
    public Main(){
        super("practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon normal = new ImageIcon("/Users/aenggyu/Desktop/JavaWorkSpace/example/예제 및 그림 소스/11장/chap11-ex03/images/normalIcon.gif");
        ImageIcon rollover = new ImageIcon("/Users/aenggyu/Desktop/JavaWorkSpace/example/예제 및 그림 소스/11장/chap11-ex03/images/rolloverIcon.gif");
        ImageIcon pressed = new ImageIcon("/Users/aenggyu/Desktop/JavaWorkSpace/example/예제 및 그림 소스/11장/chap11-ex03/images/pressedIcon.gif");

        JButton btn = new JButton("call~~",normal);
        btn.setPressedIcon(pressed);
        btn.setRolloverIcon(rollover);

        JButton btn2 = new JButton("call~~",normal);
        JButton btn3 = new JButton("call~~",normal);

        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn2.setHorizontalAlignment(SwingConstants.CENTER);
        btn3.setHorizontalAlignment(SwingConstants.RIGHT);

        c.add(btn);
        c.add(btn2);
        c.add(btn3);

        setSize(250,600);
        setVisible(true);
    }
    public static void main(String[] args){
        new Main();
    }
}
