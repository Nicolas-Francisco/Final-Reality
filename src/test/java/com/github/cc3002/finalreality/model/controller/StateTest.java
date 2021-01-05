package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.controller.state.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the Controller of the game.
 *
 * @author Nicolas García Ríos
 */
public class StateTest {
    private GameController controller;
    private GameState baseState;

    @BeforeEach
    public void setUp(){
        controller = new GameController();
        baseState = new GameState(controller);
    }

    @Test
    public void simpleVictoryGameTest(){
        assertTrue(controller.getState().isStartState());
        controller.getState().waiting();
        assertTrue(controller.getState().isWaitingState());
        controller.getState().nextTurn();
        assertTrue(controller.getState().isSelectionState());
        controller.getState().beginTurn();
        assertTrue(controller.getState().isTurnState());
        controller.getState().victory();
        assertTrue(controller.getState().isVictoryState());
    }

    @Test
    public void simpleGameOverGameTest(){
        assertTrue(controller.getState().isStartState());
        controller.getState().waiting();
        assertTrue(controller.getState().isWaitingState());
        controller.getState().nextTurn();
        assertTrue(controller.getState().isSelectionState());
        controller.getState().beginTurn();
        assertTrue(controller.getState().isTurnState());
        controller.getState().gameOver();
        assertTrue(controller.getState().isGameOverState());
    }

    @Test
    public void baseMethodsTest() throws AssertionError{
        boolean method1 = false;
        boolean method2 = false;
        boolean method3 = false;
        boolean method4 = false;
        boolean method5 = false;
        boolean method6 = false;
        boolean method7 = false;

        try{
            baseState.tryToStart();
        } catch(AssertionError e){
            method1 = true;
        }
        assertTrue(method1);

        try{
            baseState.waiting();
        } catch(AssertionError e){
            method2 = true;
        }
        assertTrue(method2);

        try{
            baseState.nextTurn();
        } catch(AssertionError e){
            method3 = true;
        }
        assertTrue(method3);

        try{
            baseState.beginTurn();
        } catch(AssertionError e){
            method4 = true;
        }
        assertTrue(method4);

        try{
            baseState.victory();
        } catch(AssertionError e){
            method5 = true;
        }
        assertTrue(method5);

        try{
            baseState.gameOver();
        } catch(AssertionError e){
            method6 = true;
        }
        assertTrue(method6);

        try{
            baseState.equip(0, "");
        } catch(AssertionError e){
            method7 = true;
        }
        assertTrue(method7);
    }

    @Test
    public void falseAssertionsTests(){
        assertFalse(baseState.isStartState());
        assertFalse(baseState.isWaitingState());
        assertFalse(baseState.isSelectionState());
        assertFalse(baseState.isTurnState());
        assertFalse(baseState.isVictoryState());
        assertFalse(baseState.isGameOverState());
    }
}
