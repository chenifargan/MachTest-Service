package com.example.finalproject;

public interface PersonService {
    Person get(Long id);
    Person delete(Long id);
    Person save(Person customer);

    double match(Person p1, Person p2);
}
