from dotenv import dotenv_values

config = dotenv_values(".env")

DB_HOST = config['DB_HOST']
DB_PORT = config['DB_PORT']
DB_PASS = config['DB_PASS']
DB_USER = config['DB_USER']

DEBEZIUM_HOST = config['DEBEZIUM_HOST']