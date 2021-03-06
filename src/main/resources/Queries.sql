//TABLE 1 - COVERAGETYPE
CREATE TABLE COVERAGETYPE(ID INT IDENTITY NOT NULL PRIMARY KEY, COVERAGETYPE_ID VARCHAR(2) , COVERAGETYPE_NAME  VARCHAR(20) NOT NULL,CREATEDBY VARCHAR(50)  ,CREATEDDATE DATE DEFAULT GETDATE(),UPDATEDBY VARCHAR(50)  ,UPDATEDDATE DATE  DEFAULT GETDATE());

//TABLE 2 - PRODUCTTYPE
CREATE TABLE PRODUCTTYPE(PRODUCTTYPEID INT IDENTITY NOT NULL  PRIMARY KEY, PRODUCTTYPE_NAME  VARCHAR(20) NOT NULL,CREATEDBY VARCHAR(50)  ,CREATEDDATE DATE  DEFAULT GETDATE(),UPDATEDBY VARCHAR(50)  ,UPDATEDDATE DATE DEFAULT  GETDATE());

//TABLE 3 UNDERWRITER
CREATE TABLE UNDERWRITER(UNDERWRITERID INT IDENTITY NOT NULL PRIMARY KEY, UNDERWRITER_NAME VARCHAR(100) NOT NULL, DIVISION VARCHAR(20) NOT NULL,CREATEDBY VARCHAR(50)  ,CREATEDDATE DATE  DEFAULT GETDATE(),UPDATEDBY VARCHAR(50) ,UPDATEDDATE DATE  DEFAULT GETDATE());

//TABLE 4- ACCOUNT
CREATE TABLE ACCOUNT(ACCOUNTID INT IDENTITY PRIMARY KEY,ACCOUNT_NUMBER VARCHAR(50),NAME VARCHAR(100) NOT NULL,DIVISION VARCHAR(100) NOT NULL,CREATEDBY VARCHAR(50) ,CREATEDDATE  DATE DEFAULT GETDATE(),UPDATEDBY VARCHAR(50),UPDATEDDATE  DATE DEFAULT GETDATE());

// TABLE 5 - DOCUMENT
CREATE TABLE DOCUMENT(DOCID INT IDENTITY PRIMARY KEY NOT NULL,DOC_NAME VARCHAR(100) NOT NULL,DIVISION VARCHAR(100) NOT NULL,FILE_NAME VARCHAR(100) NOT NULL,CREATEDBY VARCHAR(50) ,CREATEDDATE  DATE   DEFAULT GETDATE(),UPDATEDBY VARCHAR(50) ,UPDATEDDATE  DATE  DEFAULT GETDATE());

//TABLE 6 - VALIDATION STATUS
CREATE TABLE VALIDATION_STATUS (STATUSID INT IDENTITY PRIMARY KEY , STATUS VARCHAR(100) NOT NULL,CREATEDBY VARCHAR(50) , CREATEDDATE DATE  DEFAULT GETDATE(), UPDATEDBY VARCHAR(50) , UPDATEDDATE DATE  DEFAULT GETDATE());


//TRANSACTION TABLES
//TABLE 7 - UWMAPPING
CREATE TABLE UWMAPPING(UWMAPPINGID INT IDENTITY NOT NULL PRIMARY KEY,PRODUCTTYPEID INT REFERENCES PRODUCTTYPE (PRODUCTTYPEID), UNDERWRITERID INT REFERENCES UNDERWRITER(UNDERWRITERID ),CREATEDBY VARCHAR(50) ,CREATEDDATE DATE DEFAULT GETDATE(),UPDATEDBY VARCHAR(50) ,UPDATEDDATE DATE  DEFAULT GETDATE());

//TABLE 8 - ACCOUNTUWMAPPING
CREATE TABLE ACCOUNTUWMAPPING(ACCUWMAPPINGID INT IDENTITY NOT NULL PRIMARY KEY, ACCOUNTID INT REFERENCES ACCOUNT (ACCOUNTID), UNDERWRITERID INT REFERENCES UNDERWRITER (UNDERWRITERID ),CREATEDBY VARCHAR(50)  ,CREATEDDATE DATE  DEFAULT GETDATE(),UPDATEDBY VARCHAR(50)  ,UPDATEDDATE DATE  DEFAULT GETDATE());

//TABLE 9 - ACC_DOCUMENT
CREATE TABLE ACC_DOCUMENT(ACCDOCID INT IDENTITY PRIMARY KEY,ACCOUNTID INT, FOREIGN KEY(ACCOUNTID) REFERENCES ACCOUNT(ACCOUNTID),DOCID INT ,FOREIGN KEY(DOCID) REFERENCES DOCUMENT(DOCID),CREATEDBY VARCHAR(50) ,CREATEDDATE  DATE   DEFAULT GETDATE(),UPDATEDBY VARCHAR(50) ,UPDATEDDATE  DATE   DEFAULT GETDATE());

