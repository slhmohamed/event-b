package tn.eesprit.gestionevenementback.Entities;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ReservationId;



    @OneToOne(mappedBy = "reservation",cascade = CascadeType.REMOVE)
    Payement payement;
    @ManyToOne
    ServiceClient serviceClient;
    @ManyToOne
    Event event;
    @ManyToOne
    User user;
}
