package org.toyrobot.board;

import org.toyrobot.util.ApplicationConfig;

import java.awt.*;
import java.util.Arrays;

public class Board {

    private int width;
    private int height;
    private int[][] board;
    private static Board instance = null;

    private Board() { createBoard(); }

    /**
     * Get only instance of Board object
     * @return instance
     */
    public static Board getInstance() {
        if(instance == null) {
            instance = new Board();
        }
        return instance;
    }

    /**
     * Create a board using configured board height/width
     * Default value is 5 x 5
     */
    private void createBoard() {
        width = ApplicationConfig.getInstance().getBoardWidth();
        height = ApplicationConfig.getInstance().getBoardHeight();
        board = new int[width][height];
    }

    /**
     * Set a value to a specific position on the board
     * @param position - position (x,y) on the board
     * @param value - identifier set on the board (e.g. id of the robot)
     */
    public void setBoardPosition(Point position, int value) {
        board[position.x][position.y] = value;
    }


    /**
     * Check if board position is valid based on position
     * @param position - position (x,y) on the board to be checked
     * @param value - identifier used to check value of a specific point on the board
     * @return true if position is valid; false otherwise
     */
    public boolean isValidBoardPosition(Point position, int value) {
        /*
         * Board position is invalid if position is out of bounds
         * or if position is occupied by something else
         */
        if(position.x < 0 || position.x >= width
                || position.y < 0 || position.y >= height
                || (getBoardPosition(position) != 0 && getBoardPosition(position) != value)) {
            return false;
        }
        return true;
    }

    /**
     * Reset the board to its original state
     */
    public void clearBoard() {
        for(int[] row: board) {
            Arrays.fill(row, 0);
        }
    }

    /**
     * Get identifier on a specific position
     * @param position - position (x,y) on the board
     * @return identifier which occupies the specific position, 0 means nothing occupies
     */
    public int getBoardPosition(Point position) { return board[position.x][position.y]; }

}
