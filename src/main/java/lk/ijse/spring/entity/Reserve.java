package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Reserve {

    @Id
    private String reserveId;

    private String reserveDate;
    private String pickUpDate;
    private String pickUpTime;
    private String destination;
    private int duration;
    private String pickUpVenue;
    private String returnVenue;
    private String returnDate;
    private String returnTime;
    private String requestAcceptOrDeny;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "reserve",cascade = CascadeType.ALL)
    private List<ReserveDetails> reserveDetails;

}