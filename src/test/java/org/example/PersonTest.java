package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases
 * 1 - name can't be null
 * 2 - gender can't be null
 * 3 - gender must be Male or Female
 * 4 - age must be positive
 * 5 - averageAgePerGender ([]) -> [0,0]
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

}