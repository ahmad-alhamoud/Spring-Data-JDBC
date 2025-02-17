-- author

create table Author
(
    id         int auto_increment primary key,
    first_name varchar(100) not null,
    last_name  varchar(100) not null,
    email      varchar(255) not null,
    username   varchar(100) not null
);


-- post
create table Post
(
    id           int auto_increment primary key,
    title        varchar(255) not null,
    content      text         not null,
    published_on timestamp    not null,
    updated_on   timestamp,
    author       int,
    foreign key (author) references Author (id)

);

-- comment
create table Comment
(
    name         varchar(100) not null,
    content      text         not null,
    published_on timestamp ,
    updated_on   timestamp,
    post         int not null ,
    foreign key (post) references Post (id)
);

