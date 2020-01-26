package org.cartrawler.quiz;

import org.cartrawler.quiz.consts.CorporateCars;
import org.cartrawler.quiz.consts.FuelPolicy;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Archil Matchavariani on 25/01/2020
 */
public interface TestCarsCollection {

     Collection<Car> carCollection = new ArrayList<>(15);


     Car car1 = new Car(CorporateCars.SIXT.name(), "Peugeot 107", "MCMR", 22.50, FuelPolicy.FULLFULL);
     Car car11 = new Car(CorporateCars.SIXT.name(), "Peugeot 107", "MCMR", 22.50, FuelPolicy.FULLFULL);
     Car car2 = new Car(CorporateCars.AVIS.name(), "Peugeot 107", "MCMR", 30.05, FuelPolicy.FULLFULL);
     Car car13 = new Car(CorporateCars.AVIS.name(), "Peugeot 108", "MCMR", 300.05, FuelPolicy.FULLFULL);
     Car car14 = new Car(CorporateCars.AVIS.name(), "Peugeot 109", "MCMR", 130.05, FuelPolicy.FULLFULL);
     Car car3 = new Car(CorporateCars.SIXT.name(), "Opel Corsa", "EDMN", 29.50, FuelPolicy.FULLFULL);
     Car car4 = new Car(CorporateCars.FIERARY.name(), "Volkswagen Golf", "CDMR", 48.00, FuelPolicy.FULLFULL);
     Car car5 = new Car(CorporateCars.AVIS.name(), "Mercedes A Class", "ICAV", 80.00, FuelPolicy.FULLFULL);
     Car car6 = new Car("DELPASO", "Volkswagen Up", "MDMR", 8.00, FuelPolicy.FULLEMPTY);
     Car car7 = new Car("DELPASO", "Volkswagen Polo", "EDMR", 10.00, FuelPolicy.FULLFULL);
     Car car15 = new Car("DELPASO", "Volkswagen Polo", "EDMR", 100.00, FuelPolicy.FULLFULL);
     Car car8 = new Car("GOLDCAR", "Volkswagen Golf", "CLMR", 18.00, FuelPolicy.FULLEMPTY);
     Car car12 = new Car("GOLDCAR", "Volkswagen Golf", "CLMR", 18.00, FuelPolicy.FULLEMPTY);
     Car car9 = new Car("GOLDCAR", "Citroen Berlingo", "CMMV", 28.00, FuelPolicy.FULLFULL);
     Car car10 = new Car("RECORD", "Ford Galaxy", "FVAR", 65.00, FuelPolicy.FULLEMPTY);

}
