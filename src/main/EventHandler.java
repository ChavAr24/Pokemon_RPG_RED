package main;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    EventRect eventRect[][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    public EventHandler(GamePanel gp){
        this.gp = gp;
        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        int col = 0;
        int row = 0;
        while (col < gp.maxWorldCol && row < gp.maxWorldRow){
            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if (col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }

    }

    // r = 18
    // c = 27
    public void checkEvent(){
        //ADD 1 Extra tile number to x and y for accurate positioning

        //Check if the player character is more than 1 tile away from the last event.
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gp.tileSize){
            canTouchEvent = true;
        }

        if (canTouchEvent = true) {
            // teleport tile 1
            if (hit(16, 26, "right")) teleportTileEvent(16, 26, gp.dialogueState, 1);
            // teleport tile 2
            if (hit(34, 12, "any")) teleportTileEvent(34, 12, gp.dialogueState, 2);
            //teleport tile 3
            if (hit(33, 37, "any")) teleportTileEvent(33, 37, gp.dialogueState, 3);
        }
    }

    public boolean hit(int col, int row, String reqDirection){

        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;

        if (gp.player.solidArea.intersects(eventRect[col][row]) && !eventRect[col][row].eventDone){
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;

                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;

            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;


        return hit;
    }

    public void teleportTileEvent(int col, int row , int gameState, int teleportTilNum){
        //SUBTRACT 1 Extra tile number to x and y for accurate positioning

        boolean done = false;

        int xVal = 0, yVal = 0;
        gp.gameState = gameState;
        gp.ui.currentDialogue = "Teleport!!!";
        if (teleportTilNum == 1){
            xVal = 37;
            yVal = 10;
            done = false;
        }else if (teleportTilNum == 2){
            xVal = 35;
            yVal = 40;
            done = false;
        }else if (teleportTilNum == 3){
            xVal = 19;
            yVal = 41;
            done = true;
        }

        gp.player.worldX = gp.tileSize * xVal;
        gp.player.worldY = gp.tileSize * yVal;
        gp.ui.currentDialogue = "You teleported to teleport tile " + teleportTilNum + " \nin Pallet Town!!!";
        eventRect[col][row].eventDone = done;
        canTouchEvent = false;
    }
}
