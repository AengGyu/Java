import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MoneyChangerFrame extends JFrame {
    public MoneyChangerFrame() {
        setTitle("Money Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(300, 300);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
        private String[] text = {"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
        private JTextField source; // 사용자로부터 금액이 입력될 텍스트 필드
        private JTextField[] tf = new JTextField[8];

        public MyPanel(){
            setBackground(Color.YELLOW);
            setLayout(null);

            JLabel la = new JLabel("금액");
            la.setHorizontalAlignment(JLabel.RIGHT);
            la.setSize(50,20);
            la.setLocation(20,20);
            add(la);

            source = new JTextField(30);
            source.setSize(100,20);
            source.setLocation(100,20);
            add(source);

            JButton calcBtn = new JButton("계산");
            calcBtn.setSize(70,20);
            calcBtn.setLocation(210,20);
            add(calcBtn);

            JButton rstBtn = new JButton("초기화");
            rstBtn.setSize(70,20);
            rstBtn.setLocation(210,50);
            add(rstBtn);

            JButton colorMode = new JButton("다크 모드");
            colorMode.setSize(70,20);
            colorMode.setLocation(210,220);
            add(colorMode);

            for(int i =0;i<text.length;i++){
                la = new JLabel(text[i]);
                la.setHorizontalAlignment(JLabel.RIGHT);
                la.setSize(50,20);
                la.setLocation(50, 50+i*20);
                add(la);
                tf[i] = new JTextField(30);
                tf[i].setHorizontalAlignment(JTextField.CENTER);
                tf[i].setSize(70,20);
                tf[i].setLocation(120,50+i*20);
                add(tf[i]);
            }

            calcBtn.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                   String str = source.getText();
                   if(str.length()==0)return;

                   int money = Integer.parseInt(str);
                   int res;
                   for(int i=0;i<unit.length;i++){
                       res = money/unit[i];
                       tf[i].setText(Integer.toString(res));
                       if(res>0){
                           money = money%unit[i];
                       }
                   }
               }
            });

            rstBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    source.setText("");
                    for(int i=0;i<tf.length;i++){
                        tf[i].setText("");
                    }
                }
            });

            colorMode.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JButton btn = (JButton)e.getSource();
                    if(btn.getText().equals("다크 모드")){
                        btn.setText("컬러 모드");
                        setBackground(Color.DARK_GRAY);
                        for(int i=0;i<tf.length;i++){
                            tf[i].setBackground(Color.BLACK);
                            tf[i].setForeground(Color.WHITE);
                        }
                    }
                    else{
                        btn.setText("다크 모드");
                        setBackground(Color.YELLOW);
                        for(int i=0;i<tf.length;i++){
                            tf[i].setBackground(Color.WHITE);
                            tf[i].setForeground(Color.BLACK);
                        }
                    }
                }
            });
        }
    }
    public static void main(String[] args){
        new MoneyChangerFrame();
    }
}
