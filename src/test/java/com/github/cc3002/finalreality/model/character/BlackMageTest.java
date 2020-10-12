package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlackMageTest extends AbstractPlayerCharacterTest {

    @BeforeEach
    void setUp() {
        basicSetUp();
        testPlayers.add(new BlackMage(BLACKMAGE_NAME, turns));
    }

    @Test
    void constructorTest() {
        checkConstruction(new BlackMage(BLACKMAGE_NAME, turns),
                testPlayers.get(0),
                new BlackMage("Saruman", turns),
                new WhiteMage("Gandalf", turns));
    }

    @Test
    void equipWeaponTest() {
        BlackMage blackmage = new BlackMage(BLACKMAGE_NAME, turns);
        assertNull(blackmage.getEquippedWeapon());
        blackmage.equip(testWeapon);
        assertEquals(testWeapon, blackmage.getEquippedWeapon());
    }
}