package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a thief class.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */

public class Thief extends AbstractPlayerCharacter {

    public Thief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEquippedWeapon());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractPlayerCharacter)) {
            return false;
        }
        final AbstractPlayerCharacter that = (AbstractPlayerCharacter) o;
        return getName().equals(that.getName());
    }
}
