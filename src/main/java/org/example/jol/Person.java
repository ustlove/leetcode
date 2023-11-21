package org.example.jol;

import javax.swing.text.html.parser.TagElement;

/**
 * @ClassName Person
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/26 10:35
 * @Version 1.0
 */
public class Person {

    public String name;
    public Integer age;
    public Person(){

    }
    private Person(String name,Integer age){
        this.age = age;
        this.name = name;

    }
}
