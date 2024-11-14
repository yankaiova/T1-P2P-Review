package ru.akhramenko.P2PReview.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "material_id", nullable = false)
    private UUID material_id;

    @Column(name = "material_link", nullable = false)
    private String material_link;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;
//материал с полями (id, link, и привязка к встрече по meeting_id. у одной встречи несколько материалов)
}