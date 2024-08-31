(ns calculator-service.infra.db.mysql.migrations
  (:require [calculator-service.infra.db.mysql.config :as db.mysql.config]
            [clojure.java.jdbc :as jdbc]))

(def drop-operations-table-ddl (jdbc/drop-table-ddl :operations {:conditional? true}))
(def operations-table-ddl (jdbc/create-table-ddl :operations
                                                 [[:id "tinyint" :primary :key]
                                                  [:type "varchar(20)"]
                                                  [:cost "smallint"]]
                                                 {:table-spec "ENGINE=InnoDB"}))

(defn run-migration-v1! []
  (jdbc/db-do-commands db.mysql.config/connection-spec drop-operations-table-ddl)
  (jdbc/db-do-commands db.mysql.config/connection-spec operations-table-ddl))

(defn -main [& _args]
  (run-migration-v1!))
