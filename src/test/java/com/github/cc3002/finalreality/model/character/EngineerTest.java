package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EngineerTest extends AbstractPlayerCharacterTest {

    private Engineer testEngineer;
    private IWeapon testAxe;

    @Test
    void waitTurnTest() {
        testEngineer = new Engineer(ENGINEER_NAME, turns, 1, 1);
        testAxe = new Axe("test", 10, 10);
        Assertions.assertTrue(turns.isEmpty());
        testEngineer.equip(testAxe);
        testEngineer.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testEngineer, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void constructorTest() {
        var expectedEngineer = new Engineer(ENGINEER_NAME, turns, 1, 1);
        var differentEngineer1 = new Engineer("Tony", turns, 1, 1);
        var differentEngineer2 = new Engineer(ENGINEER_NAME, turns, 5, 1);
        var differentEngineer3 = new Engineer(ENGINEER_NAME, turns, 1, 5);
        var expectedKnight = new Knight("Solaire", turns, 1, 1);

        assertEquals(expectedEngineer, expectedEngineer);
        assertEquals(expectedEngineer.hashCode(), expectedEngineer.hashCode());

        assertTrue(expectedEngineer.equals(expectedEngineer));
        assertFalse(expectedEngineer.equals(differentEngineer1));
        assertFalse(expectedEngineer.equals(differentEngineer2));
        assertFalse(expectedEngineer.equals(differentEngineer3));
        assertFalse(expectedEngineer.equals(expectedKnight));
    }

    @Test
    void equipWeaponTest() {
        Engineer engineer = new Engineer(ENGINEER_NAME, turns, 1, 1);
        assertNull(engineer.getEquippedWeapon());
        engineer.equip(testAxe);
        assertEquals(testAxe, engineer.getEquippedWeapon());
    }
}