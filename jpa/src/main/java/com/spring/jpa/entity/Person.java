package com.spring.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;
    private Date lastSeen;

    public Person() { }

    public Person(String name, String location, Date lastSeen) {
        this.name = name;
        this.location = location;
        this.lastSeen = lastSeen;
    }

    public Person(int id, String name, String location, Date lastSeen) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.lastSeen = lastSeen;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", lastSeen=" + lastSeen +
                '}';
    }
}
