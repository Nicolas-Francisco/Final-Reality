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

    @Override
    public void startGame(){
        this.changeState(new WaitingState(this.controller));
    }

    @Override
    public boolean isStartState(){
        return true;
    }
}
