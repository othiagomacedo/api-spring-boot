package me.thiagochirana.api.controller;

import me.thiagochirana.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico json){
        System.out.println(json);
    }
}
