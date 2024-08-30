(ns calculator-service.controller.operations
  (:require [calculator-service.logic.operations :as logic.operations]))

(defn execute [operation]
  (logic.operations/execute operation))
