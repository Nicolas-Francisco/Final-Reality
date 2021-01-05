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

    /**
     * starts the waiting stage. From Start, Turn or Selection states to Waiting state.
     */
    @Override
    public void waiting(){
        this.changeState(new WaitingState(this.controller));
    }

    /**
     * ends the game, from Waiting state to Victory state.
     */
    @Override
    public void victory(){
        this.changeState(new VictoryState(this.controller));
        this.controller.victory();
    }

    /**
     * ends the game, from Waiting state to Game Over state.
     */
    @Override
    public void gameOver(){
        this.changeState(new GameOverState(this.controller));
        this.controller.gameOver();
    }

    /**
     * terminate() method terminates the turn completely if the game has not ended.
     */
    @Override
    public void terminate(ICharacter attackedCharacter){
        this.controller.terminateTurn(attackedCharacter);
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

    /**
     * isTurnState() returns true if the game is in TurnState
     */
    @Override
    public boolean isTurnState(){
        return true;
    }
}
