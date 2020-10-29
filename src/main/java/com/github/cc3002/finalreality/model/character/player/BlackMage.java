package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a black mage class.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */

public class BlackMage extends AbstractPlayerCharacter {

    private int MP;

    /**
     * Creates a new player.
     *
     * @param name
     *     the player's name
     * @param turnsQueue
     *     the queue with the player waiting for their turn
     * @param hp
     *     the player's health points
     * @param defense
     *     the character's defense
     * @param mana
     *     the player's magic Points for spells
     */
    public BlackMage(@NotNull String name,
                     @NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull int hp,
                     @NotNull int defense,
                     @NotNull int mana) {
        super(name, turnsQueue, hp, defense);
        this.MP = mana;
    }

    /**
     * get() method for the magic points of the player.
     */
    public int getMP(){
        return MP;
    }

    /**
     * equips a staff to the black mage.
     * A black mage class can only equip a staff or a knife. Hence, we create equipStaff and
     * equipKnife to make sure the black mage can only equip this types of weapons.
     */
    public void equip(Staff staff){
        if (this.IsAlive()){
            this.setEquippedWeapon(staff);
        }
    }

    /**
     * equips a knife to the black mage.
     * A black mage class can only equip a staff or a knife. Hence, we create equipStaff and
     * equipKnife to make sure the black mage can only equip this types of weapons.
     */
    public void equip(Knife knife){
        if (this.IsAlive()){
            this.setEquippedWeapon(knife);
        }
    }

    /**
     * both methods equals() and hashcode() are different depending of the type of character and
     * the type of Character, hence this methods cannot be used with inheritance
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHP(), getDefense(), getMP());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BlackMage)) {
            return false;
        }
        final BlackMage that = (BlackMage) o;
        return getName() == that.getName() &&
                getHP() == that.getHP() &&
                getDefense() == that.getDefense() &&
                getMP() == that.getMP();
    }
}
