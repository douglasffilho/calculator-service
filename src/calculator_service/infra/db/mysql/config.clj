(ns calculator-service.infra.db.mysql.config
  (:require [calculator-service.config :as config]))

(def host (or config/db-host "localhost"))

(def port (or config/db-port "3306"))

(def dbname (or config/db-name "calculator"))

(def username (or config/db-username "root"))

(def pwd (or config/db-pwd "admin"))

(def connection-spec {:subprotocol "mysql"
                      :subname     (str "//" host ":" port "/" dbname)
                      :user        username
                      :password    pwd})
