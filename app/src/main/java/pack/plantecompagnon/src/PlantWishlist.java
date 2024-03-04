package pack.plantecompagnon.src;

import java.util.Date;

public class PlantWishlist {

    private Date wantedSinceDate;
    private String picture;
    private String notes;

    public PlantWishlist(Date wantedSinceDate, String picture, String notes) {
        this.wantedSinceDate = wantedSinceDate;
        this.picture = picture;
        this.notes = notes;
    }

    // Getters et Setters
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

    // Méthodes
    public void addPlantToWishList(Plant plant) {

    }

    public void removePlantFromWishList(Plant plant) {

    }

    public void removeAllPlantFromWishList() {

    }

    public void modifyWishListNotes() {

    }

    public Plant getPlantDetails() {
        return null;
    }

    public Plant findPlantInWishList(String search) {
        return null;
    }
}