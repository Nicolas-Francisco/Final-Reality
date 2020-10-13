package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
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
  private Enemy testEnemy;

  /**
   * This method tests the waitTurn() method if the character is a enemy.
   * In this case we test only with a enemy character.
   */
  @Test
  void waitTurnTest() {
    testEnemy = new Enemy(ENEMY_NAME, turns, 10,1, 1, 1);
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

    assertEquals(expectedEnemy, expectedEnemy);
    assertEquals(expectedEnemy.hashCode(), expectedEnemy.hashCode());

    assertTrue(expectedEnemy.equals(expectedEnemy));
    assertFalse(expectedEnemy.equals(differentEnemy1));
    assertFalse(expectedEnemy.equals(differentEnemy2));
    assertFalse(expectedEnemy.equals(differentEnemy3));
    assertFalse(expectedEnemy.equals(differentEnemy4));
    assertFalse(expectedEnemy.equals(differentEnemy5));
    assertFalse(expectedEnemy.equals(expectedKnight));
  }

}