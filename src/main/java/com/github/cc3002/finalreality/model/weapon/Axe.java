package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of an axe.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public class Axe extends AbstractWeapon{

    public Axe(final String name, final int damage, final int weight) {
        super (name, damage, weight);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IWeapon)) {
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
