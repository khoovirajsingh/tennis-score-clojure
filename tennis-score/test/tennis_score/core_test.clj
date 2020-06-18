(ns tennis-score.core-test
  (:require [clojure.test :refer :all]
            [tennis-score.core :refer :all]))

(deftest point-is-mapped-to-score-description
  (is (= "Love" (point-to-score-description 0))))
