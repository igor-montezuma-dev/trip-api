package com.igormontezumadev.planner.participant.repositories;

import com.igormontezumadev.planner.participant.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
}
