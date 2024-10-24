package org.team9.prp.entity;

import java.sql.Time;
import jakarta.persistence.*;

@Entity
public class Change {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    private String meetingStatus;
    private String description;
    private Time changeTime;

    protected Change() {}

    public Change(String meetingStatus, String description, Time changeTime){
        this.meetingStatus = meetingStatus;
        this.description = description;
        this.changeTime = changeTime;
    }

    public Time getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Time changeTime) {
        this.changeTime = changeTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

}