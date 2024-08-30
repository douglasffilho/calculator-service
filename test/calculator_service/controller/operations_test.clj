(ns calculator-service.controller.operations-test
  (:require [calculator-service.fixture.operations :as fixture.operations]
            [calculator-service.controller.operations :as controller.operations]
            [clojure.string :as str]
            [clojure.test :refer :all]))

(deftest execute-test
  (testing "Should execute random-string operation"
    (is (false? (str/blank? (controller.operations/execute fixture.operations/random-string-operation))))))
