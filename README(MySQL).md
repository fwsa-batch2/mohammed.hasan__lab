
mysql> use hasan;

Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed

mysql> desc signUpDetails;

+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| First_Name    | varchar(25) | NO   |     | NULL    |                |
| Last_Name     | varchar(20) | NO   |     | NULL    |                |
| Mail          | varchar(20) | NO   | UNI | NULL    |                |
| DOB           | date        | NO   |     | NULL    |                |
| Password      | varchar(20) | NO   | UNI | NULL    |                |
| Mobile_Number | bigint      | NO   | UNI | NULL    |                |
| Role          | varchar(20) | NO   |     | NULL    |                |
| Id            | int         | NO   | PRI | NULL    | auto_increment |
+---------------+-------------+------+-----+---------+----------------+

8 rows in set (0.00 sec)

mysql> alter table signUpDetails modify column Mail varchar(20) Not Null;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc signUpDetails;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| First_Name    | varchar(25) | NO   |     | NULL    |                |
| Last_Name     | varchar(20) | NO   |     | NULL    |                |
| Mail          | varchar(20) | NO   | UNI | NULL    |                |
| DOB           | date        | NO   |     | NULL    |                |
| Password      | varchar(20) | NO   | UNI | NULL    |                |
| Mobile_Number | bigint      | NO   | UNI | NULL    |                |
| Role          | varchar(20) | NO   |     | NULL    |                |
| Id            | int         | NO   | PRI | NULL    | auto_increment |
+---------------+-------------+------+-----+---------+----------------+
8 rows in set (0.00 sec)

mysql> alter table signUpDetails drop index Password;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc signUpDetails;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| First_Name    | varchar(25) | NO   |     | NULL    |                |
| Last_Name     | varchar(20) | NO   |     | NULL    |                |
| Mail          | varchar(20) | NO   | UNI | NULL    |                |
| DOB           | date        | NO   |     | NULL    |                |
| Password      | varchar(20) | NO   |     | NULL    |                |
| Mobile_Number | bigint      | NO   | UNI | NULL    |                |
| Role          | varchar(20) | NO   |     | NULL    |                |
| Id            | int         | NO   | PRI | NULL    | auto_increment |
+---------------+-------------+------+-----+---------+----------------+
8 rows in set (0.00 sec)

mysql> alter table signUpDetails modify column Password varchar(20) Unique Not
 Null;
