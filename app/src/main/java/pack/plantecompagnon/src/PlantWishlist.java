package pack.plantecompagnon.src;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;
@Entity(foreignKeys ={
        @ForeignKey(entity = User.class,
                    parentColumns = "pseudo",
                    childColumns = "userId"),

        @ForeignKey(entity = UserPlant.class,
                    parentColumns = "id",
                    childColumns = "plantId")
})
public class PlantWishlist {
    @PrimaryKey(autoGenerate = true)
    private int id;

    //TO DO : gérer cas de plant
    private int plantId;
    private Date wantedSinceDate;
    private String picture;
    private String notes;

    private String userId;

    public PlantWishlist(int plantId, Date wantedSinceDate, String picture, String notes, String userId) {
        this.plantId = plantId;

        this.wantedSinceDate = wantedSinceDate;
        this.picture = picture;
        this.notes = notes;

        this.userId = userId;
    }

    // Getters et Setters
    public int getPlantId(){
        return plantId;
    }

    public Date getWantedSinceDate() {
        return wantedSinceDate;
    }

    public void setWantedSinceDate(Date wantedSinceDate) {
        this.wantedSinceDate = wantedSinceDate;
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

    /*
    // Méthodes
    public void addPlantToWishList(int plant) {

    }

    public void removePlantFromWishList(int plant) {

    }

    public void removeAllPlantFromWishList() {

    }

    public void modifyWishListNotes() {

    }

    public int getPlantDetails() {
        return null;
    }

    public int findPlantInWishList(String search) {
        return null;
    }

     */
}