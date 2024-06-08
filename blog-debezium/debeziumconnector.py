from config import *

class Connection:
    def __init__(self, connection: str, dbname: str, schema: str, table: list):
        self.connection = connection
        self.dbname = dbname
        self.schema = schema
        self.table = table
    def to_post_body(self):
        return {
            "name": "blog-account",
            "config": self.get_config()
        }
    def to_put_body(self):
        return self.get_config()
    def get_config(self):
        return {
            "connector.class": "io.debezium.connector.postgresql.PostgresConnector", 
            "database.hostname": DB_HOST, 
            "database.port": DB_PORT, 
            "database.user": DB_USER, 
            "database.password": DB_PASS, 
            "database.dbname" : self.dbname, 
            "topic.prefix": self.schema, 
            "table.include.list": ", ".join(map(lambda tb: self.schema + '.' + tb, self.table)),
            "plugin.name": "pgoutput",
            "key.converter": "org.apache.kafka.connect.json.JsonConverter",
            "key.converter.schemas.enable": "false",
            "value.converter": "org.apache.kafka.connect.json.JsonConverter",
            "value.converter.schemas.enable": "false",
        }