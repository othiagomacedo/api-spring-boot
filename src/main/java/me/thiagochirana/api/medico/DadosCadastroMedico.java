package me.thiagochirana.api.medico;

import me.thiagochirana.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco dadosEndereco) {
}
