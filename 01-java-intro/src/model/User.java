package model;

import java.util.StringJoiner;

public class User extends Person{
    private String username;
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, int age, String username, String password) {
        super(firstName, lastName, age);
        this.username = username;
        this.password = password;
    }

    public User(Long id, String firstName, String lastName, int age, String username, String password) {
        super(id, firstName, lastName, age);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
