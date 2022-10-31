import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class gameButtons extends puzzleGraphics implements ActionListener {
    public gameButtons() {
        buttons = new JButton[16];
        newGame.addActionListener(this);
        checkBox.addActionListener(this);

    }

    //metod för att shuffla buttons
    private void shuffleGame() {

        //tar bort gamla knapparna från gamepanel
        gamePanel.removeAll();

        //läser in från array igen men denna gång sparar med en new random/next int
        //för random siffror (dock är 0 med + siffror förekommer dubbelt vilket de ej ska)

        for (int i = 1; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(new Random().nextInt(buttons.length)));
                buttons[i].setSize(50, 50);
                buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 25));

                //lägger till de nya knapparna och uppdaterar gamepanel
                gamePanel.add(buttons[i]);
                gamePanel.add(emptyButton);
                gamePanel.validate();
                gamePanel.repaint();
            }
            }


    //shuffla knappar när man trycker på nytt spel elr testmode checkbox
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            shuffleGame();
        }
        if(checkBox.isSelected()) {
            //startTestMode();
        }
    }
}
