package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a staff.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public class Staff extends AbstractWeapon{

    /**
     * Creates a new Staff of the game.
     *
     * @param name
     *     the Staff's name
     * @param damage
     *     the Staff's damage
     * @param weight
     *     the Staff's weight
     */
    public Staff(final String name, final int damage, final int weight) {
        super (name, damage, weight);
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
        if (!(o instanceof Staff)) {
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