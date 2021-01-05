package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This testing class tests all the methods of a WhiteMage player.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class WhiteMageTest extends AbstractPlayerCharacterTest {

    private static final String WHITEMAGE_NAME = "Eiko";
    private IPlayer testWhiteMage;
    private IPlayer expectedWhiteMage;
    private IPlayer differentWhiteMage1;
    private IPlayer differentWhiteMage2;
    private IPlayer differentWhiteMage3;
    private IPlayer differentWhiteMage4;
    private Object differentWhiteMage5;

    /**
     * This method creates all the objects that we are going to test with the constructorTest().
     * Using inheritance, we only have to create these objects with different attributes and test them all
     * in the upper method checkConstructor, which tests all the weapons.
     */
    @BeforeEach
    void setUp() {
        testWhiteMage = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 1);
        expectedWhiteMage = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 1);
        differentWhiteMage1 = new WhiteMage("Logan", turns, 1, 1, 1);
        differentWhiteMage2 = new WhiteMage(WHITEMAGE_NAME, turns, 5, 1, 1);
        differentWhiteMage3 = new WhiteMage(WHITEMAGE_NAME, turns, 1, 5, 1);
        differentWhiteMage4 = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 5);
        differentWhiteMage5 = new Object();
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
        checkConstruction(testWhiteMage, expectedWhiteMage, differentWhiteMage1, differentWhiteMage2,
                differentWhiteMage3, differentWhiteMage4, differentWhiteMage5);
        assertEquals(testWhiteMage.getStringClass(), "White Mage");
    }

    /**
     * This method tests the equip methods and branches.
     */
    @Test
    void equipWeaponTest() {
        List<IWeapon> cannotEquip = new ArrayList<IWeapon>();
        cannotEquip.add(testSword);
        cannotEquip.add(testKnife);
        cannotEquip.add(testAxe);
        cannotEquip.add(testBow);

        List<IWeapon> canEquip = new ArrayList<IWeapon>();
        canEquip.add(testStaff);

        WhiteMage testDeadWhiteMage = new WhiteMage("Logan", turns, 0, 1, 1);

        checkEquip(testWhiteMage, testDeadWhiteMage, canEquip, cannotEquip);
    }

    /**
     * This method tests the waitTurn() method if the character is a player.
     * In this case we test only with a whitemage player.
     */
    @Test
    void waitTurnTest() {
        testWhiteMage.equip(testStaff);
        assertTrue(turns.isEmpty());
        testWhiteMage.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            assertEquals(0, turns.size());
            Thread.sleep(200);
            assertEquals(1, turns.size());
            assertEquals(testWhiteMage, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}