package org.toyrobot.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationConfigTest {

    @Test
    void testGetInstance() {
        assertNotNull(ApplicationConfig.getInstance());
    }

    @Test
    void testGetBoardWidth() {
        assertEquals(5, ApplicationConfig.getInstance().getBoardWidth());
    }

    @Test
    void getBoardHeight() {
        assertEquals(5, ApplicationConfig.getInstance().getBoardHeight());
    }

    @Test
    void getBoardOrientationX() {
        assertEquals("west", ApplicationConfig.getInstance().getBoardOrientationX());
    }

    @Test
    void getBoardOrientationY() {
        assertEquals("south", ApplicationConfig.getInstance().getBoardOrientationY());
    }
}