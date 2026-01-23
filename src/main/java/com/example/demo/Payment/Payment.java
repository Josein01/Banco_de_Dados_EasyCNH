package com.example.demo.Payment;
import java.time.LocalDateTime;

import com.example.demo.Candidate.Candidate;
import com.example.demo.Instrutor.Instrutor;

import jakarta.persistence.Column;
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
    name = "Payment",
    indexes = {
        @Index(name = "idx_payment_candidate", columnList = "candidateId"),
        @Index(name = "idx_payment_status", columnList = "status")
    }
)
public class Payment {
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
    private String candidateId;

    @ManyToOne
    @JoinColumn(
        name = "candidateId",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_payment_candidate")
    )
    private Candidate candidate;

    @Column(insertable = false, updatable = false)
    private String instrutorId;

    @ManyToOne
    @JoinColumn(
        name = "instrutorId",
        referencedColumnName = "id",
        foreignKey = @ForeignKey(name = "fk_payment_instrutor")
    )
    private Instrutor instructor;

    @Column(nullable = false)
    private float valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPagamento tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamento status = StatusPagamento.PENDING;

    @Column(nullable = false, unique = true)
    private String stripeId;

    @Column(nullable = false)
    private String stripeStatus;

    @Column
    private LocalDateTime refundedAt;

    @Column
    private Float refundAmount;

    @Column(nullable = false, updatable = false)
    private LocalDateTime criado;

    @Column(nullable = false)
    private LocalDateTime atualizado;

   


    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.criado = now;
        this.atualizado = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.atualizado = LocalDateTime.now();
    }

    public enum TipoPagamento {
        PACOTE_BRONZE,
        PACOTE_PRATA,
        PACOTE_OURO,
        CONCIERGE,
        SEGURO,
        SIMULADO,
        MARKETPLACE
    }

    public enum StatusPagamento {
        PENDING,
        PROCESSING,
        COMPLETED,
        FAILED,
        REFUNDED,
        DISPUTED
    }

     public Payment() {
    }

    public Payment(LocalDateTime atualizado, Candidate candidate, String candidateId, LocalDateTime criado, Long id, Instrutor instructor, String instrutorId, Float refundAmount, LocalDateTime refundedAt, String stripeId, String stripeStatus, TipoPagamento tipo, float valor) {
        this.atualizado = atualizado;
        this.candidate = candidate;
        this.candidateId = candidateId;
        this.criado = criado;
        this.id = id;
        this.instructor = instructor;
        this.instrutorId = instrutorId;
        this.refundAmount = refundAmount;
        this.refundedAt = refundedAt;
        this.stripeId = stripeId;
        this.stripeStatus = stripeStatus;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Payment(LocalDateTime atualizado, Candidate candidate, String candidateId, LocalDateTime criado, Instrutor instructor, String instrutorId, Float refundAmount, LocalDateTime refundedAt, String stripeId, String stripeStatus, TipoPagamento tipo, float valor) {
        this.atualizado = atualizado;
        this.candidate = candidate;
        this.candidateId = candidateId;
        this.criado = criado;
        this.instructor = instructor;
        this.instrutorId = instrutorId;
        this.refundAmount = refundAmount;
        this.refundedAt = refundedAt;
        this.stripeId = stripeId;
        this.stripeStatus = stripeStatus;
        this.tipo = tipo;
        this.valor = valor;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public String getStripeStatus() {
        return stripeStatus;
    }

    public void setStripeStatus(String stripeStatus) {
        this.stripeStatus = stripeStatus;
    }

    public LocalDateTime getRefundedAt() {
        return refundedAt;
    }

    public void setRefundedAt(LocalDateTime refundedAt) {
        this.refundedAt = refundedAt;
    }

    public Float getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Float refundAmount) {
        this.refundAmount = refundAmount;
    }

    public LocalDateTime getCriado() {
        return criado;
    }

    public void setCriado(LocalDateTime criado) {
        this.criado = criado;
    }

    public LocalDateTime getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(LocalDateTime atualizado) {
        this.atualizado = atualizado;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", candidateId='" + candidateId + '\'' +
                ", candidate=" + candidate +
                ", instrutorId='" + instrutorId + '\'' +
                ", instructor=" + instructor +
                ", valor=" + valor +
                ", tipo=" + tipo +
                ", status=" + status +
                ", stripeId='" + stripeId + '\'' +
                ", stripeStatus='" + stripeStatus + '\'' +
                ", refundedAt=" + refundedAt +
                ", refundAmount=" + refundAmount +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }
}
