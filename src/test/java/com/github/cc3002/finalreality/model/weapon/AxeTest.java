package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This testing class tests all the methods of an Axe weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class AxeTest extends AbstractWeaponTest{

    private static final String AXE_NAME = "Test Axe";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    private IWeapon testAxe;
    private IWeapon expectedAxe;
    private IWeapon differentAxe1;
    private IWeapon differentAxe2;
    private IWeapon differentAxe3;
    private Object differentAxe4;

    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        differentAxe1 = new Axe("Test", DAMAGE, SPEED);
        differentAxe2 = new Axe(AXE_NAME, 1, SPEED);
        differentAxe3 = new Axe(AXE_NAME, DAMAGE, 1);
        differentAxe4 = new Object();
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
        checkConstruction(testAxe, expectedAxe, differentAxe1, differentAxe2, differentAxe3, differentAxe4);
    }
}
