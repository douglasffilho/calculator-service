(ns calculator-service.controller.operations
  (:require [calculator-service.infra.http.client.random-string :as http.client.random-string]
            [calculator-service.logic.operations :as logic.operations]))

(defn execute [operation]
  (if (= (get operation :type) :random-string)
    (let [response      (http.client.random-string/get!)
          error?        (get response :error?)
          random-string (get response :data)]
      (if error?
        (logic.operations/execute operation)
        random-string))
    (logic.operations/execute operation)))
