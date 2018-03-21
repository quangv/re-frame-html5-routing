(defproject my-app "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.908"]
                 [reagent "0.7.0"]
                 [re-frame "0.10.5"]
                 [secretary "1.2.3"]]

  :plugins [[lein-cljsbuild "1.1.5"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]
             :ring-handler my-app.dev-server/handler}

  :aliases {"dev" ["do" "clean"
                        ["pdo" ["figwheel" "dev"]]]
            "build" ["do" "clean"
                          ["cljsbuild" "once" "min"]]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.4"]]

    :plugins      [[lein-figwheel "0.5.13"]
                   [lein-pdo "0.1.1"]]}}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "my-app.core/mount-root"
                    :websocket-host :js-client-host}
     :compiler     {:main                 my-app.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            my-app.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}


    ]}

  )
