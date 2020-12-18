
CREATE  TABLE tx_account_a (
	acc_num varchar(20) CONSTRAINT  tx_account_a_pk PRIMARY KEY,
	customer varchar(20),
	amount number	
);

INSERT INTO tx_account_a VALUES('111-11-1111', '홍길동', 40000);

CREATE TABLE  tx_account_b (
	acc_num varchar(20) CONSTRAINT  tx_account_b_pk PRIMARY KEY,
	customer varchar(20),
	amount number	
);

INSERT INTO tx_account_b VALUES('999999-999', '춘향', 20000);

COMMIT;
