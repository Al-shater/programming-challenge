package de.exxcellent.challenge.Reader;

import java.io.FileNotFoundException;

/**
 * todo ...
 */
public class JsonReader extends DataReader{
    private final String path;

    /**
     *
     *@param path todo
     */
    protected JsonReader(String path) {
        this.path = path;
    }

    /**
     *
     *@throws FileNotFoundException todo
     */
    @Override
    void readData() throws FileNotFoundException {}


}
