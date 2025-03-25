package br.com.restaurante.restaurante.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;  

import jakarta.persistence.*;

@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tag;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    @JsonIgnore
    private Restaurante restaurante;

    @Enumerated(EnumType.STRING)
    private StatusMesa status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public StatusMesa getStatus() {
        return status;
    }

    public void setStatus(StatusMesa status) {
        this.status = status;
    }
}
