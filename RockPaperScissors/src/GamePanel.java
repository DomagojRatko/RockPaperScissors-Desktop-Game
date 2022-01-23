import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    public Images img;
    public Mouse mouse;

    private String state = "menu";
    private int result = 0;
    private String enemyHand;
    private int playerScore = 0;
    private int enemyScore = 0;
    private int numPlayerHand;
    private int randomEnemyHand;
    private int loadingTime = 1; /** seconds **/

    public GamePanel() {

        int GAME_WIDTH = 1000;
        int GAME_HEIGHT = 500;
        Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        this.setPreferredSize(SCREEN_SIZE);
        this.setFocusable(true);
        Thread gameThread = new Thread(this);
        gameThread.start();
        init();
        addMouseListener(mouse);

    }

    public void init(){

        mouse = new Mouse(this);
        img = new Images();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        switch (state) {
            case "menu":
                drawMenu(g);
                break;
            case "calculate":
                drawCalculate(g);
                break;
            case "result":
                drawResult(g);
                break;
        }

    }

    public void drawMenu(Graphics g){

        mouse.rectAry.add(mouse.paperRect);
        mouse.rectAry.add(mouse.rockRect);
        mouse.rectAry.add(mouse.scissorsRect);
        mouse.rectAry.remove(mouse.playAgainRect);
        g.drawImage(img.background, 0, 0, this);
        g.drawImage(img.text, 310, 20, img.TEXT_WIDTH, img.TEXT_HEIGHT, this);
        g.drawImage(img.paperImg, 70, 150, img.IMG_WIDTH, img.IMG_HEIGHT, this);
        g.drawImage(img.rockImg, 370, 150, img.IMG_WIDTH, img.IMG_HEIGHT, this);
        g.drawImage(img.scissorsImg, 670, 150, img.IMG_WIDTH, img.IMG_HEIGHT, this);
        g.drawImage(img.player,10,15,150,50,this);
        g.drawImage(img.enemy,8,70,150,50,this);
        if(playerScore == 10 || enemyScore == 10) {
            playerScore = 0;
            enemyScore = 0;
        }
        g.drawImage(img.numAry.get(playerScore),170,25,this);
        g.drawImage(img.numAry.get(enemyScore),170,80,this);

    }

    public void drawCalculate(Graphics g) {

        mouse.rectAry.remove(mouse.paperRect);
        mouse.rectAry.remove(mouse.rockRect);
        mouse.rectAry.remove(mouse.scissorsRect);
        mouse.rectAry.remove(mouse.playAgainRect);
        g.drawImage(img.background, 0, 0, this);
        g.drawImage(img.count, 375, 125,250,250, this);

    }

    public void drawResult(Graphics g) {

        mouse.rectAry.add(mouse.playAgainRect);
        g.drawImage(img.background, 0, 0, this);
        g.drawImage(img.textAry.get(result), 310, 20, img.TEXT_WIDTH, img.TEXT_HEIGHT, this);
        g.drawImage(img.playAgainImg, 310, 400, img.TEXT_WIDTH, img.TEXT_HEIGHT, this);
        g.drawImage(img.imgAry.get(numPlayerHand), 200, 120, img.IMG_WIDTH, img.IMG_HEIGHT, this);
        g.drawImage(img.imgAry.get(randomEnemyHand), 550, 120, img.IMG_WIDTH, img.IMG_HEIGHT, this);

    }

    public void nextState(String state){

        this.state = state;
        repaint();

    }

    public void play(String playerHand, int numPlayerHand) {

        nextState("calculate");
        this.numPlayerHand = numPlayerHand;
        Random random = new Random();
        randomEnemyHand = random.nextInt(3);

        switch(randomEnemyHand){
            case 0:
                enemyHand = "paper";
                break;
            case 1:
                enemyHand = "rock";
                break;
            case 2:
                enemyHand = "scissors";
                break;
        }

        if(playerHand.equals(enemyHand)){
            result = 0;
        } else if((playerHand.equals("paper") && enemyHand.equals("rock")) ||
                (playerHand.equals("scissors") && enemyHand.equals("paper")) ||
                (playerHand.equals("rock") && enemyHand.equals("scissors"))) {
            result = 1;
            playerScore++;
        } else if((playerHand.equals("rock") && enemyHand.equals("paper")) ||
                (playerHand.equals("paper") && enemyHand.equals("scissors")) ||
                (playerHand.equals("scissors") && enemyHand.equals("rock"))) {
            result = 2;
            enemyScore++;
        }

    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                if(state.equals("calculate")){
                    try {
                        Thread.sleep(loadingTime * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    nextState("result");
                }
                delta--;
            }
        }

    }
}
