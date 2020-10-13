package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnightTest extends AbstractPlayerCharacterTest {

    private Knight testKnight;
    private IWeapon testSword;

    @Test
    void waitTurnTest() {
        testKnight = new Knight(KNIGHT_NAME, turns, 1, 1);
        testSword = new Axe("test", 10, 10);
        Assertions.assertTrue(turns.isEmpty());
        testKnight.equip(testSword);
        testKnight.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testKnight, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void constructorTest() {
        var expectedKnight = new Knight(KNIGHT_NAME, turns, 1, 1);
        var differentKnight1 = new Knight("Solaire", turns, 1, 1);
        var differentKnight2 = new Knight(KNIGHT_NAME, turns, 5, 1);
        var differentKnight3 = new Knight(KNIGHT_NAME, turns, 1, 5);
        var expectedEngineer = new Engineer(ENGINEER_NAME, turns, 1, 1);

        assertEquals(expectedKnight, expectedKnight);
        assertEquals(expectedKnight.hashCode(), expectedKnight.hashCode());

        assertTrue(expectedKnight.equals(expectedKnight));
        assertFalse(expectedKnight.equals(differentKnight1));
        assertFalse(expectedKnight.equals(differentKnight2));
        assertFalse(expectedKnight.equals(differentKnight3));
        assertFalse(expectedKnight.equals(expectedEngineer));
    }

    @Test
    void equipWeaponTest() {
        Knight knight = new Knight(KNIGHT_NAME, turns, 1, 1);
        assertNull(knight.getEquippedWeapon());
        knight.equip(testSword);
        assertEquals(testSword, knight.getEquippedWeapon());
    }
}