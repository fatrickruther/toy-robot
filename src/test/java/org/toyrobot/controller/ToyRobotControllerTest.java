package org.toyrobot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.toyrobot.board.Board;
import org.toyrobot.robot.ToyRobot;
import org.toyrobot.robot.Direction;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ToyRobotControllerTest {

    private ToyRobot toyRobot;
    private ToyRobotController controller;

    @BeforeEach
    void setUp() {
        toyRobot = new ToyRobot();
        controller = new ToyRobotController(toyRobot);
    }

    @Test
    void placeRobot() {
        assertFalse(toyRobot.isPlaced());
        assertEquals(0, Board.getInstance().getBoardPosition(new Point(1, 2)));
        controller.placeRobot(1, 2, Direction.NORTH);
        assertTrue(toyRobot.isPlaced());
        assertEquals(1, toyRobot.getPosition().x);
        assertEquals(2, toyRobot.getPosition().y);
        assertEquals(Direction.NORTH, toyRobot.getDirection());
        assertNotEquals(0, Board.getInstance().getBoardPosition(new Point(1,2)));
    }

    @Test
    void moveRobot() {
        controller.placeRobot(0, 0, Direction.NORTH);
        assertEquals(0, toyRobot.getPosition().y);
        controller.moveRobot();
        assertEquals(1, toyRobot.getPosition().y);
    }

    @Test
    void testRotateRobot() {
        controller.placeRobot(2, 2, Direction.SOUTH);
        controller.rightRotateRobot();
        assertEquals(Direction.WEST, toyRobot.getDirection());
        controller.leftRotateRobot();
        assertEquals(Direction.SOUTH, toyRobot.getDirection());
        controller.rightRotateRobot();
        controller.rightRotateRobot();
        assertEquals(Direction.NORTH, toyRobot.getDirection());
    }

}