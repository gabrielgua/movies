set foreign_key_checks = 0;

delete from filmes;

set foreign_key_checks = 1;

alter table filmes auto_increment = 1;

insert into filmes(id, nome, data_lancamento, nota, genero, diretor) values
(1, "Homem-Aranha", "2002-05-17 03:00:00", 4, "Ação", "Sam raimi"),
(2, "Shrek", "2001-06-22 03:00:00", 5, "Fantasia", "Andrew Adamson"),
(3, "Bugador Pexoal", "2001-06-30 03:00:00", 1, "Ação", "Shark Macedo"),
(4, "Interestelar", "2014-11-06 03:00:00", 5, "Ficção Científica", "Christopher Nolan"),
(5, "Corra!", "2017-05-18 03:00:00", 4, "Terror", "Jordan Peele");
