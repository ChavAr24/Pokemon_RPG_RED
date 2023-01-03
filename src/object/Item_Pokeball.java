package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Item_Pokeball extends SuperItems {

    GamePanel gp;
    public Item_Pokeball(GamePanel gp){
        name = "Pokeball";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/Pokeball_01.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
