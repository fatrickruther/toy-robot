package org.toyrobot.command;

import org.toyrobot.controller.ToyRobotController;
import org.toyrobot.robot.Direction;
import org.toyrobot.robot.ToyRobot;
import org.toyrobot.util.StringConstants;

import java.util.Objects;
import java.util.Scanner;

public class CommandHandler {

    private Scanner scanner;
    private ToyRobotController controller = new ToyRobotController(new ToyRobot());
    private static CommandHandler instance = null;

    private CommandHandler() {
        scanner = new Scanner(System.in);
        printInitialLabels();
        startListeningForCommands();
    }

    /**
     * Get only instance of CommandHandler object
     * @return instance
     */
    public static CommandHandler getInstance() {
        if(instance == null) {
            instance = new CommandHandler();
        }
        return instance;
    }

    /**
     * Print Toy Robot welcome label,
     * and available commands for the user to input
     */
    private void printInitialLabels() {
        System.out.println(StringConstants.WELCOME_LABEL);
        System.out.println(StringConstants.AVAILABLE_COMMANDS);
    }

    /**
     * Loop to start listening for commands on command line
     */
    private void startListeningForCommands() {
        while(true) {
            System.out.print(StringConstants.INPUT_COMMAND);
            String commandLine = scanner.nextLine();
            handleCommand(commandLine);
        }
    }

    /**
     * Call controller based on user-inputted command
     * @param commandLine - command inputted by the user
     */
    private void handleCommand(String commandLine) {
        String[] args = commandLine.trim().split("\\s+");

        if(Objects.nonNull(args[0])) {
            switch(args[0].toUpperCase()) {
                case "PLACE":
                    if(!isNumberOfArgsValid(args, 2)) {
                        System.out.println(StringConstants.INCORRECT_PLACE_PARAM_GENERIC);
                        break;
                    }
                    handlePlaceCommand(args[1]);
                    break;
                case "MOVE":
                    if(!isNumberOfArgsValid(args, 1)) {
                        System.out.println(StringConstants.INCORRECT_COMMAND);
                        break;
                    }
                    controller.moveRobot();
                    break;
                case "LEFT":
                    if(!isNumberOfArgsValid(args, 1)) {
                        System.out.println(StringConstants.INCORRECT_COMMAND);
                        break;
                    }
                    controller.leftRotateRobot();
                    break;
                case "RIGHT":
                    if(!isNumberOfArgsValid(args, 1)) {
                        System.out.println(StringConstants.INCORRECT_COMMAND);
                        break;
                    }
                    controller.rightRotateRobot();
                    break;
                case "REPORT":
                    if(!isNumberOfArgsValid(args, 1)) {
                        System.out.println(StringConstants.INCORRECT_COMMAND);
                        break;
                    }
                    controller.reportRobot();
                    break;
                case "EXIT":
                    System.exit(0);
                default:
                    System.out.println(StringConstants.INCORRECT_COMMAND);
            }
        } else {
            System.out.println(StringConstants.INCORRECT_COMMAND);
        }
    }

    /**
     * Util method to check if number of args is valid depending on command
     * @param args - the list of args
     * @param numRequired - number of args required
     * @return true if number of args is valid; false otherwise
     */
    protected boolean isNumberOfArgsValid(String[] args, int numRequired) {
        if(args.length != numRequired) {
            return false;
        }
        return true;
    }

    /**
     * Handle parameters for PLACE command
     * @param param - the param for the PLACE command (correct format is X,Y,F)
     */
    protected void handlePlaceCommand(String param) {
        int positionX, positionY;
        Direction direction = null;
        String[] placeParams = param.trim().split(",");

        if(!isNumberOfArgsValid(placeParams, 3)) {
            System.out.println(StringConstants.INCORRECT_PLACE_PARAM_GENERIC);
            return;
        }

        // Validate and retrieve X,Y params of PLACE command
        try {
            positionX = Integer.parseInt(placeParams[0]);
            positionY = Integer.parseInt(placeParams[1]);
        } catch(NumberFormatException nfe) {
            System.out.println(StringConstants.INCORRECT_PLACE_POSITION_PARAM);
            return;
        }

        // Validate and retrieve F (direction) param of PLACE command
        switch(placeParams[2].toUpperCase()) {
            case "NORTH":
                direction = Direction.NORTH;
                break;
            case "EAST":
                direction = Direction.EAST;
                break;
            case "SOUTH":
                direction = Direction.SOUTH;
                break;
            case "WEST":
                direction = Direction.WEST;
                break;
            default:
                System.out.println(StringConstants.INCORRECT_PLACE_DIRECTION_PARAM);
                return;
        }
        controller.placeRobot(positionX, positionY, direction);
    }

}
