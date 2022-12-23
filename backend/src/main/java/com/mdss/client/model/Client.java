package com.mdss.client.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{field.name.required}")
    private String name;

    @Column(nullable = false, length = 11)
    @CPF(message = "{field.cpf.invalid}")
    @NotNull(message = "{field.cpf.required}")
    private String cpf;

    @Column(nullable = false, updatable = false)
    private LocalDate registerDate;

    @PrePersist
    public void prePersist(){
        setRegisterDate(LocalDate.now());
    }

    public Client() {
    }

    public Client(Long id, String name, String cpf, LocalDate registerDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.registerDate = registerDate;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return getId().equals(client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
