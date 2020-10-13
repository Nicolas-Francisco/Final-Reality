package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AxeTest extends AbstractWeaponTest{

    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        var diferentAxe1 = new Axe("Test", DAMAGE, SPEED);
        var diferentAxe2 = new Axe(AXE_NAME, 1, SPEED);
        var diferentAxe3 = new Axe(AXE_NAME, DAMAGE, 1);
        var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
        assertEquals(expectedAxe, testAxe);
        assertEquals(expectedAxe.hashCode(), testAxe.hashCode());

        assertTrue(expectedAxe.equals(expectedAxe));
        assertFalse(expectedAxe.equals(diferentAxe1));
        assertFalse(expectedAxe.equals(diferentAxe2));
        assertFalse(expectedAxe.equals(diferentAxe3));
        assertFalse(expectedAxe.equals(expectedBow));
    }
}
