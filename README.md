# toy-robot

The application is a simulation of a toy robot moving on a square table top, of dimensions 5 units x 5 units. There are no
other obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented
from falling to destruction. Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.

Available commands for the toy robot:

<b>PLACE X,Y,F</b>        - place your robot at the (X,Y) position on the board, facing the direction (F); possible values for F is 'NORTH','SOUTH','EAST','WEST'

<b>MOVE</b>               - move your robot one unit forward in the direction it is currectly facing

<b>LEFT</b>               - rotate your robot to the left

<b>RIGHT</b>              - rotate your robot to the right

<b>REPORT</b>             - report the position (X,Y) and the direction (F) the robot is facing

<b>EXIT</b>               - exit the application

--
## Setup
1. Clone the repo, and do a 'mvn clean install' on the command line
2. Under target/, run the generated jar using 'java -jar ToyRobot-1.0-SNAPSHOT.jar'
