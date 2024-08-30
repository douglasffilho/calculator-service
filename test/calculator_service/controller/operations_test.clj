(ns calculator-service.controller.operations-test
  (:require [calculator-service.controller.operations :as controller.operations]
            [calculator-service.fixture.operations :as fixture.operations]
            [calculator-service.infra.http.client.random-string :as http.client.random-string]
            [clojure.string :as str]
            [clojure.test :refer :all]))

(deftest execute-test
  (testing "Should execute HTTP random-string operation"
    (is (false? (str/blank? (controller.operations/execute fixture.operations/random-string-operation)))))

  (testing "Should execute logic random-string operation when HTTP fails"
    (reset! http.client.random-string/default-timeout-ms 1)
    (is (false? (str/blank? (controller.operations/execute fixture.operations/random-string-operation))))))
