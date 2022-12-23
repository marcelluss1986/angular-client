package com.mdss.client.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "servprov")
public class ServiceProvided {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateServiceProv;

    public ServiceProvided() {
    }

    public ServiceProvided(Long id, String description, BigDecimal price, Client client, LocalDate dateServiceProv) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.client = client;
        this.dateServiceProv = dateServiceProv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateServiceProv() {
        return dateServiceProv;
    }

    public void setDateServiceProv(LocalDate dateServiceProv) {
        this.dateServiceProv = dateServiceProv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceProvided that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
