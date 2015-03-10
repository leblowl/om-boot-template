(set-env!
        :target-path "target"
        :resource-paths #{"resources"}
        :source-paths #{"src/clj" "src/cljs"}
        :dependencies '[[adzerk/boot-cljs "0.0-2814-3"]
                        [adzerk/boot-cljs-repl "0.1.9"]
                        [adzerk/boot-reload "0.2.4"]
                        [org.clojure/clojure "1.6.0"]
                        [org.clojure/clojurescript "0.0-2913"]
                        [org.omcljs/om "0.8.8"]
                        [sablono "0.3.4"]])

(require
  '[adzerk.boot-cljs       :refer :all]
  '[adzerk.boot-reload     :refer :all]
  '[adzerk.boot-cljs-repl  :refer :all])

(deftask dev
  "Build for development."
[]
(comp (watch)
      (speak)
      (reload :on-jsload (symbol "project.app/render"))
      (cljs :source-map true
            :optimizations :none
            :output-to "public/js/main.js")))
