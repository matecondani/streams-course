package lectures;


import beans.Car;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lecture8 {

    @Test
    public void simpleGrouping() throws Exception {
        List<Car> carsList = MockData.getCars();
        Map<String, List<Car>> grouped = carsList.stream()
                .collect(Collectors.groupingBy(Car::getMake));
//        To understand, GroupingBy will return a Map (K,V) with KEY = the groupBy and Value = List of object. eg.:
//        Map<Double, List<Car>> collect = carsList.stream().collect(Collectors.groupingBy(Car::getPrice));
        grouped.forEach((make, cars) -> {
            System.out.println(make);
            cars.forEach(System.out::println);
        });
    }

    @Test
    public void groupingAndCounting() throws Exception {
        ArrayList<String> names = Lists
                .newArrayList(
                        "John",
                        "John",
                        "Mariam",
                        "Alex",
                        "Mohammado",
                        "Mohammado",
                        "Vincent",
                        "Alex",
                        "Alex"
                );
        Map<String, Long> collect = names.stream()
//                Notice that "((name) -> name, Collectors.counting())" could be used to collect the count
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((name, count) -> System.out.println(name + " -> " + count));
    }

}