package entity;

import main.GamePanel;

import java.util.Random;

public class WildPokemon extends Entity{
    public WildPokemon(GamePanel gp){
        super(gp);

        direction = "down";
//        speed = 3;
        name = "Wild Pokemon";


        // do this only after the player collides with an invisible rectangle that is set to move in certain range x and certain range y depending on the map.
        //DISPLAYING RANDOM POKEMON AFTER HITTING THE RECTANGLE.
        int PokemonNumber = getPokemonNum();
        getImage(PokemonNumber);


        setDialogue();
    }

    public void getImage(int pokemonNum){
        switch (pokemonNum){
            case 1:
                up1 = setUp("/pokemons/Bulbasaur_00");
                up2 = setUp("/pokemons/Bulbasaur_00");
                down1 = setUp("/pokemons/Bulbasaur_00");
                down2 = setUp("/pokemons/Bulbasaur_00");
                left1 = setUp("/pokemons/Bulbasaur_00");
                left2 = setUp("/pokemons/Bulbasaur_00");
                right1 = setUp("/pokemons/Bulbasaur_00");
                right2 = setUp("/pokemons/Bulbasaur_00");
                break;
            case 2:
                up1 = setUp("/pokemons/Charmaleon_00");
                up2 = setUp("/pokemons/Charmaleon_00");
                down1 = setUp("/pokemons/Charmaleon_00");
                down2 = setUp("/pokemons/Charmaleon_00");
                left1 = setUp("/pokemons/Charmaleon_00");
                left2 = setUp("/pokemons/Charmaleon_00");
                right1 = setUp("/pokemons/Charmaleon_00");
                right2 = setUp("/pokemons/Charmaleon_00");
                break;
            case 3:
                up1 = setUp("/pokemons/Charizard_00");
                up2 = setUp("/pokemons/Charizard_00");
                down1 = setUp("/pokemons/Charizard_00");
                down2 = setUp("/pokemons/Charizard_00");
                left1 = setUp("/pokemons/Charizard_00");
                left2 = setUp("/pokemons/Charizard_00");
                right1 = setUp("/pokemons/Charizard_00");
                right2 = setUp("/pokemons/Charizard_00");
                break;

        }

    }

    public int getPokemonNum(){
        Random rd = new Random();
        return rd.nextInt(100)+1;
    }

    public void setDialogue(){
//        dialogues[4] = "Did you catch a pokemon yet?";
//        dialogues[5] = "I heard there's a new kid in town.";
//        dialogues[6] = "Wait!!! Is that you?";
//        dialogues[7] = "No!\nThen you should go meet Prof.Oak.";
    }

    public void setAction(){

        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1; // Picks number between 1 and 100

            if (i <= 25) direction = "up";
            if (25 < i && i <= 50) direction = "down";
            if (50 < i && i <= 75) direction = "left";
            if (75 < i) direction = "right";

            actionLockCounter = 0;
        }

    }

    public void speak(){
        //Do the characters specific stuff.
        // Check if it has pokemon then speak 0 - 3 else speak _ - _

//        super.speak();
    }
}
