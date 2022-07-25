package org.toyrobot.controller;

import org.toyrobot.board.Board;
import org.toyrobot.robot.ToyRobot;
import org.toyrobot.robot.Direction;
import org.toyrobot.util.StringConstants;

import java.awt.*;
import java.util.Objects;

public class ToyRobotController {

    private Board board;
    private ToyRobot toyRobot;

    public ToyRobotController(ToyRobot toyRobot) {
        board = Board.getInstance();
        this.toyRobot = toyRobot;
    }

    /**
     * Place the robot on the board
     * @param positionX - x position on the board to place robot
     * @param positionY - y position on the board to place robot
     * @param direction - direction of the robot (NORTH,EAST,SOUTH,WEST)
     */
    public void placeRobot(int positionX, int positionY, Direction direction) {
        Point placement = new Point(positionX, positionY);
        if(Objects.nonNull(toyRobot) && board.isValidBoardPosition(placement, toyRobot.getId()) && Objects.nonNull(direction)) {
            if(toyRobot.isPlaced()) {
                board.setBoardPosition(toyRobot.getPosition(), 0);
            }
            board.setBoardPosition(placement, toyRobot.getId());
            toyRobot.setPosition(positionX, positionY);
            toyRobot.setDirection(direction);
            toyRobot.setPlaced(true);
        } else {
            System.out.println(StringConstants.CANNOT_PLACE);
        }
    }

    /**
     * Move the robot one unit forward in the direction it is facing
     * This is ignored if robot is not placed
     */
    public void moveRobot() {
        if(Objects.nonNull(toyRobot) && toyRobot.isPlaced()) {
            Point newPosition = toyRobot.getMove();
            if(board.isValidBoardPosition(newPosition, toyRobot.getId())) {
                board.setBoardPosition(toyRobot.getPosition(), 0);
                toyRobot.move();
                board.setBoardPosition(newPosition, toyRobot.getId());
            } else {
                System.out.println(StringConstants.CANNOT_MOVE);
            }
        }
    }

    /**
     * Rotate the robot to the left
     * This is ignored if the robot is not placed
     */
    public void leftRotateRobot() {
        if(Objects.nonNull(toyRobot) && toyRobot.isPlaced()) {
            toyRobot.rotateLeft();
        }
    }

    /**
     * Rotate the robot to the right
     * This is ignored if robot is not placed
     */
    public void rightRotateRobot() {
        if(Objects.nonNull(toyRobot) && toyRobot.isPlaced()) {
            toyRobot.rotateRight();
        }
    }

    /**
     * Print state and position of the robot
     * This is ignored if robot is not placed
     */
    public void reportRobot() {
        if(Objects.nonNull(toyRobot) && toyRobot.isPlaced()) {
            System.out.printf("Output: %d,%d,%s\n",
                    toyRobot.getPosition().x, toyRobot.getPosition().y, toyRobot.getDirection());
        }
    }

}