//TABLE 9 - DOC_REV_STATUS 
CREATE TABLE DOC_REV_STATUS(DOCREVSTATUSID INT IDENTITY PRIMARY KEY,ACCOUNTID INT, FOREIGN KEY(ACCOUNTID) REFERENCES ACCOUNT(ACCOUNTID),DOCID INT ,FOREIGN KEY(DOCID) REFERENCES DOCUMENT(DOCID),STATUSID INT, FOREIGN KEY(STATUSID) REFERENCES VALIDATION_STATUS(STATUSID),CREATEDBY VARCHAR(50) ,CREATEDDATE  DATE   DEFAULT GETDATE(),UPDATEDBY VARCHAR(50) ,UPDATEDDATE  DATE   DEFAULT GETDATE());

//MASTER TABLES INSERT QUERY

//INSERT QUERIES FOR ACCOUNT
INSERT INTO ACCOUNT ( ACCOUNT_NUMBER,NAME ,DIVISION) VALUES('11401','ACCOUNT 1', 'TEXAS');
INSERT INTO ACCOUNT ( ACCOUNT_NUMBER,NAME ,DIVISION) VALUES('11402','ACCOUNT 2', 'ILLINOIS');
INSERT INTO ACCOUNT ( ACCOUNT_NUMBER,NAME ,DIVISION) VALUES('11403','ACCOUNT 3', 'MEXICO');
INSERT INTO ACCOUNT ( ACCOUNT_NUMBER,NAME ,DIVISION) VALUES('11404','ACCOUNT 4', 'MONTANA');
INSERT INTO ACCOUNT ( ACCOUNT_NUMBER,NAME ,DIVISION) VALUES('11405','ACCOUNT 5', 'OKLAHOMA');

//INSERT QUERIES FOR DOCUMENT
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('COMPOSITE RATE BILLING METHOD DECLARATION FORM','TEXAS', 'COMPOSITERATEBILLING.PDF');
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('DEPENDENT STATE CONTINUATION OF COVERAGE FORM','ILLINOIS', 'DEPENDENTSTATECONTINUATION.PDF');
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('DISABLED DEPENDENT CERTIFICATION FORM','MEXICO', 'DISABLEDDEPENDENTCERTIFICATION.PDF');
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('DISCLOSURE NOTICE / HMO CONSUMER CHOICE BENEFIT PLANS','MONTANA', 'HMOCONSUMERCHOICE.PDF');
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('EMPLOYER REPRESENTATIVE AUTHORIZATION (ERA)','OKLAHOMA', 'ERA.PDF');
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('OTHER','TEXAS', 'OTHER.PDF');
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('SMALL GROUP CERTIFICATE OF COMMON OWNERSHIP','ILLINOIS', 'GROUPCERTIFICATE.PDF');
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('STATE FILED PROOF OF BUSINESS','MEXICO', 'PROOFOFBUSINESS.PDF');
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('SUPPLEMENTAL EMPLOYMENT VERIFICATION FORM','MONTANA', 'EMPLOYMENTVERIFICATION.PDF');
INSERT INTO DOCUMENT(DOC_NAME ,DIVISION,FILE_NAME) VALUES('TEXAS NINE (9) MONTH STATE CONTINUATION OF INSURANCE APPLICATION FORM','TEXAS', 'INSURANCEAPPLICATION.PDF');


//INSERT QUERIES FOR VALIDATION_STATUS
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('SUCCESS');
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('INCORRECT');
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('MISSING');
INSERT INTO VALIDATION_STATUS (STATUS) VALUES ('INCOMPLETE');

//INSERT QUERIES FOR PRODUCTTYPE
INSERT INTO PRODUCTTYPE (PRODUCTTYPE_NAME) VALUES('B1');
INSERT INTO PRODUCTTYPE (PRODUCTTYPE_NAME) VALUES('B2');
INSERT INTO PRODUCTTYPE (PRODUCTTYPE_NAME) VALUES('G1');
INSERT INTO PRODUCTTYPE (PRODUCTTYPE_NAME) VALUES('G2');
INSERT INTO PRODUCTTYPE (PRODUCTTYPE_NAME) VALUES('S1');
INSERT INTO PRODUCTTYPE (PRODUCTTYPE_NAME) VALUES('S2');
INSERT INTO PRODUCTTYPE (PRODUCTTYPE_NAME) VALUES('P1');
INSERT INTO PRODUCTTYPE (PRODUCTTYPE_NAME) VALUES('P2');


