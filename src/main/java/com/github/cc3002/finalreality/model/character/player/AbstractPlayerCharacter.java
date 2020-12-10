package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
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
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayer{

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
   * equip base method
   */
  @Override
  public void equip(IWeapon weapon){
  }


  /**
   * Return this character's equipped weapon.
   * Enemy class does not have any weapons, so having a getEquippedWeapon() method
   * for enemies has no sense. Therefore getEquippedWeapon() should be declared and
   * implemented only by the AbstractPlayerClass.
   */
  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * Modifies this character's equipped weapon.
   * equippedWeapon is a private parameter, so there must be a setter method to be able
   * to modify it.
   */
  @Override
  public void setEquippedWeapon(IWeapon weapon) {
    this.equippedWeapon = weapon;
  }

  /**
   * the player attacks to a character using Double Dispatch
   */
  @Override
  public void attackTo(ICharacter character){
    if (this.IsAlive() && this.getEquippedWeapon() != null){
      int BaseDamage = this.getEquippedWeapon().getDamage();
      character.attacked(BaseDamage);
    }
  }

  /**
   * the player is attacked by a character using Double Dispatch
   */
  @Override
  public void attacked(int BaseDamage){
    if ((this.IsAlive()) && (BaseDamage > this.getDefense())){
      int damage = BaseDamage - this.getDefense();
      if (this.getHP() > damage){
        this.setHP(this.getHP() - damage);
      }
      else{
        this.setHP(0);
      }
    }
  }
}
