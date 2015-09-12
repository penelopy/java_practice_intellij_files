/**
 * Created by penelope on 9/1/15.
 */

//Maze has a 2d array of Cell objects


class Maze {
    private final int rows;
    private final int cols;
    private Cell[][] cells;

    public static void main(String[] args) {
        Maze maze = new Maze(3, 4);
    }
    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];
            Cell[] mazeRows;
            for (int row=0; row<rows; row++){
                Cell[] currentRow;
                for (int col=0; col<cols; col++){
                    this.currentRow.append(new Cell());
                }
            this.mazeRows.append(currentRow);
        }
    }
    public void generate() {
    }


//    public void prettyPrint() {
//        var String s;
//        }
//}



}
class Cell {
    //should these be private?
    boolean visited = false;
    boolean up = true;
    boolean right = true;
    boolean down = true;
    boolean left  = true;

}