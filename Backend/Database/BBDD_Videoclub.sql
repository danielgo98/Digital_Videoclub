create database videoclub;
use videoclub;

-- tablas
create table USERS(
ID_USUARIO int primary key auto_increment, 
EMAIL varchar(50) not null unique,
PASSWORD varchar(30) not null,
USERNAME varchar(40) not null unique
)engine=innodb;

create table CATEGORIES(
ID_CATEGORY int primary key auto_increment,
CATEGORY varchar(40) not null unique
)engine=innodb;

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
)engine=innodb;

create table SERIES(
ID_SERIE int primary key auto_increment,
TITLE varchar(40) not null unique,
IMAGE varchar(255) not null unique,
NUMBER_SEASONS int not null,
RELEASE_DATE date not null,
SYNOPSIS varchar(255) not null unique
)engine=innodb;

create table SERIE_CATEGORY(
ID_SERIE int,
ID_CATEGORY int,
primary key(ID_SERIE, ID_CATEGORY)
)engine=innodb;

create table SEASONS(
ID_SEASON int primary key auto_increment,
SEASON_NAME varchar(120) not null,
CHAPTERS int(4) not null,
RELEASE_DATE date not null,
SERIE_ID int not null,
TRAILER varchar(255) not null
)engine=innodb;

alter table MOVIE_CATEGORY
add constraint FK_CATEGORY_MOVIE_MOVIE foreign key(ID_MOVIE) references MOVIES(ID_MOVIE),
add constraint FK_CATEGORY_MOVIE_CATEGORY foreign key(ID_CATEGORY) references CATEGORIES(ID_CATEGORY);

alter table SERIE_CATEGORY
add constraint FK_CATEGORY_SERIE_SERIE foreign key(ID_SERIE) references SERIES(ID_SERIE),
add constraint FK_CATEGORY_SERIE_CATEGORY foreign key(ID_CATEGORY) references CATEGORIES(ID_CATEGORY);

alter table SEASONS
add constraint FK_SEASON_SERIE foreign key (SERIE_ID) references SERIES(ID_SERIE);

-- INSERTS EN LAS TABLAS
-- CATEGORIES
insert into CATEGORIES(CATEGORY) values ('Accion');
insert into CATEGORIES(CATEGORY) values ('Animacion');
insert into CATEGORIES(CATEGORY) values ('Anime');
insert into CATEGORIES(CATEGORY) values ('Ciencia Ficcion');
insert into CATEGORIES(CATEGORY) values ('Fantasia');
insert into CATEGORIES(CATEGORY) values ('Infantil');
insert into CATEGORIES(CATEGORY) values ('Suspense');
insert into CATEGORIES(CATEGORY) values ('Aventura');
insert into CATEGORIES(CATEGORY) values ('Comedia');
insert into CATEGORIES(CATEGORY) values ('Drama');

-- MOVIES
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('El Escuadrón Suicida', 'https://pics.filmaffinity.com/El_Escuadraon_Suicida-629689677-large.jpg', '2016/08/06', 
'El Escuadrón Suicida, un grupo de villanos, emprende una peligrosa misión para destruir un laboratorio secreto. Entre acción y humor negro, buscan redención enfrentando amenazas mortales y desafíos impredecibles.',
'James Gunn', 'https://www.youtube.com/embed/IblLmbGxw1Q?si=2k2N6HfmA_hCmiL5');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Guardianes de la Galaxia', 'https://pics.filmaffinity.com/Guardianes_de_la_galaxia-595487268-large.jpg', '2014/08/14', 
'"Guardianes de la Galaxia" sigue a un grupo disfuncional de héroes espaciales mientras intentan detener a Ronan el Acusador y salvar el cosmos con música y humor.' 
,'James Gunn', 'https://www.youtube.com/embed/F60FZKt_36s?si=Wc2kOqF5ivUYkGPD');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Fast and Furious', 'https://pics.filmaffinity.com/Fast_Furious_X-556821969-large.jpg', '2023/05/19',
 '"Fast and Furious X" lleva a Toretto y su equipo a desafíos globales con carreras frenéticas y acrobacias imparables, enfrentándose a una amenaza inesperada. La acción y la lealtad se entrelazan en esta entrega explosiva.'
