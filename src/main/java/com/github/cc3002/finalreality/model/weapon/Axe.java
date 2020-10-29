package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;

import java.util.Objects;

/**
 * A class that holds all the information of an axe.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public class Axe extends AbstractWeapon{

    /**
     * Creates a new Axe of the game.
     *
     * @param name
     *     the Axe's name
     * @param damage
     *     the Axe's damage
     * @param weight
     *     the Axe's weight
     */
    public Axe(final String name, final int damage, final int weight) {
        super (name, damage, weight);
    }

    /**
     * equips an Axe using Double Dispatch
     */
    public void equipToKnight(Knight knight){
        knight.setEquippedWeapon(this);
    }

    public void equipToEngineer(Engineer engineer){
        engineer.setEquippedWeapon(this);
    }

    /**
     * both methods equals() and hashcode() are different depending of the type of weapon
     * hence this methods cannot be used with inheritance
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Axe)) {
            return false;
        }
        final IWeapon weapon = (IWeapon) o;
        return getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight());
    }
}
