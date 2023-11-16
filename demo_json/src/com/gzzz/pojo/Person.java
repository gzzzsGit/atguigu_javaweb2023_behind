package com.gzzz.pojo;

import java.util.Objects;

/**
 * className: Person
 * Package : com.gzzz.pojo
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/5 1:03
 * @Version 1.0
 */
public class Person {
    private String name;
    private Integer age;
    private Dog dog;

    public Person(String name, Integer age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(dog, person.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dog);
    }
}
