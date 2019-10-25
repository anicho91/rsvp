package com.company.rsvpedgeservice.controller;

import com.company.rsvpedgeservice.service.RsvpService;
import com.company.rsvpedgeservice.viewmodel.RsvpViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RsvpController.class)
public class RsvpControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RsvpService service;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testCreateEventPass() throws Exception {
        RsvpViewModel inputRsvp = new RsvpViewModel(
                null,"bob", 3, "343"
        );

        String inputJson = mapper.writeValueAsString(inputRsvp);

        RsvpViewModel expected = new RsvpViewModel(
                1,"bob", 3, "343"
        );

        String outputJson = mapper.writeValueAsString(expected);

        when(service.createEvent(inputRsvp)).thenReturn(expected);

        mockMvc.perform(post("/rsvps")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

//    @Test
//    public void testCreateEventFail() throws Exception {
//        RsvpViewModel inputRsvp = new RsvpViewModel(
//                null,"bob", 8, "343"
//        );
//
//        String inputJson = mapper.writeValueAsString(inputRsvp);
//
//        mockMvc.perform(post("/rsvps")
//                .content(inputJson)
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andDo(print())
//                .andExpect(status().isBadRequest());
//    }
}