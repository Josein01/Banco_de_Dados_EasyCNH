package com.example.demo.Aula;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Candidate.Candidate;
import com.example.demo.Instrutor.Instrutor;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "aula",
    indexes = {
        @Index(name = "idx_aula_data_hora", columnList = "dataHora"),
        @Index(name = "idx_aula_status", columnList = "status"),
        @Index(name = "idx_aula_instrutor", columnList = "instrutorId"),
        @Index(name = "idx_aula_candidate", columnList = "candidateId")
    }
)
public class Aula {
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
        foreignKey = @ForeignKey(name = "fk_aula_instrutor")
    )
    private Instrutor instructor;

    // === Candidato ===
    @Column(nullable = false, insertable = false, updatable = false)
    private String candidateId;

    @ManyToOne
    @JoinColumn(
        name = "candidateId",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_aula_candidate")
    )
    private Candidate candidate;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private int duracao = 60; // minutos

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAula tipo = TipoAula.PRATICA_BÁSICA;

    @Column
    private LocalDateTime confirmadoAlunoAt;

    @Column
    private LocalDateTime confirmadoInstrutorAt;

    @Column
    private String fotoAntes; // S3 URL

    @Column
    private String fotoDepois; // S3 URL

    @Column
    private Integer avaliacao; // 1–5

    @Column
    private Integer nps; // 0–10

    @Column
    private String feedback;

    // === Tópicos ===
    @ElementCollection
    @CollectionTable(
        name = "aula_topicos_dominados",
        joinColumns = @JoinColumn(name = "aula_id")
    )
    @Column(name = "topico")
    private List<String> topicosDominados;

    @ElementCollection
    @CollectionTable(
        name = "aula_topicos_praticar",
        joinColumns = @JoinColumn(name = "aula_id")
    )
    @Column(name = "topico")
    private List<String> topicosPraticar;

    // === Status ===
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAula status = StatusAula.AGENDADA;

    @Column(nullable = false)
    private boolean faltouAm = false;

    // === Datas ===
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
    public enum TipoAula {
  TEORICA,
  PRATICA_BÁSICA,
  PRATICA_INTERMEDIÁRIA,
  PRATICA_AVANÇADA
}

