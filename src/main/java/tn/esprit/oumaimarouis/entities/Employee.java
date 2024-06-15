package tn.esprit.oumaimarouis.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeID;
    private String lastName;
    private String firstName;
    private String position;

    @ManyToOne
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "employee")
    private Set<Donation> donationSet;
}