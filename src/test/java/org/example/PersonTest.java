package org.example;

import org.example.Exceptions.EmptyValueException;
import org.example.Exceptions.IncorrectGenderException;
import org.example.Exceptions.NegativeValueException;
import org.example.Exceptions.NullParameterException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases
 * 1 - name can't be null
 * 2 - name can't be empty
 * 3 - gender can't be null
 * 4 - gender must be Male or Female
 * 5 - age must be positive
 * 6 - averageAgePerGender of a Empty list throws a EmptyValueException
 * 7 - averageAgePerGender of a list which contains Males but not Females
 * 8 - averageAgePerGender of a list which contains Females but not Males
 * 9 - averageAgePerGender of a list (not empty) returns the average age of male and female persons
 */
class PersonTest {

    @Test
    void nameIsNotNull(){
        assertThrows(NullParameterException.class, ()-> new Person(null,30,"Male"));
    }

    @Test
    void nameIsNotEmpty(){
        assertThrows(EmptyValueException.class, ()-> new Person("",3,"Male"));
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
        assertThrows(EmptyValueException.class, () -> person.averageAgePerGender(list));
    }

    /**
     * @variable list: contains 5 Males with ages 0, 1, 2, 3 and 4. The average age will be (0+1+2+3+4)/5 = 2
     * The average age of Females will be 0
     */
    @Test
    void  averageAgePerGenderOfOnlyMales(){
        Person person = new Person("Pablo",20,"Male");
        List<Person> list = new ArrayList<>();
        for(int i =0; i<5; i++){
            list.add(new Person("Antonio",i,"Male"));
        }
        double[] obtainedValue = person.averageAgePerGender(list);
        double[] expectedValue = {2,0};
    }

    /**
     * @variable list: contains 7 Females with ages 0, 1, 2, 3, 4, 5, 6 and 7.
     * The average age of Females will be (0+1+2+3+4+5+6)/7 = 3
     * The average age of Males will be 0
     */
    @Test
    void averageAgePerGenderOfOnlyFemales(){
        Person person = new Person("Pablo",20,"Male");
        List<Person> list = new ArrayList<>();
        for(int i = 0; i<7; i++){
            list.add(new Person("Ana",i,"Female"));
        }
        double[] obtainedValue = person.averageAgePerGender(list);
        double[] expectedValue = {0,3};
        assertArrayEquals(expectedValue,obtainedValue);
    }

    /**
     * @variable list: contains 5 Males and 5 Females
     * The average age of Females will be (1+2+3+4+5)/5 = 3
     * The average age of Males will be (0+1+2+3+4)/5 = 2
     */
    @Test
    void averageAgePerGenderOfGenericList(){
        Person person = new Person("Pablo",20,"Male");
        List<Person> list = new ArrayList<>();
        for (int i = 0; i<5; i++){
            list.add(new Person("Antonio",i,"Male"));
            list.add(new Person("Ana",i+1,"Female"));
        }
        double[] obtainedValue = person.averageAgePerGender(list);
        double[] expectedValue = {2,3};
        assertArrayEquals(expectedValue,obtainedValue);
    }

}