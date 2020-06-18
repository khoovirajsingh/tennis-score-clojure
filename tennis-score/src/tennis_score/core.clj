(ns tennis-score.core
  (:gen-class))

(defn point-to-score-description
  [point]
  ({0 "Love", 1 "Fifteen", 2 "Thirty", 3 "Fourty"} point))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
