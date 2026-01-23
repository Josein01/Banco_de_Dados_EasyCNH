package com.example.demo.User;
import java.time.LocalDateTime;
  
import com.example.demo.Candidate.Candidate;
import com.example.demo.Instrutor.Instrutor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

// Usuário Base

@Entity
@Table(name = "User",
    indexes = {
        @Index(name = "idx_user_email", columnList = "email"),
        @Index(name = "idx_user_role", columnList = "role")
    })

public class User {
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
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private role Role = role.CANDIDATE;
     @Column
    private String profilePhoto;
    @Column(nullable = false)
    private boolean verified = false;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime updatedAt = null;
     @Column
    private LocalDateTime deletedAt;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Candidate candidate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Instrutor instrutor;

    // @OneToMany(mappedBy = "user")
    // private List<SupportTicket> tickets;

    // @OneToMany(mappedBy = "user")
    // private List<Payment> payments;




    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum role {
        INSTRUCTOR,
        USER,
        CANDIDATE
    }
    // Getters and Setters
    public User() {
    }
    public User(Long id, String name, String email, String password, String phone, role Role, String profilePhoto, boolean verified, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Candidate candidate, Instrutor instrutor) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.Role = Role;
        this.profilePhoto = profilePhoto;
        this.verified = verified;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.candidate = candidate;
        this.instrutor = instrutor;
    } 
    public User(String name, String email, String password, String phone, role Role, String profilePhoto, boolean verified, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Candidate candidate, Instrutor instrutor) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.Role = Role;
        this.profilePhoto = profilePhoto;
        this.verified = verified;
        this.candidate = candidate;
        this.instrutor = instrutor;
    } 
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public role getRole() {
        return Role;
    }
    public void setRole(role role) {
        Role = role;
    }
    public String getProfilePhoto() {
        return profilePhoto;
    }
    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
    public boolean isVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
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
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
    public Candidate getCandidate() {
        return candidate;
    }
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
    public Instrutor getInstrutor() {
        return instrutor;
    }
    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", Role=" + Role +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", verified=" + verified +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
