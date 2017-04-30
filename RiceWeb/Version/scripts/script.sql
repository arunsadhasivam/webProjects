


CREATE SEQUENCE customers_seq1 START WITH     1000  INCREMENT BY   1  NOCACHE NOCYCLE;


create table tmp_cust_address(
            custno  varchar2(10),
			streetName varchar2(125),
			aptno varchar2(10),
			district varchar2(10),
			pincode  varchar2(10),
			city varchar2(10)


			)
      
      
      
 create table XX_customer_headers(     
 CUSTOMER_ID                               NOT NULL NUMBER,
 CUSTOMER_NO                               NOT NULL VARCHAR2(10),
 FIRST_NAME                                         VARCHAR2(50),
 LAST_NAME                                          VARCHAR2(50),
 NOTED_NAME                                         VARCHAR2(30),
 FATHER_NAME                                        VARCHAR2(30),
 PHONE_NUMBER                                       NUMBER(12),
 GENDER                                             CHAR(1),
 MOBILE_NUMBER                                      NUMBER(10),
 MOBILE_NUMBER2                                     NUMBER(10),
 EMAIL_ID                                           VARCHAR2(30),
 REMARKS                                            VARCHAR2(200),
 CREATED_BY                                         VARCHAR2(20),
 CREATION_DATE                                      DATE,
 LAST_UPDATED_BY                                    VARCHAR2(20),
 LAST_UPDATE_DATE                                   DATE
 
 );


alter table XX_customer_headers add constraint(primary_key CUSTOMER_ID                               NOT NULL NUMBER,
 CUSTOMER_NO not null);
