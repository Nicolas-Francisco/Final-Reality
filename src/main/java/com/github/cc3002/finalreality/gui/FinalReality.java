package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.model.controller.GameController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
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
  private int playersCreated = 0;
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

    int currentCharactersLeft = 4 - playersCreated;

    // Texts
    Label creationTitle = new Label("Choose the Class of your new Character");
    Label creationSubTitle = new Label(currentCharactersLeft +" Character left");

    creationTitle.setFont(frMainFont2);
    creationSubTitle.setFont(frMainFont1);

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
    createKnightButton.setLayoutY(100);

    createThiefButton.setLayoutX(290);
    createThiefButton.setLayoutY(100);

    createEngineerButton.setLayoutX(450);
    createEngineerButton.setLayoutY(100);

    createWhiteMageButton.setLayoutX(180);
    createWhiteMageButton.setLayoutY(250);

    createBlackMageButton.setLayoutX(360);
    createBlackMageButton.setLayoutY(250);

    backToMenuButton.setLayoutX(10);
    backToMenuButton.setLayoutY(430);


    creationRoot.getChildren().addAll(createKnightButton, createThiefButton, createEngineerButton,
            createWhiteMageButton, createBlackMageButton, backToMenuButton);

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

    // Draw the creation scene
    Scene creationScene = new Scene(creationRoot, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(creationScene);
    primaryStage.show();
  }

  public void createThief(Stage primaryStage, ImageView background){
    Group creationRoot = new Group();
    creationRoot.getChildren().add(background);

    // Draw the creation scene
    Scene creationScene = new Scene(creationRoot, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(creationScene);
    primaryStage.show();
  }

  public void createEngineer(Stage primaryStage, ImageView background){
    Group creationRoot = new Group();
    creationRoot.getChildren().add(background);

    // Draw the creation scene
    Scene creationScene = new Scene(creationRoot, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(creationScene);
    primaryStage.show();
  }

  public void createWhiteMage(Stage primaryStage, ImageView background){
    Group creationRoot = new Group();
    creationRoot.getChildren().add(background);

    // Draw the creation scene
    Scene creationScene = new Scene(creationRoot, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(creationScene);
    primaryStage.show();
  }

  public void createBlackMage(Stage primaryStage, ImageView background){
    Group creationRoot = new Group();
    creationRoot.getChildren().add(background);

    // Draw the creation scene
    Scene creationScene = new Scene(creationRoot, 640, 460);
    primaryStage.setResizable(false);
    primaryStage.setScene(creationScene);
    primaryStage.show();
  }
}