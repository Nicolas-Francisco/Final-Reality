package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnifeTest extends AbstractWeaponTest{

    @BeforeEach
    void setUp() {
        testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
        var diferentKnife1 = new Knife("Test", DAMAGE, SPEED);
        var diferentKnife2 = new Knife(KNIFE_NAME, 1, SPEED);
        var diferentKnife3 = new Knife(KNIFE_NAME, DAMAGE, 1);
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        assertEquals(expectedKnife, testKnife);
        assertEquals(expectedKnife.hashCode(), testKnife.hashCode());

        assertTrue(expectedKnife.equals(expectedKnife));
        assertFalse(expectedKnife.equals(diferentKnife1));
        assertFalse(expectedKnife.equals(diferentKnife2));
        assertFalse(expectedKnife.equals(diferentKnife3));
        assertFalse(expectedKnife.equals(expectedAxe));
    }
}
