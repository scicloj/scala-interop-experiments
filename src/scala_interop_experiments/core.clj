(ns scala-interop-experiments.core
  (:require [t6.from-scala.core :refer ($ $$) :as $]
            [clojure.reflect :refer [reflect]])
  (:import (scala.collection.immutable List)))

;; See https://t6.github.io/from-scala/

(= ($ List & 1 2 3)
   ($/immutable-list 1 2 3))
#_true


(= ($/for [x ($/immutable-list 1 2 3)
           y (apply $/immutable-list (range x))]
     ($/tuple x y))
   (->> (for [x [1 2 3]
              y (range x)]
          ($/tuple x y))
        (apply $/immutable-list)))
#_true
