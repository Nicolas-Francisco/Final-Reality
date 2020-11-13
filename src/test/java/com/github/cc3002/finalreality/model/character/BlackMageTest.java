package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * This testing class tests all the methods of a BlackMage player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class BlackMageTest extends AbstractPlayerCharacterTest {

    private static final String BLACKMAGE_NAME = "Vivi";
    private BlackMage testBlackMage;
    private IPlayer expectedBlackMage;
    private IPlayer differentBlackMage1;
    private IPlayer differentBlackMage2;
    private IPlayer differentBlackMage3;
    private IPlayer differentBlackMage4;
    private Object differentBlackMage5;

    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testBlackMage = new BlackMage(BLACKMAGE_NAME, turns, 1, 1, 1);
        expectedBlackMage = new BlackMage(BLACKMAGE_NAME, turns, 1, 1, 1);
        differentBlackMage1 = new BlackMage("Saruman", turns, 1, 1, 1);
        differentBlackMage2 = new BlackMage(BLACKMAGE_NAME, turns, 5, 1, 1);
        differentBlackMage3 = new BlackMage(BLACKMAGE_NAME, turns, 1, 5, 1);
        differentBlackMage4 = new BlackMage(BLACKMAGE_NAME, turns, 1, 1, 5);
        differentBlackMage5 = new Object();
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
        checkConstruction(testBlackMage, expectedBlackMage, differentBlackMage1, differentBlackMage2, differentBlackMage3,
                differentBlackMage4, differentBlackMage5);
    }

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        List<IWeapon> cannotEquip = new ArrayList<IWeapon>();
        cannotEquip.add(testSword);
        cannotEquip.add(testAxe);
        cannotEquip.add(testBow);

        List<IWeapon> canEquip = new ArrayList<IWeapon>();
        canEquip.add(testKnife);
        canEquip.add(testStaff);

        BlackMage testDeadBlackMage = new BlackMage("Saruman", turns, 0, 1, 1);

        checkEquip(testBlackMage, testDeadBlackMage, canEquip, cannotEquip);
    }

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
}