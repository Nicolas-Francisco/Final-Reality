package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class just Creates parameters for all the Testings Classes of each
 * player to use, there is nothing to test in this Abstract Class.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class AbstractPlayerCharacterTest{

  /**
   * Names for each player with a different class and the BlockingQueue
   * "turns" for the constructors of every testing player
   */
  protected static final String BLACKMAGE_NAME = "Vivi";
  protected static final String KNIGHT_NAME = "Adelbert";
  protected static final String WHITEMAGE_NAME = "Eiko";
  protected static final String ENGINEER_NAME = "Cid";
  protected static final String THIEF_NAME = "Zidane";
  protected static final Sword testSword = new Sword("testSword", 10, 10);
  protected static final Axe testAxe = new Axe("testAxe", 10, 10);
  protected static final Knife testKnife = new Knife("testKnife", 10, 10);
  protected static final Bow testBow = new Bow("testBow", 10, 10);
  protected static final Staff testStaff = new Staff("testStaff", 10, 10);
  protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();

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
    knightTest1.equipSword(testSword1);
    knightTest2.equipSword(testSword2);

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
