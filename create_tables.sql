create user myuser identified by myuser;
grant connect, resource to myuser;

create table myuser.A (
  id number primary key,
  notes varchar2(50),
  version number);

create table myuser.B (
  id number primary key,
  username varchar2(50),
  version number);

create table myuser.A_B (
  a_id number,
  b_id number,
  constraint a_fk foreign key (a_id) references myuser.A(id),
  constraint b_fk foreign key (b_id) references myuser.B(id)
);

insert into myuser.A values ('1', 'notes', 1);
insert into myuser.B values ('44', 'username', 1);
insert into myuser.A_B values ('1', '44');
