package com.example.demo.SupportMessage;
import java.time.LocalDateTime;

import com.example.demo.SupportTicket.SupportTicket;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "supportMessage")
public class SupportMessage {
    @Id
    @SequenceGenerator(
        name = "support_message_sequence",
        sequenceName = "support_message_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "support_message_sequence"
    )
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private SupportTicket ticket;
    @Column(nullable = false)
    private String autoria; 
    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensagem;

    private LocalDateTime criado = LocalDateTime.now();
    public SupportMessage() {
    }
    public SupportMessage(String id, SupportTicket ticket, String autoria, String mensagem, LocalDateTime criado) {
        this.id = id;
        this.ticket = ticket;
        this.autoria = autoria;
        this.mensagem = mensagem;
        this.criado = criado;
    }
    public SupportMessage(SupportTicket ticket, String autoria, String mensagem) {
        this.ticket = ticket;
        this.autoria = autoria;
        this.mensagem = mensagem;
    }
    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public SupportTicket getTicket() {
        return ticket;
    }
    public void setTicket(SupportTicket ticket) {
        this.ticket = ticket;
    }
    public String getAutoria() {
        return autoria;
    }
    public void setAutoria(String autoria) {
        this.autoria = autoria;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public LocalDateTime getCriado() {
        return criado;
    }
    public void setCriado(LocalDateTime criado) {
        this.criado = criado;
    }
    @Override
    public String toString() {
        return "SupportMessage [id=" + id + ", ticket=" + ticket + ", autoria=" + autoria + ", mensagem=" + mensagem
                + ", criado=" + criado + "]";
    }
}
