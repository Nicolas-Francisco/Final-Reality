package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SwordTest extends AbstractWeaponTest{

    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
        var diferentSword1 = new Sword("Test", DAMAGE, SPEED);
        var diferentSword2 = new Sword(SWORD_NAME, 1, SPEED);
        var diferentSword3 = new Sword(SWORD_NAME, DAMAGE, 1);
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        assertEquals(expectedSword, testSword);
        assertEquals(expectedSword.hashCode(), testSword.hashCode());

        assertTrue(expectedSword.equals(expectedSword));
        assertFalse(expectedSword.equals(diferentSword1));
        assertFalse(expectedSword.equals(diferentSword2));
        assertFalse(expectedSword.equals(diferentSword3));
        assertFalse(expectedSword.equals(expectedAxe));
    }
}
