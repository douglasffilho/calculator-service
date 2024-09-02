(ns calculator-service.infra.db.mysql.config)

(def host (or (System/getenv "MYSQL_DB_HOST") "localhost"))

(def port (or (System/getenv "MYSQL_DB_PORT") "3306"))

(def dbname (or (System/getenv "MYSQL_DB_NAME") "calculator"))

(def username (or (System/getenv "MYSQL_DB_USER") "root"))

(def pwd (or (System/getenv "MYSQL_DB_PWD") "admin"))

(def connection-spec {:subprotocol "mysql"
                      :subname     (str "//" host ":" port "/" dbname)
                      :user        username
                      :password    pwd})
