# Lista-de-tarefas

<h1 align="center"> To do List - Aplicativo para controlar a execução de tarefas </h1>


<!-- INTRODUÇÃO -->
## 📝 DESCRIÇÃO DO PROJETO:
<p align="center">O objetivo desse Projeto é utilizar o Spring Boot para desenvolver uma API Rest, com algumas funcionalidades. A ideia é desenvolver um CRUD, sendo as quatro operações fundamentais das aplicações: cadastro, leitura, atualização e exclusão de informações.

Isto é, será desenvolvido um CRUD de uma API Rest usando o Spring Boot.
Trabalharemos em um projeto de um aplicativo para monitorar o cadastro, leitura, atualização e arquivamento de tarefas a serem executadas. 

<!-- DESENVOLVEDORES -->
## 👨🏻‍💻 DESENVOLVEDORES

<p align="center"> 
 Meu nome é <b>Jose Ricardo Gustavo - RA: 202114786</b>, sou bastante interessado por tecnologia e trabalho a aproximadamente vinte anos na área de manutenção industrial, sendo que, nos últimos dez anos tenho atuado especificamente com assistência técnica de máquinas injetoras plástica e robôs cartesianos. Iniciei meu estudo profissionalizante em 2002 no SENAI e conclui minha primeira graduação em 2009, no curso de Tecnólogo em Automação Industrial - UniAnchieta. Ingressei no curso de Engenharia de Computação - USF com o intuito de adquirir um conhecimento mais especializado.
</p>


<!-- FERRAMENTAS UTILIZADAS -->
## 🧰 DESENVOLVIDO COM AS SEGUINTES FERRAMENTAS:

<table>
  <tr>
    <td><bold>Application</bold></td>
  </tr>
  <tr>
    <td>Spring Boot 3</td>
  </tr>
   <tr>
    <td>Java 17</td>
  </tr>
    </tr>
   <tr>
    <td>Lombok</td>
  </tr>
 <tr>
    <td>MySQL/Flyway</td>
  </tr>
   <tr>
    <td>JPA</td>
  </tr>
    </tr>
   <tr>
    <td>Maven</td>
   </tr>
   <tr>
    <td>Insomnia</td


</table>

<!-- FUNCIONALIDADES -->
## ⚙️ FUNCIONALIDADES

<h3>1. Cadastro de Tarefas (Create):</h3>
<ul>Permite a adição de novas tarefas. Sendo possível inserir o local onde será necessário executar a atividade, grau de prioridade da tarefa, nome do solicitante e Status da solicitação.</ul>

<h3>2. Consultar Status das tarefas (Read):</h3>
<ul>Fornece uma vizualização de todas as tarefas registradas, contendo a informação sobre a situação de cada evento - Pendente, Executando ou Concluido.</ul>

<h3>3. Atualizações (Update):</h3>
<ul>Possibilita a edição de detalhes das tarefas, principalmente para atualização do Status sobre o andamento da atividade.</ul>

<h3>4. Arquivamento da tarefa (Delete):</h3>
<ul>Permite o arquivamento das tarefas já concluidas, evitando que alguém perca tempo por se deslocar até um local onde a tarefa já foi feita.</ul>

<p align="center">
Tudo isso foi feito usando algumas tecnologias, como Spring Boot 3, sendo a última versão disponibilizada pelo framework. 

Será utilizado em conjunto com o projeto o Lombok, responsável por fazer a geração de códigos repetitivos, como getters, setters, toString, entre outros. Tudo via anotações para o código ficar menos escrito.

Também será utilizado o banco de dados MySQL para armazenar as informações da API e junto com ele utilizaremos a biblioteca Flyway. Isso para termos o controle do histórico de evolução do banco de dados, um conceito que chamamos de Migration.

A camada de persistência da aplicação será feita com a JPA (Java Persistence API), com o Hibernate como implementação dessa especificação e usando os módulos do Spring Boot, para tornar esse processo o mais simples possível.

Usaremos o Maven para gerenciar as dependências do projeto, e também para gerar o build da nossa aplicação. Por último, como focaremos na API Rest (apenas no Back-end), não teremos interface gráfica, como páginas HTML e nem Front-end e aplicativo mobile.

Mas para testarmos a API, usaremos o Insomnia, sendo uma ferramenta usada para testes em API. Com ela, conseguimos simular a requisição para a API e verificar se as funcionalidades implementadas estão funcionando.
</p>

<br>

<!-- REPOSITÓRIO -->
<h2 align="left">📁 PROJETO: </h2>

- Clonar o Repositório <br>
  `git clone https://github.com/Smile-JRG/Lista-de-tarefas
- Arquivos Git no logo abaixo: <br>
<a href="[https://github.com/Smile-JRG/Lista-de-tarefas]">
</a>

<br>

<!-- POSTMAN -->
## ✔️ EXEMPLO DE FUNCIONAMENTO:

<h4>todolist:</h4>

   -//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
@RequestMapping({"tarefas"})
public class TarefasController {
    @Autowired
    private TarefaRepository repository;

    public TarefasController() {
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroTarefas dados) {
        this.repository.save(new tarefa(dados));
    }
}
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
 
