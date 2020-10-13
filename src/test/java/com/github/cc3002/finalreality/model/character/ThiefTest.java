package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.Bow;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
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
     * New testing player and testing weapon
     */
    private Thief testThief;
    private IWeapon testBow;

    /**
     * This method tests the waitTurn() method if the character is a player.
     * In this case we test only with a thief player.
     */
    @Test
    void waitTurnTest() {
        testThief = new Thief(THIEF_NAME, turns, 1, 1);
        testBow = new Bow("test", 10, 10);
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
     * This method tests the equip method.
     * For now it just tests with any weapon, but when we start the double dispatch we
     * will have to test every weapon that this class can equip
     */
    @Test
    void equipWeaponTest() {
        Thief thief = new Thief(THIEF_NAME, turns, 1, 1);
        assertNull(thief.getEquippedWeapon());
        thief.equip(testBow);
        assertEquals(testBow, thief.getEquippedWeapon());
    }
}