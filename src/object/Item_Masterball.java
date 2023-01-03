package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Item_Masterball extends SuperItems {
    GamePanel gp;

    public Item_Masterball(GamePanel gp){
        name = "Masterball";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/Masterball_00.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
