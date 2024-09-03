(ns calculator-service.controller.customers-test
  (:require [calculator-service.controller.customers :as controller.customers]
            [clojure.string :as str]
            [clojure.test :refer :all]))

(deftest authenticate!-test
  (testing "Should generate token for existing and password matching customer"
    (is (false? (str/blank? (controller.customers/authenticate! "premium@customer.com" "password")))))

  (testing "Should not generate token if customer password does not matches"
    (is (nil? (controller.customers/authenticate! "premium@customer.com" "passwor"))))

  (testing "Should not generate token if customer does not exists"
    (is (nil? (controller.customers/authenticate! "unknown@customer.com" "password")))))
