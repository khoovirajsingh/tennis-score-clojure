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

(defn abs [n] (max n (- n)))

(defn is-winner?
  [playerOne playerTwo]
  (let [difference (abs (- playerOne playerTwo))
        is-any-score-forty? (or (> playerOne 2) (> playerTwo 2))]
    (and (> difference 1) is-any-score-forty?)))

(defn leader-name
  [playerOne playerTwo]
  (if (> playerOne playerTwo) "player 1" "player 2"))

(defn is-advantage?
  [playerOne playerTwo]
  (let [difference (abs (- playerOne playerTwo))
        is-any-score-thirty? (or (> playerOne 1) (> playerTwo 1))]
    (and (= difference 1) is-any-score-thirty?)))

(defn is-tie?
  [playerOne playerTwo]
  (= playerOne playerTwo))

(defn running-score
  [playerOne playerTwo]
  (let [player-name (leader-name playerOne playerTwo)]
   (cond
    (is-winner? playerOne playerTwo) (winner-score player-name)
    (is-advantage? playerOne playerTwo) (advantage-score player-name)
    (is-tie? playerOne playerTwo) (tie-score playerOne)
    :else (different-scores playerOne playerTwo))))
    


    


