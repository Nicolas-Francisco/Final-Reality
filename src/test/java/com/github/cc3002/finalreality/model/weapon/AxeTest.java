package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This testing class tests all the methods of na Axe weapon.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class AxeTest extends AbstractWeaponTest{

    /**
     * New testing weapon
     */
    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
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
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        var differentAxe1 = new Axe("Test", DAMAGE, SPEED);
        var differentAxe2 = new Axe(AXE_NAME, 1, SPEED);
        var differentAxe3 = new Axe(AXE_NAME, DAMAGE, 1);
        var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
        assertEquals(expectedAxe, testAxe);
        assertEquals(expectedAxe.hashCode(), testAxe.hashCode());

        assertTrue(expectedAxe.equals(expectedAxe));
        assertFalse(expectedAxe.equals(differentAxe1));
        assertFalse(expectedAxe.equals(differentAxe2));
        assertFalse(expectedAxe.equals(differentAxe3));
        assertFalse(expectedAxe.equals(expectedBow));
    }
}
