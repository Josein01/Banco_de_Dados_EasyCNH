package com.example.demo.Quiz;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.QuizResult.QuizResult;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "Quiz",
    indexes = {
        @Index(name = "idx_quiz_question_ordem", columnList = "ordem")
    }
)
public class Quiz {
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
    private String pergunta; 

    @ElementCollection
    @CollectionTable(
        name = "quiz_question_opcoes",
        joinColumns = @JoinColumn(name = "question_id")
    )
    @Column(name = "opcao")
    private List<String> opcoes; 

    @Column(nullable = false)
    private String respostaCorreta; 

    @Column(nullable = false)
    private int peso = 1; 

    @Column(nullable = false)
    private int ordem;

    @Column(nullable = false)
    private boolean ativa = true;

    // === Datas ===
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // === Relacionamentos ===
    @ManyToMany
    @JoinTable(
        name = "quiz_question_results",
        joinColumns = @JoinColumn(name = "question_id"),
        inverseJoinColumns = @JoinColumn(name = "quiz_result_id")
    )
    private List<QuizResult> resultados;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    public Quiz() {
    }

        public Quiz(LocalDateTime createdAt, Long id, List<String> opcoes, int ordem, String pergunta, String respostaCorreta, List<QuizResult> resultados, int peso, boolean ativa) {
        this.createdAt = createdAt;
        this.id = id;
        this.opcoes = opcoes;
        this.ordem = ordem;
        this.pergunta = pergunta;
        this.respostaCorreta = respostaCorreta;
        this.resultados = resultados;
        this.peso = peso;
        this.ativa = ativa;
    }

    public Quiz(LocalDateTime createdAt, List<String> opcoes, int ordem, String pergunta, String respostaCorreta, List<QuizResult> resultados, int peso, boolean ativa) {
        this.createdAt = createdAt;
        this.opcoes = opcoes;
        this.ordem = ordem;
        this.pergunta = pergunta;
        this.respostaCorreta = respostaCorreta;
        this.resultados = resultados;
        this.peso = peso;
        this.ativa = ativa;
        this.resultados = resultados;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    public List<String> getOpcoes() {
        return opcoes;
    }
    public void setOpcoes(List<String> opcoes) {
        this.opcoes = opcoes;
    }
    public String getRespostaCorreta() {
        return respostaCorreta;
    }
    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
    public int getOrdem() {
        return ordem;
    }
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public List<QuizResult> getResultados() {
        return resultados;
    }

    public void setResultados(List<QuizResult> resultados) {
        this.resultados = resultados;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    
    @Override
    public String toString() {
        return "Quiz [id=" + id + ", pergunta=" + pergunta + ", opcoes=" + opcoes + ", respostaCorreta=" + respostaCorreta
                + ", ordem=" + ordem + ", createdAt=" + createdAt + ", peso=" + peso + ", ativa=" + ativa + "]";
    }

}
