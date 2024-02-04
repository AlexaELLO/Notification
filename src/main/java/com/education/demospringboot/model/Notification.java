package com.education.demospringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    @JsonProperty("id")
    private Integer id;
    @Column(name = "message")
    @JsonProperty("message")
    private String message;
    @Column(name = "alert_time")
    @JsonProperty("alertTime")
    private LocalDateTime alertTime;

}
