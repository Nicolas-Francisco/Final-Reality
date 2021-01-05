package com.github.cc3002.finalreality.model.controller.state;

import com.github.cc3002.finalreality.model.character.ICharacter;
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

    /**
     * starts the turn of a player, from Selection state to Turn state.
     */
    @Override
    public void beginTurn(){
        this.changeState(new TurnState(this.controller));
    }

    /**
     * terminate() method terminates the turn completely if the game has not ended.
     */
    @Override
    public void terminate(ICharacter attackedCharacter){
        this.controller.terminateTurn(attackedCharacter);
    }

    /**
     * starts the waiting stage. From Start, Turn or Selection states to Waiting state.
     */
    @Override
    public void waiting(){
        this.changeState(new WaitingState(this.controller));
    }

    /**
     * isSelectionState() returns true if the game is in SelectionState
     */
    @Override
    public boolean isSelectionState(){
        return true;
    }
}