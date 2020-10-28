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
    public void equipSword(Sword sword);
    /**
     * equipAxe base method
     */
    public void equipAxe(Axe axe);

    /**
     * equipStaff base method
     */
    public void equipStaff(Staff staff);

    /**
     * equipKnife base method
     */
    public void equipKnife(Knife knife);
    /**
     * equipBow base method
     */
    public void equipBow(Bow bow);

    /**
     * Return this character's equipped weapon.
     * Enemy class does not have any weapons, so having a getEquippedWeapon() method
     * for enemies has no sense. Therefore getEquippedWeapon() should be declared and
     * implemented only by the AbstractPlayerClass.
     */
    public IWeapon getEquippedWeapon();

    /**
     * Modifies this character's equipped weapon.
     * equippedWeapon is a private parameter, so there must be a setter method to be able
     * to modify it.
     */
    public void setEquippedWeapon(IWeapon weapon);
}
