package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a player character of the game,
 * which is controlled by the player and not by the cpu.
 *
 * Because the CharacterClass array was eliminated, we no longer have that
 * parameter to differentiate each class from another. Hence this is now a
 * AbstractClass which represents a character controlled by the player no
 * matter the class of the player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public class AbstractPlayerCharacter extends AbstractCharacter {

  /**
   * Every Player can equip a weapon, but its not part of the
   * constructor of the player.
   */

  private IWeapon equippedWeapon = null;

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
  public AbstractPlayerCharacter(@NotNull String name,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                                 @NotNull int hp,
                                 @NotNull int defense) {
    super(turnsQueue, name, hp, defense);
  }

  /**
   * waitTurn() method if the object is a Player
   */
  public void waitTurn(){
    super.setScheduledExecutor(Executors.newSingleThreadScheduledExecutor());
    super.getScheduledExecutor().schedule(super::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * equip(Weapon) is only used in PlayerCharacter class which extends AbstractCharacter,
   * this means that this method should not be declared in the Interface nor in the
   * Abstract class, but in the AbstractPlayerCharacter class instead.
   */
  public void equip(IWeapon weapon) {
    this.equippedWeapon = weapon;
  }

  /**
   * Return this character's equipped weapon.
   * Enemy class does not have any weapons, so having a getEquippedWeapon() method
   * for enemies has no sense. Therefore getEquippedWeapon() should be declared and
   * implemented only by the AbstractPlayerClass.
   */
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }
}
