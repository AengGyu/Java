import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlockCreationAndDraggingFrame extends JFrame {
    public BlockCreationAndDraggingFrame() {
        super("블록 생성 및 드래깅 배치");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel contentPane = new MyPanel();
        setContentPane(contentPane);
        setVisible(true);

        contentPane.setFocusable(true);
        contentPane.requestFocus();
    }

    class MyPanel extends JPanel {
        private MyMouse ml = new MyMouse();
        private JLabel selectedLabel = null;

        public MyPanel() {
            setLayout(null);
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyChar() == 'm') {
                        JLabel la = new JLabel();
                        la.setSize(80, 80);
                        la.setLocation(100, 100);
                        la.setOpaque(true);
                        int r = (int) (Math.random() * 256);
                        int g = (int) (Math.random() * 256);
                        int b = (int) (Math.random() * 256);
                        la.setBackground(new Color(r, g, b));
                        la.addMouseListener(ml);
                        la.addMouseMotionListener(ml);

                        MyPanel.this.add(la);
                        MyPanel.this.repaint();
                    } else if (e.getKeyChar() == 'd') {
                        if (selectedLabel != null) {
                            MyPanel.this.remove(selectedLabel);
                            MyPanel.this.repaint();
                            selectedLabel = null;
                        }
                    } else if (e.getKeyChar() == 'c') {
                        if (selectedLabel != null) {
                            int r = (int) (Math.random() * 256);
                            int g = (int) (Math.random() * 256);
                            int b = (int) (Math.random() * 256);
                            selectedLabel.setBackground(new Color(r, g, b));
                            MyPanel.this.repaint();
                        }
                    }
                }
            });
        }

        class MyMouse extends MouseAdapter {
            private Point pressedP = null;

            @Override
            public void mousePressed(MouseEvent e) {
                pressedP = e.getPoint();
                selectedLabel = (JLabel) e.getComponent();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point draggedP = e.getPoint();
                int distX = draggedP.x - pressedP.x;
                int distY = draggedP.y - pressedP.y;
                JLabel la = (JLabel) e.getComponent();
                la.setLocation(la.getX() + distX, la.getY() + distY);
            }
        }
    }

    public static void main(String[] args) {
        new BlockCreationAndDraggingFrame();
    }
}