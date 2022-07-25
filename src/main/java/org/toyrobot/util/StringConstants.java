package org.toyrobot.util;

public class StringConstants {

    public static final String WELCOME_LABEL =
        "  ______               ____        __          __ \n" +
        " /_  __/___  __  __   / __ \\____  / /_  ____  / /_\n" +
        "  / / / __ \\/ / / /  / /_/ / __ \\/ __ \\/ __ \\/ __/\n" +
        " / / / /_/ / /_/ /  / _, _/ /_/ / /_/ / /_/ / /_  \n" +
        "/_/  \\____/\\__, /  /_/ |_|\\____/_.___/\\____/\\__/  \n" +
        "          /____/                                  \n" +
        "========== version 1.0 - July 24, 2022 ==========\n";

    public static final String AVAILABLE_COMMANDS =
        "Here are the available commands for your toy robot: \n" +
        " PLACE X,Y,F        - place your robot at the (X,Y) position on the board, facing the direction (F)\n" +
        "                      possible values for F is 'NORTH','SOUTH','EAST','WEST'\n" +
        " MOVE               - move your robot one unit forward in the direction it is currectly facing\n" +
        " LEFT               - rotate your robot to the left\n" +
        " RIGHT              - rotate your robot to the right\n" +
        " REPORT             - report the position (X,Y) and the direction (F) the robot is facing\n" +
        " EXIT               - exit the application\n";

    public static final String INPUT_COMMAND = "\ncommand>";

    // Error messages
    public static final String INCORRECT_COMMAND = "Incorrect command";
    public static final String INCORRECT_PLACE_PARAM_GENERIC = "Incorrect PLACE parameter, X,Y,F parameters required";
    public static final String INCORRECT_PLACE_POSITION_PARAM = "Incorrect PLACE parameter for X or Y";
    public static final String INCORRECT_PLACE_DIRECTION_PARAM = "Incorrect PLACE parameter for F, possible values are 'NORTH','SOUTH','EAST','WEST'";
    public static final String CANNOT_PLACE = "Cannot place robot, position is invalid";
    public static final String CANNOT_MOVE = "Cannot move robot, position is invalid";
}
