from debeziumconnector import Connection
import requests
import json
import config

account_conn = Connection("blog-account", "BlogAccount", "blogaccount", ["users", "roles", "user_role"])

list_conn = [account_conn]

headers = {"Accept" : "application/json", "Content-Type" : "application/json"}

list_connector = requests.get(config.DEBEZIUM_HOST + "/connectors", headers=headers)

exist_conn = json.loads(list_connector.text)

for conn in list_conn:
    if conn.connection in exist_conn:
        r2 = requests.put(url=config.DEBEZIUM_HOST + "/connectors/" + conn.connection + "/config", headers=headers, data=json.dumps(conn.to_put_body()))
        print(r2.headers, '\nPUT')
    else:
        r1 = requests.post(url=config.DEBEZIUM_HOST + "/connectors/", headers=headers, data=json.dumps(conn.to_post_body()))
        print(r1.headers, '\nPOST')
