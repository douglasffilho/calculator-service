(ns calculator-service.infra.db.mysql.customers
  (:require [calculator-service.infra.db.mysql.config :as db.config]
            [calculator-service.model.customer :as model.customer]
            [clojure.java.jdbc :as jdbc]))

(def db-connection nil)

(defn fetch-by-username! [username]
  (some-> (jdbc/with-db-connection [db-connection db.config/connection-spec]
                                   (jdbc/query db-connection
                                               ["SELECT * FROM customers WHERE username = ?" username]
                                               {:row-fn #(model.customer/create %)}))
          (first)))
