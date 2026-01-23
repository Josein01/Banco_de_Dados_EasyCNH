package com.example.demo.InstructorReview;
import java.time.LocalDateTime;

import com.example.demo.Instrutor.Instrutor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "InstructorReview",
    indexes = {
        @Index(name = "idx_review_instrutor", columnList = "instrutorId")
    }
)
public class InstructorReview {
    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    private Long id;
     @Column(nullable = false, insertable = false, updatable = false)
    private String instrutorId;

    @ManyToOne
    @JoinColumn(
        name = "instrutorId",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_review_instrutor")
    )
    private Instrutor instructor;

    @Column(nullable = false)
    private String aulaId; // FK lógica para rastrear a aula

    @Column(nullable = false)
    private int rating; // 1–5

    @Column
    private String titulo;

    @Column
    private String comentario;

    @Column(columnDefinition = "json")
    private String categorias;

    @Column(nullable = false)
    private boolean anonimo = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @PrePersist
    protected void onCreate() {
        this.criadoEm = LocalDateTime.now();
    }

    public InstructorReview() {
    }

     public InstructorReview(String aulaId, String categorias, String comentario, LocalDateTime criadoEm, Long id, Instrutor instructor, String instrutorId, int rating, String titulo) {
        this.aulaId = aulaId;
        this.categorias = categorias;
        this.comentario = comentario;
        this.criadoEm = criadoEm;
        this.id = id;
        this.instructor = instructor;
        this.instrutorId = instrutorId;
        this.rating = rating;
        this.titulo = titulo;
    }

       public InstructorReview(String aulaId, String categorias, String comentario, LocalDateTime criadoEm, Instrutor instructor, String instrutorId, int rating, String titulo) {
        this.aulaId = aulaId;
        this.categorias = categorias;
        this.comentario = comentario;
        this.criadoEm = criadoEm;
        this.instructor = instructor;
        this.instrutorId = instrutorId;
        this.rating = rating;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrutorId() {
        return instrutorId;
    }

    public void setInstrutorId(String instrutorId) {
        this.instrutorId = instrutorId;
    }

    public Instrutor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instrutor instructor) {
        this.instructor = instructor;
    }

    public String getAulaId() {
        return aulaId;
    }

    public void setAulaId(String aulaId) {
        this.aulaId = aulaId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public boolean isAnonimo() {
        return anonimo;
    }

    public void setAnonimo(boolean anonimo) {
        this.anonimo = anonimo;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    @Override
    public String toString() {
        return "InstructorReview{" +
                "id=" + id +
                ", instrutorId='" + instrutorId + '\'' +
                ", instructor=" + instructor +
                ", aulaId='" + aulaId + '\'' +
                ", rating=" + rating +
                ", titulo='" + titulo + '\'' +
                ", comentario='" + comentario + '\'' +
                ", categorias='" + categorias + '\'' +
                ", anonimo=" + anonimo +
                ", criadoEm=" + criadoEm +
                '}';
    }

}
