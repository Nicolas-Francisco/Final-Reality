package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a knife.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public class Knife extends AbstractWeapon{

    /**
     * Creates a new Knife of the game.
     *
     * @param name
     *     the Knife's name
     * @param damage
     *     the Knife's damage
     * @param weight
     *     the Knife's weight
     */
    public Knife(final String name, final int damage, final int weight) {
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
        if (!(o instanceof Knife)) {
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
