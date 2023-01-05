package object;

import entity.Entity;
import main.GamePanel;

public class Item_Pokeball extends Entity {

    public Item_Pokeball(GamePanel gp){
        super(gp);

        name = "Pokeball";
        down1 = setUp("/items/Pokeball_01");
//        collision = true;
    }
}
