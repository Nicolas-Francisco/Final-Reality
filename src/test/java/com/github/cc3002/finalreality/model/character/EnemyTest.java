package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  protected List<AbstractCharacter> testCharacters;

  @Test
  void constructorTest() {
    var expectedEnemy = new Enemy(ENEMY_NAME, 10,turns, 1, 1, 1);
    var diferentEnemy1 = new Enemy("Mimic", 10, turns, 1, 1, 1);
    var diferentEnemy2 = new Enemy(ENEMY_NAME, 15,turns, 1, 1, 1);
    var diferentEnemy3 = new Enemy(ENEMY_NAME, 10,turns, 5, 1, 1);
    var diferentEnemy4 = new Enemy(ENEMY_NAME, 10,turns, 1, 5, 1);
    var diferentEnemy5 = new Enemy(ENEMY_NAME, 10,turns, 1, 1, 5);
    var expectedKnight = new Knight("Solaire", turns, 1, 1);

    assertTrue(expectedEnemy.equals(expectedEnemy));
    assertFalse(expectedEnemy.equals(diferentEnemy1));
    assertFalse(expectedEnemy.equals(diferentEnemy2));
    assertFalse(expectedEnemy.equals(diferentEnemy3));
    assertFalse(expectedEnemy.equals(diferentEnemy4));
    assertFalse(expectedEnemy.equals(diferentEnemy5));
    assertFalse(expectedEnemy.equals(expectedKnight));
  }

  /**
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  */
}