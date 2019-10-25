package com.anna.and.jay.rsvpbackingservice.controller;

import com.anna.and.jay.rsvpbackingservice.dao.RsvpRepo;
import com.anna.and.jay.rsvpbackingservice.dto.Rsvp;
import javassist.NotFoundException;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class RsvpController {
    private RsvpRepo rsvpRepo;

    public RsvpController(RsvpRepo rsvpRepo){
        this.rsvpRepo = rsvpRepo;
    }

    @PostMapping("/rsvps")
    @ResponseStatus(HttpStatus.CREATED)
    public Rsvp createRsvp(@RequestBody @Valid Rsvp rsvp){
        return rsvpRepo.save(rsvp);
    }

    @GetMapping("/rsvps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rsvp fetchRsvp(@PathVariable int id) throws NotFoundException {
        Rsvp fetchedRsvp = rsvpRepo.findById(id).orElse(null);
        if(fetchedRsvp == null){
            throw new NotFoundException("No rsvp found!");
        }
        return fetchedRsvp;
    }
    @GetMapping("/rsvps")
    @ResponseStatus(HttpStatus.OK)
    public List<Rsvp> fetchAllRsvps(){
        return rsvpRepo.findAll();
    }
    @PutMapping("/rsvps")
    @ResponseStatus(HttpStatus.OK)
    public void updateRsvp(@RequestBody @Valid Rsvp rsvp) throws NotFoundException {
        Rsvp fetchedRsvp = rsvpRepo.findById(rsvp.getId()).orElse(null);
        if(fetchedRsvp == null){
            throw new NotFoundException("Rsvp was not found!!!");
        }
        rsvpRepo.save(rsvp);
    }
    @DeleteMapping("/rsvps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRsvp(@PathVariable int id){
        rsvpRepo.deleteById(id);
    }
}
