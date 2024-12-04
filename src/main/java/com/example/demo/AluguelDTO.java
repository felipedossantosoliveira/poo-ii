package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AluguelDTO {

    private Long id;

    @NotBlank(message = "O campo usuário é obrigatório")
    private String usuarioId;

    @NotBlank(message = "O campo veículo é obrigatório")
    private String veiculoId;

    @NotBlank(message = "O campo data de início é obrigatório")
    private String dataInicio;

    private String dataFim;

    @NotNull(message = "O campo status é obrigatório")
    private String status;

    @NotNull(message = "O campo quilometragem inicial é obrigatório")
    private int quilometragemInicial;
    private int quilometragemFinal;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(String veiculoId) {
        this.veiculoId = veiculoId;
    }

    @Override
    public String toString() {
        return "AluguelDTO{" +
                "id=" + id +
                ", usuarioId='" + usuarioId + '\'' +
                ", veiculoId='" + veiculoId + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", status='" + status + '\'' +
                ", quilometragemInicial=" + quilometragemInicial +
                ", quilometragemFinal=" + quilometragemFinal +
                '}';
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuilometragemInicial() {
        return quilometragemInicial;
    }

    public void setQuilometragemInicial(int quilometragemInicial) {
        this.quilometragemInicial = quilometragemInicial;
    }

    public int getQuilometragemFinal() {
        return quilometragemFinal;
    }

    public void setQuilometragemFinal(int quilometragemFinal) {
        this.quilometragemFinal = quilometragemFinal;
    }
}
