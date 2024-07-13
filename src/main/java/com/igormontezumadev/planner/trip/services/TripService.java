package com.igormontezumadev.planner.trip.services;

import com.igormontezumadev.planner.trip.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public void createTrip() {

    }
}
