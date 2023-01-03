package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Item_Potion extends SuperItems {
    GamePanel gp;
    public Item_Potion(GamePanel gp){
        name = "Potion";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/Potion_00.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
