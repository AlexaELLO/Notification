package com.education.demospringboot.service;
import com.education.demospringboot.model.Notification;
import com.education.demospringboot.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Optional<Notification> getById(Integer id) {
        return notificationRepository.findById(id);
    }

    public Notification post(Notification requestNotification) {
        return notificationRepository.save(requestNotification);
    }

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public Notification updateById(Integer id, Notification requestNotification) {
        if (notificationRepository.findById(id).isPresent()) {
            return notificationRepository.save(requestNotification);
        } else {
            throw new RuntimeException("Notification not found");
        }
    }

    public void deleteById(Integer id) {
        notificationRepository.deleteById(id);
    }

}
