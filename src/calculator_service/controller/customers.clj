(ns calculator-service.controller.customers
  (:require [calculator-service.config :as config]
            [calculator-service.infra.db.mysql.customers :as db.customers]
            [calculator-service.logic.crypto :as logic.password])
  (:import [org.joda.time DateTime]))

(defn authenticate! [username password]
  (let [customer          (db.customers/fetch-by-username! username)
        customer-password (some-> customer :password)
        password-matches? (logic.password/password-matches? (when customer-password password) customer-password)]
    (when password-matches?
      (logic.password/generate-jwt-token! customer
                                          (or config/jwt-key "TEST_KEY")
                                          (.plusHours (DateTime.) (or config/jwt-expiration-time-hours 12))))))
