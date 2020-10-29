package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This testing class tests all the methods of a Thief player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class ThiefTest extends AbstractPlayerCharacterTest {

    /**
     * New testing player
     */
    private Thief testThief = new Thief(THIEF_NAME, turns, 1, 1);

    /**
     * This method tests the waitTurn() method if the character is a player.
     * In this case we test only with a thief player.
     */
    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testThief.equip(testBow);
        testThief.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testThief, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between players. In this case, the Hashcode
     * and Equals compares every parameter of the Thief Class, thus we have to test
     * differences in each parameter (name, hp and  defence)
     */
    @Test
    void constructorTest() {
        var expectedThief = new Thief(THIEF_NAME, turns, 1, 1);
        var differentThief1 = new Thief("Lautrec", turns, 1, 1);
        var differentThief2 = new Thief(THIEF_NAME, turns, 5, 1);
        var differentThief3 = new Thief(THIEF_NAME, turns, 1, 5);
        var expectedKnight = new Knight("Solaire", turns, 1, 1);

        assertEquals(expectedThief, expectedThief);
        assertEquals(expectedThief.hashCode(), expectedThief.hashCode());

        assertTrue(expectedThief.equals(expectedThief));
        assertFalse(expectedThief.equals(differentThief1));
        assertFalse(expectedThief.equals(differentThief2));
        assertFalse(expectedThief.equals(differentThief3));
        assertFalse(expectedThief.equals(expectedKnight));
    }

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        testThief.equip(testStaff);
        assertNull(testThief.getEquippedWeapon());
        testThief.equip(testAxe);
        assertNull(testThief.getEquippedWeapon());

        testThief.equip(testBow);
        assertEquals(testBow, testThief.getEquippedWeapon());
        testThief.equip(testSword);
        assertEquals(testSword, testThief.getEquippedWeapon());
        testThief.equip(testKnife);
        assertEquals(testKnife, testThief.getEquippedWeapon());



        Thief differentThief1 = new Thief("Greirat", turns, 0, 1);
        differentThief1.equip(testKnife);
        assertNull(differentThief1.getEquippedWeapon());
        differentThief1.equip(testSword);
        assertNull(differentThief1.getEquippedWeapon());
        differentThief1.equip(testBow);
        assertNull(differentThief1.getEquippedWeapon());
    }
}