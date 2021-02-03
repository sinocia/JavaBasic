package com.pascal.util.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @auther handp
 * @date 2021/1/8 15:57
 */
public class GroupById {
   static class Person{
        Person(int id,String name,int age){
            this.id=id;
            this.name=name;
            this.age=age;
        }
        int id;
        String name;
        int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Person person1=new Person(1,"a",10);
        Person person2=new Person(1,"aa",10);
        Person person3=new Person(2,"b",10);
        Person person4=new Person(2,"bb",10);
        Person person5=new Person(3,"c",10);
        Person person6=new Person(3,"cc",10);
        List<Person> allPerson=new ArrayList<>();
        allPerson.add(person1);
        allPerson.add(person2);
        allPerson.add(person3);
        allPerson.add(person4);
        allPerson.add(person5);
        allPerson.add(person6);
        Map<Integer, List<Person>> testMap = new HashMap<>();
        testMap = allPerson.stream().collect(Collectors.groupingBy(Person::getId));

        System.out.println(testMap.size());

    }
}
