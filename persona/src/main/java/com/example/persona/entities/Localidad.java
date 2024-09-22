package com.example.persona.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="localidad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
@Builder
public class Localidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "denominacion")
    private String denominacion;

    @OneToMany(mappedBy = "localidad")
    @JsonBackReference
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();
}
