package com.github.cc3002.finalreality.model.controller.state;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.controller.GameController;

/**
 * The WaitingState class for the game.
 *
 * @author Nicolás García Ríos
 */
public class VictoryState extends GameState{

    public VictoryState(GameController controller) {
        super(controller);
    }

    /**
     * terminate() method terminates the turn completely if the game has not ended.
     */
    @Override
    public void terminate(ICharacter attackedCharacter){ }

    /**
     * isVictoryState() returns true if the game is in victoryState
     */
    @Override
    public boolean isVictoryState(){
        return true;
    }
}