package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    protected Thief testThief;
    protected Knight testKnight;
    protected Engineer testEngineer;
    protected WhiteMage testWhiteMage;
    protected BlackMage testBlackMage;
    protected Enemy testEnemy;

    protected Sword testSword;
    protected Axe testAxe;
    protected Knife testKnife;
    protected Bow testBow;
    protected Staff testStaff;

    protected GameController controller;
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();

    @BeforeEach
    public void setUp(){
        testThief = new Thief("testThief", turns, 10, 10);
        testKnight = new Knight("testKnight", turns, 10, 10);
        testEngineer = new Engineer("testEngineer", turns, 10, 10);
        testWhiteMage = new WhiteMage("testWhiteMage", turns, 10, 10, 10);
        testBlackMage = new BlackMage("testBlackMage", turns, 10, 10, 10);
        testEnemy = new Enemy("testEnemy", turns, 10, 10, 10, 10);

        testSword = new Sword("testSword", 10, 10);
        testAxe = new Axe("testAxe", 10, 10);
        testKnife = new Knife("testKnife", 10, 10);
        testBow = new Bow("testBow", 10, 10);
        testStaff = new Staff("testStaff", 10, 10);

        controller = new GameController();
    }

    @Test
    public void createCharactersTest(){
        ArrayList<IPlayer> emptyPlayerList = new ArrayList<>();
        ArrayList<Enemy> emptyEnemyList = new ArrayList<>();
        assertEquals(emptyPlayerList, controller.getGamerParty());
        assertEquals(emptyEnemyList, controller.getCpuParty());

        controller.createKnight("testKnight", 10, 10);
        assertEquals(testKnight.hashCode(), controller.getPlayer(0).hashCode());
        assertEquals(controller.getAlivePlayers(), 1);

        controller.createThief("testThief", 10, 10);
        assertEquals(testThief.hashCode(), controller.getPlayer(1).hashCode());
        assertEquals(controller.getAlivePlayers(), 2);

        controller.createEngineer("testEngineer", 10, 10);
        assertEquals(testEngineer.hashCode(), controller.getPlayer(2).hashCode());
        assertEquals(controller.getAlivePlayers(), 3);

        controller.createWhiteMage("testWhiteMage", 10, 10, 10);
        assertEquals(testWhiteMage.hashCode(), controller.getPlayer(3).hashCode());
        assertEquals(controller.getAlivePlayers(), 4);

        ArrayList<IPlayer> currentParty = controller.getGamerParty();
        controller.createBlackMage("testBlackMage", 10, 10, 10);
        assertEquals(currentParty, controller.getGamerParty());


        assertEquals(controller.getAliveEnemies(), 0);
        controller.createEnemy("testEnemy", 10, 10, 10, 10);
        assertEquals(controller.getAliveEnemies(), controller.enemies);
    }

    @Test
    public void createWeaponTest(){
        HashMap<String, IWeapon> emptyHash = new HashMap<>();
        assertEquals(emptyHash, controller.getInventory());
        controller.createAxe("testAxe", 10, 10);
        assertEquals(controller.getInventory().get("testAxe").hashCode(),
                testAxe.hashCode());

        controller.createBow("testBow", 10, 10);
        assertEquals(controller.getInventory().get("testBow").hashCode(),
                testBow.hashCode());

        controller.createKnife("testKnife", 10, 10);
        assertEquals(controller.getInventory().get("testKnife").hashCode(),
                testKnife.hashCode());

        controller.createStaff("testStaff", 10, 10);
        assertEquals(controller.getInventory().get("testStaff").hashCode(),
                testStaff.hashCode());

        controller.createSword("testSword", 10, 10);
        assertEquals(controller.getInventory().get("testSword").hashCode(),
                testSword.hashCode());
    }

    @Test
    public void equipTest(){
        controller.createKnight("testKnight", 10, 10);
        controller.createThief("testThief", 10, 10);
        controller.createEngineer("testEngineer", 10, 10);
        controller.createWhiteMage("testWhiteMage", 10, 10, 10);

        controller.createAxe("testAxe", 10, 10);
        controller.createKnife("testKnife", 10, 10);
        controller.createStaff("testStaff", 10, 10);
        controller.createSword("testSword", 10, 10);

        assertNull(controller.getEquippedWeapon(0));
        assertNull(controller.getEquippedWeapon(1));
        assertNull(controller.getEquippedWeapon(2));
        assertNull(controller.getEquippedWeapon(3));

        controller.equip(0, "testSword");
        assertEquals(controller.getEquippedWeapon(0).hashCode(), testSword.hashCode());

        controller.equip(1, "testKnife");
        assertEquals(controller.getEquippedWeapon(0).hashCode(), testKnife.hashCode());

        controller.equip(2, "testAxe");
        assertEquals(controller.getEquippedWeapon(0).hashCode(), testAxe.hashCode());

        controller.equip(3, "testStaff");
        assertEquals(controller.getEquippedWeapon(0).hashCode(), testStaff.hashCode());
    }
}
