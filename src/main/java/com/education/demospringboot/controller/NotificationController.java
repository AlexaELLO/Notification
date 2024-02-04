package com.education.demospringboot.controller;

import com.education.demospringboot.model.Notification;
import com.education.demospringboot.repository.NotificationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class NotificationController {

    private final NotificationRepository notificationRepository;

    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping(value = "/notifications/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<Notification> getNotificationById(@PathVariable Integer id) {
        return notificationRepository.findById(id);
    }

    @PutMapping(value = "/notifications", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Notification postNotification(@RequestBody Notification requestNotification) {
        return notificationRepository.save(requestNotification);
    }

    @GetMapping(value = "/notifications", produces = APPLICATION_JSON_VALUE)
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @PostMapping(value = "/notifications/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Notification updateNotificationById(@PathVariable Integer id, @RequestBody Notification requestNotification) {
        if (notificationRepository.findById(id).isPresent()) {
            return notificationRepository.save(requestNotification);
        } else {
            throw new RuntimeException("Notification not found");
        }
    }

    @DeleteMapping(value = "/notifications/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteNotificationById(@PathVariable Integer id) {
        notificationRepository.deleteById(id);
    }
}
