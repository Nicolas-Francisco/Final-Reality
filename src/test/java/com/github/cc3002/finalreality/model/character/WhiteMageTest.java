package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This testing class tests all the methods of a WhiteMage player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class WhiteMageTest extends AbstractPlayerCharacterTest {

    /**
     * New testing player
     */
    private WhiteMage testWhiteMage = new WhiteMage(WHITEMAGE_NAME, turns, 10, 10, 10);

    /**
     * This method tests the waitTurn() method if the character is a player.
     * In this case we test only with a whitemage player.
     */
    @Test
    void waitTurnTest() {
        testWhiteMage.equipStaff(testStaff);
        Assertions.assertTrue(turns.isEmpty());
        testWhiteMage.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testWhiteMage, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between players. In this case, the Hashcode
     * and Equals compares every parameter of the WhiteMage Class, thus we have to test
     * differences in each parameter (name, hp, defence and mana)
     */
    @Test
    void constructorTest() {
        var expectedWhiteMage = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 1);
        var differentWhiteMage1 = new WhiteMage("Logan", turns, 1, 1, 1);
        var differentWhiteMage2 = new WhiteMage(WHITEMAGE_NAME, turns, 5, 1, 1);
        var differentWhiteMage3 = new WhiteMage(WHITEMAGE_NAME, turns, 1, 5, 1);
        var differentWhiteMage4 = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 5);
        var expectedKnight = new Knight("Solaire", turns, 1, 1);

        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertTrue(expectedWhiteMage.equals(expectedWhiteMage));
        assertFalse(expectedWhiteMage.equals(differentWhiteMage1));
        assertFalse(expectedWhiteMage.equals(differentWhiteMage2));
        assertFalse(expectedWhiteMage.equals(differentWhiteMage3));
        assertFalse(expectedWhiteMage.equals(differentWhiteMage4));
        assertFalse(expectedWhiteMage.equals(expectedKnight));
    }

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testWhiteMage.getEquippedWeapon());
        testWhiteMage.equipSword(testSword);
        assertNull(testWhiteMage.getEquippedWeapon());
        testWhiteMage.equipKnife(testKnife);
        assertNull(testWhiteMage.getEquippedWeapon());
        testWhiteMage.equipAxe(testAxe);
        assertNull(testWhiteMage.getEquippedWeapon());
        testWhiteMage.equipBow(testBow);
        assertNull(testWhiteMage.getEquippedWeapon());

        testWhiteMage.equipStaff(testStaff);
        assertEquals(testStaff, testWhiteMage.getEquippedWeapon());

        WhiteMage differentWhiteMage1 = new WhiteMage("Logan", turns, 0, 1, 1);
        differentWhiteMage1.equipStaff(testStaff);
        assertNull(differentWhiteMage1.getEquippedWeapon());
    }
}