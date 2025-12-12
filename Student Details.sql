CREATE DATABASE Students_details;
USE Students_details;

CREATE TABLE students (
  id INT PRIMARY KEY,
  roll_no INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  faculty VARCHAR(100),
  age INT,
  contact_num BIGINT
);

describe students;

