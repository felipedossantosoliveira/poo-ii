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
            message = "Número de telefone inválido! Formatos aceitos: (XX) XXXX-XXXX, (XX) 9XXXX-XXXX, ou sem separadores."
    )
    private String telefone;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome() {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone() {
        System.out.println(telefone);
        if (telefone != null) {
            this.telefone = telefone.replaceAll("\\D", "");
        }
    }
}

