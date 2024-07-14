package com.igormontezumadev.planner.participant.controllers;

import com.igormontezumadev.planner.participant.entities.Participant;
import com.igormontezumadev.planner.participant.payload.ParticipantRequestPayload;
import com.igormontezumadev.planner.participant.repositories.ParticipantRepository;
import com.igormontezumadev.planner.participant.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    ParticipantRepository participantRepository;

    @PostMapping("/{id}/confirm")
    public ResponseEntity<Participant> confirmParticipant(
            @PathVariable UUID id,
            @RequestBody ParticipantRequestPayload payload
    ) {
        Optional<Participant> participant = this.participantRepository.findById(id);

        if (participant.isPresent()) {
            Participant rawParticipant = participant.get();
            rawParticipant.setIsConfirmed(true);
            rawParticipant.setName(payload.name());

            this.participantRepository.save(rawParticipant);
            return ResponseEntity.ok(rawParticipant);
        }
        return ResponseEntity.notFound().build();
    }
}
