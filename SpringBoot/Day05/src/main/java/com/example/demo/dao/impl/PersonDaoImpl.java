package com.example.demo.dao.impl;

import com.example.demo.dao.PersonDAO;
import com.example.demo.database.PersonDB;
import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonDaoImpl implements PersonDAO {
    @Override
    public void printListPeople(List<Person> people ) {
        people.stream()
                .forEach(System.out::println);
    }

    @Override
    public List<Person> getAll() {
        return PersonDB.people;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.people.stream()
                .sorted(Comparator.comparing(Person::getFullname))
                .toList();
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.people.stream()
                .sorted(Comparator.comparing(Person::getFullname).reversed())
                .toList();
    }

    @Override
    public List<String> getSortedJobs() {
        return PersonDB.people.stream()
                .map(person -> person.getJob())
                .distinct()
                .sorted()
                .toList();
    }

    @Override
    public List<String> getSortedCities() {
        return PersonDB.people.stream()
                .map(person -> person.getCity())
                .distinct()
                .sorted()
                .toList();
    }

    @Override
    public List<String> femaleNames() {
        return PersonDB.people.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .map(Person::getFullname)
                .toList();
    }

    @Override
    public Person highestEarner() {
        return PersonDB.people.stream()
                .max(Comparator.comparingInt(Person::getSalary))
                .get();
    }

    @Override
    public List<Person> bornAfter1990() {
        return PersonDB.people.stream()
                .filter(person -> person.getBirthday().getYear() > 1990)
                .toList();
    }

    @Override
    public double averageSalary() {
        return PersonDB.people.stream().mapToDouble(person -> person.getSalary())
                .average()
                .getAsDouble();
    }

    @Override
    public double averageAge() {
        return PersonDB.people.stream()
                .mapToDouble(person -> ChronoUnit.YEARS.between(person.getBirthday(), LocalDate.now()))
                .average()
                .getAsDouble();
    }

    @Override
    public List<Person> nameContains(String keyword) {
        return PersonDB.people.stream()
                .filter(person -> person.getFullname().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        return PersonDB.people.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("male"))
                .sorted(Comparator.comparing(Person::getBirthday))
                .toList();
    }

    @Override
    public Person longestName() {
        return PersonDB.people.stream()
                .max(Comparator.comparingInt(person ->person.getFullname().length()))
                .get();
    }

    @Override
    public List<Person> aboveAverageSalary() {
        return PersonDB.people.stream()
                .filter(person -> person.getSalary() > averageSalary())
                .toList();
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return PersonDB.people.stream()
                .collect(Collectors.groupingBy(Person::getCity));
    }

    @Override
    public Map<String, Integer> groupJobByCount() {
        return PersonDB.people.stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }
}
