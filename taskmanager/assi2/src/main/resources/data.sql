-- Insert categories
INSERT INTO CATEGORY (name) VALUES ('Work');
INSERT INTO CATEGORY (name) VALUES ('Personal');
INSERT INTO CATEGORY (name) VALUES ('Shopping');

-- Insert tasks
INSERT INTO TASK (title, description, due_date, category_id)
VALUES ('Finish Project', 'Complete Spring Boot assignment', '2025-09-15', 1);

INSERT INTO TASK (title, description, due_date, category_id)
VALUES ('Buy Groceries', 'Milk, Bread, Eggs', '2025-09-10', 3);

INSERT INTO TASK (title, description, due_date, category_id)
VALUES ('Call Mom', 'Weekly catch-up call', '2025-09-11', 2);
