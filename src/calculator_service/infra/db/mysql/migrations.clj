(ns calculator-service.infra.db.mysql.migrations
  (:require [bcrypt-clj.auth :refer [crypt-password]]
            [calculator-service.infra.db.mysql.config :as db.mysql.config]
            [clojure.java.jdbc :as jdbc]))

(defn run-migration-v1! []
  (let [drop-operations-table-ddl (jdbc/drop-table-ddl :operations {:conditional? true})
        operations-table-ddl      (jdbc/create-table-ddl :operations
                                                         [[:id :tinyint :primary :key :auto_increment :not :null]
                                                          [:type "varchar(20)" :unique :not :null]
                                                          [:cost :smallint :not :null]]
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

(defn run-migration-v2! []
  (let [drop-customers-table-ddl (jdbc/drop-table-ddl :customers {:conditional? true})
        customers-table-ddl      (jdbc/create-table-ddl :customers
                                                        [[:id :int :primary :key :auto_increment :not :null]
                                                         [:username "varchar(100)" :unique :not :null]
                                                         [:password "varchar(150)" :not :null]
                                                         [:balance :int :not :null]
                                                         [:status "enum('active','inactive')" :default "'inactive'" :not :null]]
                                                        {:table-spec "ENGINE=InnoDB"})
        password                 (crypt-password "password")
        active-premium-customer  {:username "premium@customer.com"
                                  :password password
                                  :balance  1000
                                  :status   "active"}
        active-basic-customer    (assoc active-premium-customer :username "basic@customer.com"
                                                                :balance 100)
        inactive-basic-customer  (assoc active-basic-customer :username "inactive@customer.com"
                                                              :status "inactive")]
    (jdbc/db-do-commands db.mysql.config/connection-spec drop-customers-table-ddl)
    (jdbc/db-do-commands db.mysql.config/connection-spec customers-table-ddl)
    (jdbc/insert-multi! db.mysql.config/connection-spec :customers [active-premium-customer
                                                                    active-basic-customer
                                                                    inactive-basic-customer])))

(defn -main [& _args]
  (run-migration-v1!)
  (run-migration-v2!))