public enum StatusAula {
  AGENDADA,
  CONFIRMADA_ALUNO,
  CONFIRMADA_INSTRUTOR,
  REALIZADA,
  CANCELADA_ALUNO,
  CANCELADA_INSTRUTOR,
  FALTA_ALUNO
}
public Aula() {
}
public Aula(Long id, String instrutorId, Instrutor instructor, String candidateId, Candidate candidate, LocalDateTime dataHora, int duracao, TipoAula tipo, LocalDateTime confirmadoAlunoAt, LocalDateTime confirmadoInstrutorAt, String fotoAntes, String fotoDepois, Integer avaliacao, Integer nps, String feedback, List<String> topicosDominados, List<String> topicosPraticar, StatusAula status, boolean faltouAm, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.instrutorId = instrutorId;
    this.instructor = instructor;
    this.candidateId = candidateId;
    this.candidate = candidate;
    this.dataHora = dataHora;
    this.duracao = duracao;
    this.tipo = tipo;
    this.confirmadoAlunoAt = confirmadoAlunoAt;
    this.confirmadoInstrutorAt = confirmadoInstrutorAt;
    this.fotoAntes = fotoAntes;
    this.fotoDepois = fotoDepois;
    this.avaliacao = avaliacao;
    this.nps = nps;
    this.feedback = feedback;
    this.topicosDominados = topicosDominados;
    this.topicosPraticar = topicosPraticar;
    this.status = status;
    this.faltouAm = faltouAm;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
}
    public Aula(Integer avaliacao, Candidate candidate, String candidateId, LocalDateTime confirmadoAlunoAt, LocalDateTime confirmadoInstrutorAt, LocalDateTime createdAt, LocalDateTime dataHora, String feedback, String fotoAntes, String fotoDepois, Long id, Instrutor instructor, String instrutorId, Integer nps, List<String> topicosDominados, List<String> topicosPraticar, LocalDateTime updatedAt) {
        this.avaliacao = avaliacao;
        this.candidate = candidate;
        this.candidateId = candidateId;
        this.confirmadoAlunoAt = confirmadoAlunoAt;
        this.confirmadoInstrutorAt = confirmadoInstrutorAt;
        this.createdAt = createdAt;
        this.dataHora = dataHora;
        this.feedback = feedback;
        this.fotoAntes = fotoAntes;
        this.fotoDepois = fotoDepois;
        this.id = id;
        this.instructor = instructor;
        this.instrutorId = instrutorId;
        this.nps = nps;
        this.topicosDominados = topicosDominados;
        this.topicosPraticar = topicosPraticar;
        this.updatedAt = updatedAt;
    }

    // === Lifecycle ===
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isFaltouAm() {
        return faltouAm;
    }

    public void setFaltouAm(boolean faltouAm) {
        this.faltouAm = faltouAm;
    }

    public StatusAula getStatus() {
        return status;
    }

    public void setStatus(StatusAula status) {
        this.status = status;
    }

    public List<String> getTopicosPraticar() {
        return topicosPraticar;
    }

    public void setTopicosPraticar(List<String> topicosPraticar) {
        this.topicosPraticar = topicosPraticar;
    }

    public List<String> getTopicosDominados() {
        return topicosDominados;
    }

    public void setTopicosDominados(List<String> topicosDominados) {
        this.topicosDominados = topicosDominados;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getNps() {
        return nps;
    }

    public void setNps(Integer nps) {
        this.nps = nps;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getFotoAntes() {
        return fotoAntes;
    }

    public void setFotoAntes(String fotoAntes) {
        this.fotoAntes = fotoAntes;
    }

    public LocalDateTime getConfirmadoInstrutorAt() {
        return confirmadoInstrutorAt;
    }

    public void setConfirmadoInstrutorAt(LocalDateTime confirmadoInstrutorAt) {
        this.confirmadoInstrutorAt = confirmadoInstrutorAt;
    }

    public String getFotoDepois() {
        return fotoDepois;
    }

    public void setFotoDepois(String fotoDepois) {
        this.fotoDepois = fotoDepois;
    }

    public LocalDateTime getConfirmadoAlunoAt() {
        return confirmadoAlunoAt;
    }

    public void setConfirmadoAlunoAt(LocalDateTime confirmadoAlunoAt) {
        this.confirmadoAlunoAt = confirmadoAlunoAt;
    }

    public TipoAula getTipo() {
        return tipo;
    }

    public void setTipo(TipoAula tipo) {
        this.tipo = tipo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public Instrutor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instrutor instructor) {
        this.instructor = instructor;
    }

    public String getInstrutorId() {
        return instrutorId;
    }

    public void setInstrutorId(String instrutorId) {
        this.instrutorId = instrutorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

@Override
 public String toString() {
        return "Aula{" +
                "id=" + id +
                ", instrutorId='" + instrutorId + '\'' +
                ", instructor=" + instructor +
                ", candidateId='" + candidateId + '\'' +
                ", candidate=" + candidate +
                ", dataHora=" + dataHora +
                ", duracao=" + duracao +
                ", tipo=" + tipo +
                ", confirmadoAlunoAt=" + confirmadoAlunoAt +
                ", confirmadoInstrutorAt=" + confirmadoInstrutorAt +
                ", fotoAntes='" + fotoAntes + '\'' +
                ", fotoDepois='" + fotoDepois + '\'' +
                ", avaliacao=" + avaliacao +
                ", nps=" + nps +
                ", feedback='" + feedback + '\'' +
                ", topicosDominados=" + topicosDominados +
                ", topicosPraticar=" + topicosPraticar +
                ", status=" + status +
                ", faltouAm=" + faltouAm +
                ", createdAt=" + createdAt +
                 ", updatedAt=" + updatedAt +
                '}';
    }


}
