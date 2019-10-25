package com.company.rsvpedgeservice.service;

import com.company.rsvpedgeservice.util.feign.RsvpFeign;
import com.company.rsvpedgeservice.util.model.Rsvp;
import com.company.rsvpedgeservice.viewmodel.RsvpViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RsvpService {

    @Autowired
    RsvpFeign rFeign;

    /**
     * Allows user to create an event
     * if total attending is not between 0 & 6
     * @param rsvp
     * @return
     */
    public RsvpViewModel createEvent(RsvpViewModel rsvp){

        if(rsvp.getTotalAttending()<0 || rsvp.getTotalAttending()>6) {
            return null;
        }else {
            Rsvp newRsvp = new Rsvp();
            newRsvp.setGuestName(rsvp.getGuestName());
            newRsvp.setTotalAttending(rsvp.getTotalAttending());
            newRsvp.setPhoneNumber(rsvp.getPhoneNumber());
            rFeign.createEvent(newRsvp);
            rsvp.setRsvpId(newRsvp.getRsvpId());
            return rsvp;
        }

    }

}
