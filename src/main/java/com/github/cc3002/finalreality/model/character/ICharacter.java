package com.github.cc3002.finalreality.model.character;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás García Ríos
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's health points.
   */
  int getHP();

  /**
   * Returns this character's Defense.
   */
  int getDefense();

  /**
   * Equips a weapon to the character.
   * equip(Weapon) is only used in PlayerCharacter class which extends AbstractCharacter,
   * this means that this method should not be declared in the Interface nor in the
   * Astract class, but in the PlayerCharacter class instead.
   * Declaring this method in the abstract class breaks the Liskov's subsitution principle
   * and the Interface segregation principle, since the Enemy subclass is uncapable of using it.
   *
   void equip(Weapon weapon);
   * /

  /**
   * Return this character's equipped weapon.
   * Enemy class does not have any weapons, so having a getEquippedWeapon() method
   * for enemys has no sense. Therefore getEquippedWeapon() should be declared and
   * implemented only by Player class.
   * Declaring this method in the abstract class breaks the Liskov's subsitution principle
   * and the Interface segregation principle, since the Enemy subclass is uncapable of using it.
   *
   Weapon getEquippedWeapon();
   */
}
