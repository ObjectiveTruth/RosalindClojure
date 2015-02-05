;Must Execute this code with Ctrl+Shift+Enter to view the resulting graph via graphViz
;Also must install GraphViz for it to work if it doesn't, then just remove or comment out the
;view g

(ns problem10
  (:use
   [loom.graph]
   [loom.alg]
   [loom.gen]
   [loom.attr]
   [loom.label]
   [loom.io]
   [clojure.java.io]
    )
  (:require
   [clojure.string :as string]

   ))

(def currentDir (str (System/getProperty "user.dir") "\\src\\rosalindclojure\\"))

(def outputFile (str currentDir "outputfiles\\rosalind_grph_output.txt"))

(def inputFile (str currentDir "inputfiles\\rosalind_grph.txt"))

(def sample (string/replace (slurp inputFile) #"[\r][\n]" ""))

(def sampleNames (map keyword (re-seq #"Rosalind_[0-9]+" sample)))

(def sampleSequence (re-seq #"[ATCG]{1,}" sample))

(def combined (zipmap sampleNames sampleSequence))



;(filter (fn [x] (not (nil? x))))

(def finalgraphMK2 (filter (fn [g] (not (nil? g)))
        (for [x combined
      y combined]
  (if (and (not= (key x) (key y)) (.startsWith (val y) (subs (val x) (- (.length (val x)) 3))))
    [(key x) (key y)]
  ))
        ))

(def g (apply digraph finalgraphMK2))

(spit outputFile (string/replace (string/replace (reduce str (map str (edges g))) #"\]\[|\] \[" "\r\n") #"\"|\[|\]|:|nil| nil" ""))
(view g)
