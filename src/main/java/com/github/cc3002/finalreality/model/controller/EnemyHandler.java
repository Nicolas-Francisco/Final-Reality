package com.github.cc3002.finalreality.model.controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import java.beans.PropertyChangeEvent;

/**
 * The event handler class for the enemies, which implements the IEventHandler interface
 *
 * @author Nicolás García Ríos
 */
public class EnemyHandler implements IEventHandler{
    private final GameController controller;

    public EnemyHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.onDeadEnemy((Enemy) evt.getNewValue());
    }
}