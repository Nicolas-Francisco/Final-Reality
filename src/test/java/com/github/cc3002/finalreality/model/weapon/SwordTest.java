package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This testing class tests all the methods of a Sword weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class SwordTest extends AbstractWeaponTest{

    private static final String SWORD_NAME = "Test Sword";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    private IWeapon testSword;
    private IWeapon expectedSword;
    private IWeapon differentSword1;
    private IWeapon differentSword2;
    private IWeapon differentSword3;
    private Object differentSword4;

    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
        expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
        differentSword1 = new Sword("Test", DAMAGE, SPEED);
        differentSword2 = new Sword(SWORD_NAME, 1, SPEED);
        differentSword3 = new Sword(SWORD_NAME, DAMAGE, 1);
        differentSword4 = new Object();
    }

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between weapons. In this case, the Hashcode
     * and Equals compares every parameter of the Axe Class, thus we have to test
     * differences in each parameter (name, damage and weight/speed)
     */
    @Test
    void constructorTest() {
        checkConstruction(testSword, expectedSword, differentSword1, differentSword2, differentSword3, differentSword4);
    }
}
