(defproject calculator-service "0.1.0-SNAPSHOT"
  :description "A calculator service that taxes customer operations over their budget amount."

  :dependencies [[bcrypt-clj "0.3.3"]
                 [clj-http "3.13.0"]
                 [clj-jwt/clj-jwt "0.1.1"]
                 [com.mysql/mysql-connector-j "8.3.0"]
                 [org.clojure/clojure "1.11.1"]
                 [org.clojure/java.jdbc "0.7.12"]]

  :dev-dependencies [[lein-run "1.0.0"]]

  :main calculator-service.infra.db.mysql.migrations

  :repl-options {:init-ns calculator-service.infra.db.mysql.migrations}

  :run-aliases {:migrations [calculator-service.infra.db.mysql.migrations]})
