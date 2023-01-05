package main;


import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    static GamePanel gp;
    Graphics2D g2;

    Font arial, calibri, terminal, timesNewRoman, pkmnFont; // timesNewRoman is time.ttf
    public static boolean messageOn = false;
    public static String message = "";
    public String currentDialogue = "";
    public int commandNum = 0;

    public UI(GamePanel gp){
        UI.gp = gp;

        try {
            InputStream is = getClass().getResourceAsStream("/font/arial.ttf");
            arial = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/font/calibri.ttf");
            calibri = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/font/terminal.ttf");
            terminal = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/font/times.ttf");
            timesNewRoman = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/font/pokemon_fire_red.ttf");
            pkmnFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        this.g2 = g2;

        g2.setFont(arial);
        g2.setColor(Color.white);

        //TITLESTATE
        if (gp.gameState == gp.titleState){
            drawTitleScreen();
        }

        //PLAYESTATE
        if (gp.gameState == gp.playState){
            //DO PLAYSTATE STUFF
        }
        //PAUSESTATE
        if (gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //DIALOGUESTATE
        if (gp.gameState == gp.dialogueState){
            drawDialogueScreen();
        }
    }

    public void drawTitleScreen(){
        // USE A PICTURE FOR THE BACKGROUND
        //THE PICTURE SHOULD HAVE THE TITLE AND A COUPLE OTHER THINGS.

//        SCREEN BACKGROUND
            g2.setColor(new Color(70, 120, 80));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, gp.screenWidth, gp.tileSize * 4);
            g2.fillRect(0, gp.tileSize * 8, gp.screenWidth, gp.tileSize * 4);
            g2.setColor(new Color(255, 69, 0));
            g2.fillRect(0, 0, gp.screenWidth, gp.tileSize);
            g2.setColor(new Color(128, 0, 0));
            g2.fillRect(0, gp.tileSize * 11, gp.screenWidth, gp.tileSize);

            //TITLE NAME
            g2.setFont(pkmnFont);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 120F));
            String text = "Pokémon";
            int x = getXForCenteredText(text);
            int y = gp.tileSize * 3;

            //SHADOW
            g2.setColor(Color.BLACK);
            g2.drawString(text, x + 3, y + 3);
            //MAIN COLOR
            g2.setColor(Color.YELLOW);
            g2.drawString(text, x, y);
            text = "Dark Red Version";
            x = getXForCenteredText(text) + gp.tileSize * 3;
            y = gp.tileSize * 4;
            g2.setColor(new Color(135, 13, 19));
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 60F));
            g2.drawString(text, x, y);


            // PLAYER IMAGE
            x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
            y += gp.tileSize;
            g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

            //MENU
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 46F));

            text = "NEW GAME";
            x = getXForCenteredText(text);
            y += gp.tileSize * 4;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "LOAD GAME";
            x = getXForCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "QUIT GAME";
            x = getXForCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }

    }

    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED";
        int x = getXForCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen(){

        //DIALOGUE WINDOW
        int x = gp.tileSize;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 2);
        int height = gp.tileSize * 4;

        drawSubWindow(x, y, width, height);

        g2.setFont(terminal);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 22F));
        x += gp.tileSize;
        y += gp.tileSize;

        for (String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){

        Color c = new Color(0,0,0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);


    }
    public int getXForCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth/2 - length/2;
    }

}