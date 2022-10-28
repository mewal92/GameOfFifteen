import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class puzzleGraphics extends JFrame implements ActionListener, MouseListener {
        private JPanel gamePanel;
        private JPanel panel;
        private JFrame main;
        private JSeparator separator;
        private BufferedImage img;

        puzzleGraphics(){
            panel = new JPanel();

            gamePanel = new JPanel();
            main = new JFrame();
            separator = new JSeparator(1);

            try {
                img = ImageIO.read(new File("src/bk.jpg"));
                main.setContentPane(new JLabel(new ImageIcon(img)));
                main.setLayout(new FlowLayout());
                main.getContentPane().add(gamePanel);
                main.getContentPane().add(separator);
                main.getContentPane().add(newGame);


                    gamePanel.setBorder(new MetalBorders.InternalFrameBorder());
                    gamePanel.setBorder(new SoftBevelBorder(1, Color.blue, Color.gray));
                    gamePanel.setSize(460, 360);
                    gamePanel.setLayout(new GridLayout(4, 4));
                    gamePanel.setBackground(Color.darkGray);

                gamePanel.add(buttons[i]);
                gamePanel.add(emptyButton);


                    main.setTitle("Game of 15");
                    main.setVisible(true);
                    main.setLocationRelativeTo(null);
                    main.setSize(460, 500);
                    main.setDefaultCloseOperation(EXIT_ON_CLOSE);


            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }


        public static void main(String[] args) {
            puzzleGraphics pg = new puzzleGraphics();
        }
    }

