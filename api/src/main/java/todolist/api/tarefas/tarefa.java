package todolist.api.tarefas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import todolist.api.DadosEndereco.DadosEndereco;
import todolist.api.endereco.Endereco;

@Table(name = "tarefas")
@Entity(name = "tarefa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_tarefa;
    private String contato;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @Enumerated(EnumType.STRING)
    private Solicitante solicitante;

    public tarefa(DadosCadastroTarefas dados) {
        this.nome_tarefa = dados.nome_tarefa();
        this.prioridade = dados.prioridade();
        this.status = dados.status();
        this.contato = dados.contato();
        this.solicitante = dados.solicitante();
        this.endereco = new Endereco(dados.endereco());
    }
}
