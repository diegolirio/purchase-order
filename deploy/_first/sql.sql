insert into State(abbreviation, name)values('SP', 'S�o Paulo');
insert into State(abbreviation, name)values('MG', 'Minas Gerais');
insert into State(abbreviation, name)values('RJ', 'Rio de Janeiro');
insert into State(abbreviation, name)values('ES', 'Espirito Santo');
insert into State(abbreviation, name)values('BA', 'Bahia');


insert into User(active, createdDate, email, name, login, password) 
values(true, now(), 'admin@admin.com', 'Admin', 'admin', 'admin@2016');


insert into ProductType(description) value('Caixa');
insert into ProductType(description) value('Unidade');
insert into ProductType(description) value('Peça');
