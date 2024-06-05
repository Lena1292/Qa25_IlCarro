package manager;

import models.Car;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviderCars {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> carsSuccess() {
        int i = new Random().nextInt(1000)+1000;
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{
                Car.builder()
                        .location("Tel Aviv, Israel")
                        .manufacture("KIA")
                        .model("Sportage")
                        .year("2020")
                        .fuel("Petrol")
                        .seats(4)
                        .carClass("C")
                        .carRegNumber("678-987-"+i)
                        .price(50)
                        .build()

        });
        list.add(new Object[]{
                Car.builder()
                        .location("Rehovot, Israel")
                        .manufacture("Mazda")
                        .model("CX5")
                        .year("2022")
                        .fuel("Petrol")
                        .seats(4)
                        .carClass("C")
                        .carRegNumber("678-999-"+i)
                        .price(50)
                        .about("Very beautiful car")
                        .build()

        });
//
        return list.iterator();
    }
}