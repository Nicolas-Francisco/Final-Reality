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

    @Override
    public void nextTurn(){
        this.changeState(new SelectionState(this.controller));
    }

    @Override
    public void tryToBeginTurn(){
        this.controller.beginTurn();
    }

    @Override
    public boolean isWaitingState(){
        return true;
    }
}