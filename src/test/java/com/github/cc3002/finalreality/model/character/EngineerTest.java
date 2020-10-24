package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This testing class tests all the methods of a Engineer player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class EngineerTest extends AbstractPlayerCharacterTest {

    /**
     * New testing player
     */
    private Engineer testEngineer = new Engineer(ENGINEER_NAME, turns, 1, 1);

    /**
     * This method tests the waitTurn() method if the character is a player.
     * In this case we test only with a engineer player.
     */
    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testEngineer.equipAxe(testAxe);
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

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between players. In this case, the Hashcode
     * and Equals compares every parameter of the Engineer Class, thus we have to test
     * differences in each parameter (name, hp and  defence)
     */
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

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testEngineer.getEquippedWeapon());
        testEngineer.equipSword(testSword);
        assertNull(testEngineer.getEquippedWeapon());
        testEngineer.equipKnife(testKnife);
        assertNull(testEngineer.getEquippedWeapon());
        testEngineer.equipStaff(testStaff);
        assertNull(testEngineer.getEquippedWeapon());

        testEngineer.equipAxe(testAxe);
        assertEquals(testAxe, testEngineer.getEquippedWeapon());
        testEngineer.equipBow(testBow);
        assertEquals(testBow, testEngineer.getEquippedWeapon());

        Engineer differentEngineer1 = new Engineer("Tony", turns, 0, 1);
        differentEngineer1.equipAxe(testAxe);
        assertNull(differentEngineer1.getEquippedWeapon());
        differentEngineer1.equipBow(testBow);
        assertNull(differentEngineer1.getEquippedWeapon());
    }
}