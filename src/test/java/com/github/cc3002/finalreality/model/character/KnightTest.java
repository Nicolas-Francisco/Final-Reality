package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This testing class tests all the methods of a Knight player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class KnightTest extends AbstractPlayerCharacterTest {

    /**
     * New testing player
     */
    private Knight testKnight = new Knight(KNIGHT_NAME, turns, 1, 1);

    /**
     * This method tests the waitTurn() method if the character is a player.
     * In this case we test only with a knight player.
     */
    @Test
    void waitTurnTest() {
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

    /**
     * This method tests the construction method.
     * Because every Hashcode() and Equals() is different in every Class, we have to
     * test every branch and any difference between players. In this case, the Hashcode
     * and Equals compares every parameter of the Knight Class, thus we have to test
     * differences in each parameter (name, hp and  defence)
     */
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

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        testKnight.equip(testStaff);
        assertNull(testKnight.getEquippedWeapon());
        testKnight.equip(testBow);
        assertNull(testKnight.getEquippedWeapon());

        testKnight.equip(testSword);
        assertEquals(testSword, testKnight.getEquippedWeapon());
        testKnight.equip(testKnife);
        assertEquals(testKnife, testKnight.getEquippedWeapon());
        testKnight.equip(testAxe);
        assertEquals(testAxe, testKnight.getEquippedWeapon());


        Knight differentKnight1 = new Knight("Solaire", turns, 0, 1);
        differentKnight1.equip(testAxe);
        assertNull(differentKnight1.getEquippedWeapon());
        differentKnight1.equip(testKnife);
        assertNull(differentKnight1.getEquippedWeapon());
        differentKnight1.equip(testSword);
        assertNull(differentKnight1.getEquippedWeapon());
    }
}