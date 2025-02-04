import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame{
    public Main(){
        super("practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(new MyPanel(),BorderLayout.NORTH);
        setSize(500,200);
        setVisible(true);
    }
    class MyPanel extends JPanel{
        private JButton inputBtn = new JButton("Input Name");
        private JTextField tf = new JTextField(10);
        private JButton confirmBtn = new JButton("Confirm");
        private JButton messageBtn = new JButton("Message");

        public MyPanel(){
            setBackground(Color.LIGHT_GRAY);
            add(inputBtn);
            add(confirmBtn);
            add(messageBtn);
            add(tf);

            inputBtn.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                   String name = JOptionPane.showInputDialog("이름을 입력하세요");
                   if(name != null) tf.setText(name);
               }
            });
            confirmBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int result = JOptionPane.showConfirmDialog(null,"계속 할 거?","Confirm",JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.CLOSED_OPTION){
                        tf.setText("걍 닫음");
                    }
                    else if(result == JOptionPane.YES_OPTION){
                        tf.setText("Yes");
                    }
                    else{
                        tf.setText("No");
                    }
                }
            });
            messageBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(Main.this,"조심","Message",JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }
    public static void main(String[] args){
        new Main();
    }
}
