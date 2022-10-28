import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class buttons extends JButton implements ActionListener, MouseListener {
    private JButton[] buttons;
    private JButton newGame;
    private JButton emptyButton;

    public void buttons(){
        for(int i=1;i<buttons.length;i++){
            buttons[i]=new JButton(String.valueOf(i));


            buttons[i].setPreferredSize(new Dimension(100,80));
            buttons[i].setFont(new Font("Tahoma",Font.BOLD,40));
            buttons[i].setBackground(Color.darkGray);
            buttons[i].setForeground(Color.white);
            buttons[i].setBorder(new MetalBorders.ButtonBorder());
            emptyButton.setBackground(Color.darkGray);
            buttons[i].setRolloverEnabled(true);
            emptyButton.setRolloverEnabled(true);

            emptyButton=new JButton("");
            buttons=new JButton[16];
            newGame=new JButton("Nytt spel");


            buttons[i].addActionListener(this);
            buttons[i].addMouseListener(this);
            emptyButton.addActionListener(this);
            emptyButton.addMouseListener(this);
        }
}
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }
    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].isFocusable()) {
                    buttons[i].setBackground(Color.lightGray);

                }
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                buttons[i].setBackground(null);

            }
        }
    }
}