Query OK, 0 rows affected (0.06 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc signUpDetails;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| First_Name    | varchar(25) | NO   |     | NULL    |                |
| Last_Name     | varchar(20) | NO   |     | NULL    |                |
| Mail          | varchar(20) | NO   | UNI | NULL    |                |
| DOB           | date        | NO   |     | NULL    |                |
| Password      | varchar(20) | NO   | UNI | NULL    |                |
| Mobile_Number | bigint      | NO   | UNI | NULL    |                |
| Role          | varchar(20) | NO   |     | NULL    |                |
| Id            | int         | NO   | PRI | NULL    | auto_increment |
+---------------+-------------+------+-----+---------+----------------+
8 rows in set (0.00 sec)


mysql> alter table signUpDetails modify column Mail varchar(20) Not Null;
Query OK, 0 rows affected (0.22 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc signUpDetails;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| First_Name    | varchar(25) | NO   |     | NULL    |                |
| Last_Name     | varchar(20) | NO   |     | NULL    |                |
| Mail          | varchar(20) | NO   | UNI | NULL    |                |
| DOB           | date        | NO   |     | NULL    |                |
| Password      | varchar(20) | NO   | UNI | NULL    |                |
| Mobile_Number | bigint      | NO   | UNI | NULL    |                |
| Role          | varchar(20) | NO   |     | NULL    |                |
| Id            | int         | NO   | PRI | NULL    | auto_increment |
+---------------+-------------+------+-----+---------+----------------+
8 rows in set (0.01 sec)

===========================================================================================================

### Deleting Constraint(Primary key)

mysql> alter table signUpDetails drop index Password;

(OR)

mysql> alter table signUpDetails drop primary key(col_name);

Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc signUpDetails;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| First_Name    | varchar(25) | NO   |     | NULL    |                |
| Last_Name     | varchar(20) | NO   |     | NULL    |                |
| Mail          | varchar(20) | NO   | UNI | NULL    |                |
| DOB           | date        | NO   |     | NULL    |                |
| Password      | varchar(20) | NO   |     | NULL    |                |
| Mobile_Number | bigint      | NO   | UNI | NULL    |                |
| Role          | varchar(20) | NO   |     | NULL    |                |
| Id            | int         | NO   | PRI | NULL    | auto_increment |
+---------------+-------------+------+-----+---------+----------------+
8 rows in set (0.00 sec)

mysql> show tables;
+-----------------+
| Tables_in_hasan |
+-----------------+
| signUpDetails   |
+-----------------+
1 row in set (0.01 sec)
===========================================================================================================

### Deleting Constraint (2nd way)

mysql> alter table signUpDetails drop constraint Role;
Query OK, 0 rows affected (0.05 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc signUpDetails;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| First_Name    | varchar(25) | NO   |     | NULL    |                |
| Last_Name     | varchar(20) | NO   |     | NULL    |                |
| Mail          | varchar(20) | NO   | UNI | NULL    |                |
| DOB           | date        | NO   |     | NULL    |                |
| Password      | varchar(20) | NO   |     | NULL    |                |
| Mobile_Number | bigint      | NO   | UNI | NULL    |                |
| Role          | varchar(6)  | YES  |     | user    |                |
| Id            | int         | NO   | PRI | NULL    | auto_increment |
+---------------+-------------+------+-----+---------+----------------+
8 rows in set (0.00 sec)
===========================================================================================================

### Creating new Table

mysql> create table Logged_In_User (Id int, Mail_Id varchar(30) not null,Role
varchar(6) NOT NULL,foreign key(Id) references signUpDetails(Id));
Query OK, 0 rows affected (0.05 sec)

mysql> desc signUpDetails;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| First_Name    | varchar(25) | NO   |     | NULL    |                |
| Last_Name     | varchar(20) | NO   |     | NULL    |                |
| Mail          | varchar(20) | NO   | UNI | NULL    |                |
| DOB           | date        | NO   |     | NULL    |                |
| Password      | varchar(20) | NO   |     | NULL    |                |
| Mobile_Number | bigint      | NO   | UNI | NULL    |                |
| Role          | varchar(20) | NO   |     | NULL    |                |
| Id            | int         | NO   | PRI | NULL    | auto_increment |
+---------------+-------------+------+-----+---------+----------------+
8 rows in set (0.01 sec)

mysql> show tables;
+-----------------+
| Tables_in_hasan |
+-----------------+
| Logged_In_User  |
| signUpDetails   |
+-----------------+
2 rows in set (0.00 sec)

mysql> desc Logged_In_User;
+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| Id      | int         | YES  | MUL | NULL    |       |
| Mail_Id | varchar(30) | NO   |     | NULL    |       |
| Role    | varchar(6)  | NO   |     | NULL    |       |
+---------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> select * from signUpDetails;
+------------+-----------+-----------------+------------+----------+---------------+-------+----+
| First_Name | Last_Name | Mail            | DOB        | Password | Mobile_Number | Role  | Id |
+------------+-----------+-----------------+------------+----------+---------------+-------+----+
| Mohammed   | Hasan     | hasan@gmail.com | 2003-09-19 | Hasan    |    9876543210 | admin |  1 |
+------------+-----------+-----------------+------------+----------+---------------+-------+----+
1 row in set (0.00 sec)
===========================================================================================================

### Left Join

mysql> select * from signUpDetails left join Logged_In_User on signUpDetails.Id=Logged_In_User.Id;
+------------+-----------+-----------------+------------+----------+---------------+-------+----+------+---------+------+
| First_Name | Last_Name | Mail            | DOB        | Password | Mobile_Number | Role  | Id | Id   | Mail_Id | Role |
+------------+-----------+-----------------+------------+----------+---------------+-------+----+------+---------+------+
| Mohammed   | Hasan     | hasan@gmail.com | 2003-09-19 | Hasan    |    9876543210 | admin |  1 | NULL | NULL    | NULL |
+------------+-----------+-----------------+------------+----------+---------------+-------+----+------+---------+------+
1 row in set (0.00 sec)

mysql> select * from Logged_In_User;
Empty set (0.00 sec)

===========================================================================================================

### Altering

mysql> alter table Logged_In_User modify column Id int not null;
Query OK, 0 rows affected (0.09 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc Logged_In_User;
+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| Id      | int         | NO   | MUL | NULL    |       |
| Mail_Id | varchar(30) | NO   |     | NULL    |       |
| Role    | varchar(6)  | NO   |     | NULL    |       |
+---------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

===========================================================================================================

### Inserting new row

mysql> insert into Logged_In_User values(1,"hasan@gmail.com","admin");
Query OK, 1 row affected (0.01 sec)

mysql> select * from Logged_In_User;
+----+-----------------+-------+
| Id | Mail_Id         | Role  |
+----+-----------------+-------+
|  1 | hasan@gmail.com | admin |
+----+-----------------+-------+
1 row in set (0.00 sec)

===========================================================================================================
### Left Join

mysql> select * from signUpDetails left join Logged_In_User on signUpDetails.Id=Logged_In_User.Id;
+------------+-----------+-----------------+------------+----------+---------------+-------+----+------+-----------------+-------+
| First_Name | Last_Name | Mail            | DOB        | Password | Mobile_Number | Role  | Id | Id   | Mail_Id         | Role  |
+------------+-----------+-----------------+------------+----------+---------------+-------+----+------+-----------------+-------+
| Mohammed   | Hasan     | hasan@gmail.com | 2003-09-19 | Hasan    |    9876543210 | admin |  1 |    1 | hasan@gmail.com | admin |
+------------+-----------+-----------------+------------+----------+---------------+-------+----+------+-----------------+-------+
1 row in set (0.00 sec)
<<<<<<< HEAD

===========================================================================================================
### Setting Default 

mysql> alter table signUpDetails modify column Role varchar(6) default "user";
Query OK, 1 row affected (0.17 sec)
Records: 1  Duplicates: 0  Warnings: 0

mysql> desc signUpDetails;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| First_Name    | varchar(25) | NO   |     | NULL    |                |
| Last_Name     | varchar(20) | NO   |     | NULL    |                |
| Mail          | varchar(20) | NO   | UNI | NULL    |                |
| DOB           | date        | NO   |     | NULL    |                |
| Password      | varchar(20) | NO   |     | NULL    |                |
| Mobile_Number | bigint      | NO   | UNI | NULL    |                |
| Role          | varchar(6)  | YES  |     | user    |                |
| Id            | int         | NO   | PRI | NULL    | auto_increment |
+---------------+-------------+------+-----+---------+----------------+
8 rows in set (0.00 sec)
=======
mysql

## Tips for Querying :

   * If qn. contains "atleast", then use EXIST constraint
   * If in qn. comparision is given, use "ALL","ANY","IN","NOT IN"
   
