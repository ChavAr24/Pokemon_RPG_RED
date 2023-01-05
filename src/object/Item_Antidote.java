package object;

import entity.Entity;
import main.GamePanel;

public class Item_Antidote extends Entity {

    public Item_Antidote(GamePanel gp){
        super(gp);

        name = "Antidote";
        down1 = setUp("/items/Antidote_00");
    }
}
