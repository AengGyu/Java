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

        

        setSize(250,600);
        setVisible(true);
    }
    public static void main(String[] args){
        new Main();
    }
}
