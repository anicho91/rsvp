package com.company.rsvpedgeservice.service;

import com.company.rsvpedgeservice.util.feign.RsvpFeign;
import com.company.rsvpedgeservice.util.model.Rsvp;
import com.company.rsvpedgeservice.viewmodel.RsvpViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RsvpServiceTest {

    @InjectMocks
    RsvpService service;

    @Mock
    RsvpFeign rFeign;

    @Before
    public void setUp() throws Exception {
        setUpFeignClientMock();
    }

    @Test
    public void testCreateEventPass() {

        RsvpViewModel rvm = new RsvpViewModel();
        rvm.setGuestName("bob");
        rvm.setTotalAttending(3);
        rvm.setPhoneNumber("323");
        service.createEvent(rvm);
        rvm.setRsvpId(1);

        assertNotNull(rvm);

    }

    @Test
    public void testCreateEventFail() throws IllegalArgumentException{

        RsvpViewModel rvm = new RsvpViewModel();
        rvm.setGuestName("bob");
        rvm.setTotalAttending(8);
        rvm.setPhoneNumber("323");
        service.createEvent(rvm);

        when(service.createEvent(rvm)).thenThrow(new IllegalArgumentException("Not a valid attending amount"));

    }

    private void setUpFeignClientMock() {
        Rsvp newRsvp = new Rsvp(
                0, "guest Name", 3, "323"
        );

        Rsvp newRsvp1 = new Rsvp(
                1, "guest Name", 3, "323"
        );

    }

}