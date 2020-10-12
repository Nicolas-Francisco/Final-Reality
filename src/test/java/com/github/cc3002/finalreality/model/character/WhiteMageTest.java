package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhiteMageTest extends AbstractPlayerCharacterTest {

    @BeforeEach
    void setUp() {
        basicSetUp();
        testPlayers.add(new WhiteMage(WHITEMAGE_NAME, turns));
    }

    @Test
    void constructorTest() {
        checkConstruction(new WhiteMage(WHITEMAGE_NAME, turns),
                testPlayers.get(0),
                new WhiteMage("Gandalf", turns),
                new BlackMage("Saruman", turns));
    }

    @Test
    void equipWeaponTest() {
        WhiteMage whitemage = new WhiteMage(WHITEMAGE_NAME, turns);
        assertNull(whitemage.getEquippedWeapon());
        whitemage.equip(testWeapon);
        assertEquals(testWeapon, whitemage.getEquippedWeapon());
    }
}