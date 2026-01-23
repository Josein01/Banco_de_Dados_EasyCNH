package com.example.demo.CourseAccess;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Candidate.Candidate;
import com.example.demo.CourseLesson.CourseLesson;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "CourseAccess",
    indexes = {
        @Index(name = "idx_course_access_candidate", columnList = "candidateId")
    }
)
public class CourseAccess {
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
    @Column(nullable = false, unique = true, insertable = false, updatable = false)
    private String candidateId;

    @OneToOne
    @JoinColumn(
        name = "candidateId",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_course_access_candidate")
    )
    private Candidate candidate;

    @Column(nullable = false)
    private LocalDateTime iniciadoEm;

    @Column(nullable = false)
    private LocalDateTime ultimoAcessoEm;

    @Column
    private LocalDateTime completadoEm;

    @ElementCollection
    @CollectionTable(
        name = "course_access_aulas_assistidas",
        joinColumns = @JoinColumn(name = "course_access_id")
    )
    @Column(name = "aula_id")
    private List<String> aulasAssistidas; // Array de IDs

    @ElementCollection
    @CollectionTable(
        name = "course_access_quizzes_concluidos",
        joinColumns = @JoinColumn(name = "course_access_id")
    )
    @Column(name = "quiz_id")
    private List<String> quizzesConcluidos; // Array de IDs

    @Column(nullable = false)
    private int pontuacao = 0;

    @ManyToMany
    @JoinTable(
        name = "course_access_lessons",
        joinColumns = @JoinColumn(name = "course_access_id"),
        inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private List<CourseLesson> aulas;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.iniciadoEm = now;
        this.ultimoAcessoEm = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.ultimoAcessoEm = LocalDateTime.now();
    }
    public CourseAccess() {
    }
    public CourseAccess(Long id, String candidateId, Candidate candidate, LocalDateTime iniciadoEm, LocalDateTime ultimoAcessoEm, LocalDateTime completadoEm, List<String> aulasAssistidas, List<String> quizzesConcluidos, int pontuacao, List<CourseLesson> aulas) {
        this.id = id;
        this.candidateId = candidateId;
        this.candidate = candidate;
        this.iniciadoEm = iniciadoEm;
        this.ultimoAcessoEm = ultimoAcessoEm;
        this.completadoEm = completadoEm;
        this.aulasAssistidas = aulasAssistidas;
        this.quizzesConcluidos = quizzesConcluidos;
        this.pontuacao = pontuacao;
        this.aulas = aulas;
    }
        public CourseAccess(String candidateId, Candidate candidate, LocalDateTime iniciadoEm, LocalDateTime ultimoAcessoEm, LocalDateTime completadoEm, List<String> aulasAssistidas, List<String> quizzesConcluidos, int pontuacao, List<CourseLesson> aulas) {
        this.candidateId = candidateId;
        this.candidate = candidate;
        this.iniciadoEm = iniciadoEm;
        this.ultimoAcessoEm = ultimoAcessoEm;
        this.completadoEm = completadoEm;
        this.aulasAssistidas = aulasAssistidas;
        this.quizzesConcluidos = quizzesConcluidos;
        this.pontuacao = pontuacao;
        this.aulas = aulas;
        }

    public List<CourseLesson> getAulas() {
        return aulas;
    }

    public void setAulas(List<CourseLesson> aulas) {
        this.aulas = aulas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public LocalDateTime getIniciadoEm() {
        return iniciadoEm;
    }

    public void setIniciadoEm(LocalDateTime iniciadoEm) {
        this.iniciadoEm = iniciadoEm;
    }

    public LocalDateTime getUltimoAcessoEm() {
        return ultimoAcessoEm;
    }

    public void setUltimoAcessoEm(LocalDateTime ultimoAcessoEm) {
        this.ultimoAcessoEm = ultimoAcessoEm;
    }

    public LocalDateTime getCompletadoEm() {
        return completadoEm;
    }

    public void setCompletadoEm(LocalDateTime completadoEm) {
        this.completadoEm = completadoEm;
    }

    public List<String> getAulasAssistidas() {
        return aulasAssistidas;
    }

    public void setAulasAssistidas(List<String> aulasAssistidas) {
        this.aulasAssistidas = aulasAssistidas;
    }

    public List<String> getQuizzesConcluidos() {
        return quizzesConcluidos;
    }

    public void setQuizzesConcluidos(List<String> quizzesConcluidos) {
        this.quizzesConcluidos = quizzesConcluidos;
    }
    @Override
    public String toString() {
        return "CourseAccess{" +
                "id=" + id +
                ", candidateId='" + candidateId + '\'' +
                ", candidate=" + candidate +
                ", iniciadoEm=" + iniciadoEm +
                ", ultimoAcessoEm=" + ultimoAcessoEm +
                ", completadoEm=" + completadoEm +
                ", aulasAssistidas=" + aulasAssistidas +
                ", quizzesConcluidos=" + quizzesConcluidos +
                ", pontuacao=" + pontuacao +
                ", aulas=" + aulas +
                '}';}
    }
