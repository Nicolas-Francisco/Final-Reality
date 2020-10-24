package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.BlockingQueue;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  private int attack;

  /**
   * Creates a new enemy.
   *
   * @param name
   *     the enemy's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param hp
   *     the enemy's hp
   * @param defense
   *     the enemy's defense
   * @param weight
   *    the enemy's weight
   * @param attack
   *    the enemy's attack
   */
  public Enemy(@NotNull final String name,
               @NotNull final BlockingQueue<ICharacter> turnsQueue,
               final int weight,int hp, int defense, int attack) {
    super(turnsQueue, name, hp, defense);
    this.weight = weight;
    this.attack = attack;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the attack of this enemy.
   */
  public int getAttack() {
    return attack;
  }

  /**
   * waitTurn() method if the object is an Enemy
   */
  public void waitTurn(){
    super.setScheduledExecutor(Executors.newSingleThreadScheduledExecutor());
    super.getScheduledExecutor().schedule(this::addToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * the enemy attacks to a player.
   * Assuming that an enemy can only attack to a Player class and viceversa, this method
   * reduces the Hp of the attacked character depending of the attributes of the enemy.
   */
  public void attackTo(AbstractPlayerCharacter player){
    if (player.IsAlive() && this.IsAlive()){
      int damage = this.attack - player.getDefense();
      if (player.getHP() > damage){
        player.setHP(player.getHP() - damage);
      }
      else{
        player.setHP(0);
        player.setDead();
      }
    }
  }

  /**
   * both methods equals() and hashcode() are different depending of the type of character and
   * the type of Character, hence this methods cannot be used with inheritance
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight() &&
            getName() == enemy.getName() &&
            getHP() == enemy.getHP() &&
            getDefense() == enemy.getDefense() &&
            getAttack() == enemy.getAttack();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight(),
            getName(), getHP(), getDefense(), getAttack());
  }
}
