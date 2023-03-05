create table if not exists item (
  id identity,
  name varchar(50) not null,
  price int not null,
  year_of_creation int not null,
  brand_from varchar(50) not null,
  created_at timestamp not null
);
