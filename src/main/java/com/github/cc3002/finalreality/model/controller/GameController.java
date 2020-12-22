package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The "final reality" game controller.
 *
 * @author Nicolás García Ríos
 */
public class GameController {
    private HashMap<String, IWeapon> inventory;
    private int maxCharacters = 4;
    private ArrayList<IPlayer> gamerParty;
    private ArrayList<Enemy> cpuParty;
    private int alivePlayers;
    private int aliveEnemies;
    private final IEventHandler DeadPlayerHandler = new PlayerHandler(this);
    private final IEventHandler DeadEnemyHandler = new EnemyHandler(this);
    private final BlockingQueue<ICharacter> turnsQueue;
    protected int enemies = new Random().nextInt(3) + 1;
    private ICharacter characterTurn;

    public GameController(){
        this.turnsQueue = new LinkedBlockingQueue<ICharacter>();
        this.inventory = new HashMap<String, IWeapon>();
        this.gamerParty = new ArrayList<IPlayer>();
        this.cpuParty = new ArrayList<Enemy>();
        this.aliveEnemies = 0;
        this.alivePlayers = 0;
    }

    /**
     * startQueue() method puts all the characters to the turns queue.
     */
    public void startQueue(){
        if (this.gamerParty.size() == this.maxCharacters){
            int numberPlayer = 0;
            int numberEnemies = 0;
            while (numberPlayer < this.gamerParty.size()){
                IPlayer player = this.getPlayer(numberPlayer);
                player.waitTurn();
                numberPlayer ++;
            }
            while (numberEnemies < this.cpuParty.size()) {
                Enemy enemy = this.getEnemy(numberEnemies);
                enemy.waitTurn();
                numberEnemies++;
            }
        }
    }

    /**
     * beginTurn() method designs the character who owns the actual turn.
     */
    public void beginTurn(){
        this.characterTurn = turnsQueue.peek();
        System.out.println(this.characterTurn.getName() + "'s turn");
    }

    /**
     * endTurn() method ends the actual turn, making the last character wait.
     */
    public void endTurn(ICharacter character){
        turnsQueue.poll();
        character.waitTurn();
    }

    /**
     * attack() method attacks the second character using the first one. Then it ends its turn
     */
    public void attack(ICharacter attackerCharacter, ICharacter attackedCharacter){
        System.out.println(attackerCharacter.getName() + " attacks " + attackedCharacter.getName());
        attackerCharacter.attackTo(attackedCharacter);
        endTurn(attackedCharacter);
    }

    /**
     * onDeadEnemy() method is triggered when an enemy dies (EnemyHandler). This method reduces the amount
     * of aliveCharacters in the User class and then checks if the gamer wins.
     */
    public void onDeadEnemy(Enemy enemy) {
        this.aliveEnemies --;
        System.out.println(enemy.getName() + " has died");
        if (this.getAliveEnemies() == 0){
            this.victory();
        }
    }

    /**
     * onDeadEnemy() method is triggered when a player dies (PlayerHandler). This method reduces the amount
     * of aliveCharacters in the User class and then checks if the gamer loses.
     */
    public void onDeadPlayer(IPlayer player) {
        this.alivePlayers --;
        System.out.println(player.getName() + " has died");
        if (this.getAlivePlayers() == 0){
            this.gameOver();
        }
    }

    /**
     * putInPlayerParty() method adds a player to the gamer party, with a limit given by the user
     */
    public void putInPlayerParty(IPlayer player){
        if (gamerParty.size() < this.maxCharacters){
            gamerParty.add(player);
            this.alivePlayers ++;
            player.addListener(DeadPlayerHandler);
        }
    }

    /**
     * putInEnemyParty() method adds an enemy to the gamer party, with a limit given by the user
     */
    public void putInEnemyParty(Enemy enemy){
        if (cpuParty.size() < this.maxCharacters){
            cpuParty.add(enemy);
            this.aliveEnemies ++;
            enemy.addListener(DeadEnemyHandler);
        }
    }

    /**
     * createKnight() method creates a Knight with the information given and then it is added to the party
     */
    public void createKnight(String name, int hp , int defense){
        Knight knight = new Knight(name, turnsQueue, hp, defense);
        this.putInPlayerParty(knight);
    }

    /**
     * createThief() method creates a Thief with the information given and then it is added to the party
     */
    public void createThief(String name, int hp , int defense){
        Thief thief = new Thief(name, turnsQueue, hp, defense);
        this.putInPlayerParty(thief);
    }

