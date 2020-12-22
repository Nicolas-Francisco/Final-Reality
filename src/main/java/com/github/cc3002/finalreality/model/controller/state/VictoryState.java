package com.github.cc3002.finalreality.model.controller.state;

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

    @Override
    public boolean isVictoryState(){
        return true;
    }
}