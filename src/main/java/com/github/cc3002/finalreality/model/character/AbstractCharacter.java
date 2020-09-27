package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás García Ríos
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final CharacterClass characterClass;
  // private Weapon equippedWeapon = null;
  private ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
  }

  /**
   * waitTurn() works depending of the type of Character that extends AbstractCharacter,
   * hence this is an abstract method, and instanceof function is not necessary.
   */

  @Override
  public abstract void waitTurn();

  /**
   * Adds this character to the turns queue.
   */
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  /**
   * equip(Weapon) is only used in PlayerCharacter class which extends AbstractCharacter,
   * this means that this method should not be declared in the Interface nor in the
   * Astract class, but in the PlayerCharacter class instead.
  @Override
  public void equip(Weapon weapon);
   */

  /**
   * Return this character's equipped weapon.
   * Enemy class does not have any weapons, so having a getEquippedWeapon() method
   * for enemys has no sense. Therefore getEquippedWeapon() should be declared and
   * implemented only by the Player class.
  @Override
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }
   */

  @Override
  public CharacterClass getCharacterClass() {
    return characterClass;
  }

  /**
   * both methods equals() and hashcode() are common in the subclasses, so these methods
   * have to be declared in the abstract class.
   */
  @Override
  public abstract boolean equals(final Object o);

  @Override
  public abstract int hashCode();
}