    /**
     * createEngineer() method creates an Engineer with the information given and then it is added to the party
     */
    public void createEngineer(String name, int hp , int defense){
        Engineer engineer = new Engineer(name, turnsQueue, hp, defense);
        this.putInPlayerParty(engineer);
    }

    /**
     * createWhiteMage() method creates a White Mage with the information given and then it is added to the party
     */
    public void createWhiteMage(String name, int hp , int defense, int mp){
        WhiteMage whitemage = new WhiteMage(name, turnsQueue, hp, defense, mp);
        this.putInPlayerParty(whitemage);
    }

    /**
     * createBlackMage() method creates a Black Mage with the information given and then it is added to the party
     */
    public void createBlackMage(String name, int hp , int defense, int mp){
        BlackMage blackmage = new BlackMage(name, turnsQueue, hp, defense, mp);
        this.putInPlayerParty(blackmage);
    }

    /**
     * equip() method equips a weapon to the player
     */
    public void equip(int playerIndex, String weaponName){
        IWeapon weapon = this.inventory.get(weaponName);
        IPlayer player = this.getPlayer(playerIndex);
        IWeapon currentWeapon = player.getEquippedWeapon();
        player.equip(weapon);
        if (currentWeapon == null){
            if (player.getEquippedWeapon() != null){
                inventory.remove(weapon.getName());
            }
        } else {
            if (player.getEquippedWeapon().hashCode() == weapon.hashCode()){
                inventory.remove(weapon.getName());
                inventory.put(currentWeapon.getName(), currentWeapon);
            }
        }
    }

    /**
     * createEnemy() method creates an Enemy with the information given, and then it is added to the EnemyParty
     */
    public void createEnemy(String name, int hp, int defense, int attack, int weight){
        Enemy enemy = new Enemy(name, turnsQueue, weight, hp, defense, attack);
        this.putInEnemyParty(enemy);
    }

    /**
     * createAxe() method creates an axe with the information given and then it is added to the inventory
     */
    public void createAxe(String name, int damage, int weight){
        Axe axe = new Axe(name, damage, weight);
        inventory.put(axe.getName(), axe);
    }

    /**
     * createBow() method creates a bow with the information given and then it is added to the inventory
     */
    public void createBow(String name, int damage, int weight){
        Bow bow = new Bow(name, damage, weight);
        inventory.put(bow.getName(), bow);
    }

    /**
     * createKnife() method creates a knife with the information given and then it is added to the inventory
     */
    public void createKnife(String name, int damage, int weight){
        Knife knife = new Knife(name, damage, weight);
        inventory.put(knife.getName(), knife);
    }

    /**
     * createStaff() method creates a staff with the information given and then it is added to the inventory
     */
    public void createStaff(String name, int damage, int weight){
        Staff staff = new Staff(name, damage, weight);
        inventory.put(staff.getName(), staff);
    }

    /**
     * createSword() method creates a sword with the information given and then it is added to the inventory
     */
    public void createSword(String name, int damage, int weight){
        Sword sword = new Sword(name, damage, weight);
        inventory.put(sword.getName(), sword);
    }

    /**
     * gameOver() finalizes the game when the gamer loses.
     */
    public void gameOver(){
        System.out.println("YOU DIED");
    }

    /**
     * victory() finalizes the game when the gamer wins.
     */
    public void victory(){
        System.out.println("HEIR OF FIRE DESTROYED");
    }

    /**
     * getters methods.
     */
    public ArrayList<IPlayer> getGamerParty(){return this.gamerParty;}

    public ArrayList<Enemy> getCpuParty(){return this.cpuParty;}

    public HashMap<String, IWeapon> getInventory(){return this.inventory;}

    public int getAlivePlayers(){return this.alivePlayers;}

    public int getAliveEnemies(){return this.aliveEnemies;}

    public Enemy getEnemy(int enemyIndex){
        return this.getCpuParty().get(enemyIndex);
    }

    public IPlayer getPlayer(int playerIndex){
        return this.getGamerParty().get(playerIndex);
    }

    public ICharacter getCharacterTurn(){
        return this.characterTurn;
    }

    public IWeapon getEquippedWeapon(int playerIndex){
        return this.getPlayer(playerIndex).getEquippedWeapon();
    }
}