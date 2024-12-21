package org.usermanagementservice.moviemanagementservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.usermanagementservice.moviemanagementservice.enums.RoomStatus;
import org.usermanagementservice.moviemanagementservice.enums.RoomType;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private LocalDate creationDate;

    private int numberOfChairs;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    @Enumerated(EnumType.STRING)
    private RoomType type;
}

