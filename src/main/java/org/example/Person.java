package org.example;

import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Álvaro Bermúdez Gámez
 */

public class Person {

    private final String name;
    private final int age;
    private final String gender;

    /**
     * Constructs a person with a name, age and gender.
     *
     * @param name the name of a person
     * @param age the age of a person
     * @param gender the gender of the person
     */
    public Person(String name, int age, String gender){
        this.name=name;
        this.age=age;
        this.gender = gender;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public String gender() {
        return gender;
    }

    /**
     * Compute the average age of male and female persons in a list and returns the result in an array of two elements
     * (the first element is the male mean age and the second one is the female mean age)
     *
     * @param persons
     * @return
     */

    public double[] averageAgePerGender(List<Person> persons){
        return null;
    }
}
