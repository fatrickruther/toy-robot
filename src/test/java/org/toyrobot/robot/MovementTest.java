package org.toyrobot.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    @Test
    void testGetTranslationPoint() {
        assertEquals(0, Movement.getTranslationPoint(Direction.NORTH).x);
        assertEquals(1, Movement.getTranslationPoint(Direction.NORTH).y);

        assertEquals(1, Movement.getTranslationPoint(Direction.EAST).x);
        assertEquals(0, Movement.getTranslationPoint(Direction.EAST).y);

        assertEquals(0, Movement.getTranslationPoint(Direction.SOUTH).x);
        assertEquals(-1, Movement.getTranslationPoint(Direction.SOUTH).y);

        assertEquals(-1, Movement.getTranslationPoint(Direction.WEST).x);
        assertEquals(0, Movement.getTranslationPoint(Direction.WEST).y);
    }
}