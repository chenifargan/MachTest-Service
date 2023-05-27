package com.example.finalproject;

import org.springframework.stereotype.Service;

@Service

public class PersonServiceImpl implements PersonService {
    @Override
    public Person get(Long id) {
        return new Person(id, "Janis", "Joplin",48,"");
    }

    @Override
    public Person delete(Long id) {
        return new Person(id, "Chuck", "Norris",12,"");
    }

    @Override
    public Person save(Person person) {
        return new Person(1L, person.getName(), person.getLastname(),person.getAge(),person.getAstrologicalSign());
    }

    @Override
    public double match(Person p1, Person p2) {
        return calculateCompatibility(p1.getId(),p1.getName(),p1.getLastname(),p1.getAge(),AstrologicalSign.valueOf(p1.getAstrologicalSign()).ordinal(),
                p2.getId(),p2.getName(),p2.getLastname(),p2.getAge(),AstrologicalSign.valueOf(p2.getAstrologicalSign()).ordinal());



    }
    public  double calculateCompatibility(Long idA, String nameA, String surnameA, int ageA, int luckA,
                                                Long idB, String nameB, String surnameB, int ageB, int luckB) {
        // Normalize ID values
        double normalizedIdA = idA / 100000.0;
        double normalizedIdB = idB / 100000.0;

        // Normalize age values
        double normalizedAgeA = ageA / 100.0;
        double normalizedAgeB = ageB / 100.0;

        // Calculate compatibility score
        double compatibilityScore = Math.abs(normalizedIdA - normalizedIdB)
                + calculateNameCompatibility(nameA, nameB)
                + calculateNameCompatibility(surnameA, surnameB)
                + Math.abs(normalizedAgeA - normalizedAgeB)
                + Math.abs(luckA - luckB);

        // Convert compatibility score to a percentage
        double maxScore = 5.0; // Maximum score for all parameters
        double compatibilityPercentage = (maxScore - compatibilityScore) / maxScore * 100;



        return Math.abs(compatibilityPercentage%100);
    }

    public  double calculateNameCompatibility(String nameA, String nameB) {
        // Assign numerical values to each letter (A=1, B=2, C=3, etc.)
        int valueA = getNameValue(nameA);
        int valueB = getNameValue(nameB);

        // Normalize name values
        double normalizedValueA = valueA / 100.0;
        double normalizedValueB = valueB / 100.0;

        // Calculate name compatibility score
        double nameCompatibility = Math.abs(normalizedValueA - normalizedValueB);

        return nameCompatibility;
    }

    public  int getNameValue(String name) {
        int value = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            value += Character.toLowerCase(c) - 'a' + 1;
        }
        return value;
    }

}
