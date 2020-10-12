package com.github.cc3002.finalreality.model.weapon;

/**
 * This represents a weapon form the game,
 * A weapon can be used by the player only.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public interface IWeapon {

    /**
     * Returns this character's name.
     */
    String getName();

    /**
     * Returns this character's damage.
     */
    int getDamage();

    /**
     * Returns this character's weight.
     */
    int getWeight();

    /**
     * Returns this character's type.
     */
}
