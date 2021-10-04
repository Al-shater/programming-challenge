package de.exxcellent.challenge.Reader;

import au.com.bytecode.opencsv.CSVReader;
import de.exxcellent.challenge.Exceptions.ColumnNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Yassin Alshater <mhdalshater@gmail.com>
 */
public class CsvReader extends DataReader {
    private final String path;
    private CSVReader reader;

    /**
     * @param path of csv File
     */
    protected CsvReader(String path){
        this.path = path;
    }

    /**
     *
     * @throws FileNotFoundException if the csv File not found
     */
    @Override
    protected void readData() throws FileNotFoundException {
        reader = new CSVReader( new FileReader(path));
    }

    protected CSVReader getReader(){
        return reader;
    }
    /**
     *
     * @param columnName in the csv data
     * @return the index of columnName in the csv data
     * @throws IOException data ist not readable
     * @throws ColumnNotFoundException  ColumnName not found
     *
     */
    public int findRow(String columnName) throws IOException, ColumnNotFoundException {
        readData();
        List<String> header = Arrays.asList(reader.readAll().get(0));
        if(!header.contains(columnName)){
            throw new ColumnNotFoundException("Column " + "´" + columnName + "´" + " not found");
        }
        reader.close();
        return header.indexOf(columnName);
    }

}
