package tn.eesprit.gestionevenementback.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "events",
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = "title")
            })
    public class Event {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        private Date startDate;
        private Date endDate;
        private String description;
        private String lieu;
        private EventType type;


        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
        @JoinColumn(name = "event_id")
        private Set<Activity> activites = new HashSet<>();




        public Event(String title,String description,Date startDate,Date endDate,String lieu,EventType type){

            this.title=title;
            this.description=description;
            this.startDate=startDate;
            this.endDate=endDate;
            this.lieu=lieu;
            this.type=type;
        }
    }
