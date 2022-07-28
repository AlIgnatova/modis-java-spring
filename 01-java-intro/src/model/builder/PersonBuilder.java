package model.builder;

import model.Person;

import java.util.Locale;

public class PersonBuilder {
    private Person builded = new Person();
    public  PersonBuilder(){

    }

    public  PersonBuilder setName (String name) {
        setFirstAndLastNames(name);
        return this;
    }

    public PersonBuilder setAge(int age){
        builded.setAge(age);
        return this;
    }

    //utility method
    protected void setFirstAndLastNames(String name){
        String [] names = name.trim().split("\\s+");
        builded.setFirstName(names[0]);
        builded.setLastName(names[names.length-1]);
    }

    public Person build(){
        return builded;
    }


}
