package com.example.demo.SupportTicket;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.User.User;

import com.example.demo.SupportMessage.SupportMessage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "supportTicket", indexes = {
        @Index(name = "idx_ticket_status", columnList = "status"),
        @Index(name = "idx_ticket_user", columnList = "user_id")
    })
public class SupportTicket {
    @Id
    @SequenceGenerator(
        name = "support_ticket_sequence",
        sequenceName = "support_ticket_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "support_ticket_sequence"
    )
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    private Categoria categoria = Categoria.GERAL;
    private StatusTicket status = StatusTicket.ABERTO;
    private Prioridade prioridade = Prioridade.NORMAL;
    private LocalDateTime criado = LocalDateTime.now();
    private LocalDateTime resolvido;
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupportMessage> mensagens;


public enum Categoria {
  AGENDAMENTO,
  PAGAMENTO,
  QUALIDADE_AULA,
  DOCUMENTOS,
  TÉCNICO,
  GERAL
}

  public enum StatusTicket {
  ABERTO,
  EM_PROGRESS,
  AGUARDANDO_CLIENTE,
  RESOLVIDO,
  FECHADO
}

public enum Prioridade {
  BAIXA,
  NORMAL,
  ALTA,
  CRÍTICA
}
    // Getters and Setters
    public SupportTicket() {
    }
    public SupportTicket(Long id, String titulo, String descricao, Categoria categoria, StatusTicket status, Prioridade prioridade, LocalDateTime criado, LocalDateTime resolvido, List<SupportMessage> mensagens, User user) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = status;
        this.prioridade = prioridade;
        this.criado = criado;
        this.resolvido = resolvido;
        this.mensagens = mensagens;
        this.user = user;
    }
    public SupportTicket(String titulo, String descricao, Categoria categoria, StatusTicket status, Prioridade prioridade, LocalDateTime criado, LocalDateTime resolvido, List<SupportMessage> mensagens, User user) {
         this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = status;
        this.prioridade = prioridade;
        this.criado = criado;
        this.resolvido = resolvido;
        this.mensagens = mensagens;
        this.user = user;
    }
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
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public StatusTicket getStatus() {
        return status;
    }
    public void setStatus(StatusTicket status) {
        this.status = status;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    public LocalDateTime getCriado() {
        return criado;
    }
    public void setCriado(LocalDateTime criado) {
        this.criado = criado;
    }
    public LocalDateTime getResolvido() {
        return resolvido;
    }
    public void setResolvido(LocalDateTime resolvido) {
        this.resolvido = resolvido;
    }
    public List<SupportMessage> getMensagens() {
        return mensagens;
    }
    public void setMensagens(List<SupportMessage> mensagens) {
        this.mensagens = mensagens;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "SupportTicket [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", categoria=" + categoria
                + ", status=" + status + ", prioridade=" + prioridade + ", criado=" + criado + ", resolvido="
                + resolvido + ", mensagens=" + mensagens + ", user=" + user + "]";
    }
}
