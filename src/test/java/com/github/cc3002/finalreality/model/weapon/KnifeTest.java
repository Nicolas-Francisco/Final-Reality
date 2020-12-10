package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This testing class tests all the methods of a Knife weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class KnifeTest extends AbstractWeaponTest{

    private static final String KNIFE_NAME = "Test Knife";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    private IWeapon testKnife;
    private IWeapon expectedKnife;
    private IWeapon differentKnife1;
    private IWeapon differentKnife2;
    private IWeapon differentKnife3;
    private Object differentKnife4;

    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
        expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
        differentKnife1 = new Knife("Test", DAMAGE, SPEED);
        differentKnife2 = new Knife(KNIFE_NAME, 1, SPEED);
        differentKnife3 = new Knife(KNIFE_NAME, DAMAGE, 1);
        differentKnife4 = new Object();
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
        checkConstruction(testKnife, expectedKnife, differentKnife1, differentKnife2, differentKnife3, differentKnife4);
    }
}
