package com.github.cc3002.finalreality.model.controller.observer;

import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.controller.GameController;

import java.beans.PropertyChangeEvent;

/**
 * The event handler class for the players, which implements the IEventHandler interface
 *
 * @author Nicolás García Ríos
 */
public class PlayerHandler implements IEventHandler {
    private final GameController controller;

    public PlayerHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.onDeadPlayer((IPlayer) evt.getNewValue());
    }
}