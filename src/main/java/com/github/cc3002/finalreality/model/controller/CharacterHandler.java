package com.github.cc3002.finalreality.model.controller;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;

/**
 * The event handler class. which implements the IEventHandler interface
 *
 * @author Nicolás García Ríos
 */
public class CharacterHandler implements IEventHandler{
    private final GameController controller;

    public CharacterHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.onDeadCharacter((ICharacter) evt.getNewValue());
    }
}