//INSERT QUERIES FOR UNDERWRITER
INSERT INTO UNDERWRITER ( UNDERWRITER_NAME ,DIVISION) VALUES('VISHALI KUMAR', 'TEXAS');
INSERT INTO UNDERWRITER (  UNDERWRITER_NAME ,DIVISION) VALUES('AKSHAYA RAJARAM', 'ILLINOIS');
INSERT INTO UNDERWRITER (  UNDERWRITER_NAME ,DIVISION) VALUES('MAHA LAKSHMI', 'MEXICO');
INSERT INTO UNDERWRITER (  UNDERWRITER_NAME ,DIVISION) VALUES('VAIJEYANTHI KULASEKAR', 'MONTANA');
INSERT INTO UNDERWRITER (  UNDERWRITER_NAME ,DIVISION) VALUES('GURU LAKSHMI', 'OKLAHOMA');
INSERT INTO UNDERWRITER (  UNDERWRITER_NAME ,DIVISION) VALUES('EDISON EDWARD', 'MONTANA');
INSERT INTO UNDERWRITER (  UNDERWRITER_NAME ,DIVISION) VALUES('KANI MOZHI', 'TEXAS');
INSERT INTO UNDERWRITER (  UNDERWRITER_NAME ,DIVISION) VALUES('NANDHA KUMAR', 'OKLAHOMA');
INSERT INTO UNDERWRITER (  UNDERWRITER_NAME ,DIVISION) VALUES('PRASANNA PRAKASAM', 'MEXICO');
INSERT INTO UNDERWRITER (  UNDERWRITER_NAME ,DIVISION) VALUES('MONISA RAVICHANDRAN', 'ILLINOIS');


//INSERT QUERIES FOR COVERAGETYPE
INSERT INTO COVERAGETYPE (COVERAGETYPE_ID,COVERAGETYPE_NAME) VALUES( 'B','BRONZE');
INSERT INTO COVERAGETYPE (COVERAGETYPE_ID,COVERAGETYPE_NAME) VALUES( 'G','GOLD');
INSERT INTO COVERAGETYPE (COVERAGETYPE_ID,COVERAGETYPE_NAME) VALUES( 'S','SILVER');
INSERT INTO COVERAGETYPE (COVERAGETYPE_ID,COVERAGETYPE_NAME) VALUES( 'P','PLATINUM');




//TRANSACTION TABLE INSERT QUERIES


//INSERT QUERIES FOR ACC_DOCUMENT
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('1','2');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('1','4');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('1','5');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('1','6');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('1','7');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('1','8');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('1','9');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('1','10');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('2','2');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('2','4');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('2','6');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('2','7');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('2','8');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('2','9');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('3','4');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('3','7');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('3','10');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('3','9');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('4','8');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('4','6');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('4','5');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('4','2');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('5','4');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('5','6');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('5','7');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('5','8');
INSERT INTO ACC_DOCUMENT (ACCOUNTID,DOCID) VALUES('5','9');



//INSERT QUERIES FOR DOC_REV_STATUS


INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (1,2,1);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (1,4,3);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (1,5,4);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (1,6,2);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (1,7,3);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (1,8,4);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (1,9,3);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (2,2,2);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (2,4,1);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (2,6,4);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (2,7,3);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (2,8,2);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (2,9,3);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (3,4,2);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (3,7,1);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (3,10,3);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (3,9,4);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (4,8,2);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (4,6,1);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (4,5,4);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (4,2,2);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (5,4,2);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (5,6,4);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (5,7,1);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (5,8,2);
INSERT INTO DOC_REV_STATUS (ACCOUNTID, DOCID, STATUSID) VALUES (5,9,3);



//INSERT QUERIES FOR ACCOUNTUWMAPPING
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('1','1');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('1','2');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('1','3');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('2','3');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('2','4');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('2','1');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('3','5');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('3','2');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('3','1');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('4','1');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('4','2');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('4','4');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('5','4');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('5','3');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('5','1');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('6','2');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('6','4');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('6','5');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('7','1');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('7','4');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('7','3');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('8','3');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('8','1');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('8','5');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('9','5');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('9','1');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('9','3');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('10','4');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('10','1');
INSERT INTO ACCOUNTUWMAPPING (UNDERWRITERID ,ACCOUNTID) VALUES ('10','5');



//INSERT QUERIES FOR UWMAPPING
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('1','1');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('1','3');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('1','5');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('2','2');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('2','4');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('2','6');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('3','4');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('3','6');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('3','8');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('4','5');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('4','7');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('4','9');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('5','3');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('5','5');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('5','7');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('6','1');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('6','2');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('6','9');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('7','3');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('7','7');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('7','9');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('8','2');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('8','6');
INSERT INTO UWMAPPING (PRODUCTTYPEID, UNDERWRITERID) VALUES ('8','8');
