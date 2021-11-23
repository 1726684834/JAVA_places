package com.zhang;

/**
 * @author ZhangJunqi
 * @Date 2021/11/18 -22:11
 */
public class Student {
    private String stuCode;
    private String stuName;
    private int stuAge;

    public Student() {
    }

    public Student(String stuCode, String stuName, int stuAge) {
        this.stuCode = stuCode;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public String getStuCode() {
        return stuCode;
    }

    public Student setStuCode(String stuCode) {
        this.stuCode = stuCode;
        return this;
    }

    public String getStuName() {
        return stuName;
    }

    public Student setStuName(String stuName) {
        this.stuName = stuName;
        return this;
    }

    public int getStuAge() {
        return stuAge;
    }

    public Student setStuAge(int stuAge) {
        this.stuAge = stuAge;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuCode='" + stuCode + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }
}
