create table infoview(
iname   varchar2(10)
iid     char(14) 
itel    varchar2(11) not null
isex    char(4)
iage    number(3) 
ihome   varchar2(20)

CONSTRAINT pk_infoview PRIMARY KEY (itel),
CONSTRAINT ck_infoview CHECK ('³²','¿©') 
);

