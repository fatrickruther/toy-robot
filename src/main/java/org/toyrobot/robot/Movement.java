package org.toyrobot.robot;

import org.toyrobot.util.ApplicationConfig;

import java.awt.*;

public class Movement {

    // Translation points if board orientation is 'North West'
    private static final Point NORTH_POINT = new Point(0, -1);
    private static final Point EAST_POINT = new Point(1, 0);
    private static final Point SOUTH_POINT = new Point(0, 1);
    private static final Point WEST_POINT = new Point(-1, 0);

    /**
     * Get the translation point to be added to the robot's current position (for MOVE command)
     * @param direction - direction where the robot is facing (NORTH,EAST,SOUTH,WEST)
     * @return - the translation point based on the direction
     */
    public static Point getTranslationPoint(Direction direction) {
        Point translationPoint = new Point();
        switch(direction) {
            case NORTH:
                translationPoint = new Point(NORTH_POINT);
                break;
            case EAST:
                translationPoint = new Point(EAST_POINT);
                break;
            case SOUTH:
                translationPoint = new Point(SOUTH_POINT);
                break;
            case WEST:
                translationPoint = new Point(WEST_POINT);
                break;
        }
        /**
         * Default board orientation is where origin (0,0) is at Northwest...
         * If configured to use a different orientation (east/south), negate the x/y translation points respectively
         */
        if(ApplicationConfig.getInstance().getBoardOrientationX().equalsIgnoreCase(Direction.EAST.name())) {
            translationPoint.setLocation(Math.negateExact(translationPoint.x), translationPoint.y);
        }
        if(ApplicationConfig.getInstance().getBoardOrientationY().equalsIgnoreCase(Direction.SOUTH.name())) {
            translationPoint.setLocation(translationPoint.x, Math.negateExact(translationPoint.y));
        }
        return translationPoint;
    }

}
