package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  protected List<AbstractCharacter> testCharacters;

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns));
  }

  /**
  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11, turns),
        new Knight(ENEMY_NAME, turns));
  }


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