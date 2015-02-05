(defproject rosalindclojure "0.1.0-SNAPSHOT"
  :description "Rosalind Problems solved in Clojure"
  :url "http://github.com/ObjectiveTruth/RosalindClojure"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]
  				[aysylu/loom "0.5.0"]
  				]
  :main ^:skip-aot rosalindclojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
