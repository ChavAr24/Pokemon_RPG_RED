package main;

import entity.Bulbasaur;
import entity.Charizard;
import entity.NPC_OldMan;
import entity.NPC_npc00;
import object.Item_Pokeball;
import object.Item_Potion;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new Item_Pokeball(gp);
        gp.obj[0].worldX = gp.tileSize * 26;
        gp.obj[0].worldY = gp.tileSize * 36;

        gp.obj[1] = new Item_Potion(gp);
        gp.obj[1].worldX = gp.tileSize * 20;
        gp.obj[1].worldY = gp.tileSize * 7;
    }

    public void setNPC(){

        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;

        gp.npc[1] = new NPC_npc00(gp);
        gp.npc[1].worldX = gp.tileSize * 9;
        gp.npc[1].worldY = gp.tileSize * 8;
    }

    public void setWildPokemon(){
        gp.pokemons[0] = new Bulbasaur(gp);
        gp.pokemons[0].worldX = gp.tileSize * 20;
        gp.pokemons[0].worldY = gp.tileSize * 38;

        gp.pokemons[1] = new Charizard(gp);
        gp.pokemons[1].worldX = gp.tileSize * 24;
        gp.pokemons[1].worldY = gp.tileSize * 38;

    }
}
