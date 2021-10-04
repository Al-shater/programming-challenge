package de.exxcellent.challenge.Analyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SmallestValueFinderTest {

    private SmallestValueFinder smallestValueFinder;

    @BeforeEach
    void setUp() {
        smallestValueFinder = SmallestValueFinder.createSmallestValueFinder("weather.csv");
    }
    /**
     *
     * @throws IOException ..
     */
    @Test
    void findSmallestValue() throws IOException {
        Assertions.assertEquals("14",smallestValueFinder.findSmallestValue(0,1,2));
        Assertions.assertNotEquals("10",smallestValueFinder.findSmallestValue(0,1,2));
    }


    /**
     *
     * @throws NoSuchMethodException method name is false
     * @throws InvocationTargetException private Method not exist
     * @throws IllegalAccessException ..
     */
    @Test
    void getDifferenceBetweenCsvColumnsAsListTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = SmallestValueFinder.class.getDeclaredMethod("getDifferenceBetweenCsvColumnsAsList",Integer.class, Integer.class, Integer.class);
        method.setAccessible(true);

        List<Map.Entry<String,Integer>> expected = new ArrayList<>(Map.of("22",26, "23", 22 , "24" , 13, "25",18, "26" ,33, "27",19, "28",16, "29",22).entrySet());
        List<Map.Entry<String,Integer>> value1 = new ArrayList<>(Map.of(  "30",45, "10",20,"11",32,"12",15, "13",11, "14",2, "15",9).entrySet());
        List<Map.Entry<String,Integer>> value2 = new ArrayList<>(Map.of("16",20, "17",24, "18",30, "19",20, "1",29,"2",16,"3",22).entrySet());
        List<Map.Entry<String,Integer>> value3 = new ArrayList<>(Map.of(  "4",18, "5",24, "6",20, "7",16, "8",21, "9",54, "20",27, "21",27).entrySet());
        expected.addAll(value1);
        expected.addAll(value2);
        expected.addAll(value3);
        List<Map.Entry<String,Integer>> actual = (List<Map.Entry<String,Integer>>)method.invoke(smallestValueFinder,0,1,2);


        assertTrue(expected.containsAll(actual));

    }
}