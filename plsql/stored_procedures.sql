CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
UPDATE savings_accounts
SET balance = balance + (balance * 0.01);

COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_id IN NUMBER,
    bonus_pct IN NUMBER
) AS
BEGIN
UPDATE employees
SET salary = salary + (salary * bonus_pct / 100)
WHERE department_id = dept_id;

COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acc IN NUMBER,
    to_acc IN NUMBER,
    amt IN NUMBER
) AS
    bal NUMBER;
BEGIN

SELECT balance INTO bal
FROM accounts
WHERE account_id = from_acc;

IF bal >= amt THEN

UPDATE accounts
SET balance = balance - amt
WHERE account_id = from_acc;

UPDATE accounts
SET balance = balance + amt
WHERE account_id = to_acc;

COMMIT;

ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
END IF;

END;
/