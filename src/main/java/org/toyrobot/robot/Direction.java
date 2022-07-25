package org.toyrobot.robot;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    int index = ordinal();
    static int maxIndex = values().length - 1;

    /**
     * Retrieve the direction to its left
     * @return the direction to its left
     */
    public Direction left() {
        if(index != 0) {
            return Direction.values()[index - 1];
        } else {
            return Direction.values()[maxIndex];
        }
    }

    /**
     * Retrieve the direction to its right
     * @return the direction to its right
     */
    public Direction right() {
        if(index != maxIndex) {
            return Direction.values()[index + 1];
        } else {
            return Direction.values()[0];
        }
    }
}
