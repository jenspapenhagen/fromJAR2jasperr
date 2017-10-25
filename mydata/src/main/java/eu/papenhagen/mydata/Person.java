/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.mydata;

import java.util.Objects;

/**
 * Test Object for Jasper Reports
 * @author jens.papenhagen
 */
public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String street;
    private final int housenumber;
    private final int zip;
    private final String city;

    public Person(String firstName, String lastName, int age, String street, int housenumber, int zip, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.street = street;
        this.housenumber = housenumber;
        this.zip = zip;
        this.city = city;
    }

          
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
        
    public String getStreet() {
        return street;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public int getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        hash = 89 * hash + this.age;
        hash = 89 * hash + Objects.hashCode(this.street);
        hash = 89 * hash + this.housenumber;
        hash = 89 * hash + this.zip;
        hash = 89 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.housenumber != other.housenumber) {
            return false;
        }
        if (this.zip != other.zip) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

  
    
    
}
