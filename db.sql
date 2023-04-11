# 此表是数据库的地基,只是一个可能的版本,如果写着写着发现数据库设计不合理,和组长联系修改

CREATE DATABASE IF NOT EXISTS novelnook;
USE novelnook;

DROP TABLE IF EXISTS borrow;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS staff;
CREATE  TABLE IF NOT EXISTS staff(
  username varchar(255) PRIMARY KEY,
  password varchar(255),
  firstname varchar(255),
  lastname varchar(255),
  email varchar(255),
  telephone varchar(255),
  avatar varchar(255)
);


CREATE TABLE IF NOT EXISTS user(
                                   userid VARCHAR(255) PRIMARY KEY,
                                   username VARCHAR(255),
                                   password VARCHAR(255),
                                   avatarlocation VARCHAR(255),
                                   userrole ENUM('admin','patron','staff','super user'),
                                   email VARCHAR(255),
                                   PHONE VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS book(
                                   bookid VARCHAR(255) PRIMARY KEY ,
                                   bookname VARCHAR(255),
                                   press VARCHAR(255),
                                   author VARCHAR(255),
                                   publishtime VARCHAR(255),
                                   catagory VARCHAR(255),
                                   remain int,
                                   introduction TEXT
);
CREATE TABLE IF NOT EXISTS borrow(
                                     userid VARCHAR(255),
                                     bookid VARCHAR(255),
                                     borrowtime DATE,
                                     deadline DATE,
                                     status ENUM('returned','borrowing'),
                                     FOREIGN KEY(userid) REFERENCES user(userid) ON UPDATE CASCADE ON DELETE CASCADE ,
                                     FOREIGN KEY(bookid) REFERENCES book(bookid) ON UPDATE CASCADE ON DELETE CASCADE ,
                                     PRIMARY KEY (userid,bookid)
);

CREATE TABLE IF NOT EXISTS reservation(
                                          userid VARCHAR(255),
                                          bookid VARCHAR(255),
                                          reservationtime DATE,
                                          status ENUM('cancled','waiting','satisfied'),
                                          FOREIGN KEY(userid) REFERENCES user(userid) ON UPDATE CASCADE ON DELETE CASCADE ,
                                          FOREIGN KEY(bookid) REFERENCES book(bookid) ON UPDATE CASCADE ON DELETE CASCADE ,
                                          PRIMARY KEY (userid,bookid)
);


#下面是一些测试用的数据,由GPT生成,感谢GPT的劳动^~^
# From GPT
INSERT IGNORE INTO user(userid, username, password, avatarlocation, userrole, email, phone) VALUES
                                                                                                ('001', 'John Doe', 'johndoe123', 'avatars/johndoe.jpg', 'patron', 'johndoe@example.com', '+1 (555) 123-4567'),
                                                                                                ('002', 'Jane Smith', 'janesmith456', 'avatars/janesmith.jpg', 'patron', 'janesmith@example.com', '+1 (555) 987-6543'),
                                                                                                ('003', 'Admin', 'admin123', 'avatars/admin.jpg', 'admin', 'admin@example.com', '+1 (555) 555-5555'),
                                                                                                ('004', 'Staff 1', 'staff123', 'avatars/staff1.jpg', 'staff', 'staff1@example.com', '+1 (555) 111-1111'),
                                                                                                ('005', 'Staff 2', 'staff456', 'avatars/staff2.jpg', 'staff', 'staff2@example.com', '+1 (555) 222-2222'),
                                                                                                ('006', 'Super User', 'superuser123', 'avatars/superuser.jpg', 'super user', 'superuser@example.com', '+1 (555) 333-3333'),
                                                                                                ('007', 'Patron 1', 'patron123', 'avatars/patron1.jpg', 'patron', 'patron1@example.com', '+1 (555) 444-4444'),
                                                                                                ('008', 'Patron 2', 'patron456', 'avatars/patron2.jpg', 'patron', 'patron2@example.com', '+1 (555) 555-6666'),
                                                                                                ('009', 'Patron 3', 'patron789', 'avatars/patron3.jpg', 'patron', 'patron3@example.com', '+1 (555) 777-7777'),
                                                                                                ('010', 'Patron 4', 'patron101112', 'avatars/patron4.jpg', 'patron', 'patron4@example.com', '+1 (555) 888-8888'),
                                                                                                ('011', 'Patron 5', 'patron131415', 'avatars/patron5.jpg', 'patron', 'patron5@example.com', '+1 (555) 999-9999'),
                                                                                                ('012', 'Patron 6', 'patron161718', 'avatars/patron6.jpg', 'patron', 'patron6@example.com', '+1 (555) 000-0000'),
                                                                                                ('013', 'Patron 7', 'patron192021', 'avatars/patron7.jpg', 'patron', 'patron7@example.com', '+1 (555) 111-2222'),
                                                                                                ('014', 'Patron 8', 'patron222324', 'avatars/patron8.jpg', 'patron', 'patron8@example.com', '+1 (555) 333-4444'),
                                                                                                ('015', 'Patron 9', 'patron252627', 'avatars/patron9.jpg', 'patron', 'patron9@example.com', '+1 (555) 555-7777'),
                                                                                                ('016', 'Patron 10', 'patron282930', 'avatars/patron10.jpg', 'patron', 'patron10@example.com', '+1 (555) 999-8888'),
                                                                                                ('017', 'Patron 11', 'patron313233', 'avatars/patron11.jpg', 'patron', 'patron11@example.com', '+1 (555) 222-3333'),
                                                                                                ('018', 'Patron 12', 'patron343536', 'avatars/patron12.jpg', 'patron', 'patron12@example.com', '+1 (555) 444-5555'),
                                                                                                ('019', 'Patron 13', 'patron373839', 'avatars/patron13.jpg', 'patron', 'patron13@example.com', '+1 (555) 666-7777'),
                                                                                                ('020', 'Patron 14', 'patron404142', 'avatars/patron14.jpg', 'patron', 'patron14@example.com', '+1 (555) 888-9999');



INSERT IGNORE INTO book (bookid, bookname, press, author, publishtime, catagory, remain, introduction)VALUES
                                                                                                          ('B001', 'The Great Gatsby', 'Scribner', 'F. Scott Fitzgerald', '1925', 'Classic Literature', 5, 'A story of the decadent excesses of the Jazz Age.'),
                                                                                                          ('B002', 'To Kill a Mockingbird', 'J. B. Lippincott & Co.', 'Harper Lee', '1960', 'Classic Literature', 3, 'A powerful novel about racial injustice and coming of age in the Deep South.'),
                                                                                                          ('B003', 'Pride and Prejudice', 'T. Egerton', 'Jane Austen', '1813', 'Classic Literature', 6, 'A witty and romantic novel of manners.'),
                                                                                                          ('B004', 'The Catcher in the Rye', 'Little, Brown and Company', 'J. D. Salinger', '1951', 'Classic Literature', 4, 'A story of teenage alienation and angst.'),
                                                                                                          ('B005', '1984', 'Secker & Warburg', 'George Orwell', '1949', 'Dystopian Fiction', 7, 'A chilling vision of a totalitarian future.'),
                                                                                                          ('B006', 'Animal Farm', 'Secker & Warburg', 'George Orwell', '1945', 'Satire', 8, 'A political allegory about the dangers of totalitarianism.'),
                                                                                                          ('B007', 'Brave New World', 'Chatto & Windus', 'Aldous Huxley', '1932', 'Dystopian Fiction', 3, 'A satirical novel about a future world controlled by science and technology.'),
                                                                                                          ('B008', 'The Lord of the Rings', 'George Allen & Unwin', 'J. R. R. Tolkien', '1954', 'Fantasy', 5, 'A classic epic fantasy adventure.'),
                                                                                                          ('B009', 'Harry Potter and the Philosopher\'s Stone', 'Bloomsbury', 'J. K. Rowling', '1997', 'Fantasy', 10, 'The first book in a beloved series of young adult fantasy novels.'),
                                                                                                          ('B010', 'The Hitchhiker\'s Guide to the Galaxy', 'Pan Books', 'Douglas Adams', '1979', 'Science Fiction', 2, 'A comedic science fiction series that satirizes human behavior and societal norms.'),
                                                                                                          ('B011', 'The Da Vinci Code', 'Doubleday', 'Dan Brown', '2003', 'Mystery', 3, 'A fast-paced thriller that explores the hidden codes and secrets of the Catholic Church.'),
                                                                                                          ('B012', 'Gone Girl', 'Crown Publishing Group', 'Gillian Flynn', '2012', 'Mystery', 4, 'A psychological thriller about a missing woman and the husband who becomes the prime suspect.'),
                                                                                                          ('B013', 'The Hunger Games', 'Scholastic Corporation', 'Suzanne Collins', '2008', 'Young Adult Fiction', 6, 'A dystopian adventure novel about a teenage girl who fights to survive in a deadly game.'),
                                                                                                          ('B014', 'The Fault in Our Stars', 'Dutton Books', 'John Green', '2012', 'Young Adult Fiction', 5, 'A heart-wrenching story about two teenagers with terminal illnesses who fall in love.');

INSERT IGNORE INTO borrow(userid,bookid,borrowtime,deadline,status)VALUES
                                                                       ('007','B001','2023-03-21','2023-4-21','borrowing'),
                                                                       ('007','B002','2022-03-21','2022-4-21','returned'),
                                                                       ('007','B003','2022-03-21','2024-4-21','returned'),
                                                                       ('007','B004','2023-02-21','2023-3-21','borrowing'),
                                                                       ('007','B005','2023-03-21','2023-4-21','borrowing'),
                                                                       ('007','B006','2023-03-21','2023-4-21','returned'),
                                                                       ('007','B007','2023-03-21','2023-4-21','borrowing'),
                                                                       ('007','B008','2023-03-21','2023-4-21','borrowing'),

                                                                       ('008','B009','2023-03-21','2023-4-21','borrowing'),
                                                                       ('008','B0012','2022-03-21','2022-4-21','returned'),
                                                                       ('008','B0011','2022-03-21','2024-4-21','returned'),
                                                                       ('008','B0010','2023-02-21','2023-3-21','borrowing'),
                                                                       ('008','B005','2023-03-21','2023-4-21','borrowing'),
                                                                       ('008','B006','2023-03-21','2023-4-21','returned'),
                                                                       ('008','B007','2023-03-21','2023-4-21','borrowing'),
                                                                       ('008','B008','2023-03-21','2023-4-21','borrowing');

INSERT IGNORE INTO reservation(userid,bookid,reservationtime,status)VALUES
                                                                        ('007','B001','2023-03-21','satisfied'),
                                                                        ('008','B007','2023-02-21','satisfied');

