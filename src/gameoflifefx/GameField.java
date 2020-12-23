
package gameoflifefx;

import javafx.scene.shape.Circle;

/**
 *
 * @author gorbatov
 */
public class GameField {
    private Point[][] gameField;
//    private Point[][] tempField;
    private final int x,y;
    public GameField(int x,int y) {
        this.x = x;
        this.y = y;
        gameField = new Point[x][y];
    }

    public void setGameField(Point[][] gameField) {
        this.gameField = gameField;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point[][] getGameField() {
        return gameField;
    }
    
    public  void startField() {
        int x,y;
        for (x = 0; x < this.x; x++) {
            for (y = 0; y < this.y; y++) {
                gameField[x][y] = new Point(x, y, true);
            }
        }
    }
    
    public void startField(boolean[][] initArray) {
        int x,y;
        for (x = 0; x < this.x; x++) {
            for (y = 0; y < this.y; y++) {
                gameField[x][y] = new Point(x, y, initArray[x][y]);
            }
        }
    }
    

    public void print() {
        for (Point[] points : gameField) {
            for (Point point : points) {
                if (point.isAlive()) {System.out.print("X");} else {System.out.print("O");}
            }
            System.out.println("");
        } 
    }
    
    public void gameMove(GameField mainField) {
        GameField tempField = new GameField(mainField.getX(), mainField.getY());
        for (Point[] points : mainField.getGameField()) {
            for (Point point : points) {
                int counter = 0;
                for (int i = point.getX()-1;i<=point.getX()+1;i++) {
                    for (int j = point.getY() -1;j<=point.getY()+1;j++) {
                        int x = i;
                        int y = j;
                        if (i < 0) {x = mainField.getX() - 1;}
                        if (i >= mainField.getX()) {x = 0;}
                        if (j < 0) {y = mainField.getY() - 1;}
                        if (j >= mainField.getY()) {y = 0;}
//                        if (i < 0 || j < 0 || i >= mainField.getX() || j >= mainField.getY()) continue;
                        if (mainField.getGameField()[x][y].isAlive()) counter++;
                    }
                }
                if (point.isAlive()) {
                    if (counter < 3 || counter > 4) {
                        tempField.getGameField()[point.getX()][point.getY()] = new Point(point.getX(), point.getY(), false);
//                        point.setAlive(false);
                    }  else {
                        tempField.getGameField()[point.getX()][point.getY()] = new Point(point.getX(), point.getY(), true);                    
                    }
                } else {
                    if (counter == 3) {
                        tempField.getGameField()[point.getX()][point.getY()] = new Point(point.getX(), point.getY(), true);
//                        point.setAlive(true);
                    } else {
                        tempField.getGameField()[point.getX()][point.getY()] = new Point(point.getX(), point.getY(), false);
                    }
                }
            }
        }
        this.setGameField(tempField.getGameField());
    }   
    
}
