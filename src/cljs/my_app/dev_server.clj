;; authored by @mjg123 - https://github.com/bhauman/lein-figwheel/issues/344#issuecomment-243922855

(ns my-app.dev-server
  (:require [clojure.string :refer [starts-with?]]
            [ring.middleware.resource :refer [wrap-resource]]))

(defn- wrap-default-index [next-handler]
  (fn [request]
    (next-handler
     (if (or (starts-with? (:uri request) "/css/")
             (starts-with? (:uri request) "/js/"))
       request
       (assoc request :uri "/index.html")))))

(def handler
  (-> (fn [_] {:status 404 :body "static asset not found"})
      (wrap-resource "public")
      wrap-default-index))

