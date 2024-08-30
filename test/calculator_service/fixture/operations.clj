(ns calculator-service.fixture.operations
  (:require [calculator-service.model.operation :as model.operation]
            [clojure.test :refer :all]))

(def random-string-operation (model.operation/create-operation :random-string))
