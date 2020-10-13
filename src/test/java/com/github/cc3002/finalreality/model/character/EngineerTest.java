package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EngineerTest extends AbstractPlayerCharacterTest {

    @Test
    void constructorTest() {
        var expectedEngineer = new Engineer(ENGINEER_NAME, turns, 1, 1);
        var diferentEngineer1 = new Engineer("Tony", turns, 1, 1);
        var diferentEngineer2 = new Engineer(ENGINEER_NAME, turns, 5, 1);
        var diferentEngineer3 = new Engineer(ENGINEER_NAME, turns, 1, 5);
        var expectedKnight = new Knight("Solaire", turns, 1, 1);

        assertEquals(expectedKnight, expectedKnight);
        assertEquals(expectedKnight.hashCode(), expectedKnight.hashCode());

        assertTrue(expectedEngineer.equals(expectedEngineer));
        assertFalse(expectedEngineer.equals(diferentEngineer1));
        assertFalse(expectedEngineer.equals(diferentEngineer2));
        assertFalse(expectedEngineer.equals(diferentEngineer3));
        assertFalse(expectedEngineer.equals(expectedKnight));
    }

    @Test
    void equipWeaponTest() {
        Engineer engineer = new Engineer(ENGINEER_NAME, turns, 1, 1);
        assertNull(engineer.getEquippedWeapon());
        engineer.equip(testWeapon);
        assertEquals(testWeapon, engineer.getEquippedWeapon());
    }
}