package com.education.demospringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    @JsonProperty("id")
    private Integer id;
    @Column(name="message")
    @JsonProperty("message")
    private String message;
    @Column(name="time")
    @JsonProperty("time")
    private LocalDateTime time;

    public Notification() {};

    public Notification(Integer id, String message, LocalDateTime time) {
        this.id = id;
        this.message = message;
        this.time = time;
    }
}
