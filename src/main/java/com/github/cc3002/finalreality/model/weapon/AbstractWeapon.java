package com.github.cc3002.finalreality.model.weapon;
import com.github.cc3002.finalreality.model.character.player.*;

/**
 * An abstract class that holds all the information of a weapon. Every weapon is
 * different from one another (specific type), hence every weapon should have
 * its own class, eliminating the weapontype array.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public abstract class AbstractWeapon implements IWeapon{

  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a new weapon of the game.
   *
   * @param name
   *     the weapon's name
   * @param damage
   *     the weapon's damage
   * @param weight
   *     the weapon's weight
   */
  public AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  /**
   * getters methods for each private parameter of the class.
   */
  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  /**
   * equip base methods using Double Dispatch
   */
  public void equipToKnight(Knight knight){}

  public void equipToEngineer(Engineer engineer){}

  public void equipToThief(Thief thief){}

  public void equipToWhiteMage(WhiteMage whitemage){}

  public void equipToBlackMage(BlackMage blackmage){}
}
