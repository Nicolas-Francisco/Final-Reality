package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This testing class tests all the methods of a Knight player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class KnightTest extends AbstractPlayerCharacterTest {

    private static final String KNIGHT_NAME = "Adelbert";
    private Knight testKnight;
    private IPlayer expectedKnight;
    private IPlayer differentKnight1;
    private IPlayer differentKnight2;
    private IPlayer differentKnight3;
    private Object differentKnight4;

    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testKnight = new Knight(KNIGHT_NAME, turns, 1, 1);
        expectedKnight = new Knight(KNIGHT_NAME, turns, 1, 1);
        differentKnight1 = new Knight("Solaire", turns, 1, 1);
        differentKnight2 = new Knight(KNIGHT_NAME, turns, 5, 1);
        differentKnight3 = new Knight(KNIGHT_NAME, turns, 1, 5);
        differentKnight4 = new Object();
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
        checkConstruction(testKnight, expectedKnight, differentKnight1, differentKnight2, differentKnight3,
                differentKnight4);
        assertEquals(testKnight.getStringClass(), "Knight");
    }

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        List<IWeapon> cannotEquip = new ArrayList<IWeapon>();
        cannotEquip.add(testStaff);
        cannotEquip.add(testBow);

        List<IWeapon> canEquip = new ArrayList<IWeapon>();
        canEquip.add(testSword);
        canEquip.add(testKnife);
        canEquip.add(testAxe);

        Knight testDeadKnight = new Knight("Solaire", turns, 0, 1);

        checkEquip(testKnight, testDeadKnight, canEquip, cannotEquip);
    }

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
}