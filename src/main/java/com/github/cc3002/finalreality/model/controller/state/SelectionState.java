package com.github.cc3002.finalreality.model.controller.state;

import com.github.cc3002.finalreality.model.controller.GameController;

/**
 * The WaitingState class for the game.
 *
 * @author Nicolás García Ríos
 */
public class SelectionState extends GameState{

    public SelectionState(GameController controller) {
        super(controller);
    }

    @Override
    public void beginTurn(){
        this.changeState(new TurnState(this.controller));
    }

    @Override
    public void endTurn(){
        this.changeState(new WaitingState(this.controller));
    }

    @Override
    public boolean isSelectionState(){
        return true;
    }
}