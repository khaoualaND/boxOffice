package org.usermanagementservice.moviemanagementservice.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.usermanagementservice.moviemanagementservice.entities.CinemaRoom;
import org.usermanagementservice.moviemanagementservice.services.CinemaRoomService;

import java.util.List;

public class CinemaRoomGraphqlController {

    private final CinemaRoomService service;

    public CinemaRoomGraphqlController(CinemaRoomService service) {
        this.service = service;
    }

    @QueryMapping
    public List<CinemaRoom> getAll() {
        return service.getAll();
    }
}
