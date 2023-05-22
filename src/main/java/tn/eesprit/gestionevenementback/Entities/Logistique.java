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
public class Logistique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer LogistiqueId;




    @OneToOne(cascade = CascadeType.PERSIST)
    Event event;
    @OneToOne
    Payement payement;
    @OneToOne (mappedBy = "logistique",cascade = CascadeType.REMOVE)
    ResourceMateriel resource;
    @OneToOne (mappedBy = "logistique",cascade = CascadeType.REMOVE)
    ServiceClient serviceClient;

}
