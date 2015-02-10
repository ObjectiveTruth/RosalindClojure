(use '[clojure.string])

(def currentDir (str (System/getProperty "user.dir") "\\src\\rosalindclojure\\"))

;(def outputFile (str currentDir "outputfiles\\rosalind_grph_output.txt"))

(def inputFile (str currentDir "inputfiles\\rosalind_grph.txt"))

(def sample (replace (slurp inputFile) #"[\r][\n]" ""))

(def sampleSequence (re-seq #"[ATCG]{1,}" sample))


;====================================================
;Longest Common Sustring 2 strings implementation only
;====================================================


(def firstSequence (nth sampleSequence 0))

(def secondSequence (nth sampleSequence 1))

(def similarityTable (vec (repeat (inc(count firstSequence)) (vec (repeat (inc(count secondSequence)) 0))) ))

(assoc-in similarityTable [1 2] 2)
(get-in similarityTable [1 2])
(def longestCommonSubstringSize 0)
(def newValue 0)
(def longestCommonSubstring "")

(doseq [x (range (inc (count firstSequence)))
     y (range (inc (count secondSequence)))
     ]
  (if
    (= (get firstSequence x) (get secondSequence y))
    (do
      (def newValue (inc (get-in similarityTable [x y])))
      (def similarityTable
        (assoc-in similarityTable [(inc x) (inc y)] newValue))
      (if (> newValue longestCommonSubstringSize)
        (do
          (def longestCommonSubstring (subs firstSequence (- x newValue -1) (inc x)))
          (def longestCommonSubstringSize newValue)
        )
        true
      )
    )
    true
  )
)

;====================================================
;                      ANSWERS
;====================================================

;Longest Common Substring
longestCommonSubstring

;Size of the longest Common Substring
longestCommonSubstringSize

;Memoization table for reference
similarityTable
