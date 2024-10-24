package org.team9.prp.entity;

import java.sql.Time;
import jakarta.persistence.*;

@Entity
public class Meeting {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id", nullable=false)
    private User client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="expert_id", nullable=false)
    private User expert;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="slot_id", nullable=false)
    private Slot slot;

    private Time startTime;
    private Time endTime;
    private String meetingType;

    protected Meeting() {}

    public Meeting(Time startTime, Time endTime, String meetingType) {
        this.startTime = startTime;
        this.startTime = endTime;
        this.meetingType = meetingType;
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

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

}