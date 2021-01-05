package com.github.cc3002.finalreality.model.controller.state;

import com.github.cc3002.finalreality.model.controller.GameController;

/**
 * The WaitingState class for the game.
 *
 * @author Nicolás García Ríos
 */
public class WaitingState extends GameState{

    public WaitingState(GameController controller) {
        super(controller);
    }

    /**
     * starts searching the next turn, from Waiting state to Selection state.
     */
    @Override
    public void nextTurn(){
        this.changeState(new SelectionState(this.controller));
    }

    /**
     * tryToBeginTurn() method begins the turn if the game is in waiting state.
     */
    @Override
    public void tryToBeginTurn(){
        this.nextTurn();
        this.controller.beginTurn();
    }

    /**
     * isWaitingState() returns true if the game is in waitingState
     */
    @Override
    public boolean isWaitingState(){
        return true;
    }
}