(ns calculator-service.logic.crypto-test
  (:require [calculator-service.logic.crypto :as logic.password]
            [clj-jwt.base64 :as base64]
            [clojure.data.json :as json]
            [clojure.string :as str]
            [clojure.test :refer :all])
  (:import [org.joda.time DateTime]))

(deftest password-matches?-test
  (testing "Should match empty"
    (is (true? (logic.password/password-matches? "" "$2a$10$K.P9VsWy0GpDBtEqCvLdFukmTDeF2onpo965VM5a/mpalIaPriXvW"))))

  (testing "Should match empty"
    (is (false? (logic.password/password-matches? "" ""))))

  (testing "Should match nil"
    (is (false? (logic.password/password-matches? nil nil))))

  (testing "Should match known one"
    (is (true? (logic.password/password-matches? "password" "$2a$10$UEHJ75oE1u2G3mXlzG11auSQxZEuO75pD6.GkhuTcF6dlR8oCLSny"))))

  (testing "Should not match wrong one"
    (is (false? (logic.password/password-matches? "wrong-pwd" "$2a$10$UEHJ75oE1u2G3mXlzG11auSQxZEuO75pD6.GkhuTcF6dlR8oCLSny")))))

(deftest generate-jwt-token!-test
  (testing "Should generate JWT token for a valid JWT key"
    (let [payload        {:dummy "data"}
          expires-at     (.plusHours (DateTime.) 12)
          expected-claim {"dummy" "data"
                          "exp"   (-> expires-at (.getMillis) (/ 1000) (int))}]
      (is (= expected-claim
             (-> (logic.password/generate-jwt-token! payload
                                                     "TEST_KEY"
                                                     expires-at)
                 (str/split (re-pattern "\\."))
                 (get 1)
                 (base64/decode-str)
                 (json/read-str)))))))
