package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
    @Test
    public void fakerTest(){
        //Java faker can be used for generating fake test data
        //name, lastname,job title, phone number, email, city,state,country.....
        //1.Create a Faker object
        Faker faker=new Faker();
        //2.Generate some fake data(mock data)
        String fakeName=faker.name().firstName();
        String fakeLName=faker.name().lastName();
        String fullFullName=faker.name().fullName();
        String fakeUserName=faker.name().username();

        System.out.println("Name :"+fakeName);
        System.out.println("Last Name "+fakeLName);
        System.out.println("Full Name :"+fullFullName);
        System.out.println("User Name :"+fakeUserName);

        //title
        System.out.println(faker.name().title());
        //city
        System.out.println(faker.address().city());
        //state
        System.out.println(faker.address().state());
        //phone number
        System.out.println(faker.phoneNumber().cellPhone());
        //email
        System.out.println(faker.internet().emailAddress());
        //random 5 digit number
        System.out.println(faker.number().digits(5));

    }
}
