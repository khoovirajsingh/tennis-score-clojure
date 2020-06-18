(ns tennis-score.core-test
  (:require [clojure.test :refer :all]
            [tennis-score.core :refer :all]))

(deftest individual-point-is-mapped-to-score-description
  (is (= "Love" (point-to-score 0))))

(deftest display-score-when-points-are-different-for-both-players
  (is (= "Love-Fifteen" (running-score 0 1)))
  (is (= "Forty-Thirty" (running-score 3 2))))
