package com.anna.and.jay.rsvpbackingservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Rsvp")
public class Rsvp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 1, max = 50)
    @NotEmpty(message = "guest name must not be empty")
    @Column(name = "guest_name")
    private String guestName;

    @Min(1)
    @Max(4)
    @NotNull(message = "total attending must not be null")
    @Column(name = "total_attending")
    private Integer totalAttending;

    @NotEmpty
    @Size(min = 1, max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Rsvp rsvp = (Rsvp) o;
        return getId() == rsvp.getId() &&
                Objects.equals(getGuestName(), rsvp.getGuestName()) &&
                Objects.equals(getTotalAttending(), rsvp.getTotalAttending()) &&
                Objects.equals(getPhoneNumber(), rsvp.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGuestName(), getTotalAttending(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", totalAttending=" + totalAttending +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
