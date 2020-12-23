/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifefx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author gorbatov
 */
public class Point  {
    private int x,y;
    private boolean alive;
    private Circle circle;
    
    public Point(int x, int y, boolean alive) {
        this(x,y,alive,new Circle(10));
    }

    public Point(int x, int y, boolean alive, Circle circle) {
        this.x = x;
        this.y = y;
        this.alive = alive;
        this.circle = circle;
        if (this.isAlive()) {
            this.circle.setFill(Color.RED);
        } else {
            this.circle.setFill(Color.BLACK);
        }
        
    }
    
    public final boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Circle getCircle() {
        if (isAlive()==true)  {this.circle.setFill(Color.RED);} else {this.circle.setFill(Color.BLACK);}
        return circle;
    }    
}
