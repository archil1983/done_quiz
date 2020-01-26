package org.cartrawler.quiz.utils;

import org.apache.commons.lang3.EnumUtils;
import org.cartrawler.quiz.Car;
import org.cartrawler.quiz.TestCarsCollection;
import org.cartrawler.quiz.consts.CorporateCars;
import org.cartrawler.quiz.consts.FuelPolicy;
import org.cartrawler.quiz.consts.SippType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Archil Matchavariani on 22/01/2020
 */
public class SplitterUtilsTest implements TestCarsCollection {


    @Before
    public void setUp() {
        carCollection.addAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15));
    }

    @After
    public void tearDown() {
        carCollection.clear();
    }

    @Test
    public void removeDuplicates() {
        SplitterUtils.removeDuplicates(carCollection);
        assertEquals(12, SplitterUtils.removeDuplicates(carCollection).size());
    }

    @Test
    public void corporateNotCorporateCars() {

        Map<Boolean, Collection<Car>> corpNotCorpCars = SplitterUtils.corporateNotCorporateCars(carCollection);

        corpNotCorpCars.get(true).forEach(i -> assertTrue(EnumUtils.isValidEnum(CorporateCars.class, i.getSupplier())));
        corpNotCorpCars.get(false).forEach(i -> assertFalse(EnumUtils.isValidEnum(CorporateCars.class, i.getSupplier())));
    }

    @Test
    public void splitBySsType() {

        final Set<String> typeCodes =
                Arrays.stream(SippType.values()).filter(i -> i != SippType.OTHER).map(SippType::getCode).collect(Collectors.toSet());

        Map<SippType, Collection<Car>> spittedMap = SplitterUtils.splitBySsType(carCollection);
        for (Map.Entry<SippType, Collection<Car>> entry : spittedMap.entrySet()) {
            SippType type = entry.getKey();
            entry.getValue().stream().map(Car::getSspCode).map(i -> i.substring(0, 1)).
                    map(String::toUpperCase).forEach(i -> {
                if (type == SippType.OTHER) {
                    assertFalse(typeCodes.contains(i));
                } else {
                    assertTrue(typeCodes.contains(i));
                }
            });
        }

    }


    @Test
    public void sortByPrice() {

        List<Car> cars = SplitterUtils.sortByPrice(carCollection);

        assertEquals(8.00, cars.get(0).getRentalCost(), 0.0);
        assertEquals(10.00, cars.get(1).getRentalCost(), 0.0);
        assertEquals(300.05, cars.get(carCollection.size() - 1).getRentalCost(), 0.0);


    }

    @Test
    public void calculateMedianSortedList() {
        List<Car> carsList = Arrays.asList(car1, car3, car2);
        assertEquals(29.50, SplitterUtils.calculateMedianSortedList(carsList), 0.0);

        carsList = Arrays.asList(car1, car3, car2, car10);
        assertEquals(29.775, SplitterUtils.calculateMedianSortedList(carsList), 0.0);
    }

    @Test
    public void cleanFromRecord() {
        ArrayList<Car> carsList =new ArrayList<>(Arrays.asList(car1, car3, car2));
        SplitterUtils.cleanFromRecord(carsList,FuelPolicy.FULLFULL);

        assertEquals(2,carsList.size());
        assertTrue(carsList.contains(car1));
        assertTrue(carsList.contains(car3));
    }
}