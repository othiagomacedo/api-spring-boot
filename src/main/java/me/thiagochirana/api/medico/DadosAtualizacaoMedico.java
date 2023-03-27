package me.thiagochirana.api.medico;

import jakarta.validation.constraints.NotNull;
import me.thiagochirana.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(

        @NotNull
        long id,

        String nome,

        String telefone,

        DadosEndereco endereco) {
}
