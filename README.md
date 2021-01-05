Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, 
a game developed by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and 
a group of enemies controlled by the computer.

Assumptions
---
- There are only 5 classes of players, which two of them are magical ones (Black Mage and
White Mage), and can equip only one weapon at a time. 

- Enemies cannot equip weapons, and the damage inflicted to the players is determined
by their attack attribute.

- The "Tarea 1" Version only modifies the Design and construction of the Characters and
Weapons, it is not necessary to implement spells, adverse effects, Double Dispatch nor 
Inventory.

- An enemy can attack to a player or another enemy, and a player can attack to an enemy 
or another player.

- The Thief can equip swords, knives and bows.
- The Knight can equip swords, knives and axes.
- The Engineer can equip axes and bows.
- The White Mage can only equip staffs.
- The Black Mage can equip staffs and knives.

- There are two and only two parties in the controller, one exclusive for the players
, and the other one exclusive for the enemies.

- The game will end in two possible ways: If all the enemies die, the player party wins, and the victory method
triggers. However, if all the players die, then the enemy party wins, and the gameOver method 
triggers.

- The game has 6 states in general: Start, Waiting, Selection, Turn, victory and GameOver.

- In the Start state we only can start the game (going to the waiting state) if the 
player party is complete. This represents the "menu of creation" before the actual game.

- In the Waiting-Selection and Turn states we have the actual game. It is a loop of these
three events over and over until some party wins. Waiting state is the state where the game
waits for the players to join the turns queue, Selection is a brief state in which we search
for the next character to start its turn. Finally, the Turn state corresponds to the moment
in which some character decides what to do (in this case, equip and attack). 

- In the Victory and Game Over state we have the end of the game. These states can only be 
accessed through the Turn state (the only moment in the game where somebody could die).

Original Version Design
---
To create the different Characters of this game, we create the Interface **ICharacter** 
that unifies all kinds of characters (both playable and not playable), which is 
implemented by the abstract class **AbstractCharacter**.

