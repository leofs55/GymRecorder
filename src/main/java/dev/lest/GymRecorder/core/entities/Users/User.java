package dev.lest.GymRecorder.core.entities.Users;

import dev.lest.GymRecorder.core.enuns.Role;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Role userRole;

    public User(Long id, String name, String email, String password, Role userRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String name, String email, String password, Role userRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

}
