package org.cartrawler.quiz.utils;

import org.cartrawler.quiz.Car;
import org.cartrawler.quiz.consts.CorporateCars;
import org.cartrawler.quiz.consts.FuelPolicy;
import org.cartrawler.quiz.consts.SippType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.apache.commons.lang3.EnumUtils.isValidEnum;

/**
 * Created by Archil Matchavariani on 20/01/2020
 */
public final class SplitterUtils {

    private SplitterUtils() {
    }


    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        if (collection instanceof Set) {
            return collection;
        }
        return new HashSet<>(collection);
    }

    public static Map<Boolean, Collection<Car>> corporateNotCorporateCars(Collection<Car> cars) {

        final Collection<Car> corporateCars = new LinkedList<>();
        final Collection<Car> notCorporateCars = new LinkedList<>();
        final Map<Boolean, Collection<Car>> result = new HashMap<>();
        result.put(true, corporateCars);
        result.put(false, notCorporateCars);
        for (Car car : cars) {
            if (isValidEnum(CorporateCars.class, car.getSupplier())) {
                corporateCars.add(car);
            } else {
                notCorporateCars.add(car);
            }
        }
        return result;
    }


    public static Map<SippType, Collection<Car>> splitBySsType(Collection<Car> cars) {
        final EnumMap<SippType, Collection<Car>> result = new EnumMap<>(SippType.class);
        for (Car car : cars) {
            final SippType sippType = SippType.detectType(car.getSspCode().substring(0, 1).toUpperCase());
            result.putIfAbsent(sippType, new LinkedList<>());
            result.get(sippType).add(car);
        }
        return result;
    }


    public static ArrayList<Car> sortByPrice(Collection<Car> cars) {
        final ArrayList<Car> result = new ArrayList<>(cars);
        result.sort(Comparator.comparingDouble(Car::getRentalCost));
        return result;
    }


    public static double calculateMedianSortedList(List<Car> sortedCarList) {
        if (sortedCarList.size() == 1) {
            return sortedCarList.get(0).getRentalCost();
        }
        final int length = sortedCarList.size();

        if (length % 2 == 0) {
            return (sortedCarList.get(length / 2).getRentalCost() + sortedCarList.get((length / 2) - 1).getRentalCost()) / 2.0;
        } else {
            return sortedCarList.get(length / 2).getRentalCost();
        }

    }


    public static void cleanFromRecord(ArrayList<Car> sortedCarList, FuelPolicy fuelPolicy){
        final double median = calculateMedianSortedList(sortedCarList);
        sortedCarList.removeIf(car -> car.getFuelPolicy() == fuelPolicy && car.getRentalCost() > median);

    }


}
