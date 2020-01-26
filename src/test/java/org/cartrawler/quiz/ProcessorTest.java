package org.cartrawler.quiz;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Archil Matchavariani on 25/01/2020
 */
public class ProcessorTest implements TestCarsCollection {

    @Before
    public void setUp() {
        carCollection.addAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15));
    }

    @Test
    public void process() {
        Processor processor = Processor.getInstance();
        List<Car> resultList = processor.process(carCollection);

        assertEquals(9,resultList.size());

        assertTrue(resultList.contains(car1));
        assertTrue(resultList.contains(car2));
        assertTrue(resultList.contains(car3));
        assertTrue(resultList.contains(car4));
        assertTrue(resultList.contains(car5));
        assertTrue(resultList.contains(car6));
        assertTrue(resultList.contains(car7));
        assertTrue(resultList.contains(car8));
        assertTrue(resultList.contains(car10));

        processor.printResultList(carCollection);


    }
}