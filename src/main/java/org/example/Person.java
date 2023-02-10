package org.example;

import org.example.Exceptions.EmptyValueException;
import org.example.Exceptions.IncorrectGenderException;
import org.example.Exceptions.NegativeValueException;
import org.example.Exceptions.NullParameterException;

import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Álvaro Bermúdez Gámez
 */

public class Person {

    private final String name;
    private final int age;
    private final String gender; //Male, Female

    /**
     * Constructs a person with a name, age and gender.
     *
     * @param name the name of a person
     * @param age the age of a person
     * @param gender the gender of the person
     */
    public Person(String name, int age, String gender) throws NegativeValueException, IncorrectGenderException, NullParameterException {
        if(name==null){
            throw new NullParameterException("The name is null");
        }
        if(name.equals("")){
            throw new EmptyValueException("The name is empty");
        }
        if(gender==null){
            throw new NullParameterException("The gender is null");
        }
        if(!gender.equals("Male") && !gender.equals("Female")){
            throw new IncorrectGenderException("The gender " + gender + " is incorrect");
        }
        if(age<0){
            throw new NegativeValueException("The age " + age + " is negative");
        }

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
     * @return result
     */

    public double[] averageAgePerGender(List<Person> persons){
        if(persons==null){
            throw new NullParameterException("The list is null");
        }
        if (persons.isEmpty()){
            throw new EmptyValueException("The list " + persons + " is empty");
        }
        double [] result = new double[2];
        int sumAgeMale = 0;
        int sumAgeFemale = 0;
        int countMale = 0;
        int countFemale = 0;

        for(Person p : persons){
            if(p.gender.equals("Male")){
                sumAgeMale+=p.age;
                countMale++;
            }else {
                sumAgeFemale+=p.age;
                countFemale++;
            }
        }

        if(countMale==0){
            result[0]=0.0;
        }else {
            result[0]= (sumAgeMale/countMale);
        }
        if (countFemale==0){
            result[1]=0.0;
        }else {
            result[1]=(sumAgeFemale/countFemale);
        }
        return result;
    }
}
