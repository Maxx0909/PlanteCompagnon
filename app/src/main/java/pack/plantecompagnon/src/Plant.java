package pack.plantecompagnon.src;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Plant {
    @PrimaryKey
    protected String species;
    protected int wateringFrequency;
    protected int lightRequirement;
    protected int humidityPreference;
    protected int temperaturePreference;
    protected String picture;

    public Plant(String species, int wateringFrequency, int lightRequirement, int humidityPreference, int temperaturePreference, String picture) {
        this.species = species;
        this.wateringFrequency = wateringFrequency;
        this.lightRequirement = lightRequirement;
        this.humidityPreference = humidityPreference;
        this.temperaturePreference = temperaturePreference;
        this.picture = picture;
    }
    public Plant() {

    }

    // Getters et Setters
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public int getLightRequirement() {
        return lightRequirement;
    }

    public void setLightRequirement(int lightRequirement) {
        this.lightRequirement = lightRequirement;
    }

    public int getHumidityPreference() {
        return humidityPreference;
    }

    public void setHumidityPreference(int humidityPreference) {
        this.humidityPreference = humidityPreference;
    }

    public int getTemperaturePreference() {
        return temperaturePreference;
    }

    public void setTemperaturePreference(int temperaturePreference) {
        this.temperaturePreference = temperaturePreference;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    /*
    // Méthodes
    public void addNewPlant() {

    }

    public void modifyPlant() {

    }

    public void deletePlant() {

    }

    public List<Plant> findPlant(String search) {
        return null;
    }

    public List<Plant> getListAllPlant() {
        return null;
    }

     */

}
