package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This testing class tests all the methods of a Enemy Character.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 */
public class EnemyTest{

  /**
   * Name, Enemy and the BlockingQueue for the constructor to test with
   */
  protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
  private static final String ENEMY_NAME = "Goblin";
  private Enemy testEnemy = new Enemy(ENEMY_NAME, turns, 10,1, 1, 1);

  /**
   * This method tests the waitTurn() method if the character is a enemy.
   * In this case we test only with a enemy character.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testEnemy.waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testEnemy, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method tests the construction method.
   * Because every Hashcode() and Equals() is different in every Class, we have to
   * test every branch and any difference between characters. In this case, the Hashcode
   * and Equals compares every parameter of the enemy character, thus we have to test
   * differences in each parameter (name, hp, defence and attack)
   */
  @Test
  void constructorTest() {
    var expectedEnemy = new Enemy(ENEMY_NAME,turns, 10, 1, 1, 1);
    var differentEnemy1 = new Enemy("Mimic", turns, 10, 1, 1, 1);
    var differentEnemy2 = new Enemy(ENEMY_NAME, turns, 15, 1, 1, 1);
    var differentEnemy3 = new Enemy(ENEMY_NAME, turns, 10, 5, 1, 1);
    var differentEnemy4 = new Enemy(ENEMY_NAME, turns, 10, 1, 5, 1);
    var differentEnemy5 = new Enemy(ENEMY_NAME, turns, 10, 1, 1, 5);
    var expectedKnight = new Knight("Solaire", turns, 1, 1);

    assertTrue(testEnemy.equals(expectedEnemy));
    assertEquals(testEnemy.hashCode(), expectedEnemy.hashCode());

    assertTrue(expectedEnemy.equals(expectedEnemy));
    assertEquals(expectedEnemy.hashCode(), expectedEnemy.hashCode());

    assertFalse(expectedEnemy.equals(differentEnemy1));
    assertNotEquals(expectedEnemy.hashCode(), differentEnemy1.hashCode());

    assertFalse(expectedEnemy.equals(differentEnemy2));
    assertNotEquals(expectedEnemy.hashCode(), differentEnemy2.hashCode());

    assertFalse(expectedEnemy.equals(differentEnemy3));
    assertNotEquals(expectedEnemy.hashCode(), differentEnemy3.hashCode());

    assertFalse(expectedEnemy.equals(differentEnemy4));
    assertNotEquals(expectedEnemy.hashCode(), differentEnemy4.hashCode());

    assertFalse(expectedEnemy.equals(differentEnemy5));
    assertNotEquals(expectedEnemy.hashCode(), differentEnemy5.hashCode());

    assertFalse(expectedEnemy.equals(expectedKnight));
    assertNotEquals(expectedEnemy.hashCode(), expectedKnight.hashCode());
  }

  /**
   * attackTo() tests.
   */
  @Test
  void attackToTest(){
    Enemy enemyTest1 = new Enemy("Mimic", turns, 10,50, 3, 10);
    Enemy enemyTest2 = new Enemy("Iudex", turns, 10,0, 6, 20);
    Knight knightTest1 = new Knight("Anri", turns, 25, 5);
    Knight knightTest2 = new Knight("Horace", turns, 0, 4);
    Sword testSword1 = new Sword("Astora's Sword", 10, 8);
    knightTest1.equip(testSword1);

    /**
     * attackTo() if the player is alive, and if the damage is lower than its life.
     */
    enemyTest1.attackTo(knightTest1);
    assertEquals(20, knightTest1.getHP());
    assertTrue(knightTest1.IsAlive());

    /**
     * attackTo() if the player is alive, and if the damage is greater than its life.
     */
    knightTest1.setHP(4);
    assertTrue(knightTest1.IsAlive());
    enemyTest1.attackTo(knightTest1);
    assertEquals(0, knightTest1.getHP());
    assertFalse(knightTest1.IsAlive());

    /**
     * attackTo() if the enemy's defense is higher than the damage.
     */
    knightTest1.setHP(10);
    enemyTest1.setHP(10);
    enemyTest1.setDefense(100);
    knightTest1.attackTo(enemyTest1);
    assertEquals(10, enemyTest1.getHP());
    assertTrue(enemyTest1.IsAlive());

    /**
     * attackTo() if the player is dead.
     */
    enemyTest1.attackTo(knightTest2);
    assertEquals(0, knightTest2.getHP());
    assertFalse(knightTest2.IsAlive());

    /**
     * attackTo() if the enemy is dead.
     */
    knightTest1.setHP(10);
    enemyTest2.attackTo(knightTest1);
    assertEquals(10, knightTest1.getHP());
    assertTrue(knightTest1.IsAlive());
  }
}