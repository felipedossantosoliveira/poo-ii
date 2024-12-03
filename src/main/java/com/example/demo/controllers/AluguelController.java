package com.example.demo.controllers;

import com.example.demo.Aluguel;
import com.example.demo.repositories.AluguelRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelRepository aluguelRepository = new AluguelRepository();

    @PostMapping
    public void criarAluguel(@RequestBody Aluguel aluguel) {
        aluguelRepository.salvar(aluguel);
    }

    @PutMapping("/{id}")
    public void atualizarAluguel(@PathVariable Long id, @RequestBody Aluguel aluguel) {
        aluguel.setId(id);
        aluguelRepository.atualizar(aluguel);
    }

    @GetMapping("/{id}")
    public Aluguel buscarAluguelPorId(@PathVariable Long id) {
        return aluguelRepository.buscarPorId(id);
    }

    @GetMapping
    public List<Aluguel> listarAlugueis() {
        return aluguelRepository.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarAluguel(@PathVariable Long id) {
        aluguelRepository.deletar(id);
    }
}

