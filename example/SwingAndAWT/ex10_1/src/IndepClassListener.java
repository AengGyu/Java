import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class IndepClassListener extends JFrame {
    public IndepClassListener(){
        super("Independent Class Listener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("action");
        btn.addActionListener(new MyActionListener());
        // 익명 클래스 사용
//        btn.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                JButton b = (JButton)e.getSource();
//                if(b.getText().equals("action")){
//                    b.setText("액션");
//                }
//                else{
//                    b.setText("action");
//                }
//            }
//        });
        c.add(btn);

        setSize(500,500);
        setVisible(true);
    }
//     내부 클래스
    private class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton b = (JButton)e.getSource();
            if(b.getText().equals("action")){
                b.setText("액션");
            }
            else{
                b.setText("action");
            }
        }
    }
    public static void main(String[] args){
        new IndepClassListener();
    }
}
//class MyActionListener implements ActionListener{
//    public void actionPerformed(ActionEvent e){
//        JButton b = (JButton)e.getSource();
//        if(b.getText().equals("action")){
//            b.setText("액션");
//        }
//        else{
//            b.setText("action");
//        }
//    }
//}