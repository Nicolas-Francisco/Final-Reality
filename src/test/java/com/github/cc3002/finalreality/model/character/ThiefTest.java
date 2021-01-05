package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This testing class tests all the methods of a Thief player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class ThiefTest extends AbstractPlayerCharacterTest {

    private static final String THIEF_NAME = "Zidane";    private Thief testThief;
    private IPlayer expectedThief;
    private IPlayer differentThief1;
    private IPlayer differentThief2;
    private IPlayer differentThief3;
    private Object differentThief4;


    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testThief = new Thief(THIEF_NAME, turns, 1, 1);
        expectedThief = new Thief(THIEF_NAME, turns, 1, 1);
        differentThief1 = new Thief("Lautrec", turns, 1, 1);
        differentThief2 = new Thief(THIEF_NAME, turns, 5, 1);
        differentThief3 = new Thief(THIEF_NAME, turns, 1, 5);
        differentThief4 = new Object();
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
        checkConstruction(testThief, expectedThief, differentThief1, differentThief2,
                differentThief3, differentThief4);
        assertEquals(testThief.getStringClass(), "Thief");
    }

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        List<IWeapon> cannotEquip = new ArrayList<IWeapon>();
        cannotEquip.add(testStaff);
        cannotEquip.add(testAxe);

        List<IWeapon> canEquip = new ArrayList<IWeapon>();
        canEquip.add(testBow);
        canEquip.add(testSword);
        canEquip.add(testKnife);

        Thief testDeadThief = new Thief("Greirat", turns, 0, 1);

        checkEquip(testThief, testDeadThief, canEquip, cannotEquip);
    }

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
}