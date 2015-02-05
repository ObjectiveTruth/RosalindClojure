(use '[clojure.string])

(def currentDir (str (System/getProperty "user.dir") "\\src\\rosalindclojure\\"))

(def outputFile (str currentDir "outputfiles\\rosalind_revc_output.txt"))

(def inputFile (str currentDir "inputfiles\\rosalind_revc.txt"))

(def originalSequence (seq (slurp inputFile)))

(defn complimentDNA ([x] (case x
                           \A \T
                           \T \A
                           \C \G
                           \G \C
                           x
                           )))

(def outputSequence (reverse (join (map complimentDNA originalSequence))))

(spit outputFile outputSequence)
