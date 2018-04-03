//MASTER TABLES INSERT QUERY

//INSERT QUERIES FOR Account
Insert into Account ( account_number,name ,division) values('001','Account 1', 'Texas');
Insert into Account ( account_number,name ,division) values('002','Account 2', 'Illinois');
Insert into Account ( account_number,name ,division) values('003','Account 3', 'Mexico');
Insert into Account ( account_number,name ,division) values('004','Account 4', 'Montana');
Insert into Account ( account_number,name ,division) values('005','Account 5', 'Oklahoma');

//INSERT QUERIES FOR Document
Insert into Document(doc_name ,division,file_name) values('doc2','Texas', 'doc2.pdf');
Insert into Document(doc_name ,division,file_name) values('doc3','Illinois', 'doc3.pdf');
Insert into Document(doc_name ,division,file_name) values('doc4','Mexico', 'doc4.pdf');
Insert into Document(doc_name ,division,file_name) values('doc5','Montana', 'doc5.pdf');
Insert into Document(doc_name ,division,file_name) values('doc6','Oklahoma', 'doc6.pdf');
Insert into Document(doc_name ,division,file_name) values('doc7','Texas', 'doc7.pdf');
Insert into Document(doc_name ,division,file_name) values('doc8','Illinois', 'doc8.pdf');
Insert into Document(doc_name ,division,file_name) values('doc9','Mexico', 'doc9.pdf');
Insert into Document(doc_name ,division,file_name) values('doc10','Montana', 'doc10.pdf');
Insert into Document(doc_name ,division,file_name) values('doc1','Texas', 'doc1.pdf');


//INSERT QUERIES FOR VALIDATION_STATUS
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('SUCCESS');
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('INCORRECT');
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('MISSING');
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('INCOMPLETE');

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
Insert into UnderWriter ( UNDERWRITER_name ,division) values('Underwriter 1', 'Texas');
Insert into UnderWriter (  UNDERWRITER_name ,division) values('Underwriter 2', 'Illinois');
Insert into UnderWriter (  UNDERWRITER_name ,division) values('Underwriter 3', 'Mexico');
Insert into UnderWriter (  UNDERWRITER_name ,division) values('Underwriter 4', 'Montana');
Insert into UnderWriter (  UNDERWRITER_name ,division) values('Underwriter 5', 'Oklahoma');
Insert into UnderWriter (  UNDERWRITER_name ,division) values('Underwriter 6', 'Montana');
Insert into UnderWriter (  UNDERWRITER_name ,division) values('Underwriter 7', 'Texas');
Insert into UnderWriter (  UNDERWRITER_name ,division) values('Underwriter 8', 'Oklahoma');
Insert into UnderWriter (  UNDERWRITER_name ,division) values('Underwriter 9', 'Mexico');
Insert into UnderWriter (  UNDERWRITER_name ,division) values('Underwriter 10', 'Illinois');


//INSERT QUERIES FOR COVERAGETYPE
Insert into coverageType (coverageType_Id,coverageType_name) values( 'B','Bronze');
Insert into coverageType (coverageType_Id,coverageType_name) values( 'G','Gold');
Insert into coverageType (coverageType_Id,coverageType_name) values( 'S','Silver');
Insert into coverageType (coverageType_Id,coverageType_name) values( 'P','Platinum');




//TRANSACTION TABLE INSERT QUERIES


//INSERT QUERIES FOR ACC_DOCUMENT
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','2');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','4');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','5');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','6');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','7');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','8');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','9');
insert into ACC_DOCUMENT (ACC_ID,DOC_ID) values('1','10');
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


//INSERT QUERIES FOR Account_UW_Mapping
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('1','1');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('1','2');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('1','3');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('2','3');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('2','4');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('2','1');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('3','5');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('3','2');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('3','1');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('4','1');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('4','2');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('4','4');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('5','4');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('5','3');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('5','1');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('6','2');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('6','4');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('6','5');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('7','1');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('7','4');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('7','3');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('8','3');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('8','1');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('8','5');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('9','5');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('9','1');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('9','3');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('10','4');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('10','1');
insert into Account_UW_Mapping (UNDER_WRITER_ID ,acc_id) values ('10','5');


//INSERT QUERIES FOR UW_Mapping
insert into UW_Mapping (product_Type_id, under_writer_id) values ('1','1');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('1','3');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('1','5');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('2','2');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('2','4');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('2','6');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('3','4');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('3','6');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('3','8');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('4','5');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('4','7');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('4','9');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('5','3');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('5','5');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('5','7');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('6','1');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('6','2');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('6','9');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('7','3');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('7','7');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('7','9');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('8','2');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('8','6');
insert into UW_Mapping (product_Type_id, under_writer_id) values ('8','8');

//INSERT QUERIES FOR DOC_REV_STATus


insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (1,2,1);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (1,4,3);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (1,5,4);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (1,6,2);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (1,7,3);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (1,8,4);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (1,9,3);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (2,2,2);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (2,4,1);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (2,6,4);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (2,7,3);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (2,8,2);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (2,9,3);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (3,4,2);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (3,7,1);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (3,10,3);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (3,9,4);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (4,8,2);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (4,6,1);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (4,5,4);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (4,2,2);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (5,4,2);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (5,6,4);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (5,7,1);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (5,8,2);
insert into Doc_Rev_Status (Acc_id, Doc_id, Status_id) values (5,9,3);









