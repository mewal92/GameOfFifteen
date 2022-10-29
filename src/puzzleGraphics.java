import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class puzzleGraphics extends JFrame {

        private BufferedImage img;
        JPanel gamePanel;
        JFrame frame;
        JButton newGame;
        JButton []buttons;
        JButton emptyButton;
        JCheckBox checkBox;

        puzzleGraphics(){
            frame = new JFrame();
            gamePanel = new JPanel();
            buttons= new JButton[16];
            newGame= new JButton("Nytt Spel");
            checkBox = new JCheckBox("Test mode");

            try {
                img = ImageIO.read(new File("bk.jpg"));
                frame.setContentPane(new JLabel(new ImageIcon(img)));
                frame.setLayout(new FlowLayout());
                frame.getContentPane().add(gamePanel);
               frame.getContentPane().add(newGame);
                frame.getContentPane().add(checkBox);

                    gamePanel.setBorder(new MetalBorders.InternalFrameBorder());
                    gamePanel.setBorder(new SoftBevelBorder(1, Color.blue, Color.gray));
                    gamePanel.setSize(400, 400);
                    gamePanel.setLayout(new GridLayout(4, 4));

                    //läser in knappar från 1-15 när man startar programmet
                for (int i = 1; i <buttons.length; i++) {
                    buttons[i] = new JButton(String.valueOf(i));
                    buttons[i].setSize(50,50);
                    buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 25));
                    gamePanel.add(buttons[i]);
                }
                    frame.setTitle("Game of 15");
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    setLocationRelativeTo(null);
                    frame.setSize(460, 350);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
    }

