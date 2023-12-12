create table tarefas(

                        id bigint not null auto_increment,
                        nome_tarefa varchar(100) not null,
                        prioridade varchar(100) not null,
                        status varchar(100) not null,
                        contato varchar(11) not null unique,
                        solicitante varchar(100) not null unique,
                        logradouro varchar(100) not null,
                        bairro varchar(100) not null,
                        cep varchar(9) not null,
                        complemento varchar(100),
                        numero varchar(20),
                        uf char(2) not null,
                        cidade varchar(100) not null,

                        primary key(id)

);