package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This testing class tests all the methods of a Sword weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class SwordTest extends AbstractWeaponTest{

    /**
     * New testing weapon
     */
    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    }

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between weapons. In this case, the Hashcode
     * and Equals compares every parameter of the Sword Class, thus we have to test
     * differences in each parameter (name, damage and weight/speed)
     */
    @Test
    void constructorTest() {
        var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
        var differentSword1 = new Sword("Test", DAMAGE, SPEED);
        var differentSword2 = new Sword(SWORD_NAME, 1, SPEED);
        var differentSword3 = new Sword(SWORD_NAME, DAMAGE, 1);
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        assertEquals(expectedSword, testSword);
        assertEquals(expectedSword.hashCode(), testSword.hashCode());

        assertTrue(expectedSword.equals(expectedSword));
        assertFalse(expectedSword.equals(differentSword1));
        assertFalse(expectedSword.equals(differentSword2));
        assertFalse(expectedSword.equals(differentSword3));
        assertFalse(expectedSword.equals(expectedAxe));
    }
}
