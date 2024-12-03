package com.example.demo.controllers;

import com.example.demo.Veiculo;
import com.example.demo.repositories.VeiculoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository = new VeiculoRepository();

    @PostMapping
    public void criarVeiculo(@RequestBody Veiculo veiculo) {
        veiculoRepository.salvar(veiculo);
    }

    @PutMapping("/{id}")
    public void atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        veiculo.setId(id);
        veiculoRepository.atualizar(veiculo);
    }

    @GetMapping("/{id}")
    public Veiculo buscarVeiculoPorId(@PathVariable Long id) {
        return veiculoRepository.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarVeiculo(@PathVariable Long id) {
        veiculoRepository.deletar(id);
    }
}

