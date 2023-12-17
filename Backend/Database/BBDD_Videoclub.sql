create database videoclub;
use videoclub;

-- tablas
create table LOGIN(
ID_USUARIO int primary key auto_increment, 
EMAIL varchar(50) not null unique,
PASSWORD varchar(30) not null unique,
USER_NAME varchar(40) not null unique
)engine=innodb;

create table CATEGORIES(
ID_CATEGORY int primary key auto_increment,
CATEGORY varchar(40) not null unique
);

create table MOVIES(
ID_MOVIE int primary key auto_increment,
TITLE varchar(60) not null unique,
IMAGE varchar(255) not null unique,
RELEASE_DATE date not null unique,
SYNOPSIS varchar(255),
DIRECTOR varchar(90),
TRAILER varchar(255) not null unique
)engine=innodb;

create table MOVIE_CATEGORY(
ID_MOVIE int,
ID_CATEGORY int,
primary key(ID_MOVIE, ID_CATEGORY)
);

create table SERIES(
ID_SERIE int primary key auto_increment,
TITLE varchar(40) not null unique,
IMAGE varchar(255) not null unique,
NUMBER_SEASONS int not null unique,
RELEASE_DATE date not null unique,
SYNOPSIS varchar(255) not null unique
)engine=innodb;

create table SERIE_CATEGORY(
ID_SERIE int,
ID_CATEGORY int,
primary key(ID_SERIE, ID_CATEGORY)
);

create table SEASONS(
ID_SEASON int primary key auto_increment,
SEASON_NAME varchar(120) not null,
CHAPTERS int(4) not null,
RELEASE_DATE date not null,
SERIE_ID int not null,
TRAILER varchar(255) not null
);

alter table MOVIE_CATEGORY
add constraint FK_CATEGORY_MOVIE_MOVIE foreign key(ID_MOVIE) references MOVIES(ID_MOVIE),
add constraint FK_CATEGORY_MOVIE_CATEGORY foreign key(ID_CATEGORY) references CATEGORIES(ID_CATEGORY);

alter table SERIE_CATEGORY
add constraint FK_CATEGORY_SERIE_SERIE foreign key(ID_SERIE) references SERIES(ID_SERIE),
add constraint FK_CATEGORY_SERIE_CATEGORY foreign key(ID_CATEGORY) references CATEGORIES(ID_CATEGORY);

alter table SEASONS
add constraint FK_SEASON_SERIE foreign key (SERIE_ID) references SERIES(ID_SERIE);

-- INSERTS
-- CATEGORIES
insert into CATEGORIES(ID_CATEGORY, CATEGORY) values (1, 'Accion');
insert into CATEGORIES(ID_CATEGORY, CATEGORY) values (null, 'Animacion');
insert into CATEGORIES(ID_CATEGORY, CATEGORY) values (null, 'Anime');
insert into CATEGORIES(ID_CATEGORY, CATEGORY) values (null, 'Ciencia Ficcion');
insert into CATEGORIES(ID_CATEGORY, CATEGORY) values (null, 'Fantasia');
insert into CATEGORIES(ID_CATEGORY, CATEGORY) values (null, 'Infantil');
insert into CATEGORIES(ID_CATEGORY, CATEGORY) values (null, 'Suspense');
insert into CATEGORIES(ID_CATEGORY, CATEGORY) values (null, 'Aventura');
insert into CATEGORIES(ID_CATEGORY, CATEGORY) values (null, 'Comedia');

-- MOVIES
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('El Escuadrón Suicida', 'https://pics.filmaffinity.com/El_Escuadraon_Suicida-629689677-large.jpg', '2016/08/06', 
'El Escuadrón Suicida, un grupo de villanos, emprende una peligrosa misión para destruir un laboratorio secreto. Entre acción y humor negro, buscan redención enfrentando amenazas mortales y desafíos impredecibles.',
'James Gunn', 'https://www.youtube.com/watch?v=IblLmbGxw1Q');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Guardianes de la Galaxia', 'https://pics.filmaffinity.com/Guardianes_de_la_galaxia-595487268-large.jpg', '2014/08/14', 
'"Guardianes de la Galaxia" sigue a un grupo disfuncional de héroes espaciales mientras intentan detener a Ronan el Acusador y salvar el cosmos con música y humor.' 
,'James Gunn', 'https://www.youtube.com/watch?v=F60FZKt_36s');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Fast and Furious', 'https://pics.filmaffinity.com/Fast_Furious_X-556821969-large.jpg', '2023/05/19',
 '"Fast and Furious X" lleva a Toretto y su equipo a desafíos globales con carreras frenéticas y acrobacias imparables, enfrentándose a una amenaza inesperada. La acción y la lealtad se entrelazan en esta entrega explosiva.'
