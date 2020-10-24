package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Bow;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a engineer class.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */

public class Engineer extends AbstractPlayerCharacter {

    /**
     * Creates a new player.
     *
     * @param name
     *     the player's name
     * @param turnsQueue
     *     the queue with the player waiting for their turn
     * @param hp
     *     the player's health points
     * @param defense
     *     the character's defense
     */
    public Engineer(@NotNull String name,
                    @NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull int hp,
                    @NotNull int defense) {
        super(name, turnsQueue, hp, defense);
    }

    /**
     * equips a axe to the engineer.
     * A engineer class can only equip an axe or a bow. Hence, we create equipAxe, and
     * equipBow to make sure the engineer can only equip this types of weapons.
     */
    public void equipAxe(Axe axe){
        if (this.IsAlive()){
            this.setEquippedWeapon(axe);
        }
    }

    /**
     * equips a bow to the engineer.
     * A engineer class can only equip an axe or a bow. Hence, we create equipAxe, and
     * equipBow to make sure the engineer can only equip this types of weapons.
     */
    public void equipBow(Bow bow){
        if (this.IsAlive()){
            this.setEquippedWeapon(bow);
        }
    }

    /**
     * both methods equals() and hashcode() are different depending of the type of character and
     * the type of Character, hence this methods cannot be used with inheritance
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHP(), getDefense());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engineer)) {
            return false;
        }
        final Engineer that = (Engineer) o;
        return getName() == that.getName() &&
                getHP() == that.getHP() &&
                getDefense() == that.getDefense();
    }
}
