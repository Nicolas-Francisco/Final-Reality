package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ControllerTest {
    protected Thief testThief;
    protected Knight testKnight;
    protected Engineer testEngineer;
    protected WhiteMage testWhiteMage;
    protected BlackMage testBlackMage;

    protected Sword testSword;
    protected Axe testAxe;
    protected Knife testKnife;
    protected Bow testBow;
    protected Staff testStaff;

    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();

    @BeforeEach
    public void setUp(){
        testThief = new Thief("testThief", turns, 10, 10);
        testKnight = new Knight("testKnight", turns, 10, 10);
        testEngineer = new Engineer("testEngineer", turns, 10, 10);
        testWhiteMage = new WhiteMage("testWhiteMage", turns, 10, 10, 10);
        testBlackMage = new BlackMage("testBlackMage", turns, 10, 10, 10);

        testSword = new Sword("testSword", 10, 10);
        testAxe = new Axe("testAxe", 10, 10);
        testKnife = new Knife("testKnife", 10, 10);
        testBow = new Bow("testBow", 10, 10);
        testStaff = new Staff("testStaff", 10, 10);
    }
}
