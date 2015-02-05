(use '[clojure.string])

(def homozygousDom 2)

(def heterozygous 2)

(def homozygousRec 2)

(def totalPop (+ homozygousDom homozygousRec heterozygous))

;HomozygousDom and Homozygous Dom
(+ 0.0 (* (/ homozygousDom totalPop) (/ (- homozygousDom 1) (- totalPop 1)) 2)

;heterozygous and heterozygous
(* (/ heterozygous totalPop) (/ (- heterozygous 1) (- totalPop 1)) (/ 3 4))

;HomozygousDom and heterozygous
(* (/ homozygousDom totalPop) (/ heterozygous (- totalPop 1)) 2)

;HomozygousDom and homozygousRec
(* (/ homozygousDom totalPop) (/ homozygousRec (- totalPop 1)) 2)

;heterozygous and homozygousRec
(* (/ heterozygous totalPop) (/ homozygousRec (- totalPop 1)) (/ 1 4) 2)

)
