package com.company.rsvpedgeservice.util.feign;

import com.company.rsvpedgeservice.util.model.Rsvp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "rsvp-backing-service")
public interface RsvpFeign {

    @PostMapping("/rsvps")
    Rsvp createEvent(@RequestBody Rsvp rsvp);
}
