(ns calculator-service.config)

(def db-host (System/getenv "MYSQL_DB_HOST"))

(def db-port (System/getenv "MYSQL_DB_PORT"))

(def db-name (System/getenv "MYSQL_DB_NAME"))

(def db-username (System/getenv "MYSQL_DB_USER"))

(def db-pwd (System/getenv "MYSQL_DB_PWD"))

(def jwt-key (System/getenv "JWT_KEY"))

(def jwt-expiration-time-hours (System/getenv "JWT_EXPIRATION_TIME_HOURS"))
