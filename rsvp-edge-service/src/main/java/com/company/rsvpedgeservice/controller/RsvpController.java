package com.company.rsvpedgeservice.controller;

import com.company.rsvpedgeservice.service.RsvpService;
import com.company.rsvpedgeservice.viewmodel.RsvpViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rsvps")
public class RsvpController {

    @Autowired
    RsvpService service;

    /**
     * Allows users to create an Event
     * @param rsvp
     * @return
     */
    @PostMapping
    public RsvpViewModel createEvent(@RequestBody RsvpViewModel rsvp){
        return service.createEvent(rsvp);
    }

}
