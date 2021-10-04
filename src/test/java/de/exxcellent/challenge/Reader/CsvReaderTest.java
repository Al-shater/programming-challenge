package de.exxcellent.challenge.Reader;

import de.exxcellent.challenge.Exceptions.ColumnNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class CsvReaderTest {

    private CsvReader csvReader;

    @BeforeEach
    void setUp() {
        csvReader = DataReader.createCsvReader("weather.csv");
    }
    /**
     *
     * @throws ColumnNotFoundException if column not found
     * @throws IOException ..
     */
    @Test
    void findRow() throws ColumnNotFoundException, IOException {
        Assertions.assertEquals(0,csvReader.findRow("Day"));
        Assertions.assertNotEquals(1,csvReader.findRow("AvSp"));
        Assertions.assertThrows(ColumnNotFoundException.class, () -> {
            csvReader.findRow("Column");
        });
    }
}