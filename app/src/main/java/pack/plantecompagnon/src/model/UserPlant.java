package pack.plantecompagnon.src.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "pseudo", childColumns = "userId"))
public class UserPlant /* extends Plant */ {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String name;
    private int age;
    private String status;
    private int size;
    private boolean favorite;
    private String location;
    private String arrivalDate;
    private String origin;
    private String picture;
    private String notes;

    private String userId;


    public UserPlant(@NonNull String name, int age, String status, int size, boolean favorite, String location, String arrivalDate, String origin, String picture, String notes, String userId) {
        super();
        this.name = name;
        this.age = age;
        this.status = status;
        this.size = size;
        this.favorite = favorite;
        this.location = location;
        this.arrivalDate = arrivalDate;
        this.origin = origin;
        this.picture = picture;
        this.notes = notes;

        this.userId = userId;

    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
