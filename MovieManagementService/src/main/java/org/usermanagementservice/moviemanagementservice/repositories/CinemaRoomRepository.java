package org.usermanagementservice.moviemanagementservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.usermanagementservice.moviemanagementservice.entities.CinemaRoom;
import org.usermanagementservice.moviemanagementservice.enums.RoomStatus;
import org.usermanagementservice.moviemanagementservice.enums.RoomType;

import java.util.List;

public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Long> {

    List<CinemaRoom> findByNameContainingIgnoreCase(String name);

    List<CinemaRoom> findByType(RoomType type);

    List<CinemaRoom> findByStatus(RoomStatus status);
}