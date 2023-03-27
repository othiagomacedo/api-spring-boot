package me.thiagochirana.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;

    private String bairro;

    private String cep;

    private String cidade;

    private String uf;

    private String numero;

    private String complemento;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    public void atualizarEndereco(DadosEndereco endereco) {
        if(endereco.logradouro() != null ){
            logradouro = endereco.logradouro();
        }
        if(endereco.bairro() != null){
            bairro = endereco.bairro();
        }
        if(endereco.cep() != null){
            cep = endereco.cep();
        }
        if(endereco.cidade() != null){
            cidade = endereco.cidade();
        }
        if(endereco.uf() != null){
            uf = endereco.uf();
        }
        if(endereco.numero() != null){
            numero = endereco.numero();
        }
        if(endereco.complemento() != null){
            complemento = endereco.complemento();
        }
    }
}
