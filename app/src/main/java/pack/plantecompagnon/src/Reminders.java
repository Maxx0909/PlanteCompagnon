package pack.plantecompagnon.src;

import java.util.Date;

public class Reminders {

    private ReminderTypeList type;
    private Date next;
    private int frequency;

    public Reminders(ReminderTypeList type, Date next, int frequency) {
        this.type = type;
        this.next = next;
        this.frequency = frequency;
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
}


