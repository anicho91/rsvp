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
    private String guest_name;

    @Min(1)
    @Max(4)
    @NotNull(message = "total attending must not be null")
    private Integer total_attending;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String phone_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public Integer getTotal_attending() {
        return total_attending;
    }

    public void setTotal_attending(Integer total_attending) {
        this.total_attending = total_attending;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rsvp rsvp = (Rsvp) o;
        return getId() == rsvp.getId() &&
                Objects.equals(getGuest_name(), rsvp.getGuest_name()) &&
                Objects.equals(getTotal_attending(), rsvp.getTotal_attending()) &&
                Objects.equals(getPhone_number(), rsvp.getPhone_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGuest_name(), getTotal_attending(), getPhone_number());
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "id=" + id +
                ", guest_name='" + guest_name + '\'' +
                ", total_attending=" + total_attending +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
