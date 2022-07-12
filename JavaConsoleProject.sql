--------------------------------------------------------
--  파일이 생성됨 - 화요일-7월-12-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_TOTAL_IDX
--------------------------------------------------------

   CREATE SEQUENCE  "KOSMO"."SEQ_TOTAL_IDX"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 29 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "KOSMO"."MEMBER" 
   (	"ID" VARCHAR2(30 BYTE), 
	"PASS" VARCHAR2(40 BYTE), 
	"NAME" VARCHAR2(50 BYTE), 
	"REGIDATE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SH_GOODS
--------------------------------------------------------

  CREATE TABLE "KOSMO"."SH_GOODS" 
   (	"G_IDX" NUMBER(20,0), 
	"GOODS_NAME" VARCHAR2(30 BYTE), 
	"GOODS_PRICE" NUMBER(20,0), 
	"REGIDATE" DATE, 
	"P_CODE" NUMBER(20,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SH_GOODS_LOG
--------------------------------------------------------

  CREATE TABLE "KOSMO"."SH_GOODS_LOG" 
   (	"LOG_IDX" NUMBER(20,0), 
	"GOODS_NAME" VARCHAR2(30 BYTE), 
	"GOODS_IDX" NUMBER(20,0), 
	"P_ACTION" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SH_PRODUCT_CODE
--------------------------------------------------------

  CREATE TABLE "KOSMO"."SH_PRODUCT_CODE" 
   (	"P_CODE" NUMBER(20,0), 
	"CATEGORY_NAME" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into KOSMO.MEMBER
SET DEFINE OFF;
Insert into KOSMO.MEMBER (ID,PASS,NAME,REGIDATE) values ('test3','1343','김은아',to_date('22/05/16','RR/MM/DD'));
Insert into KOSMO.MEMBER (ID,PASS,NAME,REGIDATE) values ('test4','4444','테스터4',to_date('22/05/15','RR/MM/DD'));
Insert into KOSMO.MEMBER (ID,PASS,NAME,REGIDATE) values ('test1','0412','성유겸',to_date('22/04/28','RR/MM/DD'));
Insert into KOSMO.MEMBER (ID,PASS,NAME,REGIDATE) values ('pro01','0101','프로시저1',to_date('22/04/28','RR/MM/DD'));
REM INSERTING into KOSMO.SH_GOODS
SET DEFINE OFF;
Insert into KOSMO.SH_GOODS (G_IDX,GOODS_NAME,GOODS_PRICE,REGIDATE,P_CODE) values (4,'applewatch',580000,to_date('22/04/30','RR/MM/DD'),1);
Insert into KOSMO.SH_GOODS (G_IDX,GOODS_NAME,GOODS_PRICE,REGIDATE,P_CODE) values (26,'로봇청소기',800000,to_date('22/05/04','RR/MM/DD'),1);
Insert into KOSMO.SH_GOODS (G_IDX,GOODS_NAME,GOODS_PRICE,REGIDATE,P_CODE) values (7,'novel',13000,to_date('22/05/01','RR/MM/DD'),2);
Insert into KOSMO.SH_GOODS (G_IDX,GOODS_NAME,GOODS_PRICE,REGIDATE,P_CODE) values (8,'magazine',10000,to_date('22/05/01','RR/MM/DD'),2);
Insert into KOSMO.SH_GOODS (G_IDX,GOODS_NAME,GOODS_PRICE,REGIDATE,P_CODE) values (9,'textbook',30000,to_date('22/05/01','RR/MM/DD'),2);
Insert into KOSMO.SH_GOODS (G_IDX,GOODS_NAME,GOODS_PRICE,REGIDATE,P_CODE) values (10,'shirt',25000,to_date('22/05/02','RR/MM/DD'),3);
Insert into KOSMO.SH_GOODS (G_IDX,GOODS_NAME,GOODS_PRICE,REGIDATE,P_CODE) values (11,'jeans',38000,to_date('22/05/02','RR/MM/DD'),3);
REM INSERTING into KOSMO.SH_GOODS_LOG
SET DEFINE OFF;
Insert into KOSMO.SH_GOODS_LOG (LOG_IDX,GOODS_NAME,GOODS_IDX,P_ACTION) values (27,'로봇청소기',26,'insert');
Insert into KOSMO.SH_GOODS_LOG (LOG_IDX,GOODS_NAME,GOODS_IDX,P_ACTION) values (28,'dress',12,'delete');
REM INSERTING into KOSMO.SH_PRODUCT_CODE
SET DEFINE OFF;
Insert into KOSMO.SH_PRODUCT_CODE (P_CODE,CATEGORY_NAME) values (1,'Home Appliances');
Insert into KOSMO.SH_PRODUCT_CODE (P_CODE,CATEGORY_NAME) values (2,'Books');
Insert into KOSMO.SH_PRODUCT_CODE (P_CODE,CATEGORY_NAME) values (3,'Clothing');
--------------------------------------------------------
--  DDL for Index SYS_C007089
--------------------------------------------------------

  CREATE UNIQUE INDEX "KOSMO"."SYS_C007089" ON "KOSMO"."MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007152
--------------------------------------------------------

  CREATE UNIQUE INDEX "KOSMO"."SYS_C007152" ON "KOSMO"."SH_GOODS" ("G_IDX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007157
--------------------------------------------------------

  CREATE UNIQUE INDEX "KOSMO"."SYS_C007157" ON "KOSMO"."SH_GOODS_LOG" ("LOG_IDX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007151
--------------------------------------------------------

  CREATE UNIQUE INDEX "KOSMO"."SYS_C007151" ON "KOSMO"."SH_PRODUCT_CODE" ("P_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger SHOP_LOG_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "KOSMO"."SHOP_LOG_TRIGGER" 
    after
    Insert or Delete
    on sh_goods
    for each row
begin
    if inserting then
        insert into sh_goods_log
        values (
            SEQ_TOTAL_IDX.nextval,
            :new.goods_name,
            :new.g_idx,
            'insert'
        );
    elsif deleting then
        insert into sh_goods_log
        values (
            SEQ_TOTAL_IDX.nextval,
            :old.goods_name,
            :old.g_idx,
            'delete'
        );
    end if;
end;

/
ALTER TRIGGER "KOSMO"."SHOP_LOG_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Procedure KOSMOMEMBERAUTH
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "KOSMO"."KOSMOMEMBERAUTH" (
    user_id in varchar2, 
    user_pass in varchar2, 
    returnVal out number
)
is
    member_count number(1) := 0;
    member_pw varchar2(50);
begin
    select count(*) into member_count
        from member where id=user_id;
    if member_count = 1 then
        select pass into member_pw from member
            where id=user_id;

        if member_pw = user_pass then
            returnVal :=2;
        else 
            returnVal :=1;
        end if;
    else 
        returnVal :=0;
    end if;
end;

/
--------------------------------------------------------
--  DDL for Procedure KOSMOMEMBERDELETE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "KOSMO"."KOSMOMEMBERDELETE" (
    member_id in varchar2,
    returnVal out varchar2
)
is

begin
    delete from member where id = member_id;

    if SQL%Found then
        returnVal := 'SUCESS';
        commit;
    else
        returnVal := 'FAIL';
    end if;
end;

/
--------------------------------------------------------
--  DDL for Procedure KOSMOMEMBERINSERT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "KOSMO"."KOSMOMEMBERINSERT" (
    p_id in varchar2,
    p_pass in varchar2,
    p_name in varchar2, /* Java에서 전달한 인자를 받을 인파라미터*/
    returnVal out number /* 입력성공여부 확인 */
)
is 
begin
    --인파라미터를 통해 insert쿼리문 작성
    insert into member (id, pass, name)
        values (p_id, p_pass, p_name);
    --입력이 정상적으로 처리되었다면...    
    if sql%found then
        --성공한 행의 갯수를 얻어와서 아웃파라미터에 저장한다.
        returnVal := sql%rowcount;
        commit;
    else
        --실패한 경우에는 0을 반환한다. 
        returnVal :=0;
    end if;
end;

/
--------------------------------------------------------
--  DDL for Procedure SHOPDELETEGOODS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "KOSMO"."SHOPDELETEGOODS" (
    gidx in number,
    returnVal out varchar2
)
is 

begin
    delete from sh_goods where g_idx = gidx;

    if SQL%Found then 
        returnVal := 1;
        commit;
    else
        returnVal := 0;
    end if;
end;

/
--------------------------------------------------------
--  DDL for Procedure SHOPUPDATEGOODS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "KOSMO"."SHOPUPDATEGOODS" (
    gname in varchar2, 
    gprice in varchar2, 
    pcode in number, 
    gidx in number,
    returnVal out number 
)
is
begin 
    update sh_goods 
        set goods_name = gname,
            goods_price = gprice, 
            p_code = pcode
        where g_idx = gidx;

    if sql%found then 
        returnVal := 1;
        commit;
    else 
        returnVal := 0;
    end if;
    commit;
end;

/
--------------------------------------------------------
--  DDL for Function FILLASTERIK
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "KOSMO"."FILLASTERIK" (idStr varchar2)
return varchar2
is retStr varchar2(50);
begin 
    retStr := rpad(substr(idStr, 1,1), length(idstr), '*');
    return retStr;
end;

/
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "KOSMO"."MEMBER" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "KOSMO"."MEMBER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "KOSMO"."MEMBER" MODIFY ("PASS" NOT NULL ENABLE);
  ALTER TABLE "KOSMO"."MEMBER" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SH_GOODS
--------------------------------------------------------

  ALTER TABLE "KOSMO"."SH_GOODS" ADD PRIMARY KEY ("G_IDX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SH_GOODS_LOG
--------------------------------------------------------

  ALTER TABLE "KOSMO"."SH_GOODS_LOG" ADD PRIMARY KEY ("LOG_IDX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "KOSMO"."SH_GOODS_LOG" ADD CONSTRAINT "CHECK_LOG" CHECK (p_action in ('insert', 'delete')) ENABLE;
--------------------------------------------------------
--  Constraints for Table SH_PRODUCT_CODE
--------------------------------------------------------

  ALTER TABLE "KOSMO"."SH_PRODUCT_CODE" ADD PRIMARY KEY ("P_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SH_GOODS
--------------------------------------------------------

  ALTER TABLE "KOSMO"."SH_GOODS" ADD FOREIGN KEY ("P_CODE")
	  REFERENCES "KOSMO"."SH_PRODUCT_CODE" ("P_CODE") ENABLE;
