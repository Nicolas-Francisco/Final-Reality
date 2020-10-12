package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolas García Ríos
 * @see AbstractPlayerCharacter
 */
class AbstractPlayerCharacterTest extends AbstractCharacterTest {

  protected static final String BLACKMAGE_NAME = "Vivi";
  protected static final String KNIGHT_NAME = "Adelbert";
  protected static final String WHITEMAGE_NAME = "Eiko";
  protected static final String ENGINEER_NAME = "Cid";
  protected static final String THIEF_NAME = "Zidane";
  protected IWeapon testWeapon;
  protected List<AbstractPlayerCharacter> testPlayers;



  private void tryToEquip(AbstractPlayerCharacter player) {
    player.equip(testWeapon);
  }

/**
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    tryToEquip(testPlayers.get(0));
    testPlayers.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testPlayers.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
*/
  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testPlayers = new ArrayList<>();
  }
}
