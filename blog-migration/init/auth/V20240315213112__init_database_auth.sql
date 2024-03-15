create database "BlogAuth";
\c "BlogAuth"
create schema blogauth;
alter database "BlogAuth" set search_path to blogauth;
create extension if not exists pgcrypto;