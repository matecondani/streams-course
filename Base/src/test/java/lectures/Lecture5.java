package lectures;


import beans.Car;
import beans.Person;
import beans.PersonDTO;
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
        //Ctrl+W extend or Ctrl+Alt+W to shrink selection
        //Ctrl+Alt+V extract to variable
        //Ctrl+ALT+M extract to method
        List<Person> people = MockData.getPeople();
        List<PersonDTO> collected = people.stream().map(person -> {
            PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
            return dto;
        }).collect(Collectors.toList());
    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices
        ImmutableList<Car> cars = MockData.getCars();
        double average = cars
                .stream()
                .mapToDouble(car -> car.getPrice())// This could call method reference for Car::getPrice
                .average()
                .orElse(0);
        System.out.println(average);
    }

    @Test
    public void test() throws Exception {
        //MockData.getCars().forEach(System.out::println);
        MockData.getCars().stream().mapToDouble(Car::getPrice)
                .forEach(System.out::println);
    }
}



