import java.awt.*;
import java.util.ArrayList;

public class Images {

    public Image background, text, draw, win, lose, count, player, enemy, paperImg, playAgainImg, rockImg, scissorsImg;
    public ArrayList<Image> imgAry = new ArrayList<>();
    public ArrayList<Image> textAry = new ArrayList<>();
    public ArrayList<Image> numAry = new ArrayList<>();

    public int IMG_WIDTH = 250;
    public int IMG_HEIGHT = 250;
    public int TEXT_WIDTH = 366;
    public int TEXT_HEIGHT = 80;

    public Images(){

        background = Toolkit.getDefaultToolkit().getImage("src/res/bg.jpg");
        text = Toolkit.getDefaultToolkit().getImage("src/res/text.png");
        count = Toolkit.getDefaultToolkit().getImage("src/res/count.gif");
        draw = Toolkit.getDefaultToolkit().getImage("src/res/draw.png");
        win = Toolkit.getDefaultToolkit().getImage("src/res/win.png");
        lose = Toolkit.getDefaultToolkit().getImage("src/res/lose.png");
        player = Toolkit.getDefaultToolkit().getImage("src/res/player.png");
        enemy = Toolkit.getDefaultToolkit().getImage("src/res/enemy.png");
        playAgainImg = Toolkit.getDefaultToolkit().getImage("src/res/playAgain.png");
        paperImg = Toolkit.getDefaultToolkit().getImage("src/res/paper.png");
        rockImg = Toolkit.getDefaultToolkit().getImage("src/res/rock.png");
        scissorsImg = Toolkit.getDefaultToolkit().getImage("src/res/scissors.png");
        Image n0 = Toolkit.getDefaultToolkit().getImage("src/res/0.png");
        Image n1 = Toolkit.getDefaultToolkit().getImage("src/res/1.png");
        Image n2 = Toolkit.getDefaultToolkit().getImage("src/res/2.png");
        Image n3 = Toolkit.getDefaultToolkit().getImage("src/res/3.png");
        Image n4 = Toolkit.getDefaultToolkit().getImage("src/res/4.png");
        Image n5 = Toolkit.getDefaultToolkit().getImage("src/res/5.png");
        Image n6 = Toolkit.getDefaultToolkit().getImage("src/res/6.png");
        Image n7 = Toolkit.getDefaultToolkit().getImage("src/res/7.png");
        Image n8 = Toolkit.getDefaultToolkit().getImage("src/res/8.png");
        Image n9 = Toolkit.getDefaultToolkit().getImage("src/res/9.png");
        imgAry.add(paperImg);
        imgAry.add(rockImg);
        imgAry.add(scissorsImg);
        textAry.add(draw);
        textAry.add(win);
        textAry.add(lose);
        numAry.add(n0);
        numAry.add(n1);
        numAry.add(n2);
        numAry.add(n3);
        numAry.add(n4);
        numAry.add(n5);
        numAry.add(n6);
        numAry.add(n7);
        numAry.add(n8);
        numAry.add(n9);

    }
}
