(ns calculator-service.infra.http.client.random-string
  (:require [clj-http.client :as client]))

(def base-url "https://www.random.org/strings")

(def default-timeout-ms (atom 1000))

(defn get! []
  (try
    (let [timeout-ms @default-timeout-ms
          response   (client/get base-url {:query-params       {"num"        "1"
                                                                "len"        "12"
                                                                "digits"     "on"
                                                                "upperalpha" "on"
                                                                "loweralpha" "on"
                                                                "unique"     "on"
                                                                "format"     "plain"
                                                                "rnd"        "new"}
                                           :socket-timeout     timeout-ms
                                           :connection-timeout timeout-ms})
          body       (get response :body)]
      {:data   body
       :error? false})

    (catch Exception e
      {:data   (.getMessage e)
       :error? true})))
