package com.github.cc3002.finalreality.model.controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The "final reality" game controller.
 *
 * @author Nicolás García Ríos
 */
public class GameController {
    private Inventory inventory;
    private int maxCharacters = 4;
    private User gamer;
    private User cpu;
    private final IEventHandler DeadPlayerHandler = new EnemyHandler(this);
    private final IEventHandler DeadEnemyHandler = new PlayerHandler(this);
    private final BlockingQueue<ICharacter> turnsQueue;
    private int enemies = new Random().nextInt(8) + 1;

    public GameController(){
        this.turnsQueue = new LinkedBlockingQueue<ICharacter>();
        this.inventory = new Inventory();
        this.gamer = new User(maxCharacters);
        this.cpu = new User(maxCharacters);
    }

    public void onDeadEnemy(Enemy enemy) {
        cpu.killCharacter();
        System.out.println(enemy.getName() + " has died");
        if (cpu.getAliveCharacters() == 0){
            this.victory();
        }
    }

    public void onDeadPlayer(IPlayer player) {
        gamer.killCharacter();
        System.out.println(player.getName() + " has died");
        if (gamer.getAliveCharacters() == 0){
            this.gameOver();
        }
    }

    /**
     * create characters
     */
    public void createKnight(User user, String name, int hp , int defense){
        Knight knight = new Knight(name, turnsQueue, hp, defense);
        knight.addListener(DeadPlayerHandler);
        user.putInParty(knight);
    }

    public void createThief(User user, String name, int hp , int defense){
        Thief thief = new Thief(name, turnsQueue, hp, defense);
        thief.addListener(DeadPlayerHandler);
        user.putInParty(thief);
    }

    public void createEngineer(User user, String name, int hp , int defense){
        Engineer engineer = new Engineer(name, turnsQueue, hp, defense);
        engineer.addListener(DeadPlayerHandler);
        user.putInParty(engineer);
    }

    public void createWhiteMage(User user, String name, int hp , int defense, int mp){
        WhiteMage whitemage = new WhiteMage(name, turnsQueue, hp, defense, mp);
        whitemage.addListener(DeadPlayerHandler);
        user.putInParty(whitemage);
    }

    public void createBlackMage(User user, String name, int hp , int defense, int mp){
        BlackMage blackmage = new BlackMage(name, turnsQueue, hp, defense, mp);
        blackmage.addListener(DeadPlayerHandler);
        user.putInParty(blackmage);
    }

    public void equip(IPlayer player, IWeapon weapon){
        IWeapon currentWeapon = player.getEquippedWeapon();
        player.equip(weapon);
        if (player.getEquippedWeapon().hashCode() == weapon.hashCode()){
            inventory.removeFromInventory(weapon.getName());
            inventory.addToInventory(currentWeapon);
        }
    }

    public void createEnemy(User user, String name, int hp, int defense, int attack, int weight){
        Enemy enemy = new Enemy(name, turnsQueue, weight, hp, defense, attack);
        enemy.addListener(DeadEnemyHandler);
        user.putInParty(enemy);
    }

    public void attack(String attackerCharacter, String attackedCharacter){
    }

    /**
     * create weapons
     */
    public void createAxe(String name, int damage, int weight){
        Axe axe = new Axe(name, damage, weight);
        inventory.addToInventory(axe);
    }

    public void createBow(String name, int damage, int weight){
        Bow bow = new Bow(name, damage, weight);
        inventory.addToInventory(bow);
    }

    public void createKnife(String name, int damage, int weight){
        Knife knife = new Knife(name, damage, weight);
        inventory.addToInventory(knife);
    }

    public void createStaff(String name, int damage, int weight){
        Staff staff = new Staff(name, damage, weight);
        inventory.addToInventory(staff);
    }

    public void createSword(String name, int damage, int weight){
        Sword sword = new Sword(name, damage, weight);
        inventory.addToInventory(sword);
    }

    public void gameOver(){
        System.out.println("YOU DIED");
    }

    public void victory(){
        System.out.println("HEIR OF FIRE DESTROYED");
    }
}