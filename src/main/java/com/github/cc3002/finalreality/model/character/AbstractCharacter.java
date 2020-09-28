package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
// import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
// import com.github.cc3002.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
// import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
// import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final CharacterClass characterClass;
  // private Weapon equippedWeapon = null;  Declared in Player Class instead
  protected ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
  }

  /**
   * waitTurn() works depending of the type of Character that extends AbstractCharacter,
   * hence this is an abstract method which should work with inheritance, and
   * instanceof method is not necessary.
   * This breaks the Single-responsibility principle, since this method has the
   * responsibilty to distinguish both classes, which should be delegated to
   * both subclasses instead.
   *
   @Override
     public void waitTurn() {
       scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
       if (this instanceof PlayerCharacter) {
         scheduledExecutor
             .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
       } else {
         var enemy = (Enemy) this;
         scheduledExecutor
             .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
       }
     }
   */
  @Override
  public abstract void waitTurn();

  /**
   * Adds this character to the turns queue.
   * waitTurn() uses addToQueue() method in both subclasses (Enemy and Player), therefore
   * addToQueue() should be a protected method OR there has to be a public get() method
   * for the subclasses to use. In this case addToQueue() is a protected method.
   */
  protected void addToQueue() {
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
   * Declaring this method in the abstract class breaks the Liskov's subsitution principle,
   * since the Enemy subclass is uncapable of using it.
  @Override
  public void equip(Weapon weapon);
   */

  /**
   * Return this character's equipped weapon.
   * Enemy class does not have any weapons, so having a getEquippedWeapon() method
   * for enemys has no sense. Therefore getEquippedWeapon() should be declared and
   * implemented only by the Player class.
   * Declaring this method in the abstract class breaks the Liskov's subsitution principle,
   * since the Enemy subclass is uncapable of using it.
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
