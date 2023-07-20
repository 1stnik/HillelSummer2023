-- Відображення списку груп
select distinct stady_group from student;
select s.stady_group from student s group by s.stady_group;

-- Відображення студентів групи
select * from student s where s.stady_group = 'GR-11';

-- Відображення списку студентів та фільтрація за першою літерою прізвища
select * from student s where s.last_name like 'B%';

-- Фільтрування списку студентів за прізвищем та за номером групи
select * from student s where s.last_name = 'Stepurko' and s.stady_group = 'GR-71';

-- Додавання нового студента,
insert into student (first_name, last_name, date_of_birth, email, stady_group, country)
values ('Alex', 'Stepurko', '1983-12-08', 'mail@mail.com', 'GR-71', 'Ukraine');

-- редагування
update student set first_name = '1',
                   last_name = '2',
                   date_of_birth = '1983-08-21',
                   email = '1@1.com',
                   stady_group = '1',
                   country = '1'
where id = 1;

--INSERT INTO `settings`
--VALUES (NULL, ...field values...)
-- видалення
delete from student where id = 1;
