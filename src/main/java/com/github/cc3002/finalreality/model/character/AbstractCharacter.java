package com.github.cc3002.finalreality.model.character;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import com.github.cc3002.finalreality.model.controller.GameController;
import com.github.cc3002.finalreality.model.controller.observer.IEventHandler;
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
  private int HP;
  private int Defense;
  private ScheduledExecutorService scheduledExecutor;
  private boolean alive;
  private PropertyChangeSupport DeadCharacterEvent = new PropertyChangeSupport(this);
  private PropertyChangeSupport addToQueueEvent = new PropertyChangeSupport(this);

  /**
   * Creates a new character.
   *
   * @param name       the character's name
   * @param turnsQueue the queue with the characters waiting for their turn
   * @param hp         the character's hp
   * @param defense    the character's defense
   */
  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name,
                              @NotNull int hp,
                              @NotNull int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.Defense = defense;
    this.setHP(hp);
    /**
     * depending of the amount of HP of the character, it might be dead or alive. This parameter
     * can be changed during fights (a character can be killed by another when attacked).
     * If a user creates a character with 0 HP, we initialize the character with false. (this
     * is a border case)
     */
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
  @Override
  public void addToQueue() {
    if(this.IsAlive()){
      turnsQueue.add(this);
      scheduledExecutor.shutdown();
      addToQueueEvent.firePropertyChange("Character Added to Queue", null, this);
    }
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
   * setter methods for each private parameter of the class.
   */
  public void setHP(int health) {
    if (health <= 0) {
      this.HP = 0;
      this.alive = false;
      DeadCharacterEvent.firePropertyChange("Death", null, this);
    } else {
      this.HP = health;
      this.alive = true;
    }
  }

  public void setDefense(int defense) {
    this.Defense = defense;
  }

  /**
   * the character attacks to another character.
   */
  @Override
  public void attackTo(ICharacter character){}

  /**
   * the character is attacked by character.
   */
  @Override
  public void attacked(int BaseDamage){}

  /**
   * method that informs if the character is dead or alive.
   */
  @Override
  public boolean IsAlive() {
    return this.alive;
  }

  /**
   * addListenerDead() adds a listener to the event
   */
  @Override
  public void addListenerDead(IEventHandler characterHandler){
    DeadCharacterEvent.addPropertyChangeListener(characterHandler);
  }

  /**
   * addListenerTurn() adds a listener to the event
   */
  @Override
  public void addListenerTurn(IEventHandler characterHandler){
    addToQueueEvent.addPropertyChangeListener(characterHandler);
  }

  /**
   * useTurn method. If the character is an enemy, it attacks to a random player using the controller,
   * if its not, it doesn't do anything. (We need it only for the beginTurn method in the controller,
   * using a boolean to determine if the character is an enemy or not is equal to use instanceof() method)
   */
  @Override
  public void useTurn(GameController controller){}
}