//Table 1 - CoverageType
create table coverageType(coverageType_Id varchar(2)  not null primary key, coverageType_name  varchar(20) not null,createdby varchar(50)  ,createddate date  DEFAULT GETDATE(),updatedby varchar(50)  ,updateddate date  DEFAULT GETDATE())

//Table 2 - ProductType
create table productType(productType_Id int Identity not null  primary key, productType_name  varchar(20) not null,createdby varchar(50)  ,createddate date  DEFAULT GETDATE(),updatedby varchar(50)  ,updateddate date  DEFAULT GETDATE())

//Table 3 UnderWriter
create table underWriter(underWriter_Id int Identity not null primary key, underwriter_name varchar(100) not null, division varchar(20) not null,createdby varchar(50)  ,createddate date  DEFAULT GETDATE(),updatedby varchar(50) ,updateddate date  DEFAULT GETDATE())

//Table 4- Account
CREATE TABLE ACCOUNT(ACCOUNT_ID INT IDENTITY PRIMARY KEY,ACCOUNT_NUMBER VARCHAR(50),NAME VARCHAR(100) NOT NULL,DIVISION VARCHAR(100) NOT NULL,CREATED_BY VARCHAR(50) ,CREATED_DATE  date DEFAULT GETDATE(),UPDATED_BY VARCHAR(50),UPDATED_DATE  date DEFAULT GETDATE())

// Table 5 - Document
CREATE TABLE DOCUMENT(DOC_ID INT IDENTITY PRIMARY KEY NOT NULL,DOC_NAME VARCHAR(100) NOT NULL,DIVISION VARCHAR(100) NOT NULL,FILE_NAME VARCHAR(100) NOT NULL,CREATED_BY VARCHAR(50) ,CREATED_DATE  DATE   DEFAULT GETDATE(),UPDATED_BY VARCHAR(50) ,UPDATED_DATE  DATE  DEFAULT GETDATE());

//Table 6 - Validation Status
CREATE TABLE VALIDATION_STATUS (STATUS_ID INT IDENTITY PRIMARY KEY , STATUS VARCHAR(100) NOT NULL,CREATED_BY VARCHAR(50) , CREATED_DATE DATE  DEFAULT GETDATE(), UPDATED_BY VARCHAR(50) , UPDATED_DATE DATE  DEFAULT GETDATE());

//TABLE 7 - UW_Mapping

create table UW_Mapping(uw_mapping_id int identity not null primary key,product_Type_id int references productType (productType_Id), under_writer_id int 
references underWriter(underWriter_Id ),createdby varchar(50) ,createddate date DEFAULT GETDATE(),updatedby varchar(50) ,updateddate date  DEFAULT GETDATE())

//TABLE 8 - Account_UW_Mapping
create table Account_UW_Mapping(acc_uw_mapping_id int identity not null primary key, acc_id int references account (account_id), underWriterId int references underWriter (underWriter_Id ),createdby varchar(50)  ,createddate date  DEFAULT GETDATE(),updatedby varchar(50)  ,updateddate date  DEFAULT GETDATE())

//TABLE 9 - ACC_DOCUMENT
CREATE TABLE ACC_DOCUMENT(ACC_DOC_ID INT IDENTITY PRIMARY KEY,ACC_ID INT, foreign key(ACC_ID) REFERENCES ACCOUNT(ACCOUNT_ID),DOC_ID INT ,FOREIGN KEY(DOC_ID) REFERENCES DOCUMENT(DOC_ID),CREATED_BY VARCHAR(50) ,CREATED_DATE  DATE   DEFAULT GETDATE(),UPDATED_BY VARCHAR(50) ,UPDATED_DATE  DATE   DEFAULT GETDATE());



//INSERT QUERIES FOR COVERAGETYPE

Insert into coverageType (coverageType_Id,coverageType_name) values( 'B','Bronze');
Insert into coverageType (coverageType_Id,coverageType_name) values( 'G','Gold');
Insert into coverageType (coverageType_Id,coverageType_name) values( 'S','Silver');
Insert into coverageType (coverageType_Id,coverageType_name) values( 'P','Platinum');

//INSERT QUERIES FOR PRODUCTTYPE

Insert into productType (productType_name) values('B1');
Insert into productType (productType_name) values('B2');
Insert into productType (productType_name) values('G1');
Insert into productType (productType_name) values('G2');
Insert into productType (productType_name) values('S1');
Insert into productType (productType_name) values('S2');
Insert into productType (productType_name) values('P1');
Insert into productType (productType_name) values('P2');


