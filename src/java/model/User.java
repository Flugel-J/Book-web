
package model;

import java.sql.Date;


public class User {
    private String username;
    private String password;
    private boolean status;
    private String name;
    private String dob;
    private String email;
    private boolean gender;
    private String intro;

    public User(String username, String password, boolean status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public User(String username,String password, String name, String dob, String email, boolean gender, String intro) {
        this.username=username;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.intro = intro;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}

