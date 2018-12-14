package com.example.ragha.tawjihiresultapp;

public class StudentGson {
    public int year;
    public int regNo;
    public String name;
    public double average;
    public String school;
    public String section;
    public String city;
    public int photo;


    public StudentGson(int year, String name, double average, String school, String section, int photo) {
        this.year = year;
        this.name = name;
        this.average = average;
        this.school = school;
        this.section = section;
        this.photo = photo;
    }

    public StudentGson(int year, String name, double average, String school, String section){
        this.year=year;
        this.regNo=regNo;
        this.name=name;
        this.average=average;
        this.school=school;
        this.section=section;
        this.city=city;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

}
