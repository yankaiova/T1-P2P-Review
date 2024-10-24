package org.team9.prp.entity;

import jakarta.persistence.*;
import java.util.Set;


@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String telegram;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Slot> slots;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expert")
    private Set<Meeting> meetings_expert;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private Set<Meeting> meetings_client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Change> changes;

    protected User() {}

    public User(String telegram) {
        this.telegram = telegram;
    }

    public Set getSlots() {
        return this.slots;
    }

    public Set getMeetingsExpert() {
        return this.meetings_expert;
    }
    
    public Set getMeetingsClient() {
        return this.meetings_client;
    }

    public Set getChanges() {
        return this.changes;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }
}