package com.github.cc3002.finalreality.model.controller.state;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.controller.GameController;

/**
 * The WaitingState class for the game.
 *
 * @author Nicolás García Ríos
 */
public class TurnState extends GameState{

    public TurnState(GameController controller) {
        super(controller);
    }

    @Override
    public void waiting(){
        this.changeState(new WaitingState(this.controller));
    }

    @Override
    public void victory(){
        this.changeState(new VictoryState(this.controller));
        this.controller.victory();
    }

    @Override
    public void gameOver(){
        this.changeState(new GameOverState(this.controller));
        this.controller.gameOver();
    }

    @Override
    public boolean isTurnState(){
        return true;
    }

    /**
     * tryToEquip() method tries to equip a weapon to the player. Assuming the player can only change
     * the equipped weapon in a turn, and not between two.
     */
    @Override
    public void equip(int playerIndex, String weaponName){
        this.controller.equip(playerIndex, weaponName);
    }

    /**
     * tryToAttack() method tries to attack a character. Assuming that some character can attack to another
     * during a turn only, and not between two.
     */
    @Override
    public void attack(ICharacter attackerCharacter, ICharacter attackedCharacter){
        this.controller.attack(attackerCharacter, attackedCharacter);
    }
}
