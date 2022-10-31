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
import java.util.Arrays;

public class puzzleGraphics extends JFrame implements ActionListener {

    private BufferedImage img;
    JPanel gamePanel;
    JFrame frame;
    JButton newGame;
    JButton[] buttons;
   JToggleButton testMode;
    JPanel bottomPanel;
    Shuffle shuffle = new Shuffle();
    int[] buttonOrder;

    puzzleGraphics(int[] input) {
        buttonOrder = input;
        frame = new JFrame();
        gamePanel = new JPanel();
        bottomPanel = new JPanel();
        buttons = new JButton[16];
        testMode = new JToggleButton("Test mode");
        newGame = new JButton("Nytt Spel");
        newGame.addActionListener(this);
        testMode.addActionListener(this);


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
            bottomPanel.add(testMode);


            gamePanel.setBorder(new MetalBorders.InternalFrameBorder());
            gamePanel.setBorder(new SoftBevelBorder(1, Color.blue, Color.gray));
            gamePanel.setSize(400, 400);
            gamePanel.setLayout(new GridLayout(4, 4));

            getButtons();
            gamePanel.add(buttons[0]);

        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
        private void setFrame() {
            frame.setTitle("Game of 15");
            frame.setVisible(true);
            frame.setSize(460, 350);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
        }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Nytt Spel")) {
            gamePanel.removeAll();
            buttonOrder = shuffle.shuffle(buttonOrder);
            getButtons();
        }
        if (action.equals("Test mode")) {
            gamePanel.removeAll();
            int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15};
            buttonOrder = testArray;
            getButtons();

        }
    }
    private void getButtons() {
        for (int i = 0; i < buttons.length; i++) {
            if (i == 0) {
                buttons[i] = new JButton("");
                buttons[i].setSize(65, 70);
                buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 25));
            } else
                buttons[i] = new JButton(String.valueOf(i));
            buttons[i].setSize(65, 70);
            buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 25));
        }
        for (int i = 0; i < buttonOrder.length; i++) {
            gamePanel.add(buttons[buttonOrder[i]]);
        }
        setFrame();

    }
}
