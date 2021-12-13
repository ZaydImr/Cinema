CREATE DATABASE cinema ;

use cinema;

create table if NOT exists TypeUser(
    idTypeUser VARCHAR(255) PRIMARY KEY,
    typeUser VARCHAR(50)
);

CREATE Table if NOT exists Nationality(
    idNatonality VARCHAR(255) NOT NULL,
    nationality VARCHAR(255) NOT NULL
);

create table if NOT exists User(
    idUser VARCHAR(255) PRIMARY KEY,
    idTypeUser VARCHAR(255) NOT NULL,
    email VARCHAR(80),
    password VARCHAR(50),
    fullnameUser VARCHAR(70),
    birthdayUser DATE,
    phoneNumberUser VARCHAR(20),
    imgUser VARCHAR(255),
    constraint fk_user_type FOREIGN KEY (idTypeUser) REFERENCES TypeUser(idTypeUser)
);

create table if NOT exists Subscription(
    idEmailSubscription VARCHAR(255) PRIMARY KEY,
    emailSubscriber VARCHAR(50)
);

create table if NOT exists Events(
    idEvent VARCHAR(255) PRIMARY KEY,
    dateEvent DATETIME,
    dateEndEvent DATETIME,
    imgEvent VARCHAR(50),
    titleEvent VARCHAR(50),
    descriptionEvent VARCHAR(50)
);

create table if NOT exists Actor(
    idActor VARCHAR(255) PRIMARY KEY,
    fullnameActor VARCHAR(70),
    birthdayActor DATE,
    idNationality VARCHAR(255) NOT NULL,
    imgActor VARCHAR(255),
    constraint fk_actor_nationality FOREIGN KEY (idNationality) REFERENCES Nationality(idNationality)
);

create table if NOT exists Director(
    idDirector VARCHAR(255) PRIMARY KEY,
    fullnameDirector VARCHAR(70),
    birthdayDirector DATE,
    idNationality VARCHAR(255) NOT NULL,
    imgDirector VARCHAR(255),
    constraint fk_director_nationality FOREIGN KEY (idNationality) REFERENCES Nationality(idNationality)
);


create table if NOT exists FilmType(
    idTypeFilm VARCHAR(255) PRIMARY KEY,
    typeFilm VARCHAR(70)
);


create table if NOT exists Language(
    idLanguage VARCHAR(255) PRIMARY KEY,
    LanguageFilm VARCHAR(30)
);


create table if NOT exists Film(
    idFilm VARCHAR(255) PRIMARY KEY,
    idTypeFilm VARCHAR(255) NOT NULL,
    idActor VARCHAR(255) NOT NULL,
    idNationality VARCHAR(255) NOT NULL,
    idDirector VARCHAR(255) NOT NULL,
    titleFilm VARCHAR(100),
    descriptionFilm VARCHAR(255),
    dateRelease DATE,
    durationFilm TIME,
    constraint fk_film_type FOREIGN KEY (idTypeFilm) REFERENCES FilmType(idTypeFilm),
    constraint fk_film_director FOREIGN KEY (idDirector) references Director(idDirector),
    constraint fk_film_nationality FOREIGN KEY (idNationality) references Nationality(idNationality)
);

create table if NOT exists FilmImage(
    idImageFilm VARCHAR(255) PRIMARY KEY,
    idFilm VARCHAR(255) NOT NULL,
    imgUrl VARCHAR(255),
    constraint fk_film_image FOREIGN KEY (idFilm) REFERENCES Film(idFilm)
);

create table if NOT exists Room(
    idRoom VARCHAR(255) PRIMARY KEY,
    nameRoom VARCHAR(255) NOT NULL
);

create table if NOT exists Session(
    idSession VARCHAR(255) PRIMARY KEY,
    idFilm VARCHAR(255) NOT NULL,
    idRoom VARCHAR(255) NOT NULL,
    dateBeginSession DATE,
    tarif DOUBLE NOT NULL,
    constraint fk_film_session FOREIGN KEY (idFilm) REFERENCES Film(idFilm),
    constraint fk_session_room FOREIGN KEY (idRoom) references Room(idRoom),
    constraint fk_film_nationality FOREIGN KEY (idNatonality) references Nationality(idNatonality)
);

create table if NOT exists ActorFilm(
    idActorFilm VARCHAR(255) PRIMARY KEY,
    idFilm VARCHAR(255) NOT NULL,
    idActor VARCHAR(255) NOT NULL,
    constraint fk_film_Actor FOREIGN KEY (idFilm) REFERENCES Film(idFilm),
    constraint fk_Actor_Film FOREIGN KEY (idActor) REFERENCES Actor(idActor)
);

create table if NOT exists Comment(
    idComment VARCHAR(255) PRIMARY KEY,
    idUser VARCHAR(255) NOT NULL,
    idFilm VARCHAR(255) NOT NULL,
    contentComment VARCHAR(255) NOT NULL,
    constraint fk_film_comment FOREIGN KEY (idFilm) REFERENCES Film(idFilm),
    constraint fk_user_comment FOREIGN KEY (idUser) REFERENCES User(idUser)
);
