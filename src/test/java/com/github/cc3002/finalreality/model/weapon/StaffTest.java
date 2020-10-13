package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This testing class tests all the methods of a Staff weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class StaffTest extends AbstractWeaponTest{

    /**
     * New testing weapon
     */
    @BeforeEach
    void setUp() {
        testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    }

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between weapons. In this case, the Hashcode
     * and Equals compares every parameter of the Staff Class, thus we have to test
     * differences in each parameter (name, damage and weight/speed)
     */
    @Test
    void constructorTest() {
        var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
        var differentStaff1 = new Staff("Test", DAMAGE, SPEED);
        var differentStaff2 = new Staff(STAFF_NAME, 1, SPEED);
        var differentStaff3 = new Staff(STAFF_NAME, DAMAGE, 1);
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        assertEquals(expectedStaff, testStaff);
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());

        assertTrue(expectedStaff.equals(expectedStaff));
        assertFalse(expectedStaff.equals(differentStaff1));
        assertFalse(expectedStaff.equals(differentStaff2));
        assertFalse(expectedStaff.equals(differentStaff3));
        assertFalse(expectedStaff.equals(expectedAxe));
    }
}
