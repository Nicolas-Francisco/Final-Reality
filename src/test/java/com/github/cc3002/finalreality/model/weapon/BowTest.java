package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This testing class tests all the methods of a Bow weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class BowTest extends AbstractWeaponTest{

    /**
     * New testing weapon
     */
    @BeforeEach
    void setUp() {
        testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    }

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between weapons. In this case, the Hashcode
     * and Equals compares every parameter of the Bow Class, thus we have to test
     * differences in each parameter (name, damage and weight/speed)
     */
    @Test
    void constructorTest() {
        var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
        var differentBow1 = new Bow("Test", DAMAGE, SPEED);
        var differentBow2 = new Bow(BOW_NAME, 1, SPEED);
        var differentBow3 = new Bow(BOW_NAME, DAMAGE, 1);
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        assertEquals(expectedBow, testBow);
        assertEquals(expectedBow.hashCode(), testBow.hashCode());

        assertTrue(expectedBow.equals(expectedBow));
        assertFalse(expectedBow.equals(differentBow1));
        assertFalse(expectedBow.equals(differentBow2));
        assertFalse(expectedBow.equals(differentBow3));
        assertFalse(expectedBow.equals(expectedAxe));
    }
}
