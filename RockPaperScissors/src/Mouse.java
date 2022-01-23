import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Mouse extends MouseAdapter {

    Images img;
    GamePanel gamePanel;

    public Rectangle paperRect, rockRect, scissorsRect, playAgainRect;
    public ArrayList<Rectangle> rectAry = new ArrayList<>();

    public Mouse(GamePanel gamePanel){

        this.gamePanel = gamePanel;
        this.img = new Images();
        paperRect = new Rectangle(70, 150, img.IMG_WIDTH, img.IMG_HEIGHT);
        rockRect = new Rectangle(370, 150, img.IMG_WIDTH, img.IMG_HEIGHT);
        scissorsRect = new Rectangle(670, 150, img.IMG_WIDTH, img.IMG_HEIGHT);
        playAgainRect = new Rectangle(310, 400, img.TEXT_WIDTH, img.TEXT_HEIGHT);

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (rectAry.contains(paperRect) && paperRect.contains(e.getX(), e.getY())) {
            gamePanel.play("paper", 0);
        } else if (rectAry.contains(rockRect) && rockRect.contains(e.getX(), e.getY())){
            gamePanel.play("rock", 1);
        } else if(rectAry.contains(scissorsRect) && scissorsRect.contains(e.getX(), e.getY())){
            gamePanel.play("scissors", 2);
        } else if(rectAry.contains(playAgainRect) && playAgainRect.contains(e.getX(), e.getY())){
            gamePanel.nextState("menu");
        }

    }
}
