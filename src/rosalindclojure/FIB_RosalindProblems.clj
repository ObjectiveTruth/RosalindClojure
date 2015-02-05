(use '[clojure.string])

(defn fibRabbit
  ([months litterSize]
   (loop [i 3
          maturePop 1
          newPop litterSize
          ]
     (if (< i months)
       (recur (inc i)
              (+ maturePop newPop)
              (* maturePop litterSize)
        )
       (+ maturePop newPop)

       )
     )


   )

)

(fibRabbit 35 2)
