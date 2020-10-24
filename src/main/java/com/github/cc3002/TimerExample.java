package com.github.cc3002;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.character.player.Thief;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Ignacio Slater Muñoz
 * @author Nicolas Garcia Rios
 */
public class TimerExample {

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<ICharacter> queue = new LinkedBlockingQueue<>();
    Random rng = new Random();
    for (int i = 0; i < 10; i++) {
      // Gives a random speed to each character to generate different waiting times
      var weapon = new Knife("", 0, rng.nextInt(50));
      var character = new Thief(Integer.toString(i), queue, 1, 1);
      character.equipKnife(weapon);
      character.waitTurn();
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(queue.poll().getName());
    }
  }
}
