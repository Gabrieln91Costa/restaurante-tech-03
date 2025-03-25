package br.com.restaurante.restaurante.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;  // Importa a anotação para ignorar o campo

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    
    private Integer quantidadeMesas;


    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Mesa> mesas;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeMesas() {
        return quantidadeMesas;
    }

    public void setQuantidadeMesas(Integer quantidadeMesas) {
        this.quantidadeMesas = quantidadeMesas;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }
}
