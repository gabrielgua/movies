create table filmes (
    id bigint not null auto_increment,
    nome varchar(255) not null,
    data_lancamento datetime not null,
    nota int not null,
    genero varchar(255) not null,
    diretor varchar(255) not null,

    primary key (id)
) engine=InnoDB default charset=UTF8MB4;