package main;

import java.awt.*;

public class UI {
    GamePanel gp;
    Font arial_20;
    public  boolean messageOn = false;
    public  String message ="";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public boolean fishWin = false;
<<<<<<< Updated upstream
    public boolean boatWin = false;
    public boolean tie = false;
=======
    public  boolean boatWin = false;
    public boolean tie = false;
    public int commandNum = 0;
>>>>>>> Stashed changes

    public  UI(GamePanel gp){
        this.gp = gp;

        arial_20 = new Font("Arial", Font.PLAIN, 20);
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){

        if (gameFinished == true){

            g2.setFont(arial_20);
            g2.setColor(Color.white);
            String text = "Game end!";
            int textLength;

            if (boatWin)
                text = "The Boatmen caught enough Fishes!!!";
            else if (fishWin) {
                text = "The Fishes escaped to the sea!!!";
            }
            else if (tie){
                text = "The game is tie ._.";
            }

            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            int x, y;
            x = gp.WIDTH/2 - textLength/2;
            y = gp.HEIGHT / 2 - (gp.tileHeight * 2);
            g2.drawString(text, 400, 200);

            gp.gameThread = null;
        }
<<<<<<< Updated upstream
        else {
            g2.setFont(arial_20);
            g2.setColor(Color.white);
            g2.drawString("Fishes remaining = " + gp.entityH.fishes.fishRemaining, 50, 400);
=======
        // PAUSE STATE
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }

        if (gameFinished == true){
            String text = "Game end!";

            if (boatWin)
                text = "The Boatmen caught enough Fishes!!!";
            else if (fishWin) {
                text = "The Fishes escaped to the sea!!!";
            }
            else if (tie){
                text = "The game is tie ._.";
            }

            int x = getXforCenteredText(text);
            g2.drawString(text, x, 200);

            //gp.gameState = gp.titleState;

        }
        else {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawString("Fishes remaining = " + gp.entityH.fishes.fishRemaining, 50, 400);

            if (messageOn == true) {
                g2.drawString(message, 750, 400);

                messageCounter++;

                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }

    public void drawTitleScreen() {
        g2.drawImage(menuImage,0,0,gp.WIDTH,gp.HEIGHT,null);
>>>>>>> Stashed changes

            if (messageOn == true) {
                g2.drawString(message, 750, 400);

                messageCounter++;

                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }

}
