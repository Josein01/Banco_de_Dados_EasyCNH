package com.example.demo.QuizResult;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Candidate.Candidate;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "QuizResult",
    indexes = {
        @Index(name = "idx_quiz_candidate", columnList = "candidateId")
    }
)
public class QuizResult {
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
        foreignKey = @ForeignKey(name = "fk_quiz_candidate")
    )
    private Candidate candidate;

    // === Resultado ===
    @ElementCollection
    @CollectionTable(
        name = "quiz_respostas",
        joinColumns = @JoinColumn(name = "quiz_result_id")
    )
    @Column(name = "resposta")
    private List<String> respostas; // Array de opções selecionadas

    @Column(nullable = false)
    private int score; // 0–100

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Package recomendacao; 

    @Column(nullable = false)
    private float economia; // R$ economizados

    @Column(nullable = false, updatable = false)
    private LocalDateTime completadoEm;

    @PrePersist
    protected void onCreate() {
        this.completadoEm = LocalDateTime.now();
    }
   public enum Package {
  BRONZE,    // R$ 697
  PRATA,     // R$ 997
  OURO      // R$ 1.497
}
public QuizResult() {

}
public QuizResult(Long id, String candidateId, Candidate candidate, List<String> respostas, int score,
        Package recomendacao, float economia, LocalDateTime completadoEm) {
    this.id = id;
    this.candidateId = candidateId;
    this.candidate = candidate;
    this.respostas = respostas;
    this.score = score;
    this.recomendacao = recomendacao;
    this.economia = economia;
    this.completadoEm = completadoEm;}
    public QuizResult(String candidateId, Candidate candidate, List<String> respostas, int score,
        Package recomendacao, float economia, LocalDateTime completadoEm) {
    this.candidateId = candidateId;
    this.candidate = candidate;
    this.respostas = respostas;
    this.score = score;
    this.recomendacao = recomendacao;
    this.economia = economia;
    this.completadoEm = completadoEm;
}
public Long getId() {
    return id;
}
public String getCandidateId() {
    return candidateId;
    }
public Candidate getCandidate() {
    return candidate;
}
public List<String> getRespostas() {
    return respostas;
}
public int getScore() {
    return score;
}
public Package getRecomendacao() {
    return recomendacao;
}
public float getEconomia() {
    return economia;
}
public LocalDateTime getCompletadoEm() {
    return completadoEm;
} 
public void setId(Long id) {
    this.id = id;

}
public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
}
public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
}
public void setRespostas(List<String> respostas) {
    this.respostas = respostas;
}
public void setScore(int score) {
    this.score = score;
}
public void setRecomendacao(Package recomendacao) {
    this.recomendacao = recomendacao;
}
public void setEconomia(float economia) {
    this.economia = economia;
}
public void setCompletadoEm(LocalDateTime completadoEm) {
    this.completadoEm = completadoEm;
} 
@Override
public String toString() {
    return "QuizResult [id=" + id + ", candidateId=" + candidateId + ", candidate=" + candidate + ", respostas="
            + respostas + ", score=" + score + ", recomendacao=" + recomendacao + ", economia=" + economia
            + ", completadoEm=" + completadoEm + "]";
}
}

