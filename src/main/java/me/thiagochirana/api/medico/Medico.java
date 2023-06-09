package me.thiagochirana.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.thiagochirana.api.endereco.Endereco;


@Entity
@Table(name = "medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;

    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;


    public Medico(DadosCadastroMedico json) {
        this.nome = json.nome();
        this.email = json.email();
        this.telefone = json.telefone();
        this.crm = json.crm();
        this.especialidade = json.especialidade();
        this.endereco = new Endereco(json.endereco());
        this.ativo = json.ativo();
    }

    public void atualizarMedico(DadosAtualizacaoMedico json) {
        if(json.nome() != null){
            this.nome = json.nome();
        }
        if(json.telefone() != null){
            this.telefone = json.telefone();
        }
        if(json.endereco() != null){
            this.endereco.atualizarEndereco(json.endereco());
        }

    }

    public void desativar() {
        this.ativo = false;
    }
}
