package br.com.restaurante.restaurante.dto;

public class RestauranteDTO {

    private String nome;
    private int quantidadeMesas;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeMesas() {
        return quantidadeMesas;
    }

    public void setQuantidadeMesas(int quantidadeMesas) {
        this.quantidadeMesas = quantidadeMesas;
    }
}
