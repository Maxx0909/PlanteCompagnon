package pack.plantecompagnon.src.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    private String pseudo;
    private String email;
    private String birthDate;
    @Ignore
    private int age;
    private String password;
    private String gender;
    private String city;
    private String picture;


    public User(@NonNull String pseudo, String email, String birthDate, String password, String gender, String city, String picture) {
        this.pseudo = pseudo;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
        this.gender = gender;
        this.city = city;
        this.picture = picture;

    }

    //Getters and setters

    @NonNull
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(@NonNull String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
