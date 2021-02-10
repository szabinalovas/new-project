insert into Device (name) VALUES ('Apple watch');
insert into Device (name) VALUES ('Hőmérő');
insert into Measurement (time, value, unit, device_id) values (CURRENT_DATE(), 5, 'C', (select id FROM Device where name = 'Apple watch'));
insert into Measurement (time, value, unit, device_id) values (CURRENT_DATE(), 4, 'fok', (select id FROM Device where name = 'Hőmérő'));
