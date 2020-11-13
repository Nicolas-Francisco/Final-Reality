package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This testing class tests all the methods of a Staff weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class StaffTest extends AbstractWeaponTest{

    private static final String STAFF_NAME = "Test Staff";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    private IWeapon testStaff;
    private IWeapon expectedStaff;
    private IWeapon differentStaff1;
    private IWeapon differentStaff2;
    private IWeapon differentStaff3;
    private Object differentStaff4;

    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
        expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
        differentStaff1 = new Staff("Test", DAMAGE, SPEED);
        differentStaff2 = new Staff(STAFF_NAME, 1, SPEED);
        differentStaff3 = new Staff(STAFF_NAME, DAMAGE, 1);
        differentStaff4 = new Object();
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
        checkConstruction(testStaff, expectedStaff, differentStaff1, differentStaff2, differentStaff3, differentStaff4);
    }
}
