package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This testing class tests all the methods of a Knife weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class KnifeTest extends AbstractWeaponTest{

    /**
     * New testing weapon
     */
    @BeforeEach
    void setUp() {
        testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
    }

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between weapons. In this case, the Hashcode
     * and Equals compares every parameter of the Knife Class, thus we have to test
     * differences in each parameter (name, damage and weight/speed)
     */
    @Test
    void constructorTest() {
        var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
        var differentKnife1 = new Knife("Test", DAMAGE, SPEED);
        var differentKnife2 = new Knife(KNIFE_NAME, 1, SPEED);
        var differentKnife3 = new Knife(KNIFE_NAME, DAMAGE, 1);
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        assertEquals(expectedKnife, testKnife);
        assertEquals(expectedKnife.hashCode(), testKnife.hashCode());

        assertTrue(expectedKnife.equals(expectedKnife));
        assertFalse(expectedKnife.equals(differentKnife1));
        assertFalse(expectedKnife.equals(differentKnife2));
        assertFalse(expectedKnife.equals(differentKnife3));
        assertFalse(expectedKnife.equals(expectedAxe));
    }
}
