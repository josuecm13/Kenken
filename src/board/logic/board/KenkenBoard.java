package board.logic.board;

import board.logic.shapes.Shape;
import board.logic.shapes.ShapeFactory;

import java.util.Random;

public class KenkenBoard {

    private int board[][];
    private final int COLUMNS;
    private final int ROWS;
    private final int BOXWIDTH;
    private final int BOXHEIGHT;

    public KenkenBoard(int rows,int columns,int boxWidth, int boxHeight){
        this.COLUMNS = columns;
        this.ROWS = rows;
        this.BOXHEIGHT = boxHeight;
        this.BOXWIDTH = boxWidth;
        board = new int[ROWS][COLUMNS];
        initializeBoard();
    }


    private void initializeBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = -1;
            }
        }
    }


    private void generateKenkenBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                Shape shape= ShapeFactory.getInstance();
                if(shape.fits(board,i,j))
                    shape.placeShape(board,i,j);
            }
        }
        
    }


}
