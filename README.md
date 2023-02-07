# PokerApp

-- we don't know how to generate root <with-no-name> (class Root) :(
create sequence users_id_seq;

alter sequence users_id_seq owner to postgres;

create sequence payment_details_operation_id_seq;

alter sequence payment_details_operation_id_seq owner to postgres;

create sequence games_game_id_seq;

alter sequence games_game_id_seq owner to postgres;

create table user_names
(
    id                bigint  default nextval('users_id_seq'::regclass) not null
        constraint users_pkey
            primary key,
    login             varchar                                           not null
        constraint "users_Login_key"
            unique,
    password          varchar                                           not null,
    registration_date date                                              not null,
    score             integer default 0,
    e_mail            varchar                                           not null
        constraint "users_e-mail_key"
            unique
);

alter table user_names
    owner to postgres;

alter sequence users_id_seq owned by user_names.id;

create table users_data
(
    user_id       integer not null
        unique
        constraint users_data_users_id_fk
            references user_names
            on update cascade on delete cascade,
    first_name    varchar not null,
    last_name     varchar not null,
    date_of_birth date    not null,
    nationality   varchar          default 'UNKNOWN'::character varying,
    telephone     varchar,
    balance       double precision default 0.00
);

alter table users_data
    owner to postgres;

create table operations
(
    id                 bigint default nextval('payment_details_operation_id_seq'::regclass) not null
        constraint payment_details_operation_id_key
            unique,
    type               varchar                                                              not null,
    type_det_operation varchar                                                              not null,
    date               date                                                                 not null,
    volume             double precision                                                     not null,
    result_balance     double precision                                                     not null,
    user_id            integer
        constraint balance_details_users_id_fk
            references user_names
);

alter table operations
    owner to postgres;

alter sequence payment_details_operation_id_seq owned by operations.id;

create table games
(
    id     bigint default nextval('games_game_id_seq'::regclass) not null
        unique,
    type   varchar                                               not null,
    date   date                                                  not null,
    winner varchar
);

alter table games
    owner to postgres;

alter sequence games_game_id_seq owned by games.id;

create table user_games
(
    user_id    bigint                        not null
        constraint user_games_users_id_fk
            references user_names,
    game_id    bigint                        not null
        constraint user_games_games_game_id_fk
            references games (id),
    money_in   double precision default 0.00 not null,
    money_back double precision default 0.00 not null,
    id         bigserial
        primary key
);

alter table user_games
    owner to postgres;

