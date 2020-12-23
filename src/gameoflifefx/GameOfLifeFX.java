/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifefx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;


/**
 *
 * @author gorbatov
 */
public class GameOfLifeFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        GameField gf = new GameField(10, 10);
        
        gf.startField(new boolean[][]{
        {false,false,false,false,false,false,false,false,false,false},
        {false,true,false,false,false,false,false,false,false,false},
        {false,false,true,false,false,false,false,false,false,false},
        {true,true,true,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false,false,false}
        
        });
        
        
        for (int x = 0; x < gf.getX(); x++) {
            for (int y = 0; y < gf.getY(); y++) {
                root.add(gf.getGameField()[x][y].getCircle(), x, y);
            }
        }

        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Game Of Life");
        primaryStage.setScene(scene);
        
        new AnimationTimer() {
            int count = 0;
            @Override
            
            public void handle(long now) {
                if (count < 50) {
                    count++;
                } else {
                 
                    update(gf);
                    for (int x = 0; x < gf.getX(); x++) {
                        for (int y = 0; y < gf.getY(); y++) {
                            root.add(gf.getGameField()[x][y].getCircle(), x, y);
                    
                        }
                    }
                    count = 0;
                }
            }
        }.start();
        
        
        
        primaryStage.show();
    }
    
    private void update(GameField gf) {
        gf.gameMove(gf);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
