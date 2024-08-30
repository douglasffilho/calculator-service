(ns calculator-service.model.operation)

(defrecord Operation [type x y])

(defn create-operation
  ([type]
   (map->Operation {:type type}))

  ([type x]
   (assoc (create-operation type) :x x))

  ([type x y]
   (assoc (create-operation type x) :y y)))
