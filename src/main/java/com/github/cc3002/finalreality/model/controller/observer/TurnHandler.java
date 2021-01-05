package com.github.cc3002.finalreality.model.controller.observer;

import com.github.cc3002.finalreality.model.controller.GameController;
import java.beans.PropertyChangeEvent;

/**
 * The event handler class for the Turns queue, which implements the IEventHandler interface
 *
 * @author Nicolás García Ríos
 */
public class TurnHandler implements IEventHandler {
    private final GameController controller;

    public TurnHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.tryToBeginTurn();
    }
}