,'Louis Leterrier', 'https://www.youtube.com/embed/FDhvbIqTQwI?si=T9sKqfxVE8Pi0Ejb');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Los Vengadores', 'https://pics.filmaffinity.com/the_avengers-439499921-mmed.jpg', '2012/04/27',
'"Los Vengadores" reúnen a héroes como Iron Man, Thor, Hulk y Capitán América para enfrentar a Loki y salvar la Tierra. Con acción épica y humor, forjan una alianza improbable contra amenazas intergalácticas, demostrando que juntos son más fuertes.'
, 'Joss Whedon', 'https://www.youtube.com/embed/HQIiYqOVTWo?si=f_hbQdKoNJhD1uGQ');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Piratas del Caribe', 'https://pics.filmaffinity.com/Piratas_del_Caribe_La_maldiciaon_de_la_Perla_Negra-627724446-large.jpg', '2003/08/14',
'"La Maldición del Perla Negra": Jack Sparrow, Will y Elizabeth buscan un tesoro maldito en una aventura llena de piratas, misterios y humor.'
, 'Gore Verbinski', 'https://www.youtube.com/embed/4s67PU-s1kc?si=BFyImApkv7U2Tefq');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Harry Potter', 'https://pics.filmaffinity.com/Harry_Potter_y_la_piedra_filosofal-154820574-mmed.jpg', '2001/11/30',
'"Harry Potter y la Piedra Filosofal": Harry descubre su magia al ingresar a Hogwarts. Con amigos, enfrenta misterios y el mal resurgente, culminando en la búsqueda de la Piedra Filosofal.',
'Chris Columbus', 'https://www.youtube.com/embed/ZgrCZVjPg9g?si=tnLpoRATYyfrhiZi');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('La Mansion Encantada', 'https://pics.filmaffinity.com/La_mansiaon_encantada-303930929-large.jpg', '2004/01/30',
'"La Mansión Encantada": Eddie Murphy es un agente inmobiliario que, junto a su familia, enfrenta fantasmas y revela oscuros secretos al explorar una mansión embrujada. Una comedia sobrenatural llena de risas y sustos.',
'Rob Minkoff', 'https://www.youtube.com/embed/1DDEDBubnQU?si=69aQCfsKZ2di8ZVw');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Buscando a Nemo', 'https://pics.filmaffinity.com/Buscando_a_Nemo-284341931-large.jpg', '2003/11/28',
'"Buscando a Nemo": Marlin busca desesperadamente a su hijo Nemo, capturado por un buceador. En su viaje acuático, encuentra amistades inolvidables y descubre el valor de la valentía y la amistad.'
, 'Andrew Stanton', 'https://www.youtube.com/embed/ba4TwyaNhSQ?si=MeW3Crc0cPjriZoc');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Cars', 'https://pics.filmaffinity.com/Cars-746710621-large.jpg', '2006/07/06',
'"Cars" sigue a Rayo McQueen, un auto de carreras, que aprende lecciones de humildad en el tranquilo Radiator Springs. La película celebra la amistad y descubre que hay más en la vida que la velocidad.'
, 'John Lasseter', 'https://www.youtube.com/embed/8ZMklX5BzTo?si=dWdiYdwetB-7bV9Z');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('El Planeta del Tesoro', 'https://pics.filmaffinity.com/El_planeta_del_tesoro-410694399-large.jpg', '2002/12/05',
'"El Planeta del Tesoro" sigue a Jim Hawkins en una odisea espacial en busca de un tesoro legendario. A bordo de una nave interestelar, enfrenta peligros, forja amistades y descubre secretos en un viaje lleno de aventuras y sorpresas.',
'John Musker, Ron Clements', 'https://www.youtube.com/embed/uokpV_AkQAc?si=x4tb0hPKCsIormlg');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('Spider-man', 'https://pics.filmaffinity.com/Spider_Man-945131720-large.jpg', '2002/06/21',
'"Spider-Man" (2002): Peter Parker, mordido por una araña radiactiva, descubre sus poderes y enfrenta al Duende Verde. Equilibrando amor y responsabilidad, Spider-Man emerge como un héroe en la ciudad de Nueva York.',
'Sam Raimi', 'https://www.youtube.com/embed/t06RUxPbp_c?si=3iV-EKj44xK0oUvw');
insert into MOVIES(TITLE, IMAGE, RELEASE_DATE, SYNOPSIS, DIRECTOR, TRAILER) values
('El señor de los anillos', 'https://pics.filmaffinity.com/El_seanor_de_los_anillos_La_comunidad_del_anillo-744631610-large.jpg', '2001/12/19',
'"El Señor de los Anillos: La Comunidad del Anillo" sigue a Frodo y compañía en una misión para destruir el Anillo Único. Enfrentan peligros, forjan amistades y luchan contra las fuerzas oscuras en una travesía épica por la Tierra Media.',
'Peter Jackson', 'https://www.youtube.com/embed/iFOucwxKRFE?si=j2OL7VW8kj_wUcid');

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

