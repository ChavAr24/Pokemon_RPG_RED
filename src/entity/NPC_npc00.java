package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_npc00 extends Entity{

    public NPC_npc00(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 1;
        name = "npc00";

        getImage();
        setDialogue();
    }

    public void getImage(){
        up1 = setUp("/npc/NPC_00_Back_00");
        up2 = setUp("/npc/NPC_00_Back_01");
        down1 = setUp("/npc/NPC_00_Front_00");
        down2 = setUp("/npc/NPC_00_Front_01");
        left1 = setUp("/npc/NPC_00_Back_00");
        left2 = setUp("/npc/NPC_00_Back_01");
        right1 = setUp("/npc/NPC_00_Front_00");
        right2 = setUp("/npc/NPC_00_Front_01");
    }

    public void setDialogue(){
        dialogues[4] = "Did you catch a pokemon yet?";
        dialogues[5] = "I heard there's a new kid in town.";
        dialogues[6] = "Wait!!! Is that you?";
//        dialogues[7] = "No!\nThen you should go meet Prof.Oak.";
    }

    public void setAction(){

        actionLockCounter++;
//
//        if (actionLockCounter == 120) {
//            Random random = new Random();
//            int i = random.nextInt(100) + 1; // Picks number between 1 and 100
//
//            if (i <= 25) direction = "up";
//            if (25 < i && i <= 50) direction = "down";
//            if (50 < i && i <= 75) direction = "left";
//            if (75 < i) direction = "right";
//
//            actionLockCounter = 0;
//        }

    }

    public void speak(){
        //Do the characters specific stuff.
        // Check if it has pokemon then speak 0 - 3 else speak _ - _

        super.speak();
    }

}

