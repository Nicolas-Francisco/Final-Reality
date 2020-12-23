package com.github.cc3002.finalreality.model.controller.state;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.controller.GameController;

/**
 * The state class for the game.
 *
 * @author Nicolás García Ríos
 */
public class GameState {
    protected GameController controller;

    public GameState(GameController controller){
        this.controller = controller;
    }

    protected void changeState(GameState state) {
        controller.setState(state);
    }

    /**
     * starts the game, from Start state to Waiting state.
     */
    public void startGame(){
        this.error();
    }

    /**
     * starts searching the next turn, from Waiting state to Selection state.
     */
    public void nextTurn(){
        this.error();
    }

    /**
     * starts the turn of a player, from Selection state to Turn state.
     */
    public void beginTurn(){
        this.error();
    }

    /**
     * ends the turn of a player, from Turn state to Waiting state.
     */
    public void endTurn(){
        this.error();
    }

    /**
     * ends the game, from Waiting state to Victory state.
     */
    public void victory(){
        this.error();
    }

    /**
     * ends the game, from Waiting state to GameOver state.
     */
    public void gameOver(){
        this.error();
    }

    /**
     * error method
     */
    void error() {
        throw new AssertionError("Wrong State");
    }

    /**
     * tryToEquip() method tries to equip a weapon to the player. Assuming the player can only change
     * the equipped weapon in a turn, and not between two.
     */
    public void equip(int playerIndex, String weaponName){
        this.error();
    }

    /**
     * tryToAttack() method tries to attack a character. Assuming that some character can attack to another
     * during a turn only, and not between two.
     */
    public void attack(ICharacter attackerCharacter, ICharacter attackedCharacter){
        this.error();
    }

    /**
     * tryToBeginTurn()
     */
    public void tryToBeginTurn(){
        this.error();
    }

    /**
     * assertion methods
     */
    public boolean isStartState(){
        return false;
    }

    public boolean isWaitingState(){
        return false;
    }

    public boolean isSelectionState(){
        return false;
    }

    public boolean isTurnState(){
        return false;
    }

    public boolean isVictoryState(){
        return false;
    }

    public boolean isGameOverState(){
        return false;
    }
}