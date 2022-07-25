package org.toyrobot.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class ApplicationConfig {

    private static ApplicationConfig instance = null;
    private final String configFile = "config.properties";
    private Properties prop;

    private ApplicationConfig() {
        prop = new Properties();
        loadConfig();
    }

    /**
     * Get only instance of ApplicationConfig object
     * @return instance
     */
    public static ApplicationConfig getInstance() {
        if(Objects.isNull(instance)) {
            instance = new ApplicationConfig();
        }
        return instance;
    }

    /**
     * Load properties file used for configuration
     * Exit if file can't be found or can't be loaded
     */
    private void loadConfig() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(configFile);
            if(Objects.isNull(inputStream)) {
                System.out.println("Cannot find properties file, exiting application");
                System.exit(-1);
            }
            prop.load(inputStream);
        }  catch (IOException ie) {
            System.out.println("Cannot load properties file, exiting application");
            System.exit(-1);
        }
    }

    /**
     * Get property 'board_width'
     * @return board width configured (default is 5)
     */
    public int getBoardWidth() { return Integer.parseInt(prop.getProperty("board_width")); }

    /**
     * Get property 'board_height'
     * @return board height configured (default is 5)
     */
    public int getBoardHeight() { return Integer.parseInt(prop.getProperty("board_height")); }

    /**
     * Get property 'board_orientation_x'
     * @return orientation of the board horizontally (default is 'west')
     */
    public String getBoardOrientationX() { return prop.getProperty("board_orientation_x"); }

    /**
     * Get property 'board_orientation_y'
     * @return orientation of the board vertically (default is 'south')
     */
    public String getBoardOrientationY() { return prop.getProperty("board_orientation_y"); }
}
