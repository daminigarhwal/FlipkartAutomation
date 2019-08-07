package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyParser {

    private Properties properties;

    public Properties parseProperties(String configFile) throws FileNotFoundException, IOException {

        properties = new Properties();

        // EDIT THE LOCATION OF PROPERTY FILE IN THE BLANK SPACE..... THE FILE WILL BE "..../resouces/PropertyFiles/configuration.properties"
        InputStream inputStream = new FileInputStream("");
        if (inputStream == null) {
            throw new FileNotFoundException("Property File " + configFile + " not found in the classpath.");
        } else {
            properties.load(inputStream);
        }

        return properties;
    }
}