,'Louis Leterrier', 'https://www.youtube.com/watch?v=FDhvbIqTQwI');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Los Vengadores', 'https://pics.filmaffinity.com/the_avengers-439499921-mmed.jpg', '2012/04/27',
'"Los Vengadores" reúnen a héroes como Iron Man, Thor, Hulk y Capitán América para enfrentar a Loki y salvar la Tierra. Con acción épica y humor, forjan una alianza improbable contra amenazas intergalácticas, demostrando que juntos son más fuertes.'
, 'Joss Whedon', 'https://www.youtube.com/watch?v=HQIiYqOVTWo');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Piratas del Caribe', 'https://pics.filmaffinity.com/Piratas_del_Caribe_La_maldiciaon_de_la_Perla_Negra-627724446-large.jpg', '2003/08/14',
'"La Maldición del Perla Negra": Jack Sparrow, Will y Elizabeth buscan un tesoro maldito en una aventura llena de piratas, misterios y humor.'
, 'Gore Verbinski', 'https://www.youtube.com/watch?v=4s67PU-s1kc');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Harry Potter', 'https://pics.filmaffinity.com/Harry_Potter_y_la_piedra_filosofal-154820574-mmed.jpg', '2001/11/30',
'"Harry Potter y la Piedra Filosofal": Harry descubre su magia al ingresar a Hogwarts. Con amigos, enfrenta misterios y el mal resurgente, culminando en la búsqueda de la Piedra Filosofal.',
'Chris Columbus', 'https://www.youtube.com/watch?v=ZgrCZVjPg9g');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('La Mansion Encantada', 'https://pics.filmaffinity.com/La_mansiaon_encantada-303930929-large.jpg', '2004/01/30',
'"La Mansión Encantada": Eddie Murphy es un agente inmobiliario que, junto a su familia, enfrenta fantasmas y revela oscuros secretos al explorar una mansión embrujada. Una comedia sobrenatural llena de risas y sustos.',
'Rob Minkoff', 'https://www.youtube.com/watch?v=1DDEDBubnQU');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Buscando a Nemo', 'https://pics.filmaffinity.com/Buscando_a_Nemo-284341931-large.jpg', '2003/11/28',
'"Buscando a Nemo": Marlin busca desesperadamente a su hijo Nemo, capturado por un buceador. En su viaje acuático, encuentra amistades inolvidables y descubre el valor de la valentía y la amistad.'
, 'Andrew Stanton', 'https://www.youtube.com/watch?v=ba4TwyaNhSQ');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Cars', 'https://pics.filmaffinity.com/Cars-746710621-large.jpg', '2006/07/06',
'"Cars" sigue a Rayo McQueen, un auto de carreras, que aprende lecciones de humildad en el tranquilo Radiator Springs. La película celebra la amistad y descubre que hay más en la vida que la velocidad.'
, 'John Lasseter', 'https://www.youtube.com/watch?v=8ZMklX5BzTo');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('El Planeta del Tesoro', 'https://pics.filmaffinity.com/El_planeta_del_tesoro-410694399-large.jpg', '2002/12/05',
'"El Planeta del Tesoro" sigue a Jim Hawkins en una odisea espacial en busca de un tesoro legendario. A bordo de una nave interestelar, enfrenta peligros, forja amistades y descubre secretos en un viaje lleno de aventuras y sorpresas.',
'John Musker, Ron Clements', 'https://www.youtube.com/watch?v=uokpV_AkQAc');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Spider-man', 'https://pics.filmaffinity.com/Spider_Man-945131720-large.jpg', '2002/06/21',
'"Spider-Man" (2002): Peter Parker, mordido por una araña radiactiva, descubre sus poderes y enfrenta al Duende Verde. Equilibrando amor y responsabilidad, Spider-Man emerge como un héroe en la ciudad de Nueva York.',
'Sam Raimi', 'https://www.youtube.com/watch?v=t06RUxPbp_c');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('El señor de los anillos', 'https://pics.filmaffinity.com/El_seanor_de_los_anillos_La_comunidad_del_anillo-744631610-large.jpg', '2001/12/19',
'"El Señor de los Anillos: La Comunidad del Anillo" sigue a Frodo y compañía en una misión para destruir el Anillo Único. Enfrentan peligros, forjan amistades y luchan contra las fuerzas oscuras en una travesía épica por la Tierra Media.',
'Peter Jackson', 'https://www.youtube.com/watch?v=iFOucwxKRFE');

-- MOVIE_CATEGORY
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (1, 1);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (1, 5);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (2, 1);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (2, 5);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (3, 1);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (4, 1);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (4, 5);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (5, 1);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (5, 8);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (6, 5);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (6, 8);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (7, 9);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (8, 8);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (8, 9);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (9, 2);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (9, 9);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (10, 8);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (10, 4);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (11, 1);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (11, 4);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (12, 5);
insert into MOVIE_CATEGORY(ID_MOVIE, ID_CATEGORY) values (12, 8);