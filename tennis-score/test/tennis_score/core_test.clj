(ns tennis-score.core-test
  (:require [clojure.test :refer :all]
            [tennis-score.core :refer :all]))

(deftest individual-point-is-mapped-to-score-description
  (is (= "Love" (point-to-score 0))))

(deftest display-score-when-points-are-different-for-both-players
  (is (= "Love-Fifteen" (different-scores 0 1)))
  (is (= "Forty-Thirty" (different-scores 3 2))))

(deftest display-score-when-points-are-same-for-both-players
  (is (= "Love-All" (tie-score 0)))
  (is (= "Thirty-All" (tie-score 2)))
  (is (= "Deuce" (tie-score 3))))

(deftest display-score-when-there-is-advantage
  (is (= "Advantage player 1" (advantage-score "player 1")))
  (is (= "Advantage player 2" (advantage-score "player 2"))))


(deftest display-score-when-there-is-a-winner
  (is (= "Win for player 1" (winner-score "player 1")))
  (is (= "Win for player 2" (winner-score "player 2"))))

(deftest is-winner
  (is (= false (is-winner? 0 0)))
  (is (= true (is-winner? 4 2)))
  (is (= false (is-winner? 4 3))))
