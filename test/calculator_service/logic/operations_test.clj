(ns calculator-service.logic.operations-test
  (:require [calculator-service.fixture.operations :as fixture.operations]
            [calculator-service.logic.operations :as logic.operations]
            [calculator-service.model.operation :as model.operation]
            [clojure.string :as str]
            [clojure.test :refer :all]))

(deftest execute-test
  (testing "Should be able to execute an addition operation"
    (is (= 2
           (logic.operations/execute (model.operation/create-operation :addition 1 1)))))

  (testing "Should be able to execute a subtraction operation"
    (is (= 0
           (logic.operations/execute (model.operation/create-operation :subtraction 1 1)))))

  (testing "Should be able to execute a multiplication operation"
    (is (= 1
           (logic.operations/execute (model.operation/create-operation :multiplication 1 1)))))

  (testing "Should be able to execute a division operation"
    (is (= 2
           (logic.operations/execute (model.operation/create-operation :division 4 2)))))

  (testing "Should be able to execute a square-root operation"
    (is (= 3.0
           (logic.operations/execute (model.operation/create-operation :square-root 9)))))

  (testing "Should be able to execute a square-root operation over a not quadratic number"
    (is (= 2.8284271247461903
           (logic.operations/execute (model.operation/create-operation :square-root 8)))))

  (testing "Should be able to execute a random-string operation"
    (is (false? (str/blank? (logic.operations/execute fixture.operations/random-string-operation))))))

(deftest execute-with-errors-test
  (testing "Should throw an exception when executing a division by 0"
    (is (= "Divide by zero"
           (try (logic.operations/execute (model.operation/create-operation :division 4 0))
                (catch Exception e (.getMessage e))))))

  (testing "Should get NaN when trying a square-root of a negative number"
    (is (true? (NaN? (logic.operations/execute (model.operation/create-operation :square-root -4))))))

  (testing "Should throw an exception when executing an unknown operation"
    (is (= "unknown-operation"
           (try (logic.operations/execute (model.operation/create-operation :factorial 4))
                (catch Exception e (.getMessage e)))))))
