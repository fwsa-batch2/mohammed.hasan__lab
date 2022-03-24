# &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```Ten Dots University```

<hr>

```sql
show databases;
```
```sql
create database TenDotsUniversity;
```
```sql
show tables;
```
```sql
show full tables where table_type != "views";
```
```sql
create or replace view inserting as select last_name from sign_up_details;
```
```sql
desc inserting;
drop view inserting;
select * from inserting;
select * from inserting where last_name like '[HA]%';
create or replace view inserting as select * from batch;
```
```sql
CREATE TABLE course_details (
course_name ENUM('Mechaical Engineering', 'Electrical and Electronics Engineering', 'Electronics and Communication Engineering', 'Computer Science Engineering', 'Information Technology', 'Chemical Engineering', 'Bio-medical Engineering', 'Civil Engineering', 'Bachelor of Arts', 'Bachelor of Design', 'Bachelor of Business Administration', 'Bachelor of Management Science', 'Bachelor of Hotel Management', 'B.A Psychology(Hons)'),
caption VARCHAR(40),
details LONGTEXT NOT NULL,
image BLOB,
primary key(course_name)
);
```
```sql
	 insert into course_details values("Computer Science Engineering","Our EEE Department's works","The Department of Electronics and Communication Engineering (ECE) was established in 1996 with the vision of developing the department as a Centre of Excellence in R&D, in the field of Electronics and Communication Engineering and make the hardworking students blossom into meritorious and self-disciplined engineers.  Our mission is to develop innovative and simple instructional material to drive the concepts into the minds of students and infuse scientific temper in the students and guide them towards research in communication engineering.
		It is also to striving grow a committed group of competent teachers striving for excellence, be it in teaching or research and to develop Collaborative Research and Development linkages with leading organizations in India and abroad. To accomplish this, Dr. Ian F. Akyildiz Ken Byers Chair Professor with the School of Electrical and Computer Engineering at Georgia Institute of Technology has been appointed as distinguished visiting faculty who also offers two one-credit courses to the undergrad and postgrad student of the department.
		Accreditation  :
		  This ISO9001 certified Department has been accredited by NBA (National Board of Accreditation) in 2003. It also has well-equipped state-of-the-art laboratories. 
		Scope of the Department   :
		   * To apply the concepts of mathematics, science, and engineering effectively.
		   * To design, analyse and interpret data through experiments.
		   * To identify, formulate, and solve engineering problems.
		   * To understand professional and ethical responsibility.
		   * To communicate effectively.
		   *  To broaden the education necessary to understand the impact of engineering solutions in a global, economic, environmental, and societal context.
		   * To use the techniques, skills, and modern engineering tools necessary for engineering practice.",NULL);
 ```
```sql
SELECT * FROM course_details;

CREATE TABLE dept_details (
dept_name ENUM('engineering', 'arts', 'integrated') not null,
course_name ENUM('Mechanical Engineering', 'Electrical and Electronics Engineering', 'Electronics and Communication Engineering', 'Computer Science Engineering', 'Information Technology', 'Chemical Engineering', 'Bio-medical Engineering', 'Civil Engineering', 'Bachelor of Arts', 'Bachelor of Design', 'Bachelor of Business Administration', 'Bachelor of Management Science', 'Bachelor of Hotel Management', 'B.A Psychology(Hons)'),
FOREIGN KEY (course_name)
	REFERENCES all_courses (course_name) on update cascade on delete cascade
);
```

```sql
insert into dept_details values("engineering", "Computer Science Engineering");
select * from teacher_details;
```

