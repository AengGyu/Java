import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;

public class BlockMovingByKeyFrame extends JFrame {
    public BlockMovingByKeyFrame() {
        super("상하좌우 키로 블록 이동시키기_최영규"); // 제목과 제출자 이름 쓰기
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(new JLabel("상하좌우 키로 블록을 이동시킬 수 있습니다."), BorderLayout.NORTH);
        MyPanel gridPanel = new MyPanel();
        c.add(gridPanel, BorderLayout.CENTER);
        setVisible(true);
        gridPanel.setFocusable(true);
        gridPanel.requestFocus();
    }

    static class MyPanel extends JPanel {
        private final static int ROWS = 5, COLS = 5; // 5x5 그리드
        private JLabel labels[][] = new JLabel[ROWS][COLS]; // 각 그리드 셀에 배치된 JLabel 컴포넌트
        private int curCol = 2, curRow = 2; // 현재 선택된 블록의 위치
        private int starCol, starRow; // 별의 위치
        private final static Color BLOCKCOLOR = Color.BLUE; // 선택된 블록의 배경색
        private final static Color LINECOLOR = Color.PINK; // 그리드 선을 표현할 색, 이 패널의 배경색
        private final static Color BASECOLOR = Color.WHITE; // 선택 안 된 블록들의 배경색
        private final static Color STARCOLOR = Color.YELLOW; // 목표 위치 배경색

        public MyPanel() {
            setLayout(new GridLayout(ROWS, COLS, 1, 1)); // 상하 좌우 셀의 간격 1픽셀
            setBackground(LINECOLOR); // 배경색을 입히고, 블록을 출력되면 배경색이 1픽셀만 보이게 되어, 그리드 선처럼 보이게 됨
            for (int i = 0; i < labels.length; i++) {
                for (int j = 0; j < labels[i].length; j++) {
                    labels[i][j] = new JLabel();
                    labels[i][j].setOpaque(true); // 배경색 불투명
                    labels[i][j].setBackground(BASECOLOR);
                    add(labels[i][j]);
                }
            }
            labels[curRow][curCol].setBackground(BLOCKCOLOR); // 현재 선택된 셀(블록)에 배경색 칠함
            setStarPoint(); // 별의 위치 설정
            // key 이벤트 리스너
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int key = e.getKeyCode();
                    switch (key) {
                        case KeyEvent.VK_LEFT:
                            if (curCol == 0) // 맨 왼쪽이면 멈춤
                                break;
                            labels[curRow][curCol].setBackground(BASECOLOR);
                            curCol--;
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (curCol == COLS - 1) // 맨 오른쪽이면 멈춤
                                break;
                            labels[curRow][curCol].setBackground(BASECOLOR);
                            curCol++;
                            break;
                        case KeyEvent.VK_UP:
                            if (curRow == 0)
                                break;
                            labels[curRow][curCol].setBackground(BASECOLOR);
                            curRow--;
                            break;
                        case KeyEvent.VK_DOWN:
                            if (curRow == ROWS - 1)
                                break;
                            labels[curRow][curCol].setBackground(BASECOLOR);
                            curRow++;
                            break;
                        default:
                            return;
                    }
                    labels[curRow][curCol].setBackground(BLOCKCOLOR);
                    if(curRow == starRow && curCol == starCol){ // 파란색 블록과 별이 만나면 별의 위치 재설정
                        setStarPoint();
                    }
                    ((Component) e.getSource()).repaint(); // 블록의 배경색에 변화가 발생하였기 때문에 다시 그리기 호출
                }
            });
        }
        private void setStarPoint(){
            Random rand = new Random();
            do {
                starCol = rand.nextInt(COLS);
                starRow = rand.nextInt(ROWS); // 랜덤으로 별의 좌표를 정함
            }while(starRow == curRow && starCol == curCol);

            labels[starRow][starCol].setBackground(STARCOLOR);
        }
        private int getArrayIndex(int x, int y) {
            return COLS * y + x;
        }
    }


    public static void main(String[] args) {
        new BlockMovingByKeyFrame();
    }
}