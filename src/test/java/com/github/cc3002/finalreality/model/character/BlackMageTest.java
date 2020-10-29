package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This testing class tests all the methods of a BlackMage player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class BlackMageTest extends AbstractPlayerCharacterTest {

    /**
     * New testing player
     */
    private BlackMage testBlackMage = new BlackMage(BLACKMAGE_NAME, turns, 10, 10, 10);

    /**
     * This method tests the waitTurn() method if the character is a player.
     * In this case we test only with a blackmage player.
     */
    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testBlackMage.equip(testStaff);
        testBlackMage.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testBlackMage, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between players. In this case, the Hashcode
     * and Equals compares every parameter of the BlackMage Class, thus we have to test
     * differences in each parameter (name, hp, defence and mana)
     */
    @Test
    void constructorTest() {
        var expectedBlackMage = new BlackMage(BLACKMAGE_NAME, turns, 1, 1, 1);
        var differentBlackMage1 = new BlackMage("Saruman", turns, 1, 1, 1);
        var differentBlackMage2 = new BlackMage(BLACKMAGE_NAME, turns, 5, 1, 1);
        var differentBlackMage3 = new BlackMage(BLACKMAGE_NAME, turns, 1, 5, 1);
        var differentBlackMage4 = new BlackMage(BLACKMAGE_NAME, turns, 1, 1, 5);
        var expectedKnight = new Knight("Solaire", turns, 1, 1);

        assertEquals(expectedBlackMage, expectedBlackMage);
        assertEquals(expectedBlackMage.hashCode(), expectedBlackMage.hashCode());

        assertTrue(expectedBlackMage.equals(expectedBlackMage));
        assertFalse(expectedBlackMage.equals(differentBlackMage1));
        assertFalse(expectedBlackMage.equals(differentBlackMage2));
        assertFalse(expectedBlackMage.equals(differentBlackMage3));
        assertFalse(expectedBlackMage.equals(differentBlackMage4));
        assertFalse(expectedBlackMage.equals(expectedKnight));
    }

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testBlackMage.getEquippedWeapon());
        testBlackMage.equip(testSword);
        assertNull(testBlackMage.getEquippedWeapon());
        testBlackMage.equip(testAxe);
        assertNull(testBlackMage.getEquippedWeapon());
        testBlackMage.equip(testBow);
        assertNull(testBlackMage.getEquippedWeapon());

        testBlackMage.equip(testKnife);
        assertEquals(testKnife, testBlackMage.getEquippedWeapon());
        testBlackMage.equip(testStaff);
        assertEquals(testStaff, testBlackMage.getEquippedWeapon());

        BlackMage differentBlackMage1 = new BlackMage("Saruman", turns, 0, 1, 1);
        differentBlackMage1.equip(testStaff);
        assertNull(differentBlackMage1.getEquippedWeapon());
        differentBlackMage1.equip(testKnife);
        assertNull(differentBlackMage1.getEquippedWeapon());
    }
}