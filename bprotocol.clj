(require '[clojure.string :as str_]
         '[clojure.set :refer [map-invert]])

(defprotocol Backwards
  (turn-around [arg]))

(extend-protocol Backwards
  String
  (turn-around [s]
    (str_/reverse s))
  Long
  (turn-around [l]
    (Integer. (str_/reverse (str l))))
  clojure.lang.PersistentVector
  (turn-around [v]
    (vec (rseq v)))
  clojure.lang.PersistentList
  (turn-around [_list]
    (into () _list))
  clojure.lang.PersistentArrayMap
  (turn-around [_map]
    (map-invert _map))
  Boolean
  (turn-around [bool]
    (if (true? bool) false true))
  )
