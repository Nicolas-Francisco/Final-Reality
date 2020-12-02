package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class only defines checkConstruction method, which will be used by each weapon type
 * to test using inheritance and avoid repeating the same code over and over.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
abstract public class AbstractWeaponTest {

  /**
   * checkConstruction method.
   * Tests all the different players.
   */
  protected void checkConstruction(final IWeapon testWeapon,
                                   final IWeapon expectedWeapon,
                                   final IWeapon differentWeapon1,
                                   final IWeapon differentWeapon2,
                                   final IWeapon differentWeapon3,
                                   final Object differentWeaponType){
    assertEquals(expectedWeapon, testWeapon);
    assertEquals(expectedWeapon.hashCode(), testWeapon.hashCode());

      
    assertTrue(expectedWeapon.equals(expectedWeapon));
    



    assertEquals(expectedWeapon.hashCode(), expectedWeapon.hashCode());

    assertFalse(expectedWeapon.equals(differentWeapon1));
    assertNotEquals(expectedWeapon.hashCode(), differentWeapon1.hashCode());

    assertFalse(expectedWeapon.equals(differentWeapon2));
    assertNotEquals(expectedWeapon.hashCode(), differentWeapon2.hashCode());

    assertFalse(expectedWeapon.equals(differentWeapon3));
    assertNotEquals(expectedWeapon.hashCode(), differentWeapon3.hashCode());
    assertFalse(expectedWeapon.equals(differentWeaponType));
    assertNotEquals(expectedWeapon.hashCode(), differentWeaponType.hashCode());
  }
}