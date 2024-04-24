package cc.example.busbooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public  class BusBooking {
    @Id
    private Long id;
    private String passengerName;
    private String source;
    private String destination;
    private double fare;

    @OneToOne
    @JsonBackReference
    private BusDetails busdetails;
}
