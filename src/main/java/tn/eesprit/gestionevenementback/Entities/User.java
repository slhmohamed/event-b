package tn.eesprit.gestionevenementback.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 20)
    private String username;
    private String firstName;
    private String lastName;
    private Long phone;

    @NotBlank
    @Size(max = 50)

    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    private Boolean active= false;;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Reclamation> reclamations = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Facture> factures = new HashSet<>();
    public User(String username,String email,String password)
    {
        this.username=username;
        this.email=email;

        this.password=password;
    }
    public User(String firstName,String lastName,String username,Long phone,
                String email,String password,Set<Role> role)
    {
        this.username=username;
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
        this.password=password;
        this.roles=role;
    }


}