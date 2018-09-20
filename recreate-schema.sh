#!/bin/bash

echo "[INFO] Creating DB..."
mysql -uroot -e "drop database if exists dssd; create database dssd;"

echo "[INFO] Importing schema..."
mysql -uroot dssd < schema/dump-coupons-201808030751.sql
mysql -uroot dssd < schema/dump-rrhh-201808030750.sql
mysql -uroot dssd < schema/dump-stock-201808030748.sql

echo "[DONE]"

