package main;

import object.Item_Masterball;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    static GamePanel gp;
    static Font arial_40, arial_80B;
    static BufferedImage mbImage;
    public static boolean messageOn = false;
    public static String message = "";
    static int messageCounter = 0;
    public static boolean gameFinished = false;

    static double playTime;
    static DecimalFormat dFormat = new DecimalFormat("#0.00");
    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        Item_Masterball mb = new Item_Masterball(gp);
        mbImage = mb.image;
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public static void draw(Graphics2D g2){

//        if (gameFinished == true){
//
//            g2.setFont(arial_40);
//            g2.setColor(Color.WHITE);
//
//            String text;
//            int textLength;
//            int x;
//            int y;
//
//            text = "You found the treasure!";
//            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//
//            x = gp.screenWidth/2 - textLength/2;
//            y = gp.screenHeight/2 - gp.tileSize*3;
//            g2.drawString(text, x, y);
//
//

//            if (playTime < 37.00) { // CHANGE THIS TO CHECK IF THE PLAYER REACHES THE POKEMONMASTERCUP. SO WHEN THE PLAYER TOUCHES THE CUP THE GAME ENDS.
//                text = "Your Time is " + dFormat.format(playTime) + "!";
//                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//
//                x = gp.screenWidth / 2 - textLength / 2;
//                y = gp.screenHeight / 2 + gp.tileSize * 4;
//                g2.drawString(text, x, y);
//
//                gp.gameThread = null;
//                g2.setFont(arial_80B);
//                g2.setColor(Color.YELLOW);
//                text = "Congratulations";
//                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//
//                x = gp.screenWidth / 2 - textLength / 2;
//                y = gp.screenHeight / 2 + gp.tileSize * 2;
//                g2.drawString(text, x, y);
//
//                gp.gameThread = null;
//            }
//            else {
//                g2.setColor(Color.YELLOW);
//                text = "Your Time is " + dFormat.format(playTime) + "!";
//                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//
//                x = gp.screenWidth / 2 - textLength / 2;
//                y = gp.screenHeight / 2 + gp.tileSize * 4;
//                g2.drawString(text, x, y);
//
//
//                text = "You Lose! Better luck next time!";
//                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//
//                x = gp.screenWidth / 2 - textLength / 2;
//                y = gp.screenHeight / 2 + gp.tileSize * 2;
//                g2.drawString(text, x, y);
//
//                gp.gameThread = null;
//
//            }
//
//        }


        //TIME
        playTime += (double)1/60;
        g2.drawString("Time: "+ dFormat.format(playTime), gp.tileSize*11, 65);

        // MESSAGE
        if (messageOn) {
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
            messageCounter++;
            if (messageCounter > 120) {
                messageCounter = 0;
                messageOn = false;
            }
        }
    }
}
