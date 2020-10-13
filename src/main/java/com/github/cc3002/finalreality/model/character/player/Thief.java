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

    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 @NotNull int hp,
                 @NotNull int defense) {
        super(name, turnsQueue, hp, defense);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHP(), getDefense());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Thief)) {
            return false;
        }
        final Thief that = (Thief) o;
        return getName() == that.getName() &&
                getHP() == that.getHP() &&
                getDefense() == that.getDefense();
    }
}
