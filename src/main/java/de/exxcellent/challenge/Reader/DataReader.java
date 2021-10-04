package de.exxcellent.challenge.Reader;

import java.io.FileNotFoundException;

/**
 *@author Yassin Alshater <mhdalshater@gmail.com>
 */
public abstract class DataReader {


    /**
     *
     * @throws FileNotFoundException if file not found
     */
    abstract void readData() throws FileNotFoundException;

    /**
     *
     * @param path of csv file
     * @return new Object CsvReader();
     */
    public static CsvReader createCsvReader(String path){
        return new CsvReader(path);
    }

    /**
     *
     * @param path of Json file
     * @return new Object JsonReader();
     */
    public static JsonReader createJsonReader(String path){
        return new JsonReader(path);
    }

}
