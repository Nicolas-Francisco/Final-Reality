package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This testing class tests all the methods of a Bow weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class BowTest extends AbstractWeaponTest{

    private static final String BOW_NAME = "Test Bow";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    private IWeapon testBow;
    private IWeapon expectedBow;
    private IWeapon differentBow1;
    private IWeapon differentBow2;
    private IWeapon differentBow3;
    private Object differentBow4;

    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
        expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
        differentBow1 = new Bow("Test", DAMAGE, SPEED);
        differentBow2 = new Bow(BOW_NAME, 1, SPEED);
        differentBow3 = new Bow(BOW_NAME, DAMAGE, 1);
        differentBow4 = new Object();
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
        checkConstruction(testBow, expectedBow, differentBow1, differentBow2, differentBow3, differentBow4);
    }
}
