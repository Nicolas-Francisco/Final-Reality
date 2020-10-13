package com.github.cc3002.finalreality.model.weapon;

/**
 * This class just Creates parameters for all the Testings Classes of each
 * weapon to use, there is nothing to test in this Abstract Class.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
abstract public class AbstractWeaponTest {

  /**
   * Names for each weapon we will create in the tests.
   */
  protected static final String AXE_NAME = "Test Axe";
  protected static final String STAFF_NAME = "Test Staff";
  protected static final String SWORD_NAME = "Test Sword";
  protected static final String BOW_NAME = "Test Bow";
  protected static final String KNIFE_NAME = "Test Knife";
  protected static final int DAMAGE = 15;
  protected static final int SPEED = 10;

  protected IWeapon testAxe;
  protected IWeapon testStaff;
  protected IWeapon testSword;
  protected IWeapon testBow;
  protected IWeapon testKnife;

}