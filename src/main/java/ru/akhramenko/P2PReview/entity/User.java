package ru.akhramenko.P2PReview.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.akhramenko.P2PReview.entity.enums.Competence;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID user_id;

    @Column(name = "telegram")
    private String telegram;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "role")
    private String role;

    @Column(name = "area")
    private String area;

    @Column(name = "competence")
    private Competence competence;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Slot> slots;

    @OneToMany(mappedBy = "expert",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Meeting> experts;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Meeting> clients;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Change> changes;
}
