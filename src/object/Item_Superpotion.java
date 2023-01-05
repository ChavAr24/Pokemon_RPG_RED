package object;

import entity.Entity;
import main.GamePanel;

public class Item_Superpotion extends Entity {
    public Item_Superpotion(GamePanel gp){
        super(gp);

        name = "Superpotion";
        down1 = setUp("/items/Superpotion_00");
    }
}
