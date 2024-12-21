package org.usermanagementservice.moviemanagementservice.services;


import org.springframework.stereotype.Service;
import org.usermanagementservice.moviemanagementservice.entities.CinemaRoom;
import org.usermanagementservice.moviemanagementservice.enums.RoomStatus;
import org.usermanagementservice.moviemanagementservice.enums.RoomType;
import org.usermanagementservice.moviemanagementservice.repositories.CinemaRoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaRoomService {

    private final CinemaRoomRepository repository;

    public CinemaRoomService(CinemaRoomRepository repository) {
        this.repository = repository;
    }

    public List<CinemaRoom> getAll() {
        return repository.findAll();
    }

    public Optional<CinemaRoom> getById(Long id) {
        return repository.findById(id);
    }

    public List<CinemaRoom> getByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<CinemaRoom> getByType(RoomType type) {
        return repository.findByType(type);
    }

    public List<CinemaRoom> getByStatus(RoomStatus status) {
        return repository.findByStatus(status);
    }

    public CinemaRoom save(CinemaRoom room) {
        return repository.save(room);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}