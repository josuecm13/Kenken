package gameboard.logic.board;

import gameSolver.Solver;
import gameboard.logic.shapes.Shape;
import gameboard.logic.shapes.ShapeFactory;

import java.awt.*;


public class KenkenBoard {

    private int board[][];
    private Shape shapeboard[][];
    private final int COLUMNS;
    private final int ROWS;

    public KenkenBoard(int rows,int columns){
        this.COLUMNS = columns;
        this.ROWS = rows;
        initializeBoards();
        generateKenkenBoard();

        Solver s = new Solver(ROWS);
        s.solve(shapeboard);


    }


    private void initializeBoards(){
        board = new int[ROWS][COLUMNS];
        shapeboard = new Shape[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = -1;
            }
        }
    }



    private void generateKenkenBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (shapeboard[i][j] != null)
                    continue;
                Shape shape = ShapeFactory.getInstance(ROWS);
                while(!shape.fits(shapeboard,i,j))
                    shape = ShapeFactory.getInstance(ROWS);
                shape.placeShape(shapeboard, i, j);
            }
        }
    }

    public void printBoard(){
        for (Shape i[]: shapeboard) {
            for (Shape j: i) {
                System.out.print(j + "\t");
            }
            System.out.println("        ");
        }
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int getNumColums(){return COLUMNS;}
    public int getNumRows() {return ROWS;}
    public Shape[][] getShapeboard(){return shapeboard;}



}
