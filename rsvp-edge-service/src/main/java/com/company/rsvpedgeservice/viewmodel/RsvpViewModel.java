package com.company.rsvpedgeservice.viewmodel;

import java.util.Objects;

public class RsvpViewModel {
    private Integer rsvpId;
    private String guestName;
    private Integer totalAttending;
    private String phoneNumber;

    public RsvpViewModel(Integer rsvpId, String guestName, Integer totalAttending, String phoneNumber) {
        this.rsvpId = rsvpId;
        this.guestName = guestName;
        this.totalAttending = totalAttending;
        this.phoneNumber = phoneNumber;
    }

    public RsvpViewModel() {
    }

    public Integer getRsvpId() {
        return rsvpId;
    }

    public void setRsvpId(Integer rsvpId) {
        this.rsvpId = rsvpId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Integer getTotalAttending() {
        return totalAttending;
    }

    public void setTotalAttending(Integer totalAttending) {
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
        RsvpViewModel that = (RsvpViewModel) o;
        return Objects.equals(rsvpId, that.rsvpId) &&
                Objects.equals(guestName, that.guestName) &&
                Objects.equals(totalAttending, that.totalAttending) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rsvpId, guestName, totalAttending, phoneNumber);
    }
}
