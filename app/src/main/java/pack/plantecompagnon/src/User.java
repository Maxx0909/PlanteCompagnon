package pack.plantecompagnon.src;

import java.util.Date;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    private String pseudo;
    private String email;
    private Date birthDate;
    private int age;
    private String password;
    private String gender;
    private String city;
    private String picture;

    public User(String pseudo, String email, Date birthDate, String password, String gender, String city, String picture) {
        this.pseudo = pseudo;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
        this.gender = gender;
        this.city = city;
        this.picture = picture;
    }

    public void createAccount(String pseudo, String email, Date birthDate, String passWord, String gender, String city, String picture){

    }

    public void deleteAccount(){

    }

    public void modifyInformation(String pseudo, String email, Date birthDate, String passWord, String gender, String city, String picture){

    }

    public int getNumberUserPlant(){
        return 0;
    }
}