-- SERIES
insert into SERIES(TITLE, IMAGE, NUMBER_SEASONS, RELEASE_DATE, SYNOPSIS) values
('One piece', 'https://pics.filmaffinity.com/One_Piece_Serie_de_TV-647985949-large.jpg', 9, '1999/10/20', 
'Luffy busca ser el Rey de los Piratas con su tripulación, persiguiendo el tesoro legendario, el One Piece. Aventuras, poderes y desafíos épicos les esperan en mares peligrosos y encuentros memorables en este emocionante anime lleno de camaradería');

insert into SERIES(TITLE, IMAGE, NUMBER_SEASONS, RELEASE_DATE, SYNOPSIS) values
('Juego de tronos', 'https://pics.filmaffinity.com/game_of_thrones-293142110-mmed.jpg', 8, '2011/04/17',
'En Westeros, casas nobles compiten por el Trono de Hierro mientras enfrentan intrigas y traiciones. Amenazas sobrenaturales se suman al conflicto, desencadenando eventos que alterarán los Siete Reinos en la épica serie "Juego de Tronos".');

insert into SERIES(TITLE, IMAGE, NUMBER_SEASONS, RELEASE_DATE, SYNOPSIS) values
('Jujutsu Kaisen', 'https://pics.filmaffinity.com/Jujutsu_Kaisen_Serie_de_TV-665660213-large.jpg', 2, '2020/10/03', 
'"Yuji Itadori, estudiante con habilidades ocultas, se embarca en una lucha contra maldiciones tras encontrar objetos malditos. Con sus amigos, enfrenta a seres oscuros en batallas llenas de magia y acción en "Jujutsu Kaisen"');

insert into SERIES(TITLE, IMAGE, NUMBER_SEASONS, RELEASE_DATE, SYNOPSIS) values
('Dragon Ball', 'https://pics.filmaffinity.com/doragon_boru_dragon_ball-973171538-mmed.jpg', 7, '1986/02/26', 
'Goku busca las Esferas del Dragón para lograr deseos. Aventuras épicas, combates y amistades se entrelazan en esta serie llena de acción y crecimiento personal.');

insert into SERIES(TITLE, IMAGE, NUMBER_SEASONS, RELEASE_DATE, SYNOPSIS) values
('Dragon Ball Z', 'https://pics.filmaffinity.com/Dragon_Ball_Z_Serie_de_TV-697937148-large.jpg', 5, '1989/04/26',
'Dragon Ball Z sigue las épicas batallas de Goku y sus amigos contra poderosos enemigos que amenazan la Tierra. Con habilidades mejoradas y nuevos desafíos, la serie explora la lucha entre el bien y el mal en un universo lleno de acción y aventuras.');

