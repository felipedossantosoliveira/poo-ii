package com.example.demo.dtos;

import com.example.demo.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class VeiculoCreateDTO {

    @NotBlank(message = "A placa é obrigatória.") // Verifica se o campo não é nulo ou vazio
    @Pattern(regexp = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$", message = "Placa inválida! Use o formato padrão Mercosul (ex: ABC1D23).")
    @Size(min = 7, max = 7, message = "A placa deve ter exatamente 7 caracteres.")
    private String placa;

    @NotBlank(message = "A marca é obrigatória.")
    private String marca;

    @NotBlank(message = "O modelo é obrigatório.")
    private String modelo;

    @NotBlank(message = "O ano é obrigatório.")
    @Pattern(regexp = "^[0-9]{4}$", message = "Ano inválido! Use o formato AAAA (ex: 2021).")
    private int ano;

    @NotBlank(message = "A cor é obrigatória.")
    private String cor;

    public VeiculoCreateDTO() {}

    public VeiculoCreateDTO(Long id, String placa, String marca, String modelo, int ano, String cor) {
        this.placa = placa;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
    }

    public @NotBlank(message = "A placa é obrigatória.") @Pattern(regexp = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$", message = "Placa inválida! Use o formato padrão Mercosul (ex: ABC1D23).") @Size(min = 7, max = 7, message = "A placa deve ter exatamente 7 caracteres.") String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotBlank(message = "A placa é obrigatória.") @Pattern(regexp = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$", message = "Placa inválida! Use o formato padrão Mercosul (ex: ABC1D23).") @Size(min = 7, max = 7, message = "A placa deve ter exatamente 7 caracteres.") String placa) {
        this.placa = placa;
    }

    public @NotBlank(message = "A marca é obrigatória.") String getMarca() {
        return marca;
    }

    public void setMarca(@NotBlank(message = "A marca é obrigatória.") String marca) {
        this.marca = marca;
    }

    public @NotBlank(message = "O modelo é obrigatório.") String getModelo() {
        return modelo;
    }

    public void setModelo(@NotBlank(message = "O modelo é obrigatório.") String modelo) {
        this.modelo = modelo;
    }

    @NotBlank(message = "O ano é obrigatório.")
    @Pattern(regexp = "^[0-9]{4}$", message = "Ano inválido! Use o formato AAAA (ex: 2021).")
    public int getAno() {
        return ano;
    }

    public void setAno(@NotBlank(message = "O ano é obrigatório.") @Pattern(regexp = "^[0-9]{4}$", message = "Ano inválido! Use o formato AAAA (ex: 2021).") int ano) {
        this.ano = ano;
    }

    public @NotBlank(message = "A cor é obrigatória.") String getCor() {
        return cor;
    }

    public void setCor(@NotBlank(message = "A cor é obrigatória.") String cor) {
        this.cor = cor;
    }
}
