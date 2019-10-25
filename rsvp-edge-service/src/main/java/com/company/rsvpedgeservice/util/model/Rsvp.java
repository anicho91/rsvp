package com.company.rsvpedgeservice.util.model;

import java.util.Objects;

public class Rsvp {
    private int rsvpId;
    private String guestName;
    private int totalAttending;
    private String phoneNumber;

    public Rsvp(int rsvpId, String guestName, int totalAttending, String phoneNumber) {
        this.rsvpId = rsvpId;
        this.guestName = guestName;
        this.totalAttending = totalAttending;
        this.phoneNumber = phoneNumber;
    }

    public Rsvp() {
    }

    public int getRsvpId() {
        return rsvpId;
    }

    public void setRsvpId(int rsvpId) {
        this.rsvpId = rsvpId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getTotalAttending() {
        return totalAttending;
    }

    public void setTotalAttending(int totalAttending) {
        this.totalAttending = totalAttending;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rsvp rsvp = (Rsvp) o;
        return rsvpId == rsvp.rsvpId &&
                totalAttending == rsvp.totalAttending &&
                Objects.equals(guestName, rsvp.guestName) &&
                Objects.equals(phoneNumber, rsvp.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rsvpId, guestName, totalAttending, phoneNumber);
    }
}
