package com.github.cc3002.finalreality.model.controller.state;

import com.github.cc3002.finalreality.model.controller.GameController;

/**
 * The StartState class for the game.
 *
 * @author Nicolás García Ríos
 */
public class StartState extends GameState{

    public StartState(GameController controller) {
        super(controller);
    }

    /**
     * starts the waiting stage. From Start, Turn or Selection states to Waiting state.
     */
    @Override
    public void waiting() {
        this.changeState(new WaitingState(this.controller));
    }

    /**
     * tryToStart() method starts the game if the game is in start state.
     */
    @Override
    public void tryToStart(){
        this.controller.startQueue();
    }

    /**
     * tryToEquip() method tries to equip a weapon to the player. Assuming the player can only change
     * the equipped weapon in a turn, and not between two.
     */
    @Override
    public void equip(int playerIndex, String weaponName){
        this.controller.equip(playerIndex, weaponName);
    }

    /**
     * isStartState() returns true if the game is in startState
     */
    @Override
    public boolean isStartState(){
        return true;
    }
}
