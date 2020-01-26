package org.cartrawler.quiz;

import org.cartrawler.quiz.consts.FuelPolicy;
import org.cartrawler.quiz.consts.SippType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.cartrawler.quiz.utils.SplitterUtils.cleanFromRecord;
import static org.cartrawler.quiz.utils.SplitterUtils.corporateNotCorporateCars;
import static org.cartrawler.quiz.utils.SplitterUtils.removeDuplicates;
import static org.cartrawler.quiz.utils.SplitterUtils.sortByPrice;
import static org.cartrawler.quiz.utils.SplitterUtils.splitBySsType;

/**
 * Created by Archil Matchavariani on 22/01/2020
 */
public final class Processor {


    private static final Processor INSTANCE = new Processor();

    private Processor() {
    }

    public List<Car> process(Collection<Car> carsCollection) {

        final Map<Boolean, Collection<Car>> corNotCorpCars = corporateNotCorporateCars(removeDuplicates(carsCollection));


        Map<SippType, Collection<Car>> corpCarsSp = splitBySsType(corNotCorpCars.get(true));
        Map<SippType, Collection<Car>> noCorpCarsSp = splitBySsType(corNotCorpCars.get(false));

        Map<SippType, List<Car>> corpCarsSpSortedList = removeAboveMedian(corpCarsSp);
        Map<SippType, List<Car>> nonCorpCarsSpSortedList = removeAboveMedian(noCorpCarsSp);

        final List<Car> result = new LinkedList<>();

        fillResultList(corpCarsSpSortedList, result);
        fillResultList(nonCorpCarsSpSortedList, result);

        return result;
    }

    public void printResultList(Collection<Car> carsCollection) {
        process(carsCollection).forEach(System.out::println);

    }


    public static Processor getInstance() {
        return INSTANCE;
    }


    private void fillResultList(Map<SippType, ? extends Collection<Car>> corpCarsSpSortedList, List<Car> result) {
        result.addAll(corpCarsSpSortedList.get(SippType.MINI));
        result.addAll(corpCarsSpSortedList.get(SippType.ECONOMY));
        result.addAll(corpCarsSpSortedList.get(SippType.COMPACT));
        result.addAll(corpCarsSpSortedList.get(SippType.OTHER));
    }

    private Map<SippType, List<Car>> removeAboveMedian(Map<SippType, Collection<Car>> corpCarsSp) {
        final Map<SippType, List<Car>> result = new HashMap<>(corpCarsSp.size());

        for (Map.Entry<SippType, Collection<Car>> entry : corpCarsSp.entrySet()) {
            ArrayList<Car> sortedList = sortByPrice(entry.getValue());
            cleanFromRecord(sortedList, FuelPolicy.FULLFULL);
            result.put(entry.getKey(), sortedList);
        }

        return result;
    }
}
