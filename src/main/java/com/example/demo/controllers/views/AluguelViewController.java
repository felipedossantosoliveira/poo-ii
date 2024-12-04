package com.example.demo.controllers.views;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.Aluguel;
import com.example.demo.AluguelDTO;
import com.example.demo.Usuario;
import com.example.demo.Veiculo;
import com.example.demo.repositories.AluguelRepository;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.repositories.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/alugueis")
public class AluguelViewController {

    private final AluguelRepository aluguelRepository = new AluguelRepository();
    private final UsuarioRepository usuarioRepository = new UsuarioRepository();
    private final VeiculoRepository veiculoRepository = new VeiculoRepository();

    @RequestMapping
    public String view(Model model) {
        List<Aluguel> alugueis = aluguelRepository.buscarTodos();
        model.addAttribute("alugueis", alugueis);
        return "alugueis";
    }

    @RequestMapping("/criar")
    public String criarAluguel(Model model) {
        List<Usuario> usuarios = usuarioRepository.buscarTodos();
        List<Veiculo> veiculos = veiculoRepository.buscarTodos();
        model.addAttribute("aluguelDTO", new AluguelDTO());
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("veiculos", veiculos);
        return "criar-aluguel";
    }

    @PostMapping
    public String criarAluguel(@Valid AluguelDTO aluguelDTO, BindingResult result, Model model) {

        System.out.println(aluguelDTO.toString());

        if (result.hasErrors()) {
            return "criar-aluguel";
        }
        
        Aluguel aluguel = new Aluguel();
        aluguel.setUsuario(usuarioRepository.buscarPorId(Long.parseLong(aluguelDTO.getUsuarioId())));
        aluguel.setVeiculo(veiculoRepository.buscarPorId(Long.parseLong(aluguelDTO.getVeiculoId())));
        aluguel.setDataInicio(LocalDate.parse(aluguelDTO.getDataInicio()));
        aluguel.setDataFim(LocalDate.parse(aluguelDTO.getDataFim()));
        aluguel.setStatus(aluguelDTO.getStatus());
        aluguel.setQuilometragemInicial(aluguelDTO.getQuilometragemInicial());
        aluguel.setQuilometragemFinal(aluguelDTO.getQuilometragemFinal());
        
        
        aluguelRepository.salvar(aluguel);
        return "redirect:/alugueis";
    }

    @RequestMapping("/editar/{id}")
    public String editarAluguel(@PathVariable Long id, Model model) {
        Aluguel aluguel = aluguelRepository.buscarPorId(id);
        List<Usuario> usuarios = usuarioRepository.buscarTodos();
        List<Veiculo> veiculos = veiculoRepository.buscarTodos();

        AluguelDTO aluguelDTO = new AluguelDTO();
        aluguelDTO.setId(aluguel.getId());
        aluguelDTO.setUsuarioId(aluguel.getUsuario().getId().toString());
        aluguelDTO.setVeiculoId(aluguel.getVeiculo().getId().toString());
        aluguelDTO.setDataInicio((aluguel.getDataInicio().toString()));
        aluguelDTO.setDataFim(aluguel.getDataFim().toString());
        aluguelDTO.setStatus(aluguel.getStatus());
        aluguelDTO.setQuilometragemInicial(aluguel.getQuilometragemInicial());
        aluguelDTO.setQuilometragemFinal(aluguel.getQuilometragemFinal());

        System.out.println(aluguelDTO.getDataInicio());
        System.out.println(aluguelDTO.getDataFim());

        model.addAttribute("aluguelDTO", aluguelDTO);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("veiculos", veiculos);

        return "editar-aluguel";
    }

    @PostMapping("/{id}")
    public String atualizarAluguel(@Valid AluguelDTO aluguelDTO, BindingResult result, Model model) {

        System.out.println(aluguelDTO.toString());

        if (result.hasErrors()) {
            return "criar-aluguel";
        }

        Aluguel aluguel = new Aluguel();
        aluguel.setId(aluguelDTO.getId());
        aluguel.setUsuario(usuarioRepository.buscarPorId(Long.parseLong(aluguelDTO.getUsuarioId())));
        aluguel.setVeiculo(veiculoRepository.buscarPorId(Long.parseLong(aluguelDTO.getVeiculoId())));
        aluguel.setDataInicio(LocalDate.parse(aluguelDTO.getDataInicio()));
        aluguel.setDataFim(LocalDate.parse(aluguelDTO.getDataFim()));
        aluguel.setStatus(aluguelDTO.getStatus());
        aluguel.setQuilometragemInicial(aluguelDTO.getQuilometragemInicial());
        aluguel.setQuilometragemFinal(aluguelDTO.getQuilometragemFinal());


        aluguelRepository.atualizar(aluguel);
        return "redirect:/alugueis";
    }

}
