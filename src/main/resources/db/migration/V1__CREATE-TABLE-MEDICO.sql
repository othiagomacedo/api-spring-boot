create table medico(
        id serial primary key,
        nome varchar(255) not null,
        email varchar(255) not null,
        crm varchar(10) not null,
        especialidade varchar(100) not null,
        logradouro varchar(100) not null,
        bairro varchar(50) not null,
        cep varchar(9) not null,
        complemento varchar(100),
        numero varchar(20),
        uf varchar(2) not null,
        cidade varchar(100) not null

);