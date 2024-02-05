package com.education.demospringboot.controller;

import com.education.demospringboot.model.Notification;
import com.education.demospringboot.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping(value = "/notifications/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<Notification> getNotificationById(@PathVariable Integer id) {
        return notificationService.getById(id);
    }

    @PutMapping(value = "/notifications", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Notification postNotification(@RequestBody Notification requestNotification) {
        return notificationService.post(requestNotification);
    }

    @GetMapping(value = "/notifications", produces = APPLICATION_JSON_VALUE)
    public List<Notification> getAllNotifications() {
        return notificationService.getAll();
    }

    @PostMapping(value = "/notifications/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Notification updateNotificationById(@PathVariable Integer id, @RequestBody Notification requestNotification) {
        if (notificationService.getById(id).isPresent()) {
            return notificationService.post(requestNotification);
        } else {
            throw new RuntimeException("Notification not found");
        }
    }

    @DeleteMapping(value = "/notifications/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteNotificationById(@PathVariable Integer id) {
        notificationService.deleteById(id);
    }
}
