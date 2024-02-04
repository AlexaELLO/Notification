package com.education.demospringboot.servicenotification;

import com.education.demospringboot.model.Notification;
import com.education.demospringboot.repositorynotification.NotificationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class Controller {

    private NotificationRepository notificationRepository;

    public Controller(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping(value = "/notification/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<Notification> getNotificationById(@PathVariable Integer id) {
        //studentRepository.save(student);
        return notificationRepository.findById(id);
    }

    @PutMapping(value = "/notification", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Notification postNotificatio(@RequestBody Notification requestNotification) {
        return notificationRepository.save(requestNotification);
    }

    @GetMapping(value = "/notifications", produces = APPLICATION_JSON_VALUE)
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @PostMapping(value = "/notification/update/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Notification updateNotificationById(@PathVariable Integer id, @RequestBody Notification requestNotification) {
        if (notificationRepository.findById(id).isPresent()) {
            return notificationRepository.save(requestNotification);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    @DeleteMapping(value = "/notification/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteNotificationById(@PathVariable Integer id) {
        notificationRepository.deleteById(id);
    }
}


/*
 * Уведомления
 * КРУД приложение, для уведомлений
 * */