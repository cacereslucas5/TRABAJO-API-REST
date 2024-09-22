package com.example.persona.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;

@Entity
@Table(name ="domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
@Builder
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private int numero;

    @JsonBackReference
    @OneToOne(mappedBy = "domicilio")
    private Persona persona;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_localidad")
    @JsonManagedReference
    private Localidad localidad;
}
