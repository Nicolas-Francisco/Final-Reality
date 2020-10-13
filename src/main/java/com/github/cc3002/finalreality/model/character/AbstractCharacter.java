package com.github.cc3002.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public abstract class AbstractCharacter implements ICharacter {

  private final BlockingQueue<ICharacter> turnsQueue;
  private final String name;
  private final int HP;
  private final int Defense;
  private ScheduledExecutorService scheduledExecutor;

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
  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name,
                              @NotNull int hp,
                              @NotNull int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.HP = hp;
    this.Defense = defense;
  }

  /**
   * waitTurn() works depending of the type of Character that extends AbstractCharacter,
   * hence this is an abstract method which should work with inheritance, and
   * instanceof method is not necessary.
   * This breaks the Single-responsibility principle, since this method has the
   * responsibility to distinguish both classes, which should be delegated to
   * both subclasses instead.
   */
  @Override
  public abstract void waitTurn();

  /**
   * Adds this character to the turns queue.
   * waitTurn() uses addToQueue() method in both subclasses (Enemy and Player), therefore
   * addToQueue() should be a protected method OR there has to be a public set() method
   * for the subclasses to use. In this case addToQueue() is a private method.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  /**
   * set() method for scheduled Executor parameter.
   */
  public void setScheduledExecutor(ScheduledExecutorService scheduledExecutor) {
    this.scheduledExecutor = scheduledExecutor;
  }

  /**
   * getters methods for each private parameter of the class.
   */
  public ScheduledExecutorService getScheduledExecutor() {
    return scheduledExecutor;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getHP() {
    return HP;
  }

  @Override
  public int getDefense() {
    return Defense;
  }

  /**
   * equip(Weapon) is only used in AbstractPlayerCharacter and is subclasses,
   * which all extends AbstractCharacter, this means that this method should not be
   * declared in the Interface nor in the Abstract class, but in the AbstractPlayerCharacter
   * class instead.
   * Declaring this method in this abstract class breaks the Liskov's substitution principle,
   * since the Enemy subclass is unable of using it.
   *
   @Override public void equip(Weapon weapon);
   */

  /**
   * Enemy class does not have any weapons, so having a getEquippedWeapon() method
   * for enemies has no sense. Therefore getEquippedWeapon() should be declared and
   * implemented only by the AbstractPlayerCharacter class.
   * Declaring this method in the abstract class breaks the Liskov's substitution principle,
   * since the Enemy subclass is unable of using it.
   *
   * @Override public Weapon getEquippedWeapon() {
   * return equippedWeapon;
   * }
   */

  /**
   * Having an array of Classes is not a good method nor an extendable code, besides each
   * class has different restrictions in terms of weapons (leading to Double Dispatch).
   * Hence, getCharacterClass() gets replaced by the subclasses of the AbstractPlayer Class
   *
   @Override public CharacterClass getCharacterClass() {
   return characterClass;
   }
   */
}