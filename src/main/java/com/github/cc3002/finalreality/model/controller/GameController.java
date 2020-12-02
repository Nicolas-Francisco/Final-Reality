package com.github.cc3002.finalreality.model.controller;
import com.github.cc3002.finalreality.model.Inventory;
import com.github.cc3002.finalreality.model.character.ICharacter;

/**
 * The "final reality" game controller.
 *
 * @author Nicolás García Ríos
 */
public class GameController {
    private Inventory inventory;

    public GameController(){
        this.inventory = new Inventory();

    }

    public void onDeadCharacter(ICharacter character) {
        System.out.println(character.getName() + " has died");
    }
}
