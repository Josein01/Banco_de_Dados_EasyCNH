package com.example.demo.Candidate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Aula.Aula;
import com.example.demo.CourseAccess.CourseAccess;
import com.example.demo.Payment.Payment;
import com.example.demo.QuizResult.QuizResult;
import com.example.demo.User.User;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "candidate",
    indexes = {
        @Index(name = "idx_candidate_package", columnList = "package_type"),
        @Index(name = "idx_candidate_aprovado", columnList = "aprovado")
    }
)
public class Candidate {
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
    private String userId;
    @OneToOne
    @JoinColumn(
        name = "userId",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_candidate_user")
    )
    private User user;
    @Enumerated(EnumType.STRING)
    @Column(name = "package_type", nullable = false)
    private Package packageType = Package.BRONZE;

    @Column(nullable = false)
    private float courseProgress = 0f; // 0–100%

    @Column(nullable = false)
    private int theoreticalScore = 0; // 0–100

    @Column(nullable = false)
    private int practicalAulas = 0; // count

    @Column(nullable = false)
    private boolean aprovado = false;

    @Column(nullable = false)
    private int reprovacoes = 0;

    @Column
    private LocalDateTime targetDate; // quando quer tirar CNH

    @Column
    private String reason; 

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Relacionamentos
    @OneToMany(mappedBy = "candidate")
     private List<Aula> aulas;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private CourseAccess courseAccess;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private QuizResult quizResult;

    @OneToMany(mappedBy = "candidate")
    private List<Payment> pagamentos;

    // Ciclo de vida
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    public enum Package {
        BRONZE,    // R$ 697
        PRATA,     // R$ 997
        OURO      // R$ 1.497
    }   
    public Candidate() {
    }
    // Getters e Setters
    public Candidate (Long id, String userId, User user, Package packageType, float courseProgress, int theoreticalScore, int practicalAulas, boolean aprovado, int reprovacoes, LocalDateTime targetDate, String reason, LocalDateTime createdAt, LocalDateTime updatedAt, QuizResult quizResult, List<Aula> aulas, CourseAccess courseAccess, List<Payment> pagamentos) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.packageType = packageType;
        this.courseProgress = courseProgress;
        this.theoreticalScore = theoreticalScore;
        this.practicalAulas = practicalAulas;
        this.aprovado = aprovado;
        this.reprovacoes = reprovacoes;
        this.targetDate = targetDate;
        this.reason = reason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.quizResult = quizResult;
        this.aulas = aulas;
        this.courseAccess = courseAccess;
        this.pagamentos = pagamentos;
    }
    public Candidate (String userId, User user, Package packageType, float courseProgress, int theoreticalScore, int practicalAulas, boolean aprovado, int reprovacoes, LocalDateTime targetDate, String reason, LocalDateTime createdAt, LocalDateTime updatedAt, QuizResult quizResult, List<Aula> aulas, CourseAccess courseAccess, List<Payment> pagamentos) {
        this.userId = userId;
        this.user = user;
        this.packageType = packageType;
        this.courseProgress = courseProgress;
        this.theoreticalScore = theoreticalScore;
        this.practicalAulas = practicalAulas;
        this.aprovado = aprovado;
        this.reprovacoes = reprovacoes;
        this.targetDate = targetDate;
        this.reason = reason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.quizResult = quizResult;
        this.aulas = aulas;
        this.courseAccess = courseAccess;
        this.pagamentos = pagamentos;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Package getPackageType() {
        return packageType;
    }
    public void setPackageType(Package packageType) {
        this.packageType = packageType;
    }
    public float getCourseProgress() {
        return courseProgress;
    }
    public void setCourseProgress(float courseProgress) {
        this.courseProgress = courseProgress;
    }
    public int getTheoreticalScore() {
        return theoreticalScore;
    }
    public void setTheoreticalScore(int theoreticalScore) {
        this.theoreticalScore = theoreticalScore;
    }
    public int getPracticalAulas() {
        return practicalAulas;
    }
    public void setPracticalAulas(int practicalAulas) {
        this.practicalAulas = practicalAulas;
    }
    public boolean isAprovado() {
        return aprovado;
    }
    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
    public int getReprovacoes() {
        return reprovacoes;
    }
    public void setReprovacoes(int reprovacoes) {
        this.reprovacoes = reprovacoes;
    }
    public LocalDateTime getTargetDate() {
        return targetDate;
    }
    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
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
    public QuizResult getQuizResult() {
        return quizResult;
    }
    public void setQuizResult(QuizResult quizResult) {
        this.quizResult = quizResult;
    }
    public List<Aula> getAulas() {
        return aulas;
    }
    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
    public CourseAccess getCourseAccess() {
        return courseAccess;
    }
    public void setCourseAccess(CourseAccess courseAccess) {
        this.courseAccess = courseAccess;
    }
    public List<Payment> getPagamentos() {
        return pagamentos;
    }
    public void setPagamentos(List<Payment> pagamentos) {
        this.pagamentos = pagamentos;
    }
    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", user=" + user +
                ", packageType=" + packageType +
                ", courseProgress=" + courseProgress +
                ", theoreticalScore=" + theoreticalScore +
                ", practicalAulas=" + practicalAulas +
                ", aprovado=" + aprovado +
                ", reprovacoes=" + reprovacoes +
                ", targetDate=" + targetDate +
                ", reason='" + reason + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", quizResult=" + quizResult +
                ", aulas=" + aulas + 
                ", courseAccess=" + courseAccess + 
                ", pagamentos=" + pagamentos +
                '}';
    }

}
