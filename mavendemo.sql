/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/11/25 星期一 14:20:57                      */
/*==============================================================*/


drop table if exists sys_permission;

drop table if exists sys_permission_resources;

drop table if exists sys_resources;

drop index Index_roleNo on sys_role;

drop table if exists sys_role;

drop table if exists sys_role_permission;

drop index Index_userNo on sys_user;

drop table if exists sys_user;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission
(
   pk_id                bigint not null auto_increment,
   permNo               char(10),
   permName             char(10),
   primary key (pk_id)
);

/*==============================================================*/
/* Table: sys_permission_resources                              */
/*==============================================================*/
create table sys_permission_resources
(
   permNo               varchar(20) not null,
   resNo                varchar(20) not null,
   primary key (permNo, resNo)
);

/*==============================================================*/
/* Table: sys_resources                                         */
/*==============================================================*/
create table sys_resources
(
   pk_id                bigint not null auto_increment,
   resNo                varchar(20),
   resName              varchar(100),
   resUrl               varchar(40),
   resType              smallint,
   resDesc              varchar(500),
   primary key (pk_id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   pk_id                bigint not null auto_increment,
   roleNo               varchar(20),
   roleName             varchar(100),
   description          varchar(500),
   primary key (pk_id)
);

/*==============================================================*/
/* Index: Index_roleNo                                          */
/*==============================================================*/
create unique index Index_roleNo on sys_role
(
   roleNo
);

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
create table sys_role_permission
(
   roleNo               varchar(20) not null,
   permNo               varchar(20) not null,
   primary key (roleNo, permNo)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   pk_id                bigint not null auto_increment,
   userNo               varchar(20) not null,
   userName             varchar(50),
   firstName            varchar(50),
   middleName           varchar(50),
   lastName             varchar(50),
   password             varchar(100),
   passwordModifiedDate datetime,
   email                varchar(100),
   comments             longtext,
   status               int,
   createDate           datetime,
   modifiedDate         datetime,
   loginDate            datetime,
   lastLoginDate        datetime,
   gender               smallint,
   primary key (pk_id)
);

/*==============================================================*/
/* Index: Index_userNo                                          */
/*==============================================================*/
create unique index Index_userNo on sys_user
(
   userNo
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   userNo               varchar(20) not null,
   roleNo               varchar(20) not null,
   primary key (userNo, roleNo)
);

