package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This testing class tests all the methods of a Engineer player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Cid";
    private Engineer testEngineer;
    private IPlayer expectedEngineer;
    private IPlayer differentEngineer1;
    private IPlayer differentEngineer2;
    private IPlayer differentEngineer3;
    private Object differentEngineer4;

    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testEngineer = new Engineer(ENGINEER_NAME, turns, 1, 1);
        expectedEngineer = new Engineer(ENGINEER_NAME, turns, 1, 1);
        differentEngineer1 = new Engineer("Tony", turns, 1, 1);
        differentEngineer2 = new Engineer(ENGINEER_NAME, turns, 5, 1);
        differentEngineer3 = new Engineer(ENGINEER_NAME, turns, 1, 5);
        differentEngineer4 = new Object();
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
        checkConstruction(testEngineer, expectedEngineer, differentEngineer1, differentEngineer2, differentEngineer3,
                differentEngineer4);
        assertEquals(testEngineer.getStringClass(), "Engineer");
    }

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        List<IWeapon> cannotEquip = new ArrayList<IWeapon>();
        cannotEquip.add(testStaff);
        cannotEquip.add(testSword);
        cannotEquip.add(testKnife);

        List<IWeapon> canEquip = new ArrayList<IWeapon>();
        canEquip.add(testBow);
        canEquip.add(testAxe);

        Engineer testDeadEngineer = new Engineer("Tony", turns, 0, 1);

        checkEquip(testEngineer, testDeadEngineer, canEquip, cannotEquip);
    }

    /**
     * This method tests the waitTurn() method if the character is a player.
     * In this case we test only with a engineer player.
     */
    @Test
    void waitTurnTest() {
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
}