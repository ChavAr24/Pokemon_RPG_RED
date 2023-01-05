package object;

import entity.Entity;
import main.GamePanel;

public class Item_Potion extends Entity {

    public Item_Potion(GamePanel gp){
        super(gp);

        name = "Potion";
        down1 = setUp("/items/Potion_00");
//        collision = true;
    }
}
