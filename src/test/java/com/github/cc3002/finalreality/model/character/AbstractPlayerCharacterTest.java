package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class defines checkConstruction, checkEquip methods and tests the attack to and attacked
 * methods. These methods will be used by each player type to test using inheritance and avoid
 * repeating the same code over and over.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class AbstractPlayerCharacterTest{

  protected static final Sword testSword = new Sword("testSword", 10, 10);
  protected static final Axe testAxe = new Axe("testAxe", 10, 10);
  protected static final Knife testKnife = new Knife("testKnife", 10, 10);
  protected static final Bow testBow = new Bow("testBow", 10, 10);
  protected static final Staff testStaff = new Staff("testStaff", 10, 10);
  protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();

  /**
   * checkConstruction() method.
   * This method tests the equip methods and branches for each player. Magical players have 5
   * attributes (due to mana attribute, which non-magical players do not have). For now, we will
   * create two versions of checkConstruction method, one that receives 4 differentPlayers and
   * another that receives 5.
   */
  protected void checkConstruction(final IPlayer testPlayer,
                                   final IPlayer expectedPlayer,
                                   final IPlayer differentPlayer1,
                                   final IPlayer differentPlayer2,
                                   final IPlayer differentPlayer3,
                                   final Object differentPlayer4){
    assertEquals(testPlayer, expectedPlayer);
    assertEquals(testPlayer.hashCode(), expectedPlayer.hashCode());

    assertTrue(expectedPlayer.equals(expectedPlayer));
    assertEquals(expectedPlayer.hashCode(), expectedPlayer.hashCode());

    assertFalse(expectedPlayer.equals(differentPlayer1));
    assertNotEquals(expectedPlayer.hashCode(), differentPlayer1.hashCode());

    assertFalse(expectedPlayer.equals(differentPlayer2));
    assertNotEquals(expectedPlayer.hashCode(), differentPlayer2.hashCode());

    assertFalse(expectedPlayer.equals(differentPlayer3));
    assertNotEquals(expectedPlayer.hashCode(), differentPlayer3.hashCode());

    assertFalse(expectedPlayer.equals(differentPlayer4));
    assertNotEquals(expectedPlayer.hashCode(), differentPlayer4.hashCode());
  }

  protected void checkConstruction(final IPlayer testPlayer,
                                   final IPlayer expectedPlayer,
                                   final IPlayer differentPlayer1,
                                   final IPlayer differentPlayer2,
                                   final IPlayer differentPlayer3,
                                   final IPlayer differentPlayer4,
                                   final Object differentPlayer5){
    assertEquals(testPlayer, expectedPlayer);
    assertEquals(testPlayer.hashCode(), expectedPlayer.hashCode());

    assertTrue(expectedPlayer.equals(expectedPlayer));
    assertEquals(expectedPlayer.hashCode(), expectedPlayer.hashCode());

    assertFalse(expectedPlayer.equals(differentPlayer1));
    assertNotEquals(expectedPlayer.hashCode(), differentPlayer1.hashCode());

    assertFalse(expectedPlayer.equals(differentPlayer2));
    assertNotEquals(expectedPlayer.hashCode(), differentPlayer2.hashCode());

    assertFalse(expectedPlayer.equals(differentPlayer3));
    assertNotEquals(expectedPlayer.hashCode(), differentPlayer3.hashCode());

    assertFalse(expectedPlayer.equals(differentPlayer4));
    assertNotEquals(expectedPlayer.hashCode(), differentPlayer4.hashCode());

    assertFalse(expectedPlayer.equals(differentPlayer5));
    assertNotEquals(expectedPlayer.hashCode(), differentPlayer5.hashCode());
  }

  /**
   * checkEquip() method.
   * This method tests the equip methods and branches for each player.
   */
  protected void checkEquip(final IPlayer testPlayer,
                            final IPlayer testDeadPlayer,
                            final List<IWeapon> canEquip,
                            final List<IWeapon> cannotEquip){
    assertNull(testPlayer.getEquippedWeapon());
    for (int i = 0; i < cannotEquip.size(); i++){
      testPlayer.equip(cannotEquip.get(i));
      assertNull(testPlayer.getEquippedWeapon());
    }

    for (int i = 0; i < canEquip.size(); i++){
      testPlayer.equip(canEquip.get(i));
      assertEquals(canEquip.get(i), testPlayer.getEquippedWeapon());
      testDeadPlayer.equip(canEquip.get(i));
      assertNull(testDeadPlayer.getEquippedWeapon());
    }
  }

  /**
   * attackTo() tests.
   * This method is equal for all the player classes, thus we can test it in
   * the AbstractPlayerCharacterTest.
   */
  @Test
  void attackToTest(){
    Enemy enemyTest1 = new Enemy("Mimic", turns, 10,50, 3, 10);
    Enemy enemyTest2 = new Enemy("Iudex", turns, 10,0, 6, 20);
    Knight knightTest1 = new Knight("Anri", turns, 25, 5);
    Knight knightTest2 = new Knight("Horace", turns, 0, 4);
    Sword testSword1 = new Sword("Astora's Sword", 10, 8);
    Sword testSword2 = new Sword("Halberd", 8, 5);

    /**
     * attackTo() if the player has not weapons equipped
     */
    knightTest1.attackTo(enemyTest1);
    assertEquals(50, enemyTest1.getHP());
    assertTrue(enemyTest1.IsAlive());

    knightTest1.equip(testSword1);
    knightTest2.equip(testSword2);

    /**
     * attackTo() if the enemy is alive, and if the damage is lower than its life.
     */
    knightTest1.attackTo(enemyTest1);
    assertEquals(43, enemyTest1.getHP());
    assertTrue(enemyTest1.IsAlive());

    /**
     * attackTo() if the enemy is alive, and if the damage is greater than its life.
     */
    enemyTest1.setHP(6);
    assertTrue(enemyTest1.IsAlive());
    knightTest1.attackTo(enemyTest1);
    assertEquals(0, enemyTest1.getHP());
    assertFalse(enemyTest1.IsAlive());

    /**
     * attackTo() if the player's defense is higher than the damage.
     */
    enemyTest1.setHP(10);
    enemyTest1.setAttack(1);
    knightTest1.setHP(10);
    knightTest1.setDefense(100);
    enemyTest1.attackTo(knightTest1);
    assertEquals(10, knightTest1.getHP());
    assertTrue(knightTest1.IsAlive());


    /**
     * attackTo() if the enemy is dead.
     */
    knightTest1.attackTo(enemyTest2);
    assertEquals(0, enemyTest2.getHP());
    assertFalse(enemyTest2.IsAlive());

    /**
     * attackTo() if the player is dead.
     */
    enemyTest1.setHP(10);
    knightTest2.attackTo(enemyTest1);
    assertEquals(10, enemyTest1.getHP());
    assertTrue(enemyTest1.IsAlive());
  }
}