package com.anna.and.jay.rsvpbackingservice.dao;

import com.anna.and.jay.rsvpbackingservice.dto.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RsvpRepo extends JpaRepository<Rsvp, Integer> {
}
