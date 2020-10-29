package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;


/**
 * This represents a playable character from the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public interface IPlayer extends ICharacter {

    /**
     * equipSword base method
     */
    void equip(Sword sword);
    /**
     * equipAxe base method
     */
    void equip(Axe axe);

    /**
     * equipStaff base method
     */
    void equip(Staff staff);

    /**
     * equipKnife base method
     */
    void equip(Knife knife);

    /**
     * equipBow base method
     */
    void equip(Bow bow);

    /**
     * Return this character's equipped weapon.
     * Enemy class does not have any weapons, so having a getEquippedWeapon() method
     * for enemies has no sense. Therefore getEquippedWeapon() should be declared and
     * implemented only by the AbstractPlayerClass.
     */
    IWeapon getEquippedWeapon();

    /**
     * Modifies this character's equipped weapon.
     * equippedWeapon is a private parameter, so there must be a setter method to be able
     * to modify it.
     */
    void setEquippedWeapon(IWeapon weapon);
}
