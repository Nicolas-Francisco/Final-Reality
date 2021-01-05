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

    /**
     * changeState() changes the state of the game in the controller.
     */
    protected void changeState(GameState state) {
        controller.setState(state);
    }

    /**
     * starts the waiting stage. From Start, Turn or Selection states to Waiting state.
     */
    public void waiting(){
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
     * terminate() method terminates the turn completely if the game has not ended.
     */
    public void terminate(ICharacter attackedCharacter){
        this.error();
    }

    /**
     * tryToBeginTurn() method begins the turn if the game is in waiting state.
     */
    public void tryToBeginTurn(){
        this.error();
    }

    /**
     * tryToStart() method starts the game if the game is in start state.
     */
    public void tryToStart(){
        this.error();
    }

    /**
     * isStartState() returns true if the game is in startState
     */
    public boolean isStartState(){
        return false;
    }

    /**
     * isWaitingState() returns true if the game is in waitingState
     */
    public boolean isWaitingState(){
        return false;
    }

    /**
     * isSelectionState() returns true if the game is in SelectionState
     */
    public boolean isSelectionState(){
        return false;
    }

    /**
     * isTurnState() returns true if the game is in TurnState
     */
    public boolean isTurnState(){
        return false;
    }

    /**
     * isVictoryState() returns true if the game is in victoryState
     */
    public boolean isVictoryState(){
        return false;
    }

    /**
     * isGameOverState() returns true if the game is in gameOverState
     */
    public boolean isGameOverState(){
        return false;
    }
}