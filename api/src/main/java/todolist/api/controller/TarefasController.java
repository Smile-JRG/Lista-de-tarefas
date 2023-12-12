package todolist.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todolist.api.tarefas.DadosCadastroTarefas;
import todolist.api.tarefas.TarefaRepository;
import todolist.api.tarefas.tarefa;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

    @Autowired
    private TarefaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroTarefas dados){
        repository.save(new tarefa(dados));

    }
}
