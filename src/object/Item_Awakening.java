package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Item_Awakening extends SuperItems {
    GamePanel gp;
    public Item_Awakening(GamePanel gp){
        name = "Awakening Potion";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/Awakening_00.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
