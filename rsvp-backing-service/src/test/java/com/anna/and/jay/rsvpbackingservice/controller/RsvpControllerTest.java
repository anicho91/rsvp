package com.anna.and.jay.rsvpbackingservice.controller;

import com.anna.and.jay.rsvpbackingservice.dao.RsvpRepo;
import com.anna.and.jay.rsvpbackingservice.dto.Rsvp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RsvpController.class)
public class RsvpControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RsvpRepo rsvpRepo;

    @Before
    public void setUp(){
        rsvpRepo.deleteAll();
    }

    private String asJsonString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        return mapper.writeValueAsString(obj);
    }

    @Test
    public void createRsvp() throws Exception {
        Rsvp inputRsvp = new Rsvp();
        inputRsvp.setGuestName("name");
        inputRsvp.setTotalAttending(2);
        inputRsvp.setPhoneNumber("2222222222");

        Rsvp outputRsvp = new Rsvp();
        outputRsvp.setId(1);
        outputRsvp.setGuestName("name");
        outputRsvp.setTotalAttending(2);
        outputRsvp.setPhoneNumber("2222222222");

        doReturn(outputRsvp).when(rsvpRepo).save(inputRsvp);

        this.mockMvc.perform(post("/rsvps")
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8")
            .content(asJsonString(inputRsvp)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(asJsonString(outputRsvp)));


    }

    //TODO To test edge cases on validations

    @Test
    public void fetchRsvp() throws Exception {
        Rsvp outputRsvp = new Rsvp();
        outputRsvp.setId(1);
        outputRsvp.setGuestName("name");
        outputRsvp.setTotalAttending(2);
        outputRsvp.setPhoneNumber("2222222222");

        doReturn(Optional.of(outputRsvp)).when(rsvpRepo).findById(outputRsvp.getId());

        this.mockMvc.perform(get("/rsvps/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(outputRsvp)));

    }

    @Test
    public void fetchAllRsvps() throws Exception {
        List<Rsvp> rsvpList = new ArrayList<>();
        Rsvp outputRsvp1 = new Rsvp();
        outputRsvp1.setId(1);
        outputRsvp1.setGuestName("name");
        outputRsvp1.setTotalAttending(2);
        outputRsvp1.setPhoneNumber("2222222222");
        Rsvp outputRsvp2 = new Rsvp();
        outputRsvp2.setId(1);
        outputRsvp2.setGuestName("name");
        outputRsvp2.setTotalAttending(2);
        outputRsvp2.setPhoneNumber("2222222222");
        Rsvp outputRsvp3 = new Rsvp();
        outputRsvp3.setId(1);
        outputRsvp3.setGuestName("name");
        outputRsvp3.setTotalAttending(2);
        outputRsvp3.setPhoneNumber("2222222222");

        rsvpList.add(outputRsvp1);
        rsvpList.add(outputRsvp2);
        rsvpList.add(outputRsvp3);
        doReturn(rsvpList).when(rsvpRepo).findAll();

        this.mockMvc.perform(get("/rsvps"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(rsvpList)));

    }

    @Test
    public void updateRsvp() throws Exception {
        Rsvp outputRsvp2 = new Rsvp();
        outputRsvp2.setId(1);
        outputRsvp2.setGuestName("name");
        outputRsvp2.setTotalAttending(2);
        outputRsvp2.setPhoneNumber("2222222222");

        Rsvp outputRsvp3 = new Rsvp();
        outputRsvp3.setId(1);
        outputRsvp3.setGuestName("name");
        outputRsvp3.setTotalAttending(2);
        outputRsvp3.setPhoneNumber("2222222222");

        doReturn(Optional.of(outputRsvp2)).when(rsvpRepo).findById(1);
        doReturn(outputRsvp3).when(rsvpRepo).save(outputRsvp3);

        this.mockMvc.perform(put("/rsvps")
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8")
            .content(asJsonString(outputRsvp3)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteRsvp() throws Exception {
        int idToDelete = 1;
        doNothing().when(rsvpRepo).deleteById(idToDelete);

        this.mockMvc.perform(delete("/rsvps/"+idToDelete))
                .andDo(print())
                .andExpect(status().isOk());

    }
}