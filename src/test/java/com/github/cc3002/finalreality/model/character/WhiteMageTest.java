package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WhiteMageTest extends AbstractPlayerCharacterTest {

    @Test
    void constructorTest() {
        var expectedWhiteMage = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 1);
        var diferentWhiteMage1 = new WhiteMage("Logan", turns, 1, 1, 1);
        var diferentWhiteMage2 = new WhiteMage(WHITEMAGE_NAME, turns, 5, 1, 1);
        var diferentWhiteMage3 = new WhiteMage(WHITEMAGE_NAME, turns, 1, 5, 1);
        var diferentWhiteMage4 = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 5);
        var expectedKnight = new Knight("Solaire", turns, 1, 1);

        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertTrue(expectedWhiteMage.equals(expectedWhiteMage));
        assertFalse(expectedWhiteMage.equals(diferentWhiteMage1));
        assertFalse(expectedWhiteMage.equals(diferentWhiteMage2));
        assertFalse(expectedWhiteMage.equals(diferentWhiteMage3));
        assertFalse(expectedWhiteMage.equals(diferentWhiteMage4));
        assertFalse(expectedWhiteMage.equals(expectedKnight));
    }

    @Test
    void equipWeaponTest() {
        WhiteMage whitemage = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 1);
        assertNull(whitemage.getEquippedWeapon());
        whitemage.equip(testWeapon);
        assertEquals(testWeapon, whitemage.getEquippedWeapon());
    }
}