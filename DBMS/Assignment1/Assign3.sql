/* 
Insert sample data in LIS tables by using SQL files.
*/

INSERT INTO Members VALUES  (1001, 'rajiv','sector-8','sector-10','M'),
                            (1002, 'sanju','malviyanager','sitapura','F'),
                            (1003, 'sanjiv','jagatpura','mansroavar','M'),
                            (1004, 'rajshree','india gate','goner','F');
						
INSERT INTO Publishers VALUES (501,'Tata'),
                              (502,'New world'),
                              (503,'big rock');

INSERT INTO Subjects VALUES (51,'arts'),
                            (52,'science'),
                            (53,'agriculture');
							   
INSERT INTO Titles VALUES (201,'love of Arts', 51,501),
                          (202,'science world', 52,501),
                          (203,'agriculture for you', 51,502);
						
INSERT INTO Books VALUES (101,201, '2013-01-01',500,'available'),
                         (102,202, '2014-01-01',600,'available'),
                         (103,201, '2015-01-01',700,'available');					


INSERT INTO book_issue VALUES('2015-09-08',101,1001,'2015-09-23');
INSERT INTO book_issue VALUES('2015-09-05',102,1001,'2015-09-20');

INSERT INTO Books_Return VALUES ('2015-09-08',101,1001,'2015-09-08'),
                                ('2015-09-08',102,1001,'2015-09-08'),
                                ('2015-09-08',101,1003,'2015-09-08');
							
INSERT INTO Authors VALUES ( 1, 'Babloo'),
                           ( 2, 'Ramesh'),
                           ( 3, 'Suresh');

INSERT INTO Title_Author VALUES (201,1),
                                (202,1),
                                (201,3);


/*
Change value of addressLine2 column of Members 
table with “Jaipur”. 
*/
update members
set addressLine2='Jaipur';


/* 
Change value of addressLine2 column of Members table with “Jaipur”.
*/

update members
set addressLine1='EPIP, Sitapura'
where category='F';

/*
Insert the sample data back in Publishers table using 
substitution variables.
*/

set @name='ShivKhera';
set @id=25;

insert into publishers values(@id,@name);

/*
Delete those rows of Titles table belonging to Publisher
with publisher_id = 1
*/

delete from titles 
where publisher_id=1

