package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UI;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler KeyH;

    public final int screenX;
    public final int screenY;

    public int hasPotion = 0;
    public int hasSuperPotion = 0;
    public int hasPokeball = 0;
    public int hasMasterball = 0;



    public Player(GamePanel gp, KeyHandler KeyH){
        this.gp = gp;
        this.KeyH = KeyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize*23;
        worldY = gp.tileSize*21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        up1 = setUp("boy_up_1");
        up2 = setUp("boy_up_2");
        down1 = setUp("boy_down_1");
        down2 = setUp("boy_down_2");
        left1 = setUp("boy_left_1");
        left2 = setUp("boy_left_2");
        right1 = setUp("boy_right_1");
        right2 = setUp("boy_right_2");
    }

    public BufferedImage setUp(String imageName){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
            image = uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }

        return image;
    }

    public void update(){

        if (KeyH.upPressed || KeyH.downPressed || KeyH.leftPressed || KeyH.rightPressed) {

            if (KeyH.upPressed) {
                direction = "up";
            } else if (KeyH.downPressed) {
                direction = "down";
            } else if (KeyH.leftPressed) {
                direction = "left";
            } else if (KeyH.rightPressed) {
                direction = "right";
            }

//            CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

//            CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

//            IF COLLISION IS FALSE, PLAYER CAN'T MOVE
            if (!collisionOn){
                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) spriteNum = 2;
                else if (spriteNum == 2) spriteNum = 1;
                spriteCounter = 0;
            }
        }

    }

    public void pickUpObject(int i){
        if (i != 999){
            String objectName = gp.obj[i].name;

            switch (objectName){
                case "Potion":
                    gp.playSE(1);
                    hasPotion++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Potion added to bag.");
                    break;
                case "Superpotion":
                    gp.playSE(1);
                    hasSuperPotion++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Super Potion added to bag.");
                    break;
                case "Pokeball":
                    gp.playSE(1);
                    hasPokeball++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Pokeball added to bag.");
                    break;
                case "Masterball":
                    gp.playSE(1);
                    hasMasterball++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Masterball added to bag.");
                    UI.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(4);
                    break;
            }
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.WHITE);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) image = up1;
                if (spriteNum == 2) image = up2;
            }
            case "down" -> {
                if (spriteNum == 1) image = down1;
                if (spriteNum == 2) image = down2;
            }
            case "left" -> {
                if (spriteNum == 1) image = left1;
                if (spriteNum == 2) image = left2;
            }
            case "right" -> {
                if (spriteNum == 1) image = right1;
                if (spriteNum == 2) image = right2;
            }
        }
        g2.drawImage(image, screenX, screenY, null);
    }
}
