BEGIN
FOR c IN (SELECT customer_id, age, balance, loan_interest FROM customers) LOOP

        IF c.age > 60 THEN
UPDATE customers
SET loan_interest = loan_interest - 1
WHERE customer_id = c.customer_id;
END IF;

        IF c.balance > 10000 THEN
UPDATE customers
SET is_vip = 'TRUE'
WHERE customer_id = c.customer_id;
END IF;

        IF EXISTS (
            SELECT 1 FROM loans
            WHERE customer_id = c.customer_id
            AND due_date BETWEEN SYSDATE AND SYSDATE + 30
        ) THEN
            DBMS_OUTPUT.PUT_LINE('Reminder: Loan due soon for customer ' || c.customer_id);
END IF;

END LOOP;

COMMIT;
END;
/