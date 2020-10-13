package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BowTest extends AbstractWeaponTest{

    @BeforeEach
    void setUp() {
        testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
        var diferentBow1 = new Bow("Test", DAMAGE, SPEED);
        var diferentBow2 = new Bow(BOW_NAME, 1, SPEED);
        var diferentBow3 = new Bow(BOW_NAME, DAMAGE, 1);
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        assertEquals(expectedBow, testBow);
        assertEquals(expectedBow.hashCode(), testBow.hashCode());

        assertTrue(expectedBow.equals(expectedBow));
        assertFalse(expectedBow.equals(diferentBow1));
        assertFalse(expectedBow.equals(diferentBow2));
        assertFalse(expectedBow.equals(diferentBow3));
        assertFalse(expectedBow.equals(expectedAxe));
    }
}
