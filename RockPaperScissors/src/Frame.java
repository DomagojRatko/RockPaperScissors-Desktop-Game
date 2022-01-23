import javax.swing.*;

/**
 * Created Domagoj Ratko
 * Simple game of Rock Paper Scissors
 * date: 23.01.2022
 */

public class Frame extends JFrame {

    GamePanel gamePanel;

    public Frame(String title){

        gamePanel = new GamePanel();
        this.setTitle(title);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        new Frame("Game");

    }
}
