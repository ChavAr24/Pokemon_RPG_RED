package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Item_Antidote extends SuperItems {

    GamePanel gp;
    public Item_Antidote(GamePanel gp){
        name = "Antidote";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/Antidote_00.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
