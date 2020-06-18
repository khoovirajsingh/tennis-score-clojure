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
  (is (= "Thirty-All" (tie-score 2))))
