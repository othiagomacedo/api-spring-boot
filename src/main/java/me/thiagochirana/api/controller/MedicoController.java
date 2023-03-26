package me.thiagochirana.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.thiagochirana.api.endereco.Endereco;
import me.thiagochirana.api.medico.DadosCadastroMedico;
import me.thiagochirana.api.medico.DadosListagemMedico;
import me.thiagochirana.api.medico.Medico;
import me.thiagochirana.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repo;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico json){
        repo.save(new Medico(json));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repo.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
