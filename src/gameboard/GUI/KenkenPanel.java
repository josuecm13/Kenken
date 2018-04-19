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

    public KenkenPanel(){
        this.setPreferredSize(new Dimension(550, 550));
        this.board = new KenkenBoard(5,5);
        usedHeight=0;
        usedWidth=0;
        fontSize=23;
    }

    KenkenPanel(KenkenBoard board){
        this.setPreferredSize(new Dimension(550, 550));
        this.board = board;
        usedWidth = 0;
        usedHeight = 0;
        fontSize = 26;
    }

    public void setBoard(KenkenBoard board) {
        this.board = board;
    }

    void setFontSize(int fontSize){
        this.fontSize = fontSize;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(1.0f,1.0f,1.0f));

        int slotWidth = this.getWidth()/board.getNumColums();
        int slotHeight = this.getHeight()/board.getNumRows();

        usedWidth = (this.getWidth()/board.getNumColums())*board.getNumColums();
        usedHeight = (this.getHeight()/board.getNumRows())*board.getNumRows();

        g2d.fillRect(0, 0,usedWidth,usedHeight);
        int i = 0;
        int j = 0;
        Shape temp = ShapeFactory.getInstance(2);

        g2d.setColor(new Color(0.9f,0.9f,0.9f));
        for(int x = 0;x <= usedWidth;x+=slotWidth) {
            g2d.setStroke(new BasicStroke(4));
            g2d.drawLine(x, 0, x, usedHeight);
        }
        for (int y = 0; y < usedHeight ; y+=slotHeight) {
            g2d.setStroke(new BasicStroke(4));
            g2d.drawLine(0, y, usedWidth, y);
        }
        g2d.setColor(new Color(0.0f,0.0f,0.0f));
        for (int y = 0; y < usedHeight ; y+= slotHeight) {
            for (int x = 0; x <usedWidth; x+= slotWidth) {
                if(board.getShapeboard()[i][j] != temp){
                    temp = board.getShapeboard()[i][j];
                    if(temp.isHead(i,j)){
                        g2d.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
                        g2d.drawString(""+temp.getObjective()+temp.getOperation().getSymbol(),x+10,y+16);
                    }
                    g2d.setStroke(new BasicStroke(4));
                    g2d.drawLine(x,y,x,y+slotHeight);
                }
               j++;
            }
            j=0;
            i++;
        }
        i = j = 0;
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
        g2d.setColor(new Color(0.0f,0.0f,0.0f));
        g2d.drawLine(usedWidth,0,usedWidth,usedHeight);
        g2d.drawLine(0,usedHeight,usedWidth,usedHeight);
    }

    public KenkenBoard getBoard(){
        return board;
    }


}
