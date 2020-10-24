package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

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
public abstract class AbstractPlayerCharacter extends AbstractCharacter {

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
    this.equippedWeapon = null;
  }

  /**
   * waitTurn() method if the object is a Player
   */
  public void waitTurn(){
    super.setScheduledExecutor(Executors.newSingleThreadScheduledExecutor());
    super.getScheduledExecutor().schedule(super::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Using Double Dispatch, we no longer need a general equip method, but several equip_weapon_type
   * for each character (every character can only equip certain types of weapons). In this case, we will
   * have 5 methods for each type of weapon in this father class (which will not equip anything), then
   * every class on their own will override each method depending of the types of weapons they are allowed
   * to use. In this way we make sure that, if a class tries to equip a weapon that should not equip,
   * the program would still run but will not change anything.

  public void equip(IWeapon weapon) {
    this.equippedWeapon = weapon;
  }
   */

  /**
   * equipSword base method
   */
  public void equipSword(Sword sword){
  }
  /**
   * equipAxe base method
   */
  public void equipAxe(Axe axe){
  }
  /**
   * equipStaff base method
   */
  public void equipStaff(Staff staff){
  }
  /**
   * equipKnife base method
   */
  public void equipKnife(Knife knife){
  }
  /**
   * equipBow base method
   */
  public void equipBow(Bow bow){
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

  /**
   * Modifies this character's equipped weapon.
   * equippedWeapon is a private parameter, so there must be a setter method to be able
   * to modify it.
   */
  protected void setEquippedWeapon(IWeapon weapon) {
    this.equippedWeapon = weapon;
  }

  /**
   * the player attacks to an enemy.
   * Assuming that an enemy can only attack to a Player class and viceversa, this method
   * reduces the Hp of the attacked character depending of the attributes of the player.
   */
  public void attackTo(Enemy enemy){
    if (enemy.IsAlive() && this.IsAlive()){
      int damage =  this.getEquippedWeapon().getDamage() - enemy.getDefense();
      if (enemy.getHP() > damage){
        enemy.setHP(enemy.getHP() - damage);
      }
      else{
        enemy.setHP(0);
        enemy.setDead();
      }
    }
  }
}
