package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

record Person (String name,int age,Address address){};
record Address (String line1, String line2){};
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Vasu";
    }
    @Bean
    public int age(){
        return 24;
    }
    @Bean
    public Person person(){
       // var person = new Person("vasu1",22);
        return new Person("vasu1",22,new Address("Walkers Street vasu1","Chennai 22"));
    }
    @Bean(name = "vasu")
    public Person person2method(){
        // var person = new Person("vasu1",22);

         return new Person(name(),age(),address()); //here we can call the methods of same type also
        //return new Person("vasu",24);
    }
    @Bean
    @Primary
    public Person person2methodParam(String name,int age,Address addressMismatchBeans){
        // var person = new Person("vasu1",22);

        return new Person(name,age,addressMismatchBeans); //here we can call the methods of same type also
        //return new Person("vasu",24);
    }
    @Bean
    public Address address(){
        return new Address("Walkers Street","Chennai");
    }
    @Bean
    @Primary
    public Address address2(){
        return new Address("chennai street","banglore");
    }

}
