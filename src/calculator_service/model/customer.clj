(ns calculator-service.model.customer)

(defrecord Customer [id username password status])

(defn create [{:keys [id username password status]}]
  (Customer. id username password status))
