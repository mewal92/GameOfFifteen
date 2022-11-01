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
        newGame = new JButton("Nytt Spel");
        testMode= new JCheckBox("Test mode");
        newGame.addActionListener(this);
        testMode.addActionListener(this);

        try {
            img = ImageIO.read(new File("resources/bk.jpg"));
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

            testMode.setOpaque(false);

            getButtons();

        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action == "Nytt Spel") {
            gamePanel.removeAll();
                buttonOrder = shuffle.shuffle(buttonOrder);
                getButtons();
            }else if (action == "Test mode"){
            gamePanel.removeAll();
                int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15};
                buttonOrder = testArray;
                getButtons();
            }

        JButton source;
        if (action != "Nytt Spel" && action != "Test mode") {
            source = (JButton) ae.getSource();


            int index = 0;
            int count = 0;
            for (int i = 0; i < buttons.length; i++) {
                count = buttonOrder[i];
                String s = Integer.toString(count);
                if (source.getText().equals(s)) {
                    index = i;
                    break;
                }
            }
            int index2 = index;

            if (index != 0 && index != 4 && index != 8 && index != 12 && buttonOrder[index - 1] == 0) {
                buttonOrder[index - 1] = count;
                buttonOrder[index2] = 0;
                getButtons();
            }

            else if (index != 3 && index != 7 && index != 11 && index != 15 && buttonOrder[index + 1] == 0) {
                buttonOrder[index + 1] = count;
                buttonOrder[index2] = 0;
                getButtons();

            } else if ((index - 4 >= 0) && buttonOrder[index - 4] == 0) {
                buttonOrder[index - 4] = count;
                buttonOrder[index2] = 0;
                getButtons();

            } else if ((index + 4 < 17) && buttonOrder[index + 4] == 0) {
                buttonOrder[index + 4] = count;
                buttonOrder[index2] = 0;
                getButtons();
            }
            int[] winArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
            if (Arrays.compare(winArray, buttonOrder) == 0){
                JOptionPane.showMessageDialog(null, "Grattis, du vann!");
            }
        }
    }

    private void getButtons() {
        gamePanel.removeAll();
        for (int i = 0; i < buttons.length; i++) {
            if (i == 0) {
                buttons[i] = new JButton("");
                buttons[i].setSize(65, 70);
                buttons[i].setBackground(Color.darkGray);
                buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 25));
            } else
                buttons[i] = new JButton(String.valueOf(i));
            buttons[i].setSize(65, 70);
            buttons[i].setForeground(Color.darkGray);
            buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 25));
            buttons[i].addActionListener(this);
        }
        for (int i = 0; i < buttonOrder.length; i++) {
            gamePanel.add(buttons[buttonOrder[i]]);
        }
        setFrame();
    }

    private void setFrame() {
        frame.setTitle("Game of 15");
        frame.setVisible(true);
        frame.setSize(460, 350);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}
