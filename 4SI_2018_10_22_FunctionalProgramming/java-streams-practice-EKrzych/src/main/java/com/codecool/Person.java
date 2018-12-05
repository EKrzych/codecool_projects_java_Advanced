package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private String phone;
    private List<String> skills;

    public Person(String name, String phone, String ... varargs) {
        this.name = name;
        this.phone = phone;
        this.skills = Arrays.asList(varargs);
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return name + " - " + phone + "\n";
    }

    public static String peopleWhoCanInto(String skill, List<Person> people) {
        return people.stream().filter(p -> p.skills.contains(skill))
                .map(p -> p.toString()).collect(Collectors.joining());
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Ela", "666", "java", "python"));
        people.add(new Person("Monika", "64444", "java", "python"));
        people.add(new Person("Marcin", "111666", "C++", "python"));

        System.out.println(Person.peopleWhoCanInto("C++", people));

    }


}


