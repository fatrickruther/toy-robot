package org.toyrobot.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board = Board.getInstance();

    @BeforeEach
    void setUp() {
        board.clearBoard();
    }

    @Test
    void testGetInstance() {
        assertNotNull(Board.getInstance());
    }

    @Test
    void testClearBoard() {
        Point initPoint = new Point(1,3);
        board.setBoardPosition(initPoint, 1);
        assertEquals(1, board.getBoardPosition(initPoint));
        board.clearBoard();
        assertEquals(0, board.getBoardPosition(initPoint));
    }

    @Test
    void testSettingBoardPosition() {
        Point initPoint = new Point(2,2);
        assertEquals(0, board.getBoardPosition(initPoint));
        board.setBoardPosition(initPoint, 1);
        assertEquals(1, board.getBoardPosition(initPoint));
    }

    @Test
    void testIsValidBoardPosition() {
        Point initPoint = new Point(2, 2);
        assertEquals(0, board.getBoardPosition(initPoint));
        assertTrue(board.isValidBoardPosition(initPoint, 1));

        board.setBoardPosition(initPoint, 1);
        assertTrue(board.isValidBoardPosition(initPoint, 1));

        board.setBoardPosition(initPoint, 2);
        assertFalse(board.isValidBoardPosition(initPoint, 1));

        Point invalidPointXUnder = new Point(-1,0);
        assertFalse(board.isValidBoardPosition(invalidPointXUnder, 1));
        Point invalidPointYUnder = new Point(0,-1);
        assertFalse(board.isValidBoardPosition(invalidPointYUnder, 1));

        Point invalidPointXOver = new Point(5,0);
        assertFalse(board.isValidBoardPosition(invalidPointXOver, 1));
        Point invalidPointYOver = new Point(0,5);
        assertFalse(board.isValidBoardPosition(invalidPointYOver, 1));
    }
}