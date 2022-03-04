#!/bin/bash

# drop database
sudo -u postgres psql -c "DROP DATABASE \"crud-base\""

# create database
sudo -u postgres psql -c "CREATE DATABASE \"crud-base\""
