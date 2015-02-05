(use '[clojure.string])

(def currentDir (str (System/getProperty "user.dir") "\\src\\rosalindclojure\\"))

(def inputFile (str currentDir "inputfiles\\rosalind_cons.txt"))

(def outputFile (str currentDir "outputfiles\\rosalind_cons_output.txt"))

(def sample (replace (slurp inputFile) #"[\r][\n]" "" ))

(def sampleSequence (re-seq #"[ATCG]{1,}" sample))

(def frequenciesMap (map frequencies (map join (apply map list sampleSequence))))

(def finalString (join (map (fn[x] (key (apply max-key val x))) frequenciesMap )))

(format "%s" finalString)

(def mapAs (join " " (map (fn ([x] (if (get x \A) (get x \A) 0))) frequenciesMap)))
(def mapCs (join " " (map (fn ([x] (if (get x \C) (get x \C) 0))) frequenciesMap)))
(def mapGs (join " " (map (fn ([x] (if (get x \G) (get x \G) 0))) frequenciesMap)))
(def mapTs (join " " (map (fn ([x] (if (get x \T) (get x \T) 0))) frequenciesMap)))

(spit outputFile (format "%s\r\nA: %s\r\nC: %s\r\nG: %s\r\nT: %s" finalString mapAs mapCs mapGs mapTs))