insert into SERIES(TITLE, IMAGE, NUMBER_SEASONS, RELEASE_DATE, SYNOPSIS) values
('Dragon Ball Super', 'https://pics.filmaffinity.com/Dragon_Ball_Super_Serie_de_TV-965587763-large.jpg', 5,'2015/07/05',
'Goku y sus amigos enfrentan desafíos cósmicos y enemigos poderosos en "Dragon Ball Super", explorando nuevas dimensiones de poder y amistad en la saga épica.');

insert into SERIES(TITLE, IMAGE, NUMBER_SEASONS, RELEASE_DATE, SYNOPSIS) values
('My hero academia', 'https://pics.filmaffinity.com/My_Hero_Academia_Serie_de_TV-206305193-large.jpg', 6, '2016/04/03', 
'Izuku Midoriya sin superpoderes sueña con ser un héroe. Tras heredar poderes, ingresa a la U.A. High School para entrenar y enfrentar villanos en "My Hero Academia".');

insert into SERIES(TITLE, IMAGE, NUMBER_SEASONS, RELEASE_DATE, SYNOPSIS) values
('Breaking bad', 'https://pics.filmaffinity.com/breaking_bad-504442815-mmed.jpg', 5, '2008/05/20', 
'"Walter White, profesor con cáncer, se convierte en fabricante de metanfetaminas para asegurar el futuro familiar en "Breaking Bad", desencadenando consecuencias y dilemas morales.');

insert into SERIES(TITLE, IMAGE, NUMBER_SEASONS, RELEASE_DATE, SYNOPSIS) values
('Cobra Kai', 'https://pics.filmaffinity.com/cobra_kai-980186140-mmed.jpg', 5, '2018/05/02', 
'"En "Cobra Kai", la rivalidad resurge entre Johnny y Daniel, desencadenando conflictos y lecciones de karate que afectan a una nueva generación.');

-- SERIE_CATEGORY
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(1, 3);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(1, 8);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(2, 10);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(2, 5);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(3, 3);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(3, 8);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(4, 3);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(4, 8);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(5, 3);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(5, 8);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(6, 3);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(6, 8);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(7, 3);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(7, 8);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(8, 10);
insert into SERIE_CATEGORY(ID_SERIE, ID_CATEGORY) values(9, 10);

