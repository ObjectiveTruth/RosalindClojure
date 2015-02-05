(use '[clojure.string])

(def currentDir (str (System/getProperty "user.dir") "\\src\\rosalindclojure\\"))

(def inputFile (str currentDir "inputfiles\\rosalind_hamm.txt"))


(def nucleotideVec (split  (slurp inputFile) #"\r\n"))

(loop [i 0
       hammingDistance 0
       ]
        (if (< i (count (nth nucleotideVec 1)))
          (if (= (.charAt (nth nucleotideVec 1) i) (.charAt (nth nucleotideVec 0) i))
              (recur (inc i) hammingDistance)
              (recur (inc i) (inc hammingDistance))
            )
          hammingDistance
          )
  )


