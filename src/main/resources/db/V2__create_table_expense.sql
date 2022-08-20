CREATE TABLE expense(
    id int auto_increment primary key,
    description varchar(255),
    amount decimal(11, 2),
    date_creation date
)