create database "BlogAccount";
\c "BlogAccount"
create schema blogaccount;
alter database "BlogAccount" set search_path to blogaccount;
create extension if not exists pgcrypto;