package pack.plantecompagnon.src;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity
public class UserPlant extends Plant{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private Date age;
    private PlantStatusList status;
    private int size;
    private boolean favorite;
    private HousePieceList location;
    private Date arrivalDate;
    private PlantOriginList origin;
    private String picture;
    private String notes;

    public UserPlant(String name, Date age, PlantStatusList status, int size, boolean favorite, HousePieceList location, Date arrivalDate, PlantOriginList origin, String picture, String notes) {
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
    }

    // Getters et Setters
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

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public PlantStatusList getStatus() {
        return status;
    }

    public void setStatus(PlantStatusList status) {
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

    public HousePieceList getLocation() {
        return location;
    }

    public void setLocation(HousePieceList location) {
        this.location = location;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public PlantOriginList getOrigin() {
        return origin;
    }

    public void setOrigin(PlantOriginList origin) {
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


    // Méthodes
    public void addNewUserPlant() {

    }

    public void deleteUserPlant() {

    }

    public void addUserPlantToFavorite(UserPlant plant) {

    }

    public void removeUserPlantFromFavorite(UserPlant plant) {

    }

    @Override
    public void modifyPlant() {
        super.modifyPlant();
    }

    public List<Plant> findUserPlant(String search) {
        return null;
    }

    public List<Plant> getAllFavorite() {
        return null;
    }

    public List<Reminders> getAllPlantReminders() {
        return null;
    }

    public List<PlantProblems> getAllPlantProblems() {
        return null;
    }
}
