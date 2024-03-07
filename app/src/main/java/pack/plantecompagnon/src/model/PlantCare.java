package pack.plantecompagnon.src.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = UserPlant.class, parentColumns = "id", childColumns = "userPlantId"))
public class PlantCare {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Date date;
    private String notes;

    private int userPlantId;

    public PlantCare(Date date, String notes, int userPlantId) {
        this.date = date;
        this.notes = notes;

        this.userPlantId = userPlantId;
    }

    //Getters et setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getUserPlantId() {
        return userPlantId;
    }

    public void setUserPlantId(int userPlantId) {
        this.userPlantId = userPlantId;
    }



    /*
    public void addNewCare(){

    }

    public void modifyCare(){

    }

    public void deleteCare(){

    }

     */
}


