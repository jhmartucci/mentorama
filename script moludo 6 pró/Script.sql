create table medicine_professionals(
registration varchar(10) primary key,
nome varchar(80),
department varchar(50),
office varchar(50),
telefone varchar(12)
);

create table patients(
id int primary key,
name varchar(80),
phone varchar(15),
birthdate date
);

create table patients_history(
patient_entry datetime,
patient_exit datetime,
diagnosis(500),
doctor_responsible varchar(10) foreign key,
id_patient fereing key
);

insert into patients 
(id, name, phone, birthdate)
values
(1, 'Elvira Souza', '01198181-1111', '08/11/1943'),
(2, 'Vanderlei Matos', '06892121-3131', '28/03/1977'),
(3, 'Pafuncio Antonio', '02199855-8877', '01/01/1969')

insert into medicine_professionals 
(registration, name, department, office)
values
('AWF1589EE0', 'Willian Cardoso', 'Geriatria', 'Geriatra'),
('BNF8943A4Y', 'Amanda Cristina', 'Pediatria', 'Pediatra'),
('JUD456AD6P', 'Beatriz Castro', 'Assistencia Social', 'Pediatra'),
('JBFA5589BV', 'Juarez Caetano', 'Plantão', 'Clinico Geral'),
('LOKJ4488PO', 'Mateus Molina', 'Plantão', 'Ortopedista');

insert into patients_history 
(patienty_entry, patient_exit, diagnosis, doctor_responsible, id_patient)
values
('10/02/2022 - 01:11', '15/02/2022 - 11:45', 'Covid', 'JBFA5589BV', 2);


select * from medicine_professionals mp 
inner join patients_history ph 
on r.registration = ph.doctor_responsible
inner join patients p 
on p.id = ph.id_patient
order by p.id;

select * from patients p 
inner join patients_history ph 
on p.id = ph.id_patient
order by p.id; 






















 

 