//INSERT QUERIES FOR UnderWriter

Insert into UnderWriter ( name ,division) values('Underwriter 1', 'Texas')
Insert into UnderWriter ( name ,division) values('Underwriter 2', 'Illinois')
Insert into UnderWriter ( name ,division) values('Underwriter 3', 'Mexico')
Insert into UnderWriter ( name ,division) values('Underwriter 4', 'Montana')
Insert into UnderWriter ( name ,division) values('Underwriter 5', 'Oklahoma')
Insert into UnderWriter ( name ,division) values('Underwriter 6', 'Montana')
Insert into UnderWriter ( name ,division) values('Underwriter 7', 'Texas')
Insert into UnderWriter ( name ,division) values('Underwriter 8', 'Oklahoma')
Insert into UnderWriter ( name ,division) values('Underwriter 9', 'Mexico')
Insert into UnderWriter ( name ,division) values('Underwriter 10', 'Illinois')

//INSERT QUERIES FOR Account

Insert into Account ( account_number,name ,division) values('001','Account 1', 'Texas')
Insert into Account ( account_number,name ,division) values('002','Account 2', 'Illinois')
Insert into Account ( account_number,name ,division) values('003','Account 3', 'Mexico')
Insert into Account ( account_number,name ,division) values('004','Account 4', 'Montana')
Insert into Account ( account_number,name ,division) values('005','Account 5', 'Oklahoma')

//INSERT QUERIES FOR Document

Insert into Document(document_name ,division,file_name) values('doc1','Texas', 'doc1.pdf')
Insert into Document(doc_name ,division,file_name) values('doc2','Texas', 'doc2.pdf')
Insert into Document(doc_name ,division,file_name) values('doc3','Illinois', 'doc3.pdf')
Insert into Document(doc_name ,division,file_name) values('doc4','Mexico', 'doc4.pdf')
Insert into Document(doc_name ,division,file_name) values('doc5','Montana', 'doc5.pdf')
Insert into Document(doc_name ,division,file_name) values('doc6','Oklahoma', 'doc6.pdf')
Insert into Document(doc_name ,division,file_name) values('doc7','Texas', 'doc7.pdf')
Insert into Document(doc_name ,division,file_name) values('doc8','Illinois', 'doc8.pdf')
Insert into Document(doc_name ,division,file_name) values('doc9','Mexico', 'doc9.pdf')
Insert into Document(doc_name ,division,file_name) values('doc10','Montana', 'doc10.pdf')

//INSERT QUERIES FOR VALIDATION_STATUS
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('SUCCESS');
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('INCORRECT');
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('MISSING');
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('INCOMPLETE');

//INSERT QUERIES FOR UW_Mapping

insert into UW_Mapping (product_Type_id, under_writer_id) values ('1','1')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('1','3')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('1','5')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('2','2')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('2','4')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('2','6')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('3','4')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('3','6')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('3','8')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('4','5')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('4','7')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('4','9')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('5','3')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('5','5')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('5','7')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('6','1')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('6','2')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('6','9')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('7','3')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('7','7')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('7','9')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('9','2')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('9','6')
insert into UW_Mapping (product_Type_id, under_writer_id) values ('9','8')

//INSERT QUERIES FOR Account_UW_Mapping

insert into Account_UW_Mapping (underWriterId,acc_id) values ('1','1');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('1','2');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('1','3');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('2','3');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('2','4');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('2','1');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('3','5');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('3','2');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('3','1');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('4','1');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('4','2');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('4','4');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('5','4');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('5','3');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('5','1');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('6','2');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('6','4');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('6','5');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('7','1');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('7','4');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('7','3');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('8','3');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('8','1');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('8','5');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('9','5');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('9','1');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('9','3');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('10','4');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('10','1');
insert into Account_UW_Mapping (underWriterId,acc_id) values ('10','5');

//INSERT QUERIES FOR ACC_DOCUMENT

insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','2');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','11');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','4');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','5');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','6');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','7');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','8');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','9');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','10');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','12');

insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('2','2');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('2','4');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('2','6');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('2','7');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('2','8');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('2','9');

insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('3','4');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('3','7');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('3','10');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('3','12');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('3','9');

insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('4','8');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('4','6');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('4','5');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('4','2');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('4','11');


insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('5','4');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('5','6');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('5','7');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('5','8');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('5','9');














