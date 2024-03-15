create database "BlogBlog";
\c "BlogBlog"
create schema blogblog;
alter database "BlogBlog" set search_path to blogblog;
create extension if not exists pgcrypto;