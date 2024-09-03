(ns calculator-service.logic.crypto
  (:require [bcrypt-clj.auth :refer [check-password]]
            [clj-jwt.core :refer :all]
            [clojure.string :as str]))

(defn password-matches? [raw-password encrypted-password]
  (if (and (str/blank? raw-password) (str/blank? encrypted-password))
    false
    (check-password raw-password encrypted-password)))

(defn generate-jwt-token! [payload jwt-key expires-at]
  (let [algorithm :HS256
        payload   (assoc payload :exp expires-at)]
    (-> (map->JWT {}) (init payload) (set-alg algorithm) (sign algorithm jwt-key) (to-str))))
