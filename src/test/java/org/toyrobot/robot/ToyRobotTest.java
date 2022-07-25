package org.toyrobot.robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyRobotTest {

    private ToyRobot toyRobot;

    @BeforeEach
    void setUp() {
        toyRobot = new ToyRobot();
    }

    @Test
    void testGetId() {
        assertNotNull(toyRobot.getId());
    }

    @Test
    void testMoveAndGetMove() {
        toyRobot.setDirection(Direction.NORTH);
        toyRobot.setPosition(1,1);
        assertEquals(2, toyRobot.getMove().y);
        assertEquals(2, toyRobot.move().y);
    }

    @Test
    void testGetAndSetPosition() {
        toyRobot.setPosition(0,2);
        assertEquals(0, toyRobot.getPosition().x);
        assertEquals(2, toyRobot.getPosition().y);
    }

    @Test
    void testGetAndSetDirection() {
        toyRobot.setDirection(Direction.EAST);
        assertEquals(Direction.EAST, toyRobot.getDirection());
    }

    @Test
    void testIsAndSetPlaced() {
        assertFalse(toyRobot.isPlaced());
        toyRobot.setPlaced(true);
        assertTrue(toyRobot.isPlaced());
    }

    @Test
    void testRotate() {
        toyRobot.setDirection(Direction.NORTH);
        toyRobot.rotateRight();
        assertEquals(Direction.EAST, toyRobot.getDirection());

        toyRobot.setDirection(Direction.NORTH);
        toyRobot.rotateLeft();
        assertEquals(Direction.WEST, toyRobot.getDirection());
    }

}