package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome não pode ser vazio")
    private String nome;

    @Email(message = "E-mail inválido")
    private String email;

    @NotEmpty(message = "O telefone não pode ser vazio")
    @Pattern(
            regexp = "^(\\(\\d{2}\\)\\s?9?\\d{4}-\\d{4}|\\d{10,11})$",
            message = "Número de telefone inválido! Formatos aceitos: 1234567890, 12 3456-7890, (12) 34567-8901, 12345 67890, 1234-5678, ou sem separadores."
    )
    private String telefone;

    // Getters e Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "O nome não pode ser vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty(message = "O nome não pode ser vazio") String nome) {
        this.nome = nome;
    }

    public @Email(message = "E-mail inválido") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "E-mail inválido") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "O telefone não pode ser vazio") @Pattern(
            regexp = "^(\\(?\\d{2}\\)?\\s?)?(\\d{4,5})[-.\\s]?\\d{4}$",
            message = "Número de telefone inválido! Formatos aceitos: 1234567890, 12 3456-7890, (12) 34567-8901, 12345 67890, 1234-5678, ou sem separadores."
    ) String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotEmpty(message = "O telefone não pode ser vazio") @Pattern(
            regexp = "^(\\(?\\d{2}\\)?\\s?)?(\\d{4,5})[-.\\s]?\\d{4}$",
            message = "Número de telefone inválido! Formatos aceitos: 1234567890, 12 3456-7890, (12) 34567-8901, 12345 67890, 1234-5678, ou sem separadores."
    ) String telefone) {
        if (telefone != null) {
            this.telefone = telefone.replaceAll("\\D", "");
        }
    }
}

