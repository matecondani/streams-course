package lectures;


import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Lecture5 {

    @Test
    public void understandingFilter() throws Exception {
        ImmutableList<Car> cars = MockData.getCars();
        List<Car> expensiveCars = cars.stream()
                .filter(car -> car.getPrice() > 50000)
                .collect(Collectors.toList());
        System.out.println(expensiveCars);
        expensiveCars.forEach(System.out::println);
        System.out.println(expensiveCars.size());
    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        List<Person> people = MockData.getPeople();

    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices

    }

    @Test
    public void test() throws Exception {

    }
}



