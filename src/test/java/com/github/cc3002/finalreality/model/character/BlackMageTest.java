package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BlackMageTest extends AbstractPlayerCharacterTest {

    @Test
    void constructorTest() {
        var expectedBlackMage = new BlackMage(BLACKMAGE_NAME, turns, 1, 1, 1);
        var diferentBlackMage1 = new BlackMage("Saruman", turns, 1, 1, 1);
        var diferentBlackMage2 = new BlackMage(BLACKMAGE_NAME, turns, 5, 1, 1);
        var diferentBlackMage3 = new BlackMage(BLACKMAGE_NAME, turns, 1, 5, 1);
        var diferentBlackMage4 = new BlackMage(BLACKMAGE_NAME, turns, 1, 1, 5);
        var expectedKnight = new Knight("Solaire", turns, 1, 1);

        assertEquals(expectedKnight, expectedKnight);
        assertEquals(expectedKnight.hashCode(), expectedKnight.hashCode());

        assertTrue(expectedBlackMage.equals(expectedBlackMage));
        assertFalse(expectedBlackMage.equals(diferentBlackMage1));
        assertFalse(expectedBlackMage.equals(diferentBlackMage2));
        assertFalse(expectedBlackMage.equals(diferentBlackMage3));
        assertFalse(expectedBlackMage.equals(diferentBlackMage4));
        assertFalse(expectedBlackMage.equals(expectedKnight));
    }

    @Test
    void equipWeaponTest() {
        BlackMage blackmage = new BlackMage(BLACKMAGE_NAME, turns, 10, 10, 10);
        assertNull(blackmage.getEquippedWeapon());
        blackmage.equip(testWeapon);
        assertEquals(testWeapon, blackmage.getEquippedWeapon());
    }
}