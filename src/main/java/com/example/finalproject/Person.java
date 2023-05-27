package com.example.finalproject;

public class Person {
    private Long id;
    private String name;
    private String lastname;
    private int age;
    private String astrologicalSign;

    public Person(Long id, String name, String lastname,int age,String astrologicalSign) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age=age;
        this.astrologicalSign = astrologicalSign;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAstrologicalSign() {
        return astrologicalSign;
    }

    public void setAstrologicalSign(String astrologicalSign) {
        this.astrologicalSign = astrologicalSign;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
