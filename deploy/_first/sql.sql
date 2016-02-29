insert into State(abbreviation, name)values('SP', 'Sao Paulo');
insert into State(abbreviation, name)values('MG', 'Minas Gerais');
insert into State(abbreviation, name)values('RJ', 'Rio de Janeiro');
insert into State(abbreviation, name)values('ES', 'Espirito Santo');

insert into State(abbreviation, name)values('AC', 'Acre');
insert into State(abbreviation, name)values('AL', 'Alagoas');
insert into State(abbreviation, name)values('AP', 'Amapá');
insert into State(abbreviation, name)values('AM', 'Amazonas');
insert into State(abbreviation, name)values('BA', 'Bahia');
insert into State(abbreviation, name)values('CE', 'Ceará');
insert into State(abbreviation, name)values('DF', 'Distrito Federal');
insert into State(abbreviation, name)values('MA', 'Maranhão');
insert into State(abbreviation, name)values('MT', 'Mato Grosso');
insert into State(abbreviation, name)values('MT', 'Mato Grosso do Sul');
insert into State(abbreviation, name)values('PA', 'Pará');
insert into State(abbreviation, name)values('PB', 'Paraíba');
insert into State(abbreviation, name)values('PR', 'Paraná');
insert into State(abbreviation, name)values('PE', 'Pernambuco');
insert into State(abbreviation, name)values('PI', 'Piauí');
insert into State(abbreviation, name)values('RN', 'Rio Grande do Norte');
insert into State(abbreviation, name)values('RS', 'Rio Grande do Sul');
insert into State(abbreviation, name)values('RO', 'Rondônia');
insert into State(abbreviation, name)values('RR', 'Roraima');
insert into State(abbreviation, name)values('SC', 'Santa Catarina');
insert into State(abbreviation, name)values('SE', 'Sergipe');
insert into State(abbreviation, name)values('TO', 'Tocantins');


insert into User(active, createdDate, email, name, login, password) 
values(true, now(), 'admin@admin.com', 'Admin', 'admin', 'admin@2016');

insert into User(active, createdDate, email, name, login, password) 
values(true, now(), 'carlosvendas@hotmail.com', 'Carlos', 'carlos', 'carlos@1620');


insert into ProductType(description) value('Caixa');
insert into ProductType(description) value('Unidade');
insert into ProductType(description) value('Peça');