```sql

	CREATE TABLE teacher_details (
		teachers VARCHAR(50) NOT NULL,
		course_name ENUM('Mechanical Engineering', 'Electrical and Electronics Engineering', 'Electronics and Communication Engineering', 'Computer Science Engineering', 'Information Technology', 'Chemical Engineering', 'Bio-medical Engineering', 'Civil Engineering', 'Bachelor of Arts', 'Bachelor of Design', 'Bachelor of Business Administration', 'Bachelor of Management Science', 'Bachelor of Hotel Management', 'B.A Psychology(Hons)'),
		FOREIGN KEY (course_name)
			REFERENCES dept_details (course_name)
			ON UPDATE CASCADE ON DELETE CASCADE
);
```
```sql
insert into teacher_details values("Sumitha", "Computer Science Engineering");
	
    
	 create table sign_up_details (id int primary key,
	 mail_Id char(30) not null,
	 mobile_number int not null unique,
 	 First_name varchar(30) not null,
	 Last_name varchar(30) not null,
	 D_o_b date not null,
	 password varchar(20) not null check(length(password)>12),
	 role char(6) not null default ("user")
	 );
```
```sql
	alter table sign_up_details add check(length(mobile_number) = 10 and d_o_b < "2003-12-01");
    alter table sign_up_details add column notification enum("on","off") not null;
	desc sign_up_details;
	select * from sign_up_details;
	insert into sign_up_details values(1, "hasan@gmail.com", 9876544510, "Mohammed", "Hasan","2002:5:25","jebfsfdnDohwerN.","User");
```
```sql
	CREATE VIEW logged_in_user AS
    SELECT 
        id, mail_id, role
    FROM
        sign_up_details;
	desc logged_in_user;
    select * from logged_in_user;

	CREATE TABLE comments (
    mail_id varCHAR(30) PRIMARY KEY,
    name varCHAR(40),
    likes INT,
    date_of_comment DATE NOT NULL,
    comment LONGTEXT NOT NULL
);
```
```sql
select * from comments;
insert into comments values("hasan@gmail.com","Hasan",10,"2021:5:25","Very good college");
drop table liked_people;
```
```sql

	CREATE TABLE likes (
      commented_id varchar(30) not null,
      liked_id INT unique,
    FOREIGN KEY (liked_id)
        REFERENCES sign_up_details (id)
        ON UPDATE CASCADE ON DELETE CASCADE,
        foreign key(commented_id) references comments (mail_id) on update cascade on delete cascade
);
```
```sql
	desc liked_people;
	insert into likes values("hasan@gmail.com",2);
	select * from likes;
```
```sql
    CREATE TABLE student_details (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    mail_id VARCHAR(30) NOT NULL UNIQUE,
    dob DATE NOT NULL,
    cut_off_10 INT NOT NULL,
    cut_off_12 INT NOT NULL,
    course VARCHAR(50) NOT NULL,
    contact_number BIGINT UNIQUE,
    area_address TEXT NOT NULL,
    district ENUM('Ariyalur', 'Chengalpattu', 'Chennai', 'Coimbatore', 'Cuddalore', 'Dharmapuri', 'Dindigul', 'Erode', 'Kallakurichi', 'Kanchipuram', 'Kanyakumari', 'Karur', 'Krishnagiri', 'Madurai', 'Nagapattinam', 'Namakkal', 'Nilgiris', 'Perambalur', 'Pudukkottai', 'Ramanathapuram', 'Ranipet', 'Salem', 'Sivaganga', 'Tenkasi', 'Thanjavur', 'Theni', 'Thoothukudi', 'Tiruchirappalli', 'Tirunelveli', 'Tirupathur', 'Tiruppur', 'Tiruvallur', 'Tiruvannamalai', 'Tiruvarur', 'Vellore', 'Viluppuram', 'Virudhunagar') NOT NULL,
    CHECK (dob < "2003:12:12"
        AND cut_off_10 > 40
        AND cut_off_12 > 40)
);
```
```sql
alter table student_details add column status enum("paid","unpaid");
insert into student_details values(1,"Hasan","hasan@gmail.com","2003:9:9",50,60,"Mechanical Engineering",9876543210,"Thiruvanmiyur","Chennai");
select * from student_details;
```

<hr>

![Screenshot (38)](https://user-images.githubusercontent.com/93571027/159881376-d7a1026f-722c-41bb-b8de-0b1dbe374c2b.png)

<hr>

![Screenshot (39)](https://user-images.githubusercontent.com/93571027/159881564-da83cf12-4ffd-4cad-adf4-3bf0d2c06b7b.png)


