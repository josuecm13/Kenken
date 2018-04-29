package gameboard.GUI;

import gameboard.logic.board.KenkenBoard;
import gameboard.logic.shapes.Shape;
import gameboard.logic.shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;

public class KenkenPanel extends JPanel {

    private KenkenBoard board;
    private int usedWidth;
    private int usedHeight;
    private int fontSize;
    private int numFontSize;
    private int numGapX, numGapY;
    private int gapX;
    private int gapY;
    Graphics2D g2d;

    public KenkenPanel(){
        this.setPreferredSize(new Dimension(650, 650));
        this.board = new KenkenBoard(5,5,true);
        usedHeight=0;
        usedWidth=0;
        gapX = 10;
        gapY = 16;
        fontSize=23;
        numFontSize = 50;
    }

    public void setGapX(int gapX) {
        this.gapX = gapX;
    }

    public void setGapY(int gapY) {
        this.gapY = gapY;
    }

    KenkenPanel(KenkenBoard board){
        this.setPreferredSize(new Dimension(650, 650));
        this.board = board;
        usedWidth = 0;
        usedHeight = 0;
        gapX = 5;
        gapY = 16;
        fontSize = 16;
        numFontSize = 80;
        numGapY  = 90;
        numGapX = 40;
    }

    public void setBoard(KenkenBoard board) {
        this.board = board;
    }

    void setFontSize(int fontSize){
        this.fontSize = fontSize;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setColor(new Color(1.0f,1.0f,1.0f));

        int slotWidth = this.getWidth()/board.getNumColums();
        int slotHeight = this.getHeight()/board.getNumRows();

        usedWidth = (this.getWidth()/board.getNumColums())*board.getNumColums();
        usedHeight = (this.getHeight()/board.getNumRows())*board.getNumRows();
        g2d.fillRect(0, 0,usedWidth,usedHeight);
        makeGrid(slotWidth,slotHeight);

        int i = 0;
        int j = 0;
        Shape temp = ShapeFactory.getInstance(2, false);
        verticalBorders(slotHeight,slotWidth,i,j,temp);
        horizontalBorders(slotHeight,slotWidth,i,j,temp);

        setNumbers(board.getBoard());

        g2d.setColor(new Color(0.0f,0.0f,0.0f));
        g2d.drawLine(usedWidth,0,usedWidth,usedHeight);
        g2d.drawLine(0,usedHeight,usedWidth,usedHeight);
    }


    private void makeGrid(int slotWidth, int slotHeight){
        g2d.setColor(new Color(0.9f,0.9f,0.9f));
        for(int x = 0;x <= usedWidth;x+=slotWidth) {
            g2d.setStroke(new BasicStroke(4));
            g2d.drawLine(x, 0, x, usedHeight);
        }
        for (int y = 0; y < usedHeight ; y+=slotHeight) {
            g2d.setStroke(new BasicStroke(4));
            g2d.drawLine(0, y, usedWidth, y);
        }
    }

    private void verticalBorders(int slotHeight, int slotWidth,int i,int j, Shape temp){
        g2d.setColor(new Color(0.0f,0.0f,0.0f));
        for (int y = 0; y < usedHeight ; y+= slotHeight) {
            for (int x = 0; x <usedWidth; x+= slotWidth) {
                if(board.getShapeboard()[i][j] != temp){
                    temp = board.getShapeboard()[i][j];
                    /*
                    Color c =g2d.getColor();
                    g2d.setColor(temp.getColor());
                    g2d.fillRect(x, y,x+usedWidth-10,y+usedHeight-10);
                    g2d.setColor(c);
                    */
                    if(temp.isHead(i,j)){
                        g2d.setFont(new Font(Font.MONOSPACED,Font.BOLD,fontSize));
                        g2d.drawString(""+(temp.getObjective() >= 0 ? temp.getObjective(): "(" + temp.getObjective() + ")")  +temp.getOperation().getSymbol(),x+gapX,y+gapY);
                    }
                    g2d.setStroke(new BasicStroke(4));
                    g2d.drawLine(x,y,x,y+slotHeight);
                }
                j++;
            }
            j=0;
            i++;
        }
    }

    private void horizontalBorders(int slotHeight, int slotWidth,int i,int j, Shape temp){
        for (int x = 0; x < usedWidth ; x+= slotWidth) {
            for (int y = 0; y <usedHeight; y+= slotHeight) {
                if(board.getShapeboard()[i][j] != temp){
                    temp = board.getShapeboard()[i][j];
                    g2d.setStroke(new BasicStroke(4));
                    g2d.drawLine(x,y,x+slotHeight,y);
                }
                i++;
            }
            i=0;
            j++;
        }
    }

    public void setNumConfiguration(int numFontSize, int numGapX, int numGapY){
        this.numFontSize = numFontSize;
        this.numGapX = numGapX;
        this.numGapY = numGapY;
    }

    public void setNumbers(int[][] matrix){
        g2d.setColor(new Color(0.0f,0.0f,0.0f));
        int slotWidth = this.getWidth()/board.getNumColums();
        int slotHeight = this.getHeight()/board.getNumRows();
        int i = 0;
        int j = 0;
        for (int y = 0; y < usedHeight ; y+= slotHeight) {
            for (int x = 0; x <usedWidth; x+= slotWidth) {
                if(matrix[i][j] == Integer.MIN_VALUE) {
                    j++;
                    continue;
                }
                g2d.setFont(new Font(Font.MONOSPACED,Font.BOLD,numFontSize));
                g2d.drawString(Integer.toString(matrix[i][j]),x+numGapX,y+numGapY);
                j++;
            }
            j=0;
            i++;
        }
        this.revalidate();
    }

    public KenkenBoard getBoard(){
        return board;
    }


}
