package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases
 * 1 - name can't be null
 * 2 - gender can't be null
 * 3 - gender must be Male or Female
 * 4 - age must be positive
 * 5 - averageAgePerGender ([]) -> [-1,-1]
 * 6 - averageAgePerGender of a list which contains Males but not Females
 * 7 - averageAgePerGender of a list which contains Females but not Males
 * 8 - averageAgePerGender of a list (not empty) returns the average age of male and female persons
 */
class PersonTest {
    Person person;

    @Test
    void nameIsNotNull(){
        assertThrows(NullParameterException.class, ()-> new Person(null,30,"Male"));
    }

    @Test
    void genderIsNotNull(){
        assertThrows(NullParameterException.class, ()-> new Person("Pepe",30,null));
    }

    @Test
    void genderIsMaleOrFemale(){
        assertThrows(IncorrectGenderException.class, ()-> new Person("Pepe",30,"Kid"));
    }

    @Test
    void ageIsPositive(){
        assertThrows(NegativeValueException.class, ()-> new Person("Pepe",-4,"Male"));
    }

    @Test
    void averageAgePerGenderOfEmptyListIs(){
        Person person = new Person("Pablo",20,"Male");
        List<Person> list = new ArrayList<>();
        double[] obtainedValue = person.averageAgePerGender(list);
        double[] expectedValue = {0.0,0.0};

        assertArrayEquals(expectedValue,obtainedValue);

    }

}