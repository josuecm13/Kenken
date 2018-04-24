package gameboard.logic.board;

import gameSolver.Solver;
import gameboard.logic.shapes.Shape;
import gameboard.logic.shapes.ShapeFactory;


public class KenkenBoard {

    private int board[][];
    private Shape shapeboard[][];
    private final int COLUMNS;
    private final int ROWS;
    private Solver solver;

    public KenkenBoard(int rows,int columns, boolean random) {
        this.COLUMNS = columns;
        this.ROWS = rows;
        initializeBoards();
        if (!random) {
            board = Generator.generateMatrix(board);
        }
        generateKenkenBoard(random);
        solver = new Solver(this, ROWS);
        solver.generatePermutations(shapeboard);
    }

    private void initializeBoards(){
        board = new int[ROWS][COLUMNS];
        shapeboard = new Shape[ROWS][COLUMNS];
    }


    private void generateKenkenBoard(boolean random){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (shapeboard[i][j] != null)
                    continue;
                Shape shape = ShapeFactory.getInstance(ROWS, random);
                while(!shape.fits(shapeboard,i,j))
                    shape = ShapeFactory.getInstance(ROWS, random);
                shape.placeShape(shapeboard,board,i,j,!random);
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
        System.out.println("\n\n");
    }

    public int getNumColums(){return COLUMNS;}
    public int getNumRows() {return ROWS;}
    public Shape[][] getShapeboard(){return shapeboard;}

    public int[][] getBoard() {
        return board;
    }




}
