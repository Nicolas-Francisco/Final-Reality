package com.github.cc3002.finalreality.model.weapon;
import com.github.cc3002.finalreality.model.character.player.*;

/**
 * This represents a weapon form the game.
 * A weapon can be used by the player only, and every weapon has
 * many parameters that relate them, hence there has to be a Interface
 * wich can unify all the weapons in the game
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public interface IWeapon {

    /**
     * Returns this weapon's name.
     */
    String getName();

    /**
     * Returns this weapon's damage.
     */
    int getDamage();

    /**
     * Returns this weapon's weight.
     */
    int getWeight();

    /**
     * equip base methods using Double Dispatch
     */
    void equipToKnight(Knight knight);

    void equipToEngineer(Engineer engineer);

    void equipToThief(Thief thief);

    void equipToWhiteMage(WhiteMage whitemage);

    void equipToBlackMage(BlackMage blackmage);
}
