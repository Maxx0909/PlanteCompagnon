package pack.plantecompagnon.src;

import java.util.Date;

public class PlantProblems {

    private ProblemTypeList problemType;
    private Date date;
    private boolean resolutionStatus;
    private String picture;
    private String notes;

    public PlantProblems(ProblemTypeList problemType, Date date, boolean resolutionStatus, String picture, String notes) {
        this.problemType = problemType;
        this.date = date;
        this.resolutionStatus = resolutionStatus;
        this.picture = picture;
        this.notes = notes;
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

    //Méthodes

    public void addProblem(){

    }

    public void modifyProblem(){

    }

    public void deleteProblem(){

    }

    public void setResolved(){

    }
}
