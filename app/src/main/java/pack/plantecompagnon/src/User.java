package pack.plantecompagnon.src;

import java.util.Date;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    private String pseudo;
    private String email;
    private Date birthDate;
    private int age;
    private String password;
    private String Gender;
    private String City;
    private String Picture;

    public User(){

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
