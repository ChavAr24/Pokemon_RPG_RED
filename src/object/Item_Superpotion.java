package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Item_Superpotion extends SuperItems {
    GamePanel gp;
    public Item_Superpotion(GamePanel gp){
        name = "Superpotion";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/Superpotion_00.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
