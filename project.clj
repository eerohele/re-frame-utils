(defproject me.flowthing/re-frame-utils "0.1.1"
  :description "Fxs and CoFxs for re-frame"
  :url "http://github.com/vimsical/re-frame-utils"
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :plugins      [[lein-cljsbuild "1.1.7"]
                 [lein-doo "0.1.11"]]
  :profiles {:provided {:dependencies [[re-frame "0.11.0"]]}
             :dev      {:dependencies [[org.clojure/clojurescript "1.10.597"]
                                       [reagent "0.9.1" :exclusions [org.clojure/clojurescript]]
                                       [re-frame "0.11.0" :exclusions [org.clojure/clojurescript]]
                                       [day8.re-frame/test "0.1.5" :exclusions [org.clojure/clojurescript]]]}}
  :cljsbuild
  {:builds
   [{:id           "test"
     :source-paths ["src/" "test/"]     ; test is needed for the runner
     :test-paths   ["test/"]
     :compiler     {:main           vimsical.re-frame.runner
                    :output-to      "target/cljs-test/test.js"
                    :output-dir     "target/cljs-test"
                    :optimizations  :none
                    :target         :nodejs}}]})
