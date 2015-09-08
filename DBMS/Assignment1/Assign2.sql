
/*Assignment Two*/
create database PiyushSharmaDB;
use PiyushSharmaDB;

/*
Create all tables of Library as described and mentioned in Slides. (Write all CREATE commands in a SQL file and run that SQL File).
 */

create table members(member_id int primary key,
                    member_nm varchar(90),
                    addressline1 varchar(200),
                    addressline2 varchar(200),
                    category varchar(3));
                    
create table book_issue(issue_dt date,
                        accession_no int,
                        member_id int,
                        due_dt date,
                        Primary Key(issue_dt,accession_no,member_id),
                        Foreign Key(member_id) References members(member_id)
                        );
                        
create table books(accession_no int Primary key,
                    title_dt date,
                    purchase_dt date,
                    price int,
                    status varchar(90)
                    );
                    
create table book_return(return_dt date,
                        accession_no int,
                        member_id int,
                        issue_dt date,
                        Primary key(return_dt,accession_no,member_id),
                        Foreign Key(accession_no) References books(accession_no),
                        Foreign key(member_id) References members(member_id)
                        );

create table subjects(subject_id int,
                      subject_nm varchar(90),
                      Primary key(subject_id)
                      );
                    
create table publishers(publisher_id int Primary Key,
                        publisher_nm varchar(90)
                        );
                    
create table titles(title_id int Primary Key,
                    title_nm varchar(90),
                    subject_id int,
                    publisher_id int,
                    Foreign Key(subject_id) References subjects(subject_id),
                    Foreign Key(publisher_id) References publishers(publisher_id)
                    );

create table authors(author_id int Primary key,
                    author_nm varchar(90)
                    );
                    
create table title_author(title_id int primary key,
                        author_id int References authors(author_nm)
                        );

/* Write a command to display all the table names present in LIS.*/
show tables;

/* 
Alter definitions of following LIS tables to provide the default constraints:

Table		    Column		Default value
---------------------------------------------------------------------------
Book_Issue	Issue_dt		Current date
Book_Issue	Due_dt		Current date + 15 days
*/

alter table book_issue MODIFY column issue_dt TIMESTAMP
not null default current_timestamp;

alter table book_issue MODIFY column issue_dt TIMESTAMP
not null default current_timestamp;

/* 
Write  command to remove Members table of the LIS database.

Create the members table again.
As per what sir told us to do..
*/
ALTER TABLE book_issue
DROP FOREIGN KEY book_issue_ibfk_1;

ALTER TABLE book_return
DROP FOREIGN KEY book_return_ibfk_1;

DROP TABLE members;
