package object;

import entity.Entity;
import main.GamePanel;

public class Item_Awakening extends Entity {
    public Item_Awakening(GamePanel gp){
        super(gp);

        name = "Awakening Potion";
        down1 = setUp("/items/Awakening_00");
    }
}
