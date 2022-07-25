package org.toyrobot.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    void testLeft() {
        assertEquals(Direction.WEST, Direction.NORTH.left());
        assertEquals(Direction.SOUTH, Direction.WEST.left());
        assertEquals(Direction.EAST, Direction.SOUTH.left());
        assertEquals(Direction.NORTH, Direction.EAST.left());
    }

    @Test
    void testRight() {
        assertEquals(Direction.EAST, Direction.NORTH.right());
        assertEquals(Direction.SOUTH, Direction.EAST.right());
        assertEquals(Direction.WEST, Direction.SOUTH.right());
        assertEquals(Direction.NORTH, Direction.WEST.right());
    }
}