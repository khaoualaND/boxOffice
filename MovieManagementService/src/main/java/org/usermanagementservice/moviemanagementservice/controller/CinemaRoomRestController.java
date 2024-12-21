package org.usermanagementservice.moviemanagementservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.usermanagementservice.moviemanagementservice.entities.CinemaRoom;
import org.usermanagementservice.moviemanagementservice.enums.RoomStatus;
import org.usermanagementservice.moviemanagementservice.enums.RoomType;
import org.usermanagementservice.moviemanagementservice.services.CinemaRoomService;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class CinemaRoomRestController {

    private final CinemaRoomService service;

    public CinemaRoomRestController(CinemaRoomService service) {
        this.service = service;
    }

    @GetMapping
    public List<CinemaRoom> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaRoom> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<CinemaRoom> search(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) RoomStatus status,
                                   @RequestParam(required = false) RoomType type) {
        if (name != null) return service.getByName(name);
        if (status != null) return service.getByStatus(status);
        if (type != null) return service.getByType(type);
        return service.getAll();
    }

    @PostMapping
    public CinemaRoom create(@RequestBody CinemaRoom room) {
        return service.save(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CinemaRoom> update(@PathVariable Long id, @RequestBody CinemaRoom room) {
        return service.getById(id)
                .map(existing -> {
                    room.setId(id);
                    return ResponseEntity.ok(service.save(room));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
