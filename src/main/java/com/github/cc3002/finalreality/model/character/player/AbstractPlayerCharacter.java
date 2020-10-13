package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public class AbstractPlayerCharacter extends AbstractCharacter {

  private IWeapon equippedWeapon = null;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param hp
   *     the character's hp
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
   * Astract class, but in the PlayerCharacter class instead.
   */
  public void equip(IWeapon weapon) {
    this.equippedWeapon = weapon;
  }

  /**
   * Return this character's equipped weapon.
   * Enemy class does not have any weapons, so having a getEquippedWeapon() method
   * for enemys has no sense. Therefore getEquippedWeapon() should be declared and
   * implemented only by the Player class.
   */
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

}
