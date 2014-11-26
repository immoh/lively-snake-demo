(defproject lively-snake-demo "0.1.0-SNAPSHOT"
  :min-lein-version "2.0.0"
  :dependencies [;; Clojure
                 [org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0"]
                 ;; ClojureScript
                 [org.clojure/clojurescript "0.0-2371"]
                 [reagent "0.4.3"]
                 [lively "0.1.2"]]
  :source-paths ["src/clj"]
  :plugins [[lein-ring "0.8.13"]
            [lein-cljsbuild "1.0.3"]]
  :ring {:handler snake.server/app
         :browser-uri "/index.html"}
  :cljsbuild {:builds {:main {:source-paths ["src/cljs"]
                              :compiler {:output-to "resources/public/js/snake.js"
                                         :output-dir "resources/public/js/out"
                                         :optimizations :none}}}})
