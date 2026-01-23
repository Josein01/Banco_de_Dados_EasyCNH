package com.example.demo.Instrutor;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Aula.Aula;
import com.example.demo.InstructorReview.InstructorReview;
import com.example.demo.Payment.Payment;
import com.example.demo.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "Instrutor",
    indexes = {
        @Index(name = "idx_instructor_approved", columnList = "approved"),
        @Index(name = "idx_instructor_rating", columnList = "rating"),
        @Index(name = "idx_instructor_taxa_aprovacao", columnList = "taxa_aprovacao")
    }
)
public class Instrutor {
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
    @OneToOne
    @JoinColumn(
        name = "userId",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_instructor_user")
    )
    private User user;
    @Column(nullable = false, unique = true)
    private String cnh; // CNH número validado

    @Column(nullable = false)
    private LocalDateTime cnhValidatedAt;

    @Column(nullable = false)
    private boolean backgroundCheck = false;

    @Column(nullable = false)
    private boolean approved = false;

    @Column
    private LocalDateTime approvedAt;

    @Column(nullable = false)
    private float rating = 5.0f; // 1–5 stars

    @Column(nullable = false)
    private int aulasConcluidas = 0;

    @Column(name = "taxa_aprovacao", nullable = false)
    private int taxaAprovacao = 0; // %

    @Column(nullable = false)
    private int reviewsCount = 0;

    // === Disponibilidade ===
    @Column(columnDefinition = "json", nullable = false)
    private String horariosDisponiveis;
    // JSON ex: { "seg": ["18:00", "19:00"], "ter": [...] }

    @Column(nullable = false)
    private float precoAula = 80f; // R$ por aula

    @Column
    private String localizacao; // Endereço

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime suspendedAt;

  
    @OneToMany(mappedBy = "instructor")
    private List<Aula> aulas;

    @OneToMany(mappedBy = "instructor")
    private List<InstructorReview> reviews;

    @OneToMany(mappedBy = "instructor")
    private List<Payment> pagamentos;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Instrutor() {
    }
    // Getters and Setters 
    public Instrutor(Long id, User user, String cnh, LocalDateTime cnhValidatedAt, boolean backgroundCheck, boolean approved, LocalDateTime approvedAt, float rating, int aulasConcluidas, int taxaAprovacao, int reviewsCount, String horariosDisponiveis, float precoAula, String localizacao, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime suspendedAt, List<Aula> aulas, List<InstructorReview> reviews, List<Payment> pagamentos) {
        this.id = id;
        this.user = user;
        this.cnh = cnh;
        this.cnhValidatedAt = cnhValidatedAt;
        this.backgroundCheck = backgroundCheck;
        this.approved = approved;
        this.approvedAt = approvedAt;
        this.rating = rating;
        this.aulasConcluidas = aulasConcluidas;
        this.taxaAprovacao = taxaAprovacao;
        this.reviewsCount = reviewsCount;
        this.horariosDisponiveis = horariosDisponiveis;
        this.precoAula = precoAula;
        this.localizacao = localizacao;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.suspendedAt = suspendedAt;
        this.aulas = aulas;
        this.reviews = reviews;
        this.pagamentos = pagamentos;
    }
    public Instrutor(User user, String cnh, LocalDateTime cnhValidatedAt, boolean backgroundCheck, boolean approved, LocalDateTime approvedAt, float rating, int aulasConcluidas, int taxaAprovacao, int reviewsCount, String horariosDisponiveis, float precoAula, String localizacao, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime suspendedAt, List<Aula> aulas, List<InstructorReview> reviews, List<Payment> pagamentos) {
        this.user = user;
        this.cnh = cnh;
        this.cnhValidatedAt = cnhValidatedAt;
        this.backgroundCheck = backgroundCheck;
        this.approved = approved;
        this.approvedAt = approvedAt;
        this.rating = rating;
        this.aulasConcluidas = aulasConcluidas;
        this.taxaAprovacao = taxaAprovacao;
        this.reviewsCount = reviewsCount;
        this.horariosDisponiveis = horariosDisponiveis;
        this.precoAula = precoAula;
        this.localizacao = localizacao;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.suspendedAt = suspendedAt;
        this.aulas = aulas;
        this.reviews = reviews;
        this.pagamentos = pagamentos;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getCnh() {
        return cnh;
    }
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    public LocalDateTime getCnhValidatedAt() {
        return cnhValidatedAt;
    }
    public void setCnhValidatedAt(LocalDateTime cnhValidatedAt) {
        this.cnhValidatedAt = cnhValidatedAt;
    }
    public boolean isBackgroundCheck() {
        return backgroundCheck;
    }
    public void setBackgroundCheck(boolean backgroundCheck) {
        this.backgroundCheck = backgroundCheck;
    }
    public boolean isApproved() {
        return approved;
    }
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    public LocalDateTime getApprovedAt() {
        return approvedAt;
    }
    public void setApprovedAt(LocalDateTime approvedAt) {
        this.approvedAt = approvedAt;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public int getAulasConcluidas() {
        return aulasConcluidas;
    }
    public void setAulasConcluidas(int aulasConcluidas) {
        this.aulasConcluidas = aulasConcluidas;
    }
    public int getTaxaAprovacao() {
        return taxaAprovacao;
    }
    public void setTaxaAprovacao(int taxaAprovacao) {
        this.taxaAprovacao = taxaAprovacao;
    }
    public int getReviewsCount() {
        return reviewsCount;
    }
    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }
    public String getHorariosDisponiveis() {
        return horariosDisponiveis;
    }
    public void setHorariosDisponiveis(String horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }
    public float getPrecoAula() {
        return precoAula;
    }
    public void setPrecoAula(float precoAula) {
        this.precoAula = precoAula;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public LocalDateTime getSuspendedAt() {
        return suspendedAt;
    }
    public void setSuspendedAt(LocalDateTime suspendedAt) {
        this.suspendedAt = suspendedAt;
    }
    public List<Aula> getAulas() {
        return aulas;
    }
    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
    public List<InstructorReview> getReviews() {
        return reviews;
    }
    public void setReviews(List<InstructorReview> reviews) {
        this.reviews = reviews;
    }
    public List<Payment> getPagamentos() {
        return pagamentos;
    }
    public void setPagamentos(List<Payment> pagamentos) {
        this.pagamentos = pagamentos;
    }
    @Override
    public String toString() {
        return "Instrutor{" +
                "id=" + id +
                ", user=" + user +
                ", cnh='" + cnh + '\'' +
                ", cnhValidatedAt=" + cnhValidatedAt +
                ", backgroundCheck=" + backgroundCheck +
                ", approved=" + approved +
                ", approvedAt=" + approvedAt +
                ", rating=" + rating +
                ", aulasConcluidas=" + aulasConcluidas +
                ", taxaAprovacao=" + taxaAprovacao +
                ", reviewsCount=" + reviewsCount +
                ", horariosDisponiveis='" + horariosDisponiveis + '\'' +
                ", precoAula=" + precoAula +
                ", localizacao='" + localizacao + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", suspendedAt=" + suspendedAt +
                ", aulas=" + aulas + 
                ", reviews=" + reviews +
                ", pagamentos=" + pagamentos +
                '}';
    }
    

}
