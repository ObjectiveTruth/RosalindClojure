(use '[clojure.string])

(def currentDir (str (System/getProperty "user.dir") "\\src\\rosalindclojure\\"))

(def inputFile (str currentDir "inputfiles\\rosalind_gc.txt"))

(def outputFile (str currentDir "outputfiles\\rosalind_gc_output.txt"))

(def datastructure (rest (split (slurp inputFile) #">")))

(defn replacer ([x] (replace x #"\r\n" "")))

(defn getKeys ([y] (replace y #"Rosalind_...." "")))

(defn getData ([z] (replace z #"[ATCG]+" "")))

(defn worker ([DNA] (* 100.0 (/ (count (re-seq #"[CG]" DNA)) (count DNA)))))

(worker "ATCGFGFCG")

(def datastructure (map replacer datastructure))

(def hashMapKeys (map keyword (map getData datastructure)))

(def dataStripped (map worker (map getKeys datastructure)))


(def finalMap (zipmap  hashMapKeys dataStripped))

(def biggestKey (key (apply max-key val finalMap)))

(format "%.6f" (get finalMap biggestKey))

(spit outputFile (join finalMap))
