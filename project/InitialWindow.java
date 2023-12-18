import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialWindow {
    public static void main(String[] args) {
        initialStart start = new initialStart();
    }
}

class initialStart{
    JFrame frame = new JFrame("Warehouse keeper");
    JButton startButton = new JButton("Начать!");

    public initialStart()  {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(null);


        JLabel nameLabel = new JLabel("Введите имя:");
        nameLabel.setBounds(275, 160, 80, 25);
        frame.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(275, 180, 250, 40);
        frame.add(nameText);

        startButton.setBounds(275, 300, 250, 60);
        startButton.setFocusable(false);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GameStart game = new GameStart(nameText.getText());
            }
        });
        frame.add(startButton);
        frame.setVisible(true);
    }
}
