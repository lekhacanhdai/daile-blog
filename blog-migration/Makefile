migrate-account-local:
	mvn flyway:migrate -Dflyway.configFiles=config/local/flyway_account.conf

migrate-auth-local:
	mvn flyway:migrate -Dflyway.configFiles=config/local/flyway_auth.conf

migrate-blog-local:
	mvn flyway:migrate -Dflyway.configFiles=config/local/flyway_blog.conf

migrate-all-local:
	mvn flyway:migrate -Dflyway.configFiles=config/local/flyway_account.conf
	mvn flyway:migrate -Dflyway.configFiles=config/local/flyway_auth.conf
	mvn flyway:migrate -Dflyway.configFiles=config/local/flyway_blog.conf