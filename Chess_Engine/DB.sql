  create table Player (
	id int identity(1,1) primary key,
	username varchar(max),
	password varchar(max),
	sound varchar(3),
	soundVl int,
	theme varchar(10)
  )
  insert into Player 
  values ('yang','admin2','on','55','hell')