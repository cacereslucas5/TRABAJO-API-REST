package com.example.persona.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="libro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
@Builder
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    private int fecha;
    @Column(name = "genero")
    private String genero;
    @Column(name="paginas")
    private int paginas;
    @Column(name = "autor")
    private String autor;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "fk_persona")
    private Persona persona;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="libro_autor",
            joinColumns = @JoinColumn(name = "fk_libro"),
            inverseJoinColumns = @JoinColumn(name = "fk_autor")
    )

    @JsonManagedReference
    @Builder.Default
    private Set<Autor> autores= new HashSet<>();
}
