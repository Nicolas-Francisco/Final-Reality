package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ThiefTest extends AbstractPlayerCharacterTest {

    @BeforeEach
    void setUp() {
        basicSetUp();
        testPlayers.add(new Thief(THIEF_NAME, turns));
    }

    @Test
    void constructorTest() {
        checkConstruction(new Thief(THIEF_NAME, turns),
                testPlayers.get(0),
                new Thief("Greirat", turns),
                new Knight("Anri", turns));
    }

    @Test
    void equipWeaponTest() {
        Thief thief = new Thief(THIEF_NAME, turns);
        assertNull(thief.getEquippedWeapon());
        thief.equip(testWeapon);
        assertEquals(testWeapon, thief.getEquippedWeapon());
    }
}