-- SEASONS
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga del East Blue', 61, '1999/10/20', 1, 'https://www.youtube.com/embed/G2yiXao9W7E?si=Eubwl3Xns4KT74Ea');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Arabasta', 69, '2001/03/21', 1, 'https://www.youtube.com/embed/7JERctGBNYk?si=SukRhoJoYBkrPEbp');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Skypeia', 62, '2003/02/02', 1,'https://www.youtube.com/embed/AYhIPAs8JTU?si=kl18_-I59BCu_5PK');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Water 7', 118, '2004/06/20', 1,'https://www.youtube.com/embed/KcjRlCT_c8g?si=S7-PvvR9vigjOdt3');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Thriller Bark', 59, '2007/12/23', 1, 'https://www.youtube.com/embed/ixCsF4RDoME?si=pPJoLRnyGAIovb3i');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Marineford', 132, '2009/01/18', 1, 'https://www.youtube.com/embed/hJgJTTIbMDI?si=oXk0vy2HwF-o-gT5');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de la isla Gyojin', 57, '2011/10/02', 1, 'https://www.youtube.com/embed/v_lyicIHv0I?si=CJQLGx9O3amcYdtm');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Dressrossa', 172, '2013/01/06', 1, 'https://www.youtube.com/embed/jJHDDYd6PrM?si=1yOOQEqf6wIzPMNu');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de los cuatro emperadores', 339, '2016/06/26', 1, 'https://www.youtube.com/embed/YFbno_aPm0w?si=4eOTtdHrh1M92j7w');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 1', 10, '2011/04/17', 2, 'https://www.youtube.com/embed/GkvDHqzDz-w?si=RAjOe9PRvb07mQGf');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 2', 10, '2012/04/01', 2, 'https://www.youtube.com/embed/spzf-ihXpX4?si=7ejbahTywh769ZUZ');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 3', 10, '2013/03/31', 2, 'https://www.youtube.com/embed/rw_QIbi40zU?si=WJgYjln5jdKIljdd');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 4', 10, '2014/04/06', 2, 'https://www.youtube.com/embed/QeuBq0qpNrQ?si=JP7lJ-DypHaWjjta');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 5', 10, '2015/04/12', 2, 'https://www.youtube.com/embed/KqYJKqUuVOI?si=rJRcu49Y3ijPQO6K');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 6', 10, '2016/04/24', 2, 'https://www.youtube.com/embed/l8tUY14C5cE?si=npXAAzfBFm6GuFzJ');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 7', 7, '2017/07/16', 2, 'https://www.youtube.com/embed/f-rlcVEH-Y4?si=BUuZdW0omZZEI8Cu');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 8', 6, '1019/04/14', 2, 'https://www.youtube.com/embed/EhuKM_mcGhA?si=GPUKmUwqJvy79Dso');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Season 1', 24, '2020/10/03', 3, 'https://www.youtube.com/embed/GwaRztMaoY0?si=TgV5sjuXkKK2oajT');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Season 2', 23, '2023/07/06', 3, 'https://www.youtube.com/embed/AQcOdxEmfEg?si=VljDg5OHcpbduhwQ');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Pilaf', 13, '1986/02/06', 4, 'https://www.youtube.com/embed/dtD_xGvkWLk?si=B_rVVTD_WbDa34q5');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('21° Torneo de las Artes Marciales (Tenkaichi Budōkai)', 15, '1986/05/28', 4, 'https://www.youtube.com/embed/dtD_xGvkWLk?si=B_rVVTD_WbDa34q5');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga del Ejército del Lazo rojo (Red Ribbon)', 40, '1986/09/10', 4, 'https://www.youtube.com/embed/dtD_xGvkWLk?si=B_rVVTD_WbDa34q5');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('El Palacio de Uranai Baba', 14, '1987/07/08', 4, 'https://www.youtube.com/embed/dtD_xGvkWLk?si=B_rVVTD_WbDa34q5');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('22° Torneo de las Artes Marciales (Tenkaichi Budōkai)', 19, '1987/10/14', 4, 'https://www.youtube.com/embed/dtD_xGvkWLk?si=B_rVVTD_WbDa34q5');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Piccolo', 31, '1988/04/24', 4, 'https://www.youtube.com/embed/dtD_xGvkWLk?si=B_rVVTD_WbDa34q5');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('23° Torneo de las Artes Marciales (Tenkaichi Budōkai)', 21, '1988/11/09', 4, 'https://www.youtube.com/embed/dtD_xGvkWLk?si=B_rVVTD_WbDa34q5');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga Saiyan', 35, '1989/04/26', 5, 'https://www.youtube.com/embed/Kf9h9C3RI4Y?si=3VsnSYmLtDasT5_l');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Freezer', 72, '1990/03/14', 5, 'https://www.youtube.com/embed/3HT60PKvrfM?si=GW5wnIVar2PT1LX2'); 
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Garlic jr', 10, '1991/07/17', 5, 'https://www.youtube.com/embed/3HT60PKvrfM?si=GW5wnIVar2PT1LX2');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga Androide', 22, '1991/09/18', 5, 'https://www.youtube.com/embed/3HT60PKvrfM?si=GW5wnIVar2PT1LX2');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Célula', 56, '1992/07/08', 5, 'https://www.youtube.com/embed/3HT60PKvrfM?si=GW5wnIVar2PT1LX2');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga del Torneo del Otro Mundo', 5, '1993/12/08', 5, 'https://www.youtube.com/embed/3HT60PKvrfM?si=GW5wnIVar2PT1LX2');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Majin Buu', 92, '1994/02/16', 5, 'https://www.youtube.com/embed/HvOJnCHGwzc?si=7_e0uf8GXDTHGsps');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de la Batalla de los Dioses', 14, '2015/07/05', 6, 'https://www.youtube.com/embed/jyjOaeq6kwo?si=LgEQfgUFFOqP7UHR');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de la Resurreccion de Freezer', 13, '2015/10/18', 6, 'https://www.youtube.com/embed/jyjOaeq6kwo?si=LgEQfgUFFOqP7UHR');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga del Torneo de Champa', 19, '2016/01/24', 6, 'https://www.youtube.com/embed/jyjOaeq6kwo?si=LgEQfgUFFOqP7UHR');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga de Trunks del Futuro', 30, '2016/06/12', 6, 'https://www.youtube.com/embed/jyjOaeq6kwo?si=LgEQfgUFFOqP7UHR');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Saga del Torneo de Poder', 55, '2017/02/05', 6, 'https://www.youtube.com/embed/3vD4kl59-mc?si=VQWu6QqrD6KtzBJZ');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Season 1', 13, '2016/04/03', 7, 'https://www.youtube.com/embed/-77UEct0cZM?si=QZoR2cT3t4bI1-gF');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Season 2', 25, '2017/04/01', 7, 'https://www.youtube.com/embed/JVu7-XSI_OM?si=cv3gdpMxpe_bYNB-');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Season 3', 25, '2018/04/07', 7, 'https://www.youtube.com/embed/v1YojYU5nPQ?si=fVLvAyYDOHCIkGVV');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Season 4', 25, '2019/10/12', 7, 'https://www.youtube.com/embed/-t5--PiJsWo?si=qO4yNNAV7hDkmauD');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Season 5', 25, '2021/03/21', 7, 'https://www.youtube.com/embed/PTbRl5h64tU?si=uQKtcZqJ_vxzo-HX');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Season 6', 25, '2022/10/01', 7, 'https://www.youtube.com/embed/JFDFFoBClLY?si=JLseN9g3NTYnm7VX');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 1', 7, '2008/01/20', 8, 'https://www.youtube.com/embed/HhesaQXLuRY?si=zI3ppvQJgn966z-5');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 2', 13, '2009/03/08', 8, 'https://www.youtube.com/embed/qqNrz_U7NRk?si=0z0EQGCcYOid5gh1');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 3', 13, '2010/03/21', 8, 'https://www.youtube.com/embed/TggkQXwe0Vk?si=gZgvyHclS6PHW7X_');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 4', 13, '2011/07/17', 8, 'https://www.youtube.com/embed/sZFOyNFKPug?si=O0SgsfLtECOQ1Y8J');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 5', 16, '2012/07/15', 8, 'https://www.youtube.com/embed/_Z-PTJhf0Po?si=BkrQRe6frGwGCwL2');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 1', 10, '2018/05/02', 9, 'https://www.youtube.com/embed/CfOuYm8EnBA?si=r0Nw58Ptg276OdNx');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 2', 10, '2019/04/24', 9, 'https://www.youtube.com/embed/wbLyMWdNvzQ?si=KpGIE991tJuh9_6P');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 3', 10, '2021/01/01', 9, 'https://www.youtube.com/embed/ZjUzMd6p4R8?si=Ez8FzT_s7-SFvzZP');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 4', 10, '2021/12/31', 9, 'https://www.youtube.com/embed/ZxWET9C2MYA?si=Y9C1pQRKYK_Q80qE');
insert into SEASONS(SEASON_NAME, CHAPTERS, RELEASE_DATE, SERIE_ID, TRAILER) values
('Temporada 5', 10, '2022/09/09', 9, 'https://www.youtube.com/embed/NMdSs5NkiOg?si=2cnBXTHEOxdZzocx');