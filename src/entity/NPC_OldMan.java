package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_OldMan extends Entity{

    public NPC_OldMan(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage(){
        up1 = setUp("/npc/oldman_up_1");
        up2 = setUp("/npc/oldman_up_2");
        down1 = setUp("/npc/oldman_down_1");
        down2 = setUp("/npc/oldman_down_2");
        left1 = setUp("/npc/oldman_left_1");
        left2 = setUp("/npc/oldman_left_2");
        right1 = setUp("/npc/oldman_right_1");
        right2 = setUp("/npc/oldman_right_2");
    }

    public void setDialogue(){
        dialogues[0] = "Hello, lad.";
        dialogues[1] = "Welcome to pallet town!";
        dialogues[2] = "Do you have your first pokemon?";
        dialogues[3] = "No! Then you should go meet Prof.Oak.";
    }

    public void setAction(){

        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1; // Picks number between 1 and 100

            if (i <= 25) direction = "up";
            if (25 < i && i <= 50) direction = "down";
            if (50 < i && i <= 75) direction = "left";
            if (75 < i) direction = "right";

            actionLockCounter = 0;
        }

    }

    public void speak(){
        if (dialogues[dialogueIndex] == null || dialogueIndex >= 4){ // change the 4 to the next number after the number of dialogues of the NPC
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction) {
            case "up" -> direction = "down";
            case "down" -> direction = "up";
            case "left" -> direction = "right";
            case "right" -> direction = "left";
        }
    }

}
