(ns calculator-service.infra.db.mysql.migrations
  (:require [calculator-service.infra.db.mysql.config :as db.mysql.config]
            [clojure.java.jdbc :as jdbc]))

(defn run-migration-v1! []
  (let [drop-operations-table-ddl (jdbc/drop-table-ddl :operations {:conditional? true})
        operations-table-ddl      (jdbc/create-table-ddl :operations
                                                         [[:id "tinyint" :primary :key :auto_increment]
                                                          [:type "varchar(20)"]
                                                          [:cost "smallint"]]
                                                         {:table-spec "ENGINE=InnoDB"})
        addition-operation        {:type "addition" :cost 10}
        subtraction-operation     {:type "subtraction" :cost 10}
        multiplication-operation  {:type "multiplication" :cost 15}
        division-operation        {:type "division" :cost 15}
        square-root-operation     {:type "square-root" :cost 20}
        random-string-operation   {:type "random-string" :cost 25}]
    (jdbc/db-do-commands db.mysql.config/connection-spec drop-operations-table-ddl)
    (jdbc/db-do-commands db.mysql.config/connection-spec operations-table-ddl)
    (jdbc/insert-multi! db.mysql.config/connection-spec :operations [addition-operation
                                                                     subtraction-operation
                                                                     multiplication-operation
                                                                     division-operation
                                                                     square-root-operation
                                                                     random-string-operation])))

(defn -main [& _args]
  (run-migration-v1!))
