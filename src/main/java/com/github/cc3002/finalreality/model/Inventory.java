package com.github.cc3002.finalreality.model;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import java.util.HashMap;

/**
 * A class that represents the user's inventory
 *
 * @author Nicolás García Ríos
 */
public class Inventory {
    private HashMap<String, IWeapon> inventory;
    private final int Limit = 10;

    public Inventory(){
        this.inventory = new HashMap<String, IWeapon>();
    }

    /**
     * getter method of the inventory
     */
    public HashMap<String, IWeapon> getInventory() {
        return inventory;
    }

    /**
     * addToInventory() checks the size of the hashmap. If the inventory is full,
     * it won't add anything to the inventory
     */
    public void addToInventory(IWeapon weapon){
        if (this.getInventory().size() < Limit) {
            this.getInventory().put(weapon.getName(), weapon);
        }
    }

    /**
     * removes an item from the inventory
     */
    public void removeFromInventory(String name){
        if (this.getInventory().containsKey(name)){
            this.getInventory().remove(name);
        }
    }

    /**
     * isEmpty() method checks if the inventory is empty
     */
    public boolean isEmpty(){
        return (this.getInventory().size()==0);
    }

    /**
     * getDamage() returns the weapon's damage. If its not in the inventory, returns -1
     */
    public int getDamage(String name){
        if (this.getInventory().containsKey(name)){
            return this.getInventory().get(name).getDamage();
        }
        return -1;
    }

    /**
     * getWeight() returns the weapon's weight. If its not in the inventory, returns -1
     */
    public int getWeight(String name){
        if (this.getInventory().containsKey(name)){
            return this.getInventory().get(name).getWeight();
        }
        return -1;
    }
}

