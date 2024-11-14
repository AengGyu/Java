import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    public Main(){
        setTitle("practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JButton("OK"));
        panel.add(new JButton("Cancel"));
        panel.add(new JButton("Ignore"));
        setContentPane(panel);
        panel.setBackground(Color.cyan);

//        Container container = getContentPane();
//        container.setBackground(Color.CYAN);
//        container.setLayout(new FlowLayout());
//
//        container.add(new JButton("OK"));
//        container.add(new JButton("Cancel"));
//        container.add(new JButton("Ignore"));

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        Main frame = new Main();
    }
}
