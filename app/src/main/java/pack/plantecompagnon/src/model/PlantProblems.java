package pack.plantecompagnon.src.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = UserPlant.class, parentColumns = "id", childColumns = "userPlantId"))
public class PlantProblems {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private ProblemTypeList problemType;
    private Date date;
    private boolean resolutionStatus;
    private String picture;
    private String notes;

    private int userPlantId;

    public PlantProblems(ProblemTypeList problemType, Date date, boolean resolutionStatus, String picture, String notes, int userPlantId) {
        this.problemType = problemType;
        this.date = date;
        this.resolutionStatus = resolutionStatus;
        this.picture = picture;
        this.notes = notes;

        this.userPlantId = userPlantId;
    }

    public ProblemTypeList getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemTypeList problemType) {
        this.problemType = problemType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isResolutionStatus() {
        return resolutionStatus;
    }

    public void setResolutionStatus(boolean resolutionStatus) {
        this.resolutionStatus = resolutionStatus;
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

    public int getUserPlantId() {
        return userPlantId;
    }

    public void setUserPlantId(int userPlantId) {
        this.userPlantId = userPlantId;
    }

}
