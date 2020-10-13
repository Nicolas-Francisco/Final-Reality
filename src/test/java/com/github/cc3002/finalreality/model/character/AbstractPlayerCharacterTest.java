package com.github.cc3002.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
  protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();

}
