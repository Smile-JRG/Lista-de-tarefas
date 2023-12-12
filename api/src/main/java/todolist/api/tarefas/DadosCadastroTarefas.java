package todolist.api.tarefas;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import todolist.api.DadosEndereco.DadosEndereco;

public record DadosCadastroTarefas(

        @NotBlank
        String nome_tarefa,
        @NotNull
        Prioridade prioridade,
        @NotNull
        StatusTarefa status,
        @NotBlank
        String contato,
        @NotNull
        Solicitante solicitante,
        @NotNull @Valid DadosEndereco endereco) {
}
