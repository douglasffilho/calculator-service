(ns calculator-service.logic.operations)

(defmulti execute "Pattern match by type to execute a well-defined operation" :type)

(defmethod execute :addition [operation]
  (let [x (get operation :x)
        y (get operation :y)]
    (+ x y)))

(defmethod execute :subtraction [operation]
  (let [x (get operation :x)
        y (get operation :y)]
    (- x y)))

(defmethod execute :multiplication [operation]
  (let [x (get operation :x)
        y (get operation :y)]
    (* x y)))

(defmethod execute :division [operation]
  (let [x (get operation :x)
        y (get operation :y)]
    (/ x y)))

(defmethod execute :square-root [operation]
  (-> operation :x Math/sqrt))

(defmethod execute :default [& _params]
  (throw (RuntimeException. "unknown-operation")))
