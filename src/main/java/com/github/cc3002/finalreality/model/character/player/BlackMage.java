package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a black mage class.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */

public class BlackMage extends AbstractPlayerCharacter {

    private int MP;

    public BlackMage(@NotNull String name,
                     @NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull int hp,
                     @NotNull int defense,
                     @NotNull int mana) {
        super(name, turnsQueue, hp, defense);
        this.MP = mana;
    }

    public int getMP(){
        return MP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHP(), getDefense(), getMP());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BlackMage)) {
            return false;
        }
        final BlackMage that = (BlackMage) o;
        return getName() == that.getName() &&
                getHP() == that.getHP() &&
                getDefense() == that.getDefense() &&
                getMP() == that.getMP();
    }
}
