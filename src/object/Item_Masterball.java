package object;

import entity.Entity;
import main.GamePanel;

public class Item_Masterball extends Entity {

    public Item_Masterball(GamePanel gp){
        super(gp);

        name = "Masterball";
        down1 = setUp("/items/Masterball_00");
    }
}
