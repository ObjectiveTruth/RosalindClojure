(use '[clojure.string])

(use 'clojure.java.io)

(def currentDir (str (System/getProperty "user.dir") "\\src\\rosalindclojure\\"))

(def outputFile (str currentDir "outputfiles\\rosalind_revc_output.txt"))

(def inputFile (str currentDir "inputfiles\\rosalind_prot.txt"))

(def codonTable (str currentDir "inputfiles\\codon-table.txt"))

(def codonTableString (slurp codonTable))



(def dnaData (slurp inputFile))

(def codonHM (zipmap (map keyword (re-seq #"[A-Z]{3}" codonTableString)) (map last (re-seq #"(?:[A-Z]{3} )." codonTableString))))

(join (map (fn [x] (get codonHM x)) (map keyword (map join (partition 3 dnaData)))))
