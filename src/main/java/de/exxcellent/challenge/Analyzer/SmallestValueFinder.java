package de.exxcellent.challenge.Analyzer;

import de.exxcellent.challenge.Reader.CsvReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yassin Alshater <mhdalshater@gmail.com>
 */
public class SmallestValueFinder extends CsvReader {
    /**
     * @param path of csv file
     */
    protected SmallestValueFinder(String path){
        super(path);
    }

    /**
     *
     * @param path of csv file
     * @return new Object DifferenceBetweenCsvColumn();
     */
    public static SmallestValueFinder createSmallestValueFinder(String path) {
        return new SmallestValueFinder(path);
    }

    /**
     *
     * @param columnAsKey expected the column as key for the Difference
     * @param firstColumn expected the first Column to find the Difference
     * @param secColumn expected the second Column to find the Difference
     * @return entrySet as : Keys = columnAsKey , Value = Def. of | firstColumn - secColumn |
     * @throws IOException if an I/O error expected
     */
    private  List<Map.Entry<String,Integer>> getDifferenceBetweenCsvColumnsAsList(Integer columnAsKey, Integer firstColumn, Integer secColumn) throws IOException {
        super.readData();
        Map<String, Integer> columnMap = new HashMap<>();
        List<String[]> rows = super.getReader().readAll();
        //remove the Header
        rows.remove(0);
        for (String[] row : rows) {
            columnMap.put(row[columnAsKey], (Math.abs(Integer.parseInt(row[firstColumn]) - Integer.parseInt(row[secColumn]))));
        }
        return new ArrayList<>(columnMap.entrySet());
    }


    /**
     *
     * @param columnAsKey expected the column as key for the Difference
     * @param firstColumn expected the first Column to find the Difference
     * @param secColumn expected the second Column to find the Difference
     * @return the key of the smallest Value
     * @throws IOException if an I/O error expected
     */
    public String findSmallestValue(int  columnAsKey, int firstColumn, int secColumn) throws IOException {
        List<Map.Entry<String,Integer>> sortedEntries = getDifferenceBetweenCsvColumnsAsList(columnAsKey,firstColumn,secColumn);
        sortedEntries.sort(Map.Entry.comparingByValue());
        super.getReader().close();
        // the first Element in the List has the smallestValue
        return sortedEntries.get(0).getKey();
    }

}
