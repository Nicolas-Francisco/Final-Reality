package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ThiefTest extends AbstractPlayerCharacterTest {


    /**
     * 
     */
    @Test
    void constructorTest() {
        var expectedThief = new Thief(THIEF_NAME, turns, 1, 1);
        var diferentThief1 = new Thief("Lautrec", turns, 1, 1);
        var diferentThief2 = new Thief(THIEF_NAME, turns, 5, 1);
        var diferentThief3 = new Thief(THIEF_NAME, turns, 1, 5);
        var expectedKnight = new Knight("Solaire", turns, 1, 1);

        assertEquals(expectedThief, expectedThief);
        assertEquals(expectedThief.hashCode(), expectedThief.hashCode());

        assertTrue(expectedThief.equals(expectedThief));
        assertFalse(expectedThief.equals(diferentThief1));
        assertFalse(expectedThief.equals(diferentThief2));
        assertFalse(expectedThief.equals(diferentThief3));
        assertFalse(expectedThief.equals(expectedKnight));
    }

    @Test
    void equipWeaponTest() {
        Thief thief = new Thief(THIEF_NAME, turns, 1, 1);
        assertNull(thief.getEquippedWeapon());
        thief.equip(testWeapon);
        assertEquals(testWeapon, thief.getEquippedWeapon());
    }
}