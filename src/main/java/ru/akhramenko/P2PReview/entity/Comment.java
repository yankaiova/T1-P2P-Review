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
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "comment_id", nullable = false)
    private UUID meeting_id;

    @Column(name = "comment_text", nullable = false)
    private String comment_text;

    @Column(name = "create_time")
    private Time create_time;

    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;
//rкоммент с полями (id, текст,user_id,create_time и привязка к встрече по meeting_id. у одной встречи несколько комментов) юзеры берутся с другого бека и бд
}