From **AbstractCharacter** we extend two classes, Enemy class and Player class. The Enemy
class represents all the enemies of the game, and the Player Class represents every 
playable character. In **AbstractCharacter** we implement two methods that, depending 
on the class, it might work one way or the other, these methods are waitTurn() and
equip() (Enemies can't equip weapons).

Both Weapons and Players have a new parameter called WeaponType and CharacterClass 
respectively, and all the characters can equip only certain types of weapons depending
on the CharacterClass.
 
"Tarea 1" version Design
---

To create the different Characters of this game, we create the Interface **ICharacter** 
that unifies all kinds of characters (both playable and not playable), which is 
implemented by the abstract class **AbstractCharacter**. All the characters from the 
game have the same parameters such as a name, hp (health points), defense, and a 
BlockingQueue for the combat.

The class **Enemy** extends **AbstractCharacter**, this is a character controlled by
the computer and has new parameters, weight and attack. This class also has a waitTurn()
method for the combat.

The abstract class **AbstractPlayerCharacter** extends **AbstractCharacter**, this 
represents a playable character of the game. In this class we have two new important 
methods, waitTurn() (which works different from the enemies' homonym method), and the
equip() method that equips a weapon to the player.

Every character from the game has a specific class, and depending on the class, the 
player might have MP (magic points) to use spells or not, or could equip certain
types of weapons or nat. If we implement a parameter that discriminates these 
abilities (such as CharacterClass parameter) this will make the code extendable (Double
Dispatch). Hence, the classes will figure this out and implement these ideas by themselves.

By the other hand, we have an Interface **IWeapon** which unifies every weapon in the 
game, and for the same reason we don't have a parameter that determines the character 
class, we make different classes depending on the type of weapon, which extends 
**AbstractWeapon** class.

In this version all the original tests are changed in order to test this new Design.

"Entrega Parcial 1 - Tarea 2" version Design
---

The previous design (Tarea 1) does not implement an Inteface for the Player (it is not a good
design to call an Abstract Class, therefore, there must be an Interface). In this new version
we modify this error and create a new Interface IPlayer, which has all equip() methods (described
in the next paragraph) and the get/set methods for the equipped weapon.

Besides this, the design (Tarea 1) stays the same except for equip() method. Using Double
Dispatch we implement a base equip_weapon() for every weapon in the AbstractPlayer Class
that is not implemented in order to avoid errors if we try to equip a weapon that some 
class should not equip. Therefore, every player class overrides equip_weapon() and 
implements it if the weapon type can be used for the player.  

Also, we implement new methods to the Interface ICharacter (shared between players and 
enemies), these methods are attackTo(), attackedBy() and IsAlive(). attackTo() method attacks the 
another character, and IsAlive() method returns a boolean depending on the character's HP.
attackTo() works different if the character that attacks is an enemy or a player, because an
enemy has a specific attribute called attack while the player does not (the damage inflicted
by the player depends on the equipped weapon's damage).


"Tarea 2" version Design
---

In this version we created the controller of the game (GameController class), the inventory of the game
 (controller by the GameController), and the observer for the players and enemies 
 within the game. The IEventHandler interface extends the PropertyChangeListener,
which is extended by two new handlers (PlayerHandler and EnemyHandler, where both are observers of the
players and enemies). Whenever a player or an enemy dies, the onDeadPlayer or on DeadEnemy methods of 
the controller triggers to see if all the enemies or players had died.  

In the controller class we implement all the creation methods to put in both parties and inventory. 
The ones that create characters (such as createKnight, createEnemy, etc.) create the character and adds it
to its party depending on it's class (player or enemy). By the other hand the ones that create
weapons (such as createKnife, createStaff, etc.) create the weapon and then adds it to the inventory.

The inventory is represented by a HashMap using a string as a key (the name of the weapon), 
eliminating the "Inventory" class, while the party is represented by an ArrayList of characters,
 eliminating the "User" class.

"Tarea 3" version Design
---

In this version we create de states of the game using the State patter design and the GUI of the game. 
The game is divided in 6 principal states (Start, Waiting, Selecting, Turn, Victory and Game Over), these 
states and their inner relations are best described in the assumptions title. By the other hand, the GUI 
of the game is a series of methods which modify the primary scene in order to be able to play the game.


Final Reality Game
---

To be able to play the game, you must right-click the "FinalReality.java" archive and select the "Run" option.
Once clicked, a new window called "Final Reality" will open and show the main menu of the game. This scene contains
the name of the game along with two buttons (New Game and Continues), and the name of the creator.

To play the game, you only have to press the "New Game" button which will lead you to the creation Scene. This 
menu is the creation section of the game, where you can create four and only four characters with the classes you want. 
In order to be challenging, all the classes have default values such as the hp, defense, and the mana 
(not yet implemented). Once a class is selected a new scene will open, where you can choose the name of your character
and two weapons maximum. In order to be challenging, the weapons are too created with default values such as the name, 
weight and damage, and only the first two weapons selected will be in the inventory of the game. 

This creation scene allows the player to not choose a name at all (nameless character). It also allows to not select 
a weapon at all, but in this case the game will automatically select the first weapon out of the three shown.

When the player has already created the four characters and their weapons, the Difficulty selection menu will open. In 
order to be easier for the player to test the game, there are 3 buttons which will create different enemies:
- The "Easy" mode of the game will create 2 or 3 weak enemies that can be easily defeated, and was created to test 
the "victory" final more quickly.

- The "Normal" mode will create 4 enemies with more attack power, hp and defense, and was created to test long 
battles between the player and the cpu.

- Finally, the "Final Reality" mode will create impossible enemies with a lots of damage and defense, and was created 
to test the "game over" final more quickly.

When a game mode is selected, the game will wait until all the characters are added to the queue and will show a new
button called "Start". When the "Start" button is pressed, the Game scene will start and show all the alive members 
of the game (player characters and enemies). When a character of the player has the turn, it can equip a different
weapon or attack a certain enemy.

The "Equip" button of the game scene will work only if there are at least 1 weapon in the inventory (the inventory can 
have between 0 and 4 weapons saved). When clicked, it will open the inventory of the player, showing the current data 
of the owner of the turn (class, current weapon equipped and its damage). To change the current wheapon, the player only
has to write the number of the weapon and press the "Enter" button, this will open the game scene again and change the
weapon only if the player is allowed to equip the weapon selected (see the assumption title).

By the other hand, if the player wants to attack a certain enemy, it only has to write down the index of the enemy shown
and press "Attack". If a certain enemy or player is dead, it will disappear of the scene even though it is still in 
the queue, so if the player decides to attack an already dead enemy that is not in the scene the game will attack 
anyway, and the player will lose its turn.

The game will be over when all the players or all the enemies are dead. If all the enemies are gone, the victory scene
will be open and show a victory message. If all the players died, the game over scene will be open and show a game over 
message. In both cases there will be two buttons, "Play Again" or "Try again" and "Close" or "Give Up". "Play Again" and 
"Try again" buttons will start the game again (allowing the player to play multiple rounds), while "Close" and "Give Up" 
buttons will close the window and end the game.

Testing
---
To execute the testings of this work you will need to change the coverage settings as
shown in this [video](https://www.youtube.com/watch?v=VVxERw4cpOY&list=PLUt1A-R2OH5788r_u0y9XeuUVx6thIVkI&index=3).
Then you only have to right-click on **test** package and select **Run 'tests in 
'final...'' with Coverage'**.
