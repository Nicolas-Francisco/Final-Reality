package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnightTest extends AbstractPlayerCharacterTest {

    @Test
    void constructorTest() {
        var expectedKnight = new Knight(KNIGHT_NAME, turns, 1, 1);
        var diferentKnight1 = new Knight("Solaire", turns, 1, 1);
        var diferentKnight2 = new Knight(KNIGHT_NAME, turns, 5, 1);
        var diferentKnight3 = new Knight(KNIGHT_NAME, turns, 1, 5);
        var expectedEngineer = new Engineer(ENGINEER_NAME, turns, 1, 1);

        assertEquals(expectedKnight, expectedKnight);
        assertEquals(expectedKnight.hashCode(), expectedKnight.hashCode());

        assertTrue(expectedKnight.equals(expectedKnight));
        assertFalse(expectedKnight.equals(diferentKnight1));
        assertFalse(expectedKnight.equals(diferentKnight2));
        assertFalse(expectedKnight.equals(diferentKnight3));
        assertFalse(expectedKnight.equals(expectedEngineer));
    }

    @Test
    void equipWeaponTest() {
        Knight knight = new Knight(KNIGHT_NAME, turns, 1, 1);
        assertNull(knight.getEquippedWeapon());
        knight.equip(testWeapon);
        assertEquals(testWeapon, knight.getEquippedWeapon());
    }
}