package org.team9.prp.entity;

import java.sql.Time;
import jakarta.persistence.*;

@Entity
public class Slot {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private Time startTime;
    private Time endTime;
    private String description;
    private String typeSlot;
    private boolean isAvailable;

    protected Slot() {}

    public Slot(Time startTime, Time endTime, String description, String typeSlot, boolean isAvailable){
        this.startTime = startTime;
        this.startTime = endTime;
        this.description = description;
        this.typeSlot = typeSlot;
        this.isAvailable = isAvailable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeSlot() {
        return typeSlot;
    }

    public void setTypeSlot(String typeSlot) {
        this.typeSlot = typeSlot;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}