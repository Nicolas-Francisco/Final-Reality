package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.model.controller.GameController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Main entry point for the application.
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás García Ríos
 */
public class FinalReality extends Application {
  private GameController controller = new GameController();
  private Font frTitleFont = Font.loadFont("file:images/finalf.ttf", 70);
  private Font frMainFont1 = Font.loadFont("file:images/Final-Fantasy.ttf", 12);
  private Font frMainFont2 = Font.loadFont("file:images/Final-Fantasy.ttf", 20);

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    primaryStage.setTitle("Final reality");
    mainScene(primaryStage);
  }

  public void mainScene(Stage primaryStage) throws FileNotFoundException {
    Group root = new Group();

    // Texts
    Label title = new Label("FINAL REALITY");
    Label firma = new Label("created by BlackFire");

    title.setFont(frTitleFont);
    firma.setFont(frMainFont1);

    title.setTextFill(Color.web("#000000"));
    firma.setTextFill(Color.web("#000000"));

    title.setLayoutX(172);
    title.setLayoutY(120);

    firma.setLayoutX(462);
    firma.setLayoutY(440);

    root.getChildren().addAll(title, firma);

    //Background
    Image menu = new Image(new FileInputStream("images/main.jpg"));
    ImageView background = new ImageView(menu);
    background.setMouseTransparent(true);
    background.setOpacity(0.75);
    background.setViewOrder(0.4);
    background.isPreserveRatio();

    root.getChildren().add(background);

    // Buttons
    Button startButton = new Button("New Game");
    Button continueButton = new Button("Continue");

    startButton.setFont(frMainFont1);
    continueButton.setFont(frMainFont1);

    startButton.setLayoutX(274);
    startButton.setLayoutY(220);

    continueButton.setLayoutX(278);
    continueButton.setLayoutY(250);

    root.getChildren().addAll(startButton, continueButton);

    startButton.setOnAction(event -> creationScene(primaryStage, background));

    // Draw the main scene
    Scene scene = new Scene(root, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void creationScene(Stage primaryStage, ImageView background){
    Group creationRoot = new Group();
    creationRoot.getChildren().add(background);

    int currentCharactersLeft = 4 - controller.getAlivePlayers();

    // Texts
    Label creationTitle = new Label("Choose the Class of your new Character");
    Label creationSubTitle = new Label(currentCharactersLeft +" Character left");

    Label creationKnightText1 = new Label("HP      35");
    Label creationKnightText2 = new Label("DEF   20");
    Label creationThiefText1 = new Label("HP      30");
    Label creationThiefText2 = new Label("DEF   16");
    Label creationEngineerText1 = new Label("HP      33");
    Label creationEngineerText2 = new Label("DEF   18");
    Label creationWhiteMageText1 = new Label("HP      25");
    Label creationWhiteMageText2 = new Label("DEF  15");
    Label creationWhiteMageText3 = new Label("MP       15");
    Label creationBlackMageText1 = new Label("HP      27");
    Label creationBlackMageText2 = new Label("DEF   15");
    Label creationBlackMageText3 = new Label("MP       15");


    creationTitle.setFont(frMainFont2);
    creationSubTitle.setFont(frMainFont1);

    creationKnightText1.setFont(frMainFont1);
    creationThiefText1.setFont(frMainFont1);
    creationEngineerText1.setFont(frMainFont1);
    creationWhiteMageText1.setFont(frMainFont1);
    creationBlackMageText1.setFont(frMainFont1);

    creationKnightText2.setFont(frMainFont1);
    creationThiefText2.setFont(frMainFont1);
    creationEngineerText2.setFont(frMainFont1);
    creationWhiteMageText2.setFont(frMainFont1);
    creationBlackMageText2.setFont(frMainFont1);

    creationWhiteMageText3.setFont(frMainFont1);
    creationBlackMageText3.setFont(frMainFont1);

    creationTitle.setTextFill(Color.web("#000000"));
    creationSubTitle.setTextFill(Color.web("#000000"));

    creationTitle.setLayoutX(50);
    creationTitle.setLayoutY(10);

    creationSubTitle.setLayoutX(250);
    creationSubTitle.setLayoutY(40);

    creationRoot.getChildren().addAll(creationTitle, creationSubTitle);

    // Buttons
    Button createKnightButton = new Button("Knight");
    Button createThiefButton = new Button("Thief");
    Button createEngineerButton = new Button("Engineer");
    Button createWhiteMageButton = new Button("White Mage");
    Button createBlackMageButton = new Button("Black Mage");
    Button backToMenuButton = new Button("Back to menu");

    createKnightButton.setFont(frMainFont1);
    createThiefButton.setFont(frMainFont1);
    createEngineerButton.setFont(frMainFont1);
    createWhiteMageButton.setFont(frMainFont1);
    createBlackMageButton.setFont(frMainFont1);
    backToMenuButton.setFont(frMainFont1);

    createKnightButton.setLayoutX(100);
    createKnightButton.setLayoutY(130);
    creationKnightText1.setLayoutX(100);
    creationKnightText1.setLayoutY(160);
    creationKnightText2.setLayoutX(100);
    creationKnightText2.setLayoutY(175);

    createThiefButton.setLayoutX(290);
    createThiefButton.setLayoutY(130);
    creationThiefText1.setLayoutX(290);
    creationThiefText1.setLayoutY(160);
    creationThiefText2.setLayoutX(290);
    creationThiefText2.setLayoutY(175);

    createEngineerButton.setLayoutX(450);
    createEngineerButton.setLayoutY(130);
    creationEngineerText1.setLayoutX(460);
    creationEngineerText1.setLayoutY(160);
    creationEngineerText2.setLayoutX(460);
    creationEngineerText2.setLayoutY(175);

    createWhiteMageButton.setLayoutX(180);
    createWhiteMageButton.setLayoutY(250);
    creationWhiteMageText1.setLayoutX(200);
    creationWhiteMageText1.setLayoutY(280);
    creationWhiteMageText2.setLayoutX(200);
    creationWhiteMageText2.setLayoutY(295);
    creationWhiteMageText3.setLayoutX(200);
    creationWhiteMageText3.setLayoutY(310);

    createBlackMageButton.setLayoutX(360);
    createBlackMageButton.setLayoutY(250);
    creationBlackMageText1.setLayoutX(380);
    creationBlackMageText1.setLayoutY(280);
    creationBlackMageText2.setLayoutX(380);
    creationBlackMageText2.setLayoutY(295);
    creationBlackMageText3.setLayoutX(380);
    creationBlackMageText3.setLayoutY(310);

    backToMenuButton.setLayoutX(10);
    backToMenuButton.setLayoutY(430);

    creationRoot.getChildren().addAll(createKnightButton, createThiefButton, createEngineerButton,
            createWhiteMageButton, createBlackMageButton, backToMenuButton, creationKnightText1,
            creationKnightText2, creationThiefText1, creationThiefText2, creationEngineerText1,
            creationEngineerText2, creationWhiteMageText1, creationWhiteMageText2, creationBlackMageText1,
            creationBlackMageText2, creationWhiteMageText3, creationBlackMageText3);

    createKnightButton.setOnAction(event -> createKnight(primaryStage, background));
    createThiefButton.setOnAction(event -> createThief(primaryStage, background));
    createEngineerButton.setOnAction(event -> createEngineer(primaryStage, background));
    createWhiteMageButton.setOnAction(event -> createWhiteMage(primaryStage, background));
    createBlackMageButton.setOnAction(event -> createBlackMage(primaryStage, background));

    // Draw the creation scene
    Scene creationScene = new Scene(creationRoot, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(creationScene);
    primaryStage.show();
  }

  public void createKnight(Stage primaryStage, ImageView background){
    Group creationRoot = new Group();
    creationRoot.getChildren().add(background);

    // Texts
    Label creationTitle = new Label("Create Your Knight");
    Label creationSubTitle1 = new Label("Choose Your Name");
    Label creationSubTitle2 = new Label("Choose 2 weapons");

    creationTitle.setFont(frMainFont2);
    creationSubTitle1.setFont(frMainFont1);
    creationSubTitle2.setFont(frMainFont1);

    Label weapon1 = new Label("Claymore");
    Label weapon1w = new Label("W    22");
    Label weapon1d = new Label("D    18");

    Label weapon2 = new Label("Corvian knife");
    Label weapon2w = new Label("W    12");
    Label weapon2d = new Label("D    10");

    Label weapon3 = new Label("BlackKnight Axe");
    Label weapon3w = new Label("W    25");
    Label weapon3d = new Label("D    20");

    weapon1.setFont(frMainFont1);
    weapon1w.setFont(frMainFont1);
    weapon1d.setFont(frMainFont1);
    weapon2.setFont(frMainFont1);
    weapon2w.setFont(frMainFont1);
    weapon2d.setFont(frMainFont1);
    weapon3.setFont(frMainFont1);
    weapon3w.setFont(frMainFont1);
    weapon3d.setFont(frMainFont1);

    creationTitle.setTextFill(Color.web("#000000"));
    creationSubTitle1.setTextFill(Color.web("#000000"));
    creationSubTitle2.setTextFill(Color.web("#000000"));

    creationTitle.setLayoutX(190);
    creationTitle.setLayoutY(10);

    creationSubTitle1.setLayoutX(240);
    creationSubTitle1.setLayoutY(100);

    creationSubTitle2.setLayoutX(242);
    creationSubTitle2.setLayoutY(180);

    creationRoot.getChildren().addAll(creationTitle, creationSubTitle1, creationSubTitle2);

    // Text Field
    TextField textNameCharacter = new TextField();
    textNameCharacter.setFont(frMainFont1);
    textNameCharacter.setText("");
    textNameCharacter.setAlignment(Pos.CENTER);

    textNameCharacter.setLayoutX(235);
    textNameCharacter.setLayoutY(130);

    creationRoot.getChildren().add(textNameCharacter);

    // Grid
    GridPane weapon1Grid = new GridPane();
    weapon1Grid.addRow(0, weapon1);
    weapon1Grid.addRow(1, weapon1d);
    weapon1Grid.addRow(2, weapon1w);

    GridPane weapon2Grid = new GridPane();
    weapon2Grid.addRow(0, weapon2);
    weapon2Grid.addRow(1, weapon2d);
    weapon2Grid.addRow(2, weapon2w);

    GridPane weapon3Grid = new GridPane();
    weapon3Grid.addRow(0, weapon3);
    weapon3Grid.addRow(1, weapon3d);
    weapon3Grid.addRow(2, weapon3w);

    weapon1Grid.setLayoutX(100);
    weapon1Grid.setLayoutY(240);

    weapon2Grid.setLayoutX(240);
    weapon2Grid.setLayoutY(240);

    weapon3Grid.setLayoutX(400);
    weapon3Grid.setLayoutY(240);

    creationRoot.getChildren().addAll(weapon1Grid, weapon2Grid, weapon3Grid);

    // Buttons
    Button createButton = new Button("Create");

    Button createweapon1Button = new Button("Sword");
    Button createweapon2Button = new Button("Knife");
    Button createweapon3Button = new Button("Axe");

    createButton.setFont(frMainFont1);
    createweapon1Button.setFont(frMainFont1);
    createweapon2Button.setFont(frMainFont1);
    createweapon3Button.setFont(frMainFont1);

    createButton.setLayoutX(280);
    createButton.setLayoutY(400);

    weapon1Grid.addRow(3, createweapon1Button);
    weapon2Grid.addRow(3, createweapon2Button);
    weapon3Grid.addRow(3, createweapon3Button);

    createButton.setOnAction(event -> {
        controller.createKnight(textNameCharacter.getText(), 35, 20);
        if (controller.getAlivePlayers() == 4){
            selectionEnemyScene(primaryStage, background);
        } else {
            creationScene(primaryStage, background);
        }
    });

    createweapon1Button.setOnAction(event -> {
        controller.createSword("Claymore", 18, 22);
    });

    createweapon2Button.setOnAction(event -> {
        controller.createKnife("Corvian knife", 10, 10);
    });

    createweapon3Button.setOnAction(event -> {
        controller.createAxe("Blacknight Axe", 20, 25);
    });

    creationRoot.getChildren().add(createButton);

    // Draw the creation scene
    Scene creationScene = new Scene(creationRoot, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(creationScene);
    primaryStage.show();
  }

  public void createThief(Stage primaryStage, ImageView background){
    Group creationRoot = new Group();
    creationRoot.getChildren().add(background);

    // Texts
    Label creationTitle = new Label("Create Your Thief");
    Label creationSubTitle1 = new Label("Choose Your Name");
    Label creationSubTitle2 = new Label("Choose 2 weapons");

    Label weapon1 = new Label("Broadsword");
    Label weapon1w = new Label("W    12");
    Label weapon1d = new Label("D    10");

    Label weapon2 = new Label("Bandit's knife");
    Label weapon2w = new Label("W    10");
    Label weapon2d = new Label("D    10");

    Label weapon3 = new Label("Bow of Pharis");
    Label weapon3w = new Label("W    14");
    Label weapon3d = new Label("D    12");

    weapon1.setFont(frMainFont1);
    weapon1w.setFont(frMainFont1);
    weapon1d.setFont(frMainFont1);
    weapon2.setFont(frMainFont1);
    weapon2w.setFont(frMainFont1);
    weapon2d.setFont(frMainFont1);
    weapon3.setFont(frMainFont1);
    weapon3w.setFont(frMainFont1);
    weapon3d.setFont(frMainFont1);

    creationTitle.setFont(frMainFont2);
    creationSubTitle1.setFont(frMainFont1);
    creationSubTitle2.setFont(frMainFont1);

    creationTitle.setTextFill(Color.web("#000000"));
    creationSubTitle1.setTextFill(Color.web("#000000"));
    creationSubTitle2.setTextFill(Color.web("#000000"));

    creationTitle.setLayoutX(180);
    creationTitle.setLayoutY(10);

    creationSubTitle1.setLayoutX(240);
    creationSubTitle1.setLayoutY(100);

    creationSubTitle2.setLayoutX(242);
    creationSubTitle2.setLayoutY(180);

    creationRoot.getChildren().addAll(creationTitle, creationSubTitle1, creationSubTitle2);

    // Text Field
    TextField textNameCharacter = new TextField();
    textNameCharacter.setFont(frMainFont1);
    textNameCharacter.setText("");
    textNameCharacter.setAlignment(Pos.CENTER);

    textNameCharacter.setLayoutX(235);
    textNameCharacter.setLayoutY(130);

    creationRoot.getChildren().add(textNameCharacter);

    // Grid
    GridPane weapon1Grid = new GridPane();
    weapon1Grid.addRow(0, weapon1);
    weapon1Grid.addRow(1, weapon1d);
    weapon1Grid.addRow(2, weapon1w);

    GridPane weapon2Grid = new GridPane();
    weapon2Grid.addRow(0, weapon2);
    weapon2Grid.addRow(1, weapon2d);
    weapon2Grid.addRow(2, weapon2w);

    GridPane weapon3Grid = new GridPane();
    weapon3Grid.addRow(0, weapon3);
    weapon3Grid.addRow(1, weapon3d);
    weapon3Grid.addRow(2, weapon3w);

    weapon1Grid.setLayoutX(100);
    weapon1Grid.setLayoutY(240);

    weapon2Grid.setLayoutX(240);
    weapon2Grid.setLayoutY(240);

    weapon3Grid.setLayoutX(400);
    weapon3Grid.setLayoutY(240);

    creationRoot.getChildren().addAll(weapon1Grid, weapon2Grid, weapon3Grid);

    // Buttons
    Button createButton = new Button("Create");

    Button createweapon1Button = new Button("Sword");
    Button createweapon2Button = new Button("Knife");
    Button createweapon3Button = new Button("Bow");

    createButton.setFont(frMainFont1);
    createweapon1Button.setFont(frMainFont1);
    createweapon2Button.setFont(frMainFont1);
    createweapon3Button.setFont(frMainFont1);

    createButton.setLayoutX(280);
    createButton.setLayoutY(400);

    weapon1Grid.addRow(3, createweapon1Button);
    weapon2Grid.addRow(3, createweapon2Button);
    weapon3Grid.addRow(3, createweapon3Button);

    createButton.setOnAction(event -> {
        controller.createThief(textNameCharacter.getText(), 30, 16);
        if (controller.getAlivePlayers() == 4){
            selectionEnemyScene(primaryStage, background);
        } else {
            creationScene(primaryStage, background);
        }
    });

    createweapon1Button.setOnAction(event -> {
        controller.createSword("Broadsword", 10, 12);
    });

    createweapon2Button.setOnAction(event -> {
        controller.createKnife("Bandit's knife", 10, 10);
    });

    createweapon3Button.setOnAction(event -> {
        controller.createAxe("Bow of Pharis", 14, 12);
    });

    creationRoot.getChildren().add(createButton);

    // Draw the creation scene
    Scene creationScene = new Scene(creationRoot, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(creationScene);
    primaryStage.show();
  }

  public void createEngineer(Stage primaryStage, ImageView background){
      Group creationRoot = new Group();
      creationRoot.getChildren().add(background);

      // Texts
      Label creationTitle = new Label("Create Your Engineer");
      Label creationSubTitle1 = new Label("Choose Your Name");
      Label creationSubTitle2 = new Label("Choose 2 weapons");

      Label weapon1 = new Label("Eleonora");
      Label weapon1w = new Label("W    16");
      Label weapon1d = new Label("D    14");

      Label weapon2 = new Label("Demon's Axe");
      Label weapon2w = new Label("W    24");
      Label weapon2d = new Label("D    22");

      Label weapon3 = new Label("Dragonslayer bow");
      Label weapon3w = new Label("W    18");
      Label weapon3d = new Label("D    16");

      weapon1.setFont(frMainFont1);
      weapon1w.setFont(frMainFont1);
      weapon1d.setFont(frMainFont1);
      weapon2.setFont(frMainFont1);
      weapon2w.setFont(frMainFont1);
      weapon2d.setFont(frMainFont1);
      weapon3.setFont(frMainFont1);
      weapon3w.setFont(frMainFont1);
      weapon3d.setFont(frMainFont1);

      creationTitle.setFont(frMainFont2);
      creationSubTitle1.setFont(frMainFont1);
      creationSubTitle2.setFont(frMainFont1);

      creationTitle.setTextFill(Color.web("#000000"));
      creationSubTitle1.setTextFill(Color.web("#000000"));
      creationSubTitle2.setTextFill(Color.web("#000000"));

      creationTitle.setLayoutX(190);
      creationTitle.setLayoutY(10);

      creationSubTitle1.setLayoutX(240);
      creationSubTitle1.setLayoutY(100);

      creationSubTitle2.setLayoutX(242);
      creationSubTitle2.setLayoutY(180);

      creationRoot.getChildren().addAll(creationTitle, creationSubTitle1, creationSubTitle2);

      // Text Field
      TextField textNameCharacter = new TextField();
      textNameCharacter.setFont(frMainFont1);
      textNameCharacter.setText("");
      textNameCharacter.setAlignment(Pos.CENTER);

      textNameCharacter.setLayoutX(235);
      textNameCharacter.setLayoutY(130);

      creationRoot.getChildren().add(textNameCharacter);

      // Grid
      GridPane weapon1Grid = new GridPane();
      weapon1Grid.addRow(0, weapon1);
      weapon1Grid.addRow(1, weapon1d);
      weapon1Grid.addRow(2, weapon1w);

      GridPane weapon2Grid = new GridPane();
      weapon2Grid.addRow(0, weapon2);
      weapon2Grid.addRow(1, weapon2d);
      weapon2Grid.addRow(2, weapon2w);

      GridPane weapon3Grid = new GridPane();
      weapon3Grid.addRow(0, weapon3);
      weapon3Grid.addRow(1, weapon3d);
      weapon3Grid.addRow(2, weapon3w);

      weapon1Grid.setLayoutX(100);
      weapon1Grid.setLayoutY(240);

      weapon2Grid.setLayoutX(240);
      weapon2Grid.setLayoutY(240);

      weapon3Grid.setLayoutX(400);
      weapon3Grid.setLayoutY(240);

      creationRoot.getChildren().addAll(weapon1Grid, weapon2Grid, weapon3Grid);

      // Buttons
      Button createButton = new Button("Create");

      Button createweapon1Button = new Button("Axe 1");
      Button createweapon2Button = new Button("Axe 2");
      Button createweapon3Button = new Button("Bow");

      createButton.setFont(frMainFont1);
      createweapon1Button.setFont(frMainFont1);
      createweapon2Button.setFont(frMainFont1);
      createweapon3Button.setFont(frMainFont1);

      createButton.setLayoutX(280);
      createButton.setLayoutY(400);

      weapon1Grid.addRow(3, createweapon1Button);
      weapon2Grid.addRow(3, createweapon2Button);
      weapon3Grid.addRow(3, createweapon3Button);

      createButton.setOnAction(event -> {
          controller.createEngineer(textNameCharacter.getText(), 33, 18);
          if (controller.getAlivePlayers() == 4){
              selectionEnemyScene(primaryStage, background);
          } else {
              creationScene(primaryStage, background);
          }
      });

      createweapon1Button.setOnAction(event -> {
          controller.createAxe("Eleonora", 14, 16);
      });

      createweapon2Button.setOnAction(event -> {
          controller.createAxe("Demon's Axe", 22, 24);
      });

      createweapon3Button.setOnAction(event -> {
          controller.createAxe("Dragonslayer Bow", 18, 16);
      });

      creationRoot.getChildren().add(createButton);

      // Draw the creation scene
      Scene creationScene = new Scene(creationRoot, 640, 460);
      primaryStage.setResizable(false);
      primaryStage.setScene(creationScene);
      primaryStage.show();
  }

  public void createWhiteMage(Stage primaryStage, ImageView background){
      Group creationRoot = new Group();
      creationRoot.getChildren().add(background);

      // Texts
      Label creationTitle = new Label("Create Your White Mage");
      Label creationSubTitle1 = new Label("Choose Your Name");
      Label creationSubTitle2 = new Label("Choose 2 weapons");

      Label weapon1 = new Label("Izalith Staff");
      Label weapon1w = new Label("W    6");
      Label weapon1d = new Label("D    10");

      Label weapon2 = new Label("Oolacile Staff");
      Label weapon2w = new Label("W    10");
      Label weapon2d = new Label("D    14");

      Label weapon3 = new Label("Archdeacon's Staff");
      Label weapon3w = new Label("W    16");
      Label weapon3d = new Label("D    19");

      weapon1.setFont(frMainFont1);
      weapon1w.setFont(frMainFont1);
      weapon1d.setFont(frMainFont1);
      weapon2.setFont(frMainFont1);
      weapon2w.setFont(frMainFont1);
      weapon2d.setFont(frMainFont1);
      weapon3.setFont(frMainFont1);
      weapon3w.setFont(frMainFont1);
      weapon3d.setFont(frMainFont1);

      creationTitle.setFont(frMainFont2);
      creationSubTitle1.setFont(frMainFont1);
      creationSubTitle2.setFont(frMainFont1);

      creationTitle.setTextFill(Color.web("#000000"));
      creationSubTitle1.setTextFill(Color.web("#000000"));
      creationSubTitle2.setTextFill(Color.web("#000000"));

      creationTitle.setLayoutX(160);
      creationTitle.setLayoutY(10);

      creationSubTitle1.setLayoutX(240);
      creationSubTitle1.setLayoutY(100);

      creationSubTitle2.setLayoutX(242);
      creationSubTitle2.setLayoutY(180);

      creationRoot.getChildren().addAll(creationTitle, creationSubTitle1, creationSubTitle2);

      // Text Field
      TextField textNameCharacter = new TextField();
      textNameCharacter.setFont(frMainFont1);
      textNameCharacter.setText("");
      textNameCharacter.setAlignment(Pos.CENTER);

      textNameCharacter.setLayoutX(235);
      textNameCharacter.setLayoutY(130);

      creationRoot.getChildren().add(textNameCharacter);

      // Grid
      GridPane weapon1Grid = new GridPane();
      weapon1Grid.addRow(0, weapon1);
      weapon1Grid.addRow(1, weapon1d);
      weapon1Grid.addRow(2, weapon1w);

      GridPane weapon2Grid = new GridPane();
      weapon2Grid.addRow(0, weapon2);
      weapon2Grid.addRow(1, weapon2d);
      weapon2Grid.addRow(2, weapon2w);

      GridPane weapon3Grid = new GridPane();
      weapon3Grid.addRow(0, weapon3);
      weapon3Grid.addRow(1, weapon3d);
      weapon3Grid.addRow(2, weapon3w);

      weapon1Grid.setLayoutX(100);
      weapon1Grid.setLayoutY(240);

      weapon2Grid.setLayoutX(240);
      weapon2Grid.setLayoutY(240);

      weapon3Grid.setLayoutX(400);
      weapon3Grid.setLayoutY(240);

      creationRoot.getChildren().addAll(weapon1Grid, weapon2Grid, weapon3Grid);

      // Buttons
      Button createButton = new Button("Create");

      Button createweapon1Button = new Button("Staff 1");
      Button createweapon2Button = new Button("Staff 2");
      Button createweapon3Button = new Button("Staff 3");

      createButton.setFont(frMainFont1);
      createweapon1Button.setFont(frMainFont1);
      createweapon2Button.setFont(frMainFont1);
      createweapon3Button.setFont(frMainFont1);

      createButton.setLayoutX(280);
      createButton.setLayoutY(400);

      weapon1Grid.addRow(3, createweapon1Button);
      weapon2Grid.addRow(3, createweapon2Button);
      weapon3Grid.addRow(3, createweapon3Button);

      createButton.setOnAction(event -> {
          controller.createWhiteMage(textNameCharacter.getText(), 25, 15, 15);
          if (controller.getAlivePlayers() == 4){
              selectionEnemyScene(primaryStage, background);
          } else {
              creationScene(primaryStage, background);
          }
      });

      createweapon1Button.setOnAction(event -> {
          controller.createStaff("Izalith Staff", 10, 6);
      });

      createweapon2Button.setOnAction(event -> {
          controller.createStaff("Oolacile Staff", 14, 10);
      });

      createweapon3Button.setOnAction(event -> {
          controller.createStaff("Archdeacon's Staff", 19, 16);
      });

      creationRoot.getChildren().add(createButton);

      // Draw the creation scene
      Scene creationScene = new Scene(creationRoot, 640, 460);
      primaryStage.setResizable(false);
      primaryStage.setScene(creationScene);
      primaryStage.show();
  }

  public void createBlackMage(Stage primaryStage, ImageView background){
      Group creationRoot = new Group();
      creationRoot.getChildren().add(background);

      // Texts
      Label creationTitle = new Label("Create Your Black Mage");
      Label creationSubTitle1 = new Label("Choose Your Name");
      Label creationSubTitle2 = new Label("Choose 2 weapons");

      Label weapon1 = new Label("Heretic's Staff");
      Label weapon1w = new Label("W    12");
      Label weapon1d = new Label("D    16");

      Label weapon2 = new Label("Manus Catalyst");
      Label weapon2w = new Label("W    18");
      Label weapon2d = new Label("D    25");

      Label weapon3 = new Label("Aquamarine Dagger");
      Label weapon3w = new Label("W    6");
      Label weapon3d = new Label("D    9");

      weapon1.setFont(frMainFont1);
      weapon1w.setFont(frMainFont1);
      weapon1d.setFont(frMainFont1);
      weapon2.setFont(frMainFont1);
      weapon2w.setFont(frMainFont1);
      weapon2d.setFont(frMainFont1);
      weapon3.setFont(frMainFont1);
      weapon3w.setFont(frMainFont1);
      weapon3d.setFont(frMainFont1);

      creationTitle.setFont(frMainFont2);
      creationSubTitle1.setFont(frMainFont1);
      creationSubTitle2.setFont(frMainFont1);

      creationTitle.setTextFill(Color.web("#000000"));
      creationSubTitle1.setTextFill(Color.web("#000000"));
      creationSubTitle2.setTextFill(Color.web("#000000"));

      creationTitle.setLayoutX(160);
      creationTitle.setLayoutY(10);

      creationSubTitle1.setLayoutX(240);
      creationSubTitle1.setLayoutY(100);

      creationSubTitle2.setLayoutX(242);
      creationSubTitle2.setLayoutY(180);

      creationRoot.getChildren().addAll(creationTitle, creationSubTitle1, creationSubTitle2);

      // Text Field
      TextField textNameCharacter = new TextField();
      textNameCharacter.setFont(frMainFont1);
      textNameCharacter.setText("");
      textNameCharacter.setAlignment(Pos.CENTER);

      textNameCharacter.setLayoutX(235);
      textNameCharacter.setLayoutY(130);

      creationRoot.getChildren().add(textNameCharacter);

      // Grid
      GridPane weapon1Grid = new GridPane();
      weapon1Grid.addRow(0, weapon1);
      weapon1Grid.addRow(1, weapon1d);
      weapon1Grid.addRow(2, weapon1w);

      GridPane weapon2Grid = new GridPane();
      weapon2Grid.addRow(0, weapon2);
      weapon2Grid.addRow(1, weapon2d);
      weapon2Grid.addRow(2, weapon2w);

      GridPane weapon3Grid = new GridPane();
      weapon3Grid.addRow(0, weapon3);
      weapon3Grid.addRow(1, weapon3d);
      weapon3Grid.addRow(2, weapon3w);

      weapon1Grid.setLayoutX(100);
      weapon1Grid.setLayoutY(240);

      weapon2Grid.setLayoutX(250);
      weapon2Grid.setLayoutY(240);

      weapon3Grid.setLayoutX(400);
      weapon3Grid.setLayoutY(240);

      creationRoot.getChildren().addAll(weapon1Grid, weapon2Grid, weapon3Grid);

      // Buttons
      Button createButton = new Button("Create");

      Button createweapon1Button = new Button("Staff 1");
      Button createweapon2Button = new Button("Staff 2");
      Button createweapon3Button = new Button("Knife");

      createButton.setFont(frMainFont1);
      createweapon1Button.setFont(frMainFont1);
      createweapon2Button.setFont(frMainFont1);
      createweapon3Button.setFont(frMainFont1);

      createButton.setLayoutX(280);
      createButton.setLayoutY(400);

      weapon1Grid.addRow(3, createweapon1Button);
      weapon2Grid.addRow(3, createweapon2Button);
      weapon3Grid.addRow(3, createweapon3Button);

      createButton.setOnAction(event -> {
          controller.createBlackMage(textNameCharacter.getText(), 23, 15, 15);
          if (controller.getAlivePlayers() == 4){
              selectionEnemyScene(primaryStage, background);
          } else {
              creationScene(primaryStage, background);
          }
      });

      createweapon1Button.setOnAction(event -> {
          controller.createStaff("Heretic's Staff", 16, 12);
      });

      createweapon2Button.setOnAction(event -> {
          controller.createStaff("Manus Catalyst", 25, 18);
      });

      createweapon3Button.setOnAction(event -> {
          controller.createKnife("Aquamarine Dagger", 6, 9);
      });

      creationRoot.getChildren().add(createButton);

      // Draw the creation scene
      Scene creationScene = new Scene(creationRoot, 640, 460);
      primaryStage.setResizable(false);
      primaryStage.setScene(creationScene);
      primaryStage.show();
  }

  public void selectionEnemyScene(Stage primaryStage, ImageView background){
    Group selectionRoot = new Group();
    selectionRoot.getChildren().add(background);

    // Draw the creation scene
    Scene creationScene = new Scene(selectionRoot, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(creationScene);
    primaryStage.show();
  }
}