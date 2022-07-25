package org.toyrobot.robot;

import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ToyRobot {

    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final int id;
    private Point position;
    private Direction direction;
    private boolean placed = false;

    public ToyRobot() {
        position = new Point();
        direction = Direction.NORTH;
        id = idGenerator.getAndIncrement();
    }

    /**
     * Get unique id of ToyRobot
     * @return the unique id
     */
    public int getId() {
        return id;
    }

    /**
     * Move the robot and update its position
     * @return the new position of the robot
     */
    public Point move() {
        Point translationPoint = Movement.getTranslationPoint(direction);
        position.translate(translationPoint.x, translationPoint.y);
        return position;
    }

    /**
     * Peek at the new position of the robot when move is executed
     * @return the supposed position of the robot when move is executed
     */
    public Point getMove() {
        Point translationPoint = Movement.getTranslationPoint(direction);
        return new Point(position.x + translationPoint.x, position.y + translationPoint.y);
    }

    /**
     * Get the current position of the robot
     * @return the robot's current position (x,y)
     */
    public Point getPosition() { return position; }

    /**
     * Set the current position of the robot
     * @param positionX - x position to be set
     * @param positionY - y position to be set
     */
    public void setPosition(int positionX, int positionY) { position.setLocation(positionX, positionY); }

    /**
     * Get the current direction the robot is facing
     * @return current direction of the robot (NORTH,EAST,SOUTH,WEST)
     */
    public Direction getDirection() { return direction; }

    /**
     * Set the current direction of the robot
     * @param direction - direction to be set (NORTH,EAST,SOUTH,WEST)
     */
    public void setDirection(Direction direction) { this.direction = direction; }

    /**
     * Retrieve if robot is currently placed on the board
     * @return true is robot is placed; false otherwise
     */
    public boolean isPlaced() { return placed; }

    /**
     * Set isPlaced flag to true/false
     * @param isPlaced - flag to set
     */
    public void setPlaced(boolean isPlaced) { this.placed = isPlaced; }

    /**
     * Rotate the direction of robot to the left
     */
    public void rotateLeft() { direction = direction.left(); }

    /**
     * Rotate the direction of robot to the right
     */
    public void rotateRight() { direction = direction.right(); }
}
