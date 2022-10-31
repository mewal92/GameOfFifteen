import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class puzzleGraphics extends JFrame implements ActionListener {

    private BufferedImage img;
    JPanel gamePanel;
    JFrame frame;
    JButton newGame;
    JButton[] buttons;
    JCheckBox checkBox;
    JPanel bottomPanel;
    Shuffle shuffle = new Shuffle();
    int[] buttonOrder;

    puzzleGraphics(int[] input) {
        buttonOrder = input;
        frame = new JFrame();
        gamePanel = new JPanel();
        bottomPanel = new JPanel();
        buttons = new JButton[16];
        newGame = new JButton("Nytt Spel");
        checkBox = new JCheckBox("Test mode");
        newGame.addActionListener(this);
        checkBox.addActionListener(this);

        try {
            img = ImageIO.read(new File("bk.jpg"));
            frame.setContentPane(new JLabel(new ImageIcon(img)));
            frame.setLayout(new FlowLayout());
            frame.getContentPane().add(gamePanel);
            frame.getContentPane().add(bottomPanel);

            bottomPanel.setLayout(new FlowLayout());
            bottomPanel.setOpaque(true);
            bottomPanel.setBackground(new Color(0, 0, 0, 0));
            bottomPanel.add(newGame);
            bottomPanel.add(checkBox);

            checkBox.setOpaque(true);
            checkBox.setBackground(new Color(0, 0, 0, 0));

            gamePanel.setBorder(new MetalBorders.InternalFrameBorder());
            gamePanel.setBorder(new SoftBevelBorder(1, Color.blue, Color.gray));
            gamePanel.setSize(400, 400);
            gamePanel.setLayout(new GridLayout(4, 4));

            getButtons();
            gamePanel.add(buttons[0]);

            frame.setTitle("Game of 15");
            frame.setVisible(true);
            frame.setSize(460, 350);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            gamePanel.removeAll();
            if (!checkBox.isSelected()) {
                buttonOrder = shuffle.shuffle(buttonOrder);
                getButtons();

                frame.setTitle("Game of 15");
                frame.setVisible(true);
                frame.setSize(460, 350);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
            }
        }
    }

    private void getButtons() {
        for (int i = 0; i < buttons.length; i++) {
            if (i == 0) {
                buttons[i] = new JButton("");
                buttons[i].setSize(50, 50);
                buttons[i].setBackground(Color.darkGray);
                buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 25));
            } else
                buttons[i] = new JButton(String.valueOf(i));
            buttons[i].setSize(50, 50);
            buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 25));
        }
        for (int i = 0; i < buttonOrder.length; i++) {
            gamePanel.add(buttons[buttonOrder[i]]);
        }
    }
}
