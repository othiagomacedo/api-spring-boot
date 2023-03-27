package me.thiagochirana.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.thiagochirana.api.endereco.Endereco;
import me.thiagochirana.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repo;

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico json){
        repo.save(new Medico(json));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listagem")
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repo.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico json){
        var medico = repo.getReferenceById(json.id());
        medico.atualizarMedico(json);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable long id){
        var medico = repo.getReferenceById(id);
        medico.desativar();
        return ResponseEntity.noContent().build();
    }
}
