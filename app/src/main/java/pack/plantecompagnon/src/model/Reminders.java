package pack.plantecompagnon.src.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = UserPlant.class, parentColumns = "id", childColumns = "userPlantId"))
public class Reminders {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private ReminderTypeList type;
    private Date next;
    private int frequency;

    private int userPlantId;

    public Reminders(ReminderTypeList type, Date next, int frequency, int userPlantId) {
        this.type = type;
        this.next = next;
        this.frequency = frequency;

        this.userPlantId = userPlantId;
    }

    // Getters et Setters
    public ReminderTypeList getType() {
        return type;
    }

    public void setType(ReminderTypeList type) {
        this.type = type;
    }

    public Date getNext() {
        return next;
    }

    public void setNext(Date next) {
        this.next = next;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getUserPlantId() {
        return userPlantId;
    }

    public void setUserPlantId(int userPlantId) {
        this.userPlantId = userPlantId;
    }

    /*
    //Méthodes

    public void setNewReminder(Date dateNextReminder) {

    }

    public void modifyReminder() {

    }

    public void deleteReminder() {

    }

    public Date getNextReminder() {

        return next;
    }

    public void enableReminder() {

    }

    public void disableReminder() {

    }

    public void notifyUser() {

    }

    public void validateReminder() {

    }

    public void snoozeReminder() {

    }

     */
}


