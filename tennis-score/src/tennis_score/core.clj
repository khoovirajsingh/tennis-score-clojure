(ns tennis-score.core
  (:gen-class))

(defn point-to-score
  [point]
  ({0 "Love", 1 "Fifteen", 2 "Thirty", 3 "Forty"} point))

(defn different-scores
  [playerOne playerTwo]
  (str (point-to-score playerOne) "-" (point-to-score playerTwo)))

(defn tie-score
  [point]
  (if (> point 2) "Deuce" 
    (str (point-to-score point) "-" "All")))

(defn advantage-score
  [player]
  (str "Advantage " player))

(defn winner-score
  [player]
  (str "Win for " player))
