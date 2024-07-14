package com.igormontezumadev.planner.participant.repositories;

import com.igormontezumadev.planner.participant.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {

    List<Participant> findByTripId(UUID tripId);
}
