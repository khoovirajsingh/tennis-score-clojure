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

(deftest winner-name-for-player
  (is (= "player 1" (winner-name 4 2)))
  (is (= "player 2" (winner-name 2 4))))

(deftest is-advantage
  (is (= false (is-advantage? 0 0)))
  (is (= false (is-advantage? 4 2)))
  (is (= true (is-advantage? 4 3)))
  (is (= true (is-advantage? 8 7))))

(deftest running-score-for-tennis-game
  (is (= "Love-All" (running-score 0 0)))
  (is (= "Fifteen-Love" (running-score 1 0)))
  (is (= "Advantage player 1" (running-score 4 3)))
  (is (= "Deuce" (running-score 4 4)))
  (is (= "Win for player 2" (running-score 4 6))))
  



