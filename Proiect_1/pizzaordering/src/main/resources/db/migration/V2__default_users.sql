INSERT INTO pizza_ordering.app_user
(user_id, user_name, password, first_name, last_name, phone_number, email, account_not_expired, account_not_locked, credentials_not_expired, enabled)
VALUES(1, 'admin', '$2a$10$IVQsgh4dILRHO0FFqqupCOJ8CJnhIuy5nOPnj2NKYH207zWRHWn2u', 'admin', 'admin', '0000000000', 'admin@gmail.com', 1, 1, 1, 1);
INSERT INTO pizza_ordering.app_user
(user_id, user_name, password, first_name, last_name, phone_number, email, account_not_expired, account_not_locked, credentials_not_expired, enabled)
VALUES(2, 'guest', '$2a$10$OuvtUid22Iw8LroArO3e4.5b05H6N2VNzKnyB3ew3YMzMix8IPphK', 'George2', 'Oprian2', '0743144861', 'george.oprian2@gmail.com', 1, 1, 1, 1);


INSERT INTO pizza_ordering.authority
(id, `role`)
VALUES(1, 'ROLE_ADMIN');
INSERT INTO pizza_ordering.authority
(id, `role`)
VALUES(2, 'ROLE_GUEST');

INSERT INTO pizza_ordering.user_authority
(user_id, authority_id)
VALUES(1, 1);
INSERT INTO pizza_ordering.user_authority
(user_id, authority_id)
VALUES(2, 2);
