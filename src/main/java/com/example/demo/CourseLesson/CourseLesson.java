package com.example.demo.CourseLesson;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.CourseAccess.CourseAccess;
import com.example.demo.CourseLessonQuiz.CourseLessonQuiz;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "CourseLesson",
    indexes = {
        @Index(name = "idx_course_lesson_modulo", columnList = "modulo"),
        @Index(name = "idx_course_lesson_ordem", columnList = "ordem")
    }
)
public class CourseLesson {
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
    @Column(nullable = false)
    private String titulo; 
    @Column
    private String descricao;

    @Column(nullable = false)
    private String videoUrl; 

    @Column(nullable = false)
    private int duracao; 

    @Column(nullable = false)
    private String modulo;

    @Column(nullable = false)
    private int ordem;

    @Column(columnDefinition = "text")
    private String transcricao; 
    @Column
    private String thumbnailUrl;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

 
    @OneToOne(mappedBy = "lesson", cascade = CascadeType.ALL)
    private CourseLessonQuiz quiz;

  
    @ManyToMany(mappedBy = "aulas")
    private List<CourseAccess> acessosEm;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    public CourseLesson() {
    }   
    public CourseLesson(Long id, String titulo, String descricao, String videoUrl, int duracao, String modulo, int ordem, String transcricao, String thumbnailUrl, LocalDateTime createdAt, CourseLessonQuiz quiz, List<CourseAccess> acessosEm) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.videoUrl = videoUrl;
        this.duracao = duracao;
        this.modulo = modulo;
        this.ordem = ordem;
        this.transcricao = transcricao;
        this.thumbnailUrl = thumbnailUrl;
        this.createdAt = createdAt;
        this.quiz = quiz;
        this.acessosEm = acessosEm;
    }
    public CourseLesson(String titulo, String descricao, String videoUrl, int duracao, String modulo, int ordem, String transcricao, String thumbnailUrl, LocalDateTime createdAt, CourseLessonQuiz quiz, List<CourseAccess> acessosEm) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.videoUrl = videoUrl;
        this.duracao = duracao;
        this.modulo = modulo;
        this.ordem = ordem;
        this.transcricao = transcricao;
        this.thumbnailUrl = thumbnailUrl;
        this.createdAt = createdAt;
        this.quiz = quiz;
        this.acessosEm = acessosEm;}
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getVideoUrl() {
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public String getModulo() {
        return modulo;
    }
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
    public int getOrdem() {
        return ordem;
    }
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
    public String getTranscricao() {
        return transcricao;
    }
    public void setTranscricao(String transcricao) {
        this.transcricao = transcricao;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public CourseLessonQuiz getQuiz() {
        return quiz;
    }
    public void setQuiz(CourseLessonQuiz quiz) {
        this.quiz = quiz;
    }
    public List<CourseAccess> getAcessosEm() {
        return acessosEm;
    }
    public void setAcessosEm(List<CourseAccess> acessosEm) {
        this.acessosEm = acessosEm;
    }
    @Override
    public String toString() {
        return "CourseLesson{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", duracao=" + duracao +
                ", modulo='" + modulo + '\'' +
                ", ordem=" + ordem + 
                ", transcricao='" + transcricao + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", createdAt=" + createdAt +
                ", quiz=" + quiz +
                ", acessosEm=" + acessosEm +
                '}';